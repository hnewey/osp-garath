package net.castleadventure.ospgarath.model;

import net.castleadventure.ospgarath.factory.RoomFactory;
import net.castleadventure.ospgarath.model.room.Room;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRoom {

    private Room sut;

    @Test
    public void newRoom_test() throws Exception {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            rooms.add(RoomFactory.generateRoom());
        }
        assert(rooms.size() == 50);
    }
}