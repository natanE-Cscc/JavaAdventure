package edu.cscc.javaadventure;

public abstract class MovableObject extends JAObject {
    private Room room;

    public MovableObject() {
        super();
    }
    public MovableObject (String name, String description, Double weight ) {
        super(name, description, weight);

    }

    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }

    public void move (Direction direction) {
        //getting the current room of the MovableObject

        Room currentRoom = getRoom();

        if (currentRoom != null) {

            switch (direction) {
                case UP:
                case DOWN:
                case NORTH:
                case SOUTH:
                case EAST:
                case WEST:
                    Room newRoom = currentRoom.getRoom(direction.toString());

                    if(newRoom != null) {
                        currentRoom.removeFromContents(this.getName());
                        currentRoom.addToContents(this);
                        setRoom(newRoom);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}


