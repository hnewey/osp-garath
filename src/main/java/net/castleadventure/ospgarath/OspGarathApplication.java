package net.castleadventure.ospgarath;

import net.castleadventure.ospgarath.model.character.Character;
import net.castleadventure.ospgarath.game.GameRunner;
import net.castleadventure.ospgarath.game.GameState;
import net.castleadventure.ospgarath.model.character.PlayerCharacter;
import net.castleadventure.ospgarath.model.character.race.Race;
import net.castleadventure.ospgarath.model.room.EntryRoom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class OspGarathApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(OspGarathApplication.class, args);

        System.out.println("\n");
        System.out.println("Game started...");

        GameState gameState = GameState.getInstance();
        gameState.setCurrentRoom(new EntryRoom());
        gameState.initBoard();

        Character playerCharacter = new PlayerCharacter(15, 15, 15, 15, 8, 6);
        playerCharacter.setName("Lahod");
        playerCharacter.setPlayerName("hnewey");
        playerCharacter.setCharacterRace(Race.HALF_ELF);
        gameState.setPlayerCharacter(playerCharacter);
//        GameRunner.start();
    }
}
