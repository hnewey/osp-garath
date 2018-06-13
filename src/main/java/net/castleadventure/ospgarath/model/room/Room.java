package net.castleadventure.ospgarath.model.room;

import net.castleadventure.ospgarath.factory.RoomFactory;
import net.castleadventure.ospgarath.model.monster.Monster;
import net.castleadventure.ospgarath.model.trap.Trap;
import net.castleadventure.ospgarath.game.GameState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Room {

    protected RoomType roomType;
    protected RoomSecret roomSecret;
    protected String imageSrc;
    protected List<Trap> traps;
    protected List<Monster> monsters;
    protected String roomIntro;
    protected List<RoomEval> roomEvals;
    protected Integer numConnectingRooms;
    protected List<Room> connectingRooms;
    protected Boolean canGoBack;

    public Room() {
        traps = new ArrayList<>();
        monsters = new ArrayList<>();
        roomEvals = new ArrayList<>();
        connectingRooms = new ArrayList<>();
        numConnectingRooms = new Random().nextInt(3) + 1;
        canGoBack = true; //true by default. Individual rooms may override this
    }

    public abstract void initializeRoom();

    protected void addConnectingRooms() {
        for (int i = 0; i < this.numConnectingRooms; i++) {
            connectingRooms.add(RoomFactory.generateRoom());
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

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public String getRoomIntro() {
        return roomIntro;
    }

    public List<RoomEval> getRoomEvals() {
        return roomEvals;
    }

    public List<Room> getConnectingRooms() {
        return connectingRooms;
    }

    public Integer getNumConnectingRooms() {
        return numConnectingRooms;
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
        for (Room room : connectingRooms) {
            rooms.append("(").append(roomNum++).append(")").append(room.getRoomType()).append(", ");
        }
        return rooms.toString();
    }
}
