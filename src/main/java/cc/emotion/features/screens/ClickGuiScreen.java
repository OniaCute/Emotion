package cc.emotion.features.screens;

import cc.emotion.Emotion;
import cc.emotion.features.managers.GuiManager;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() {
        super(Text.of("Emotion-Client-Click-Gui-Screen"));
    }

    public boolean LEFT_CLICKED = false; // Mouse 1 (0)
    public boolean RIGHT_CLICKED = false; // Mouse 2 (1)
    public boolean CENTER_CLICKED = false; // Mouse 3 (2)
    public boolean FLANK_FRONT_CLICKED = false; // Mouse 5 (4)
    public boolean FLANK_BACK_CLICKED = false; // mouse 4 (3)
    public boolean MOUSE_CLICKED = false; // However, this var always active in mouse click with any "Click type".

    @Override
    public boolean shouldPause() {
        return false;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        MOUSE_CLICKED = true;
        if (button == 0) {
            LEFT_CLICKED = true;
            GuiManager.CLICKED_LEFT = true;
        }
        else if (button == 1) {
            RIGHT_CLICKED = true;
            GuiManager.CLICKED_RIGHT = true;
        }
        else if (button == 2) {
            CENTER_CLICKED = true;
        }
        else if (button == 3) {
            FLANK_FRONT_CLICKED = true;
        }
        else if (button == 4) {
            FLANK_BACK_CLICKED = true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0) {
            LEFT_CLICKED = false;
            GuiManager.CLICKED_LEFT = false;
        }
        else if (button == 1) {
            RIGHT_CLICKED = false;
            GuiManager.CLICKED_RIGHT = false;
        }
        else if (button == 2) {
            CENTER_CLICKED = false;
        }
        else if (button == 3) {
            FLANK_FRONT_CLICKED = false;
        }
        else if (button == 4) {
            FLANK_BACK_CLICKED = false;
        }
        if (!LEFT_CLICKED && !RIGHT_CLICKED && !CENTER_CLICKED && !FLANK_FRONT_CLICKED && !FLANK_BACK_CLICKED) {
            MOUSE_CLICKED = false;
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public void close() {
        super.close();
        LEFT_CLICKED = false;
        RIGHT_CLICKED = false;
        CENTER_CLICKED = false;
        FLANK_FRONT_CLICKED = false;
        FLANK_BACK_CLICKED = false;
        MOUSE_CLICKED = false;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float partialTicks) {
        Emotion.EVENTS.onMouseMoveInClickGuiScreen(context, mouseX, mouseY);
    }
}
