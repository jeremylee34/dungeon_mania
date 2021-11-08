package dungeonmania.entities;

import dungeonmania.util.*;

import java.util.List;
import java.util.Random;


public class Hydra extends MovingEntity {
    private final static int STARTING_HEALTH = 8;
    private final static int ATTACK = 4;

    
    /**
     * Creates the main zombie
     * @param position - the current position in the dungeon
     * @param type - the type of entity
     * @param ID - the ID of entity
     * @param isInteractable - check if the entity is interactable
     */
    public Hydra(Position position, String type, String ID, boolean isInteractable) {
        super(position, type, ID, isInteractable);
        setHealth(STARTING_HEALTH);
        setAttack(ATTACK);
    }

    public void moveEntity(List<Entity> entities, Position position) {
        // For now, hydras travel randomely
        Random random = new Random();
        int randDirection = random.nextInt(4);

        if (position.equals(super.getPosition())) return;

        switch(randDirection) {
            case 0:
                if (checkMovement(super.getPosition().translateBy(0, -1), entities)) {
                    // If its netiher a wall nor a boulder, check if its a door
                    Door doorEntity = checkDoor(super.getPosition().translateBy(0,-1), entities); 
                    if (doorEntity != null) {
                        //If it is a door, check if its locked or not, if it isnt locked, move into it
                        if (doorEntity.getLocked() == true) {
                            break;
                        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
                    }

                    super.moveUpward();
                    break;
                }
            
            case 1:
                if (checkMovement(super.getPosition().translateBy(0, 1), entities)) {
                    // If its netiher a wall nor a boulder, check if its a door
                    Door doorEntity = checkDoor(super.getPosition().translateBy(0,1), entities); 
                    if (doorEntity != null) {
                        //If it is a door, check if its locked or not, if it isnt locked, move into it
                        if (doorEntity.getLocked() == true) {
                            break;
                        }
                    }
                    super.moveDownward();
                    break;
                }
            
            case 2:
                if (checkMovement(super.getPosition().translateBy(-1, 0), entities)) {
                    // If its netiher a wall nor a boulder, check if its a door
                    Door doorEntity = checkDoor(super.getPosition().translateBy(-1, 0), entities); 
                    if (doorEntity != null) {
                        //If it is a door, check if its locked or not, if it isnt locked, move into it
                        if (doorEntity.getLocked() == true) {
                            break;
                        }
                    }
                    super.moveLeft();
                    break;
                }
            
            case 3:
                if (checkMovement(super.getPosition().translateBy(1, 0), entities)) {
                    // If its netiher a wall nor a boulder, check if its a door
                    Door doorEntity = checkDoor(super.getPosition().translateBy(1,0), entities); 
                    if (doorEntity != null) {
                        //If it is a door, check if its locked or not, if it isnt locked, move into it
                        if (doorEntity.getLocked() == true) {
                            break;
                        }
                    }
                    super.moveRight();
                    break;
                }
        }   
    }


}

