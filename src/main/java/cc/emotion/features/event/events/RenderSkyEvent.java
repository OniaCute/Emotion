package cc.emotion.features.event.events;

import java.awt.*;

public class RenderSkyEvent extends Event {

    private Color color;

    public RenderSkyEvent() {
        super(Stage.Pre);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}