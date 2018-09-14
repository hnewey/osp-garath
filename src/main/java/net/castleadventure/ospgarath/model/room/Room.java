package net.castleadventure.ospgarath.model.room;

import net.castleadventure.ospgarath.factory.RoomFactory;
import net.castleadventure.ospgarath.game.Dice;
import net.castleadventure.ospgarath.game.SpaceInfo;
import net.castleadventure.ospgarath.model.character.Character;
import net.castleadventure.ospgarath.model.trap.Trap;

import java.util.*;

public abstract class Room {

    protected RoomType roomType;
    protected RoomSecret roomSecret;
    protected String imageSrc;
    protected List<Trap> traps = new ArrayList<>();
    protected List<Character> monsters = new ArrayList<>();
    protected String roomIntro;
    protected List<RoomEval> roomEvals = new ArrayList<>();
    protected Integer numConnectingRooms;

    //map of board position key to room value. Positions are: 1=left 2=top 3=right
    protected Map<Integer, Room> connectingRooms = new HashMap<>();
    protected Boolean canGoBack;
    protected Room previousRoom;

    //13 being the size of the board
    protected final Integer WIDTH = 13;
    protected final Integer HEIGHT = 13;
    //specific info for spaces that contain enemies or obstacles as defined in child classes. Used in Board creation
    protected SpaceInfo[][] spaceInfos = new SpaceInfo[WIDTH][HEIGHT];

    public Room() {
        numConnectingRooms = Dice.d3();
        canGoBack = true; //true by default. Individual rooms may override this
        spaceInfos[6][0] = SpaceInfo.DOOR; //this is the bottom-middle door. It will be where the character enters always
    }

    public abstract void initializeRoom();

    protected void addConnectingRooms() {
        List<Integer> roomPositions = new ArrayList<>();
        if (numConnectingRooms == 3) {
            roomPositions.add(1);
            roomPositions.add(2);
            roomPositions.add(3);
        }
        else {
            for (int i = 0; i < this.numConnectingRooms; i++) {
                Integer position = 0;
                do {
                    position = Dice.d3();
                } while (roomPositions.contains(position));
                roomPositions.add(position);
            }
        }
        for (int i = 0; i < this.numConnectingRooms; i++) {
            if (roomPositions.contains(i+1)) {
                connectingRooms.put(i+1, RoomFactory.generateRoom(this));
                addSpaceInfoForConnectingRoom(i+1);
            }
            else {
                connectingRooms.put(i, null);
            }
        }
    }

    private void addSpaceInfoForConnectingRoom(int roomPosition) {
        switch (roomPosition) {
            //position 1 is Left (0, 6)
            case 1:
                spaceInfos[0][6] = SpaceInfo.DOOR;
                break;
            case 2:
                spaceInfos[6][12] = SpaceInfo.DOOR;
                break;
            case 3:
                spaceInfos[12][6] = SpaceInfo.DOOR;
        }
    }

    public RoomType getRoomType() {
        return roomType;
    }
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public RoomSecret getRoomSecret() {
        return roomSecret;
    }
    public void setRoomSecret(RoomSecret roomSecret) {
        this.roomSecret = roomSecret;
    }

    public String getImageSrc() {
        return imageSrc;
    }
    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public List<Trap> getTraps() {
        return traps;
    }
    public void setTraps(List<Trap> traps) {
        this.traps = traps;
    }

    public List<Character> getMonsters() {
        return monsters;
    }
    public void setMonsters(List<Character> monsters) {
        this.monsters = monsters;
    }

    public String getRoomIntro() {
        return roomIntro;
    }
    public List<RoomEval> getRoomEvals() {
        return roomEvals;
    }

    public Map<Integer, Room> getConnectingRooms() {
        return connectingRooms;
    }
    public Integer getNumConnectingRooms() {
        return numConnectingRooms;
    }
    public void setPreviousRoom(Room previousRoom) {
        this.previousRoom = previousRoom;
    }

    public SpaceInfo[][] getSpaceInfos() {
        return spaceInfos;
    }

    @Override
    public String toString() {
        return "Type: " + roomType + "\n" +
                "Secret: " + roomSecret + "\n" +
                "Intro: " + roomIntro + "\n" +
                "Evals: " + roomEvals + "\n" +
                "Connecting Rooms: " + printConnectingRooms() + "\n" +
                "Traps: " + traps + "\n" +
                "Monsters: " + monsters + "\n";
    }

    private String printConnectingRooms() {
        if (connectingRooms.isEmpty()) {
            return "No connecting rooms";
        }
        StringBuilder rooms = new StringBuilder();
        int roomNum = 1;
        rooms.append("(0)Previous, ");
        for (Room room : connectingRooms.values()) {
            rooms.append("(").append(roomNum++).append(")").append(room.getRoomType()).append(", ");
        }
        return rooms.toString();
    }
}
