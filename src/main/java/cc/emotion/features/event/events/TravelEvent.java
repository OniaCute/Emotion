package cc.emotion.features.event.events;

import cc.emotion.features.event.Event;
import net.minecraft.entity.player.PlayerEntity;

public class TravelEvent extends Event {

    private PlayerEntity entity;


    public TravelEvent(Stage stage, PlayerEntity entity) {
        super(stage);
        this.entity = entity;
    }

    public PlayerEntity getEntity() {
        return entity;
    }
}