package net.castleadventure.ospgarath.web.controller;

import net.castleadventure.ospgarath.game.Board;
import net.castleadventure.ospgarath.game.GameState;
import net.castleadventure.ospgarath.model.character.Character;
import net.castleadventure.ospgarath.game.Space;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (value = "game")
public class GameController {

    @RequestMapping (value = "/board/spaces", method = RequestMethod.GET)
    public List<Space> getBoardSpaces() {
        return Board.getInstance().getSpacesAsList();
    }

    @RequestMapping (value = "/character", method = RequestMethod.GET)
    public Character getCharacter() {
        return GameState.getInstance().getCharacter();
    }

    @RequestMapping (value = "/character", method = RequestMethod.POST)
    public void updateCharacter(@RequestBody Character character) {
        GameState.getInstance().setCharacter(character);
    }

    @RequestMapping (value = "/endTurn", method = RequestMethod.POST)
    public ResponseEntity endTurn(@RequestBody Character character) {
        GameState.getInstance().setCharacter(character);
        character.endTurn();
        return ResponseEntity.noContent().build();
    }

    @RequestMapping (value = "/quickActions", method = RequestMethod.POST)
    public List<String> getQuickActions(@RequestBody Character character) {
        return character.getQuickActions();
    }

    @RequestMapping (value = "/standardActions", method = RequestMethod.POST)
    public List<String> getStandardActions(@RequestBody Character character) {
        return character.getStandardActions();
    }

}
