package cc.emotion.features.event.events;

import cc.emotion.features.event.Event;

public class KeyboardInputEvent extends Event {
    public KeyboardInputEvent() {
        super(Stage.Post);
    }
}
