package dungeonmania.entities.CollectibleEntities;

import dungeonmania.entities.CollectibleEntity;
import dungeonmania.util.Position;

public class InvincibilityPotion extends CollectibleEntity{
    public InvincibilityPotion(Position position, String type, String ID, boolean IsInteractable) {
        super(position,type, ID, IsInteractable);
    }   
}