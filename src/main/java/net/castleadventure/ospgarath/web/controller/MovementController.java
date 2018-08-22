package net.castleadventure.ospgarath.web.controller;

import net.castleadventure.ospgarath.game.GameState;
import net.castleadventure.ospgarath.game.Space;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
        Character character = GameState.getInstance().getCharacter();
        return character.getPossibleMovements();
    }

    @RequestMapping (value = "/blocked", method = RequestMethod.GET)
    public List<Space> getBlockedMovements() throws Exception {
        Character character = GameState.getInstance().getCharacter();
        return character.getBlockedMovements();
    }
}
