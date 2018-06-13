package net.castleadventure.ospgarath.model.room;

import net.castleadventure.ospgarath.factory.RoomFactory;

public class TowerIntro extends Room {

    public TowerIntro() {
        connectingRooms.add(new EntryRoom());
        roomIntro = "You stand before a rundown tower facing a young man in a gray cloak, his hood pulled up to slightly \n" +
                "obscure his face. \"You have chosen to face the Grim Trials of Osp-Garath\" he says in a voice that \n" +
                "sounds far too old to belong to him. \"The Salt Sisters will now test you to see if you are worthy to \n" +
                "join the Gray Wardens. It is said that every decision you make is judged of the Sisters and every \n" +
                "choice they deem incorrect increases the difficulty of the trials you will face. While the Sisters may \n" +
                "take, they also provide [At this, the man stops to kiss a ring on his left hand before continuing]. \n" +
                "You are entitled to whatever you find in Osp-Garath--if you can pass the trials. You are placing yourself \n" +
                "at the Salt Sisters' mercy and as such, you are not allowed to bring anything with you into the tower. \n" +
                "Failure to abide by this one rule will be met with swift judgement. Are you ready to begin?\"\n\n" +
                "The man produces a small clay bowl from within his cloak. \"From Salt and Ash we draw our strength\"\n" +
                "He says as he dips his finger in the bowl. He draws a symbol on your forehead with the chalky-black \n" +
                "substance and he motions for you to enter a small door at the base of the tower. \"Salt and Ash\" he says\n" +
                "once more as you enter. The door swings shut behind you with a loud BOOM. Your trial has begun.";
    }


    @Override
    public void initializeRoom() {
    }

}
