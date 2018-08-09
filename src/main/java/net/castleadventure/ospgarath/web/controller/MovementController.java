package net.castleadventure.ospgarath.web.controller;

import net.castleadventure.ospgarath.model.character.Space;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import net.castleadventure.ospgarath.model.character.Character;

import java.util.List;

@RestController
@RequestMapping (value = "move")
public class MovementController {

    @RequestMapping (value = "/possible", method = RequestMethod.GET)
    public List<Space> getPossibleMovements() throws Exception {
        //TODO: Remove new character creation and take a character parameter instead
        Character character = new Character(10, 10, 10, 10, 4, 6);
        return character.getPossibleMovements();
    }

    @RequestMapping (value = "/blocked", method = RequestMethod.GET)
    public List<Space> getBlockedMovements() throws Exception {
        //TODO: Remove new character creation and take a character parameter instead
        Character character = new Character(10, 10, 10, 10, 4, 6);
        return character.getBlockedMovements();
    }
}
