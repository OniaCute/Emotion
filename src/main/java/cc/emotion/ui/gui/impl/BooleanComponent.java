package cc.emotion.ui.gui.impl;

import cc.emotion.features.options.impl.BooleanOption;
import cc.emotion.ui.gui.GuiComponent;
import net.minecraft.client.gui.DrawContext;

public class BooleanComponent extends GuiComponent {
    private BooleanOption option;

    public BooleanComponent(BooleanOption option) {
        this.option = option;
    }

    public void setOption(BooleanOption option) {
        this.option = option;
    }

    public BooleanOption getOption() {
        return option;
    }

    @Override
    public void onDraw(DrawContext context, double mouseX, double mouseY, boolean CLICK_LEFT, boolean CLICK_RIGHT) {
        
    }
}
