package net.castleadventure.ospgarath;

import net.castleadventure.ospgarath.model.character.Character;
import net.castleadventure.ospgarath.game.GameRunner;
import net.castleadventure.ospgarath.game.GameState;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class OspGarathApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(OspGarathApplication.class, args);

        System.out.println("\n");
        System.out.println("Enter Player's Stats:");

        Character playerCharacter = new Character(15, 15, 15, 15, 8, 6);

        GameState.getInstance().setCharacter(playerCharacter);
        GameRunner.start();
    }
}
