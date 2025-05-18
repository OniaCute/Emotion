package cc.emotion.features.event.events;

import cc.emotion.features.event.Event;
import net.minecraft.util.math.Box;

public class StepEvent extends Event {
    private final Box box;
    private float height;

    public StepEvent(Box axisAlignedBB, float height) {
        super(Stage.Pre);
        this.box = axisAlignedBB;
        this.height = height;
    }

    public Box getAxisAlignedBB() {
        return box;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float in) {
        height = in;
    }
}
