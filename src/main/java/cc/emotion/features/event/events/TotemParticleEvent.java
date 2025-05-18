package cc.emotion.features.event.events;

import java.awt.*;
import cc.emotion.features.event.Event;

public class TotemParticleEvent extends Event {
    public double velocityX, velocityY, velocityZ;
    public Color color;
    public TotemParticleEvent(double velocityX, double velocityY, double velocityZ) {
        super(Stage.Pre);
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
    }
}
