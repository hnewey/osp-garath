package net.castleadventure.ospgarath.web;

import com.fasterxml.jackson.core.JsonParseException;
import net.castleadventure.ospgarath.game.GameState;
import net.castleadventure.ospgarath.model.ability.power.Power;
import net.castleadventure.ospgarath.model.ability.power.PowerManager;
import net.castleadventure.ospgarath.model.character.Character;
import net.castleadventure.ospgarath.model.character.CharacterManager;
import net.castleadventure.ospgarath.model.character.race.Race;
import net.castleadventure.ospgarath.model.character.race.RaceManager;
import net.castleadventure.ospgarath.model.characterClass.ClassType;
import net.castleadventure.ospgarath.model.characterClass.ClassDescription;
import net.castleadventure.ospgarath.model.characterClass.trait.SelectedRaceAndClass;
import net.castleadventure.ospgarath.model.characterClass.trait.TraitManager;
import net.castleadventure.ospgarath.model.monster.StatResolver;
import net.castleadventure.ospgarath.model.monster.beast.Beast;
import net.castleadventure.ospgarath.model.monster.beast.BeastManager;
import net.castleadventure.ospgarath.model.monster.beast.Pony;
import net.castleadventure.ospgarath.model.monster.beast.Viper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import net.minidev.json.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping( value =  "" )
public class CharacterCreationController {

    private ClassType selectedClassType;

    @RequestMapping(value = "/character/create")
    public void createCharacter(@RequestBody net.minidev.json.JSONObject json) throws Exception {
        if (json == null) {
            System.out.println("json is null");
        }
        Character newCharacter;
        try {
            newCharacter = Character.createFromJson(json);
        } catch (JSONException e) {
            throw new Exception(String.format("Invalid json for character creation provided: %s", json.toString()));
        }
        GameState.getInstance().setCharacter(newCharacter);
    }

//    @RequestMapping(value = "/character/create")
//    public void createCharacter(@RequestBody Character newCharacter, @RequestBody List<String> powersList) throws Exception {
//        if (newCharacter == null) {
//            throw new Exception("Character can't be null");
//        }
//        newCharacter.setDefaultValues();
//        GameState.getInstance().setCharacter(newCharacter);
//    }
//
    @RequestMapping(value = "/class/classList", method = RequestMethod.GET)
    public List<String> getClassList() {
        List<String> classList = ClassType.getAllClassNamesWithCombos();
        classList.add(0, "");
        return classList;
    }

    @RequestMapping(value = "/class/classDescription/{className}", method = RequestMethod.GET)
    public String getClassDescription(
            @PathVariable ("className") String className) {
        return ClassDescription.getClassDescription(className);
    }

    @RequestMapping(value = "/class/classTraits/{className}", method = RequestMethod.GET)
    public List<String> getClassTraits(
            @PathVariable ("className") String className) {
        return TraitManager.getClassTraits(className);
    }

    @RequestMapping(value = "/class/classRestrictions/{className}", method = RequestMethod.GET)
    public List<String> getClassRestrictions(
            @PathVariable ("className") String className) {
        return TraitManager.getClassRestrictions(className);
    }

    @RequestMapping(value = "/class/classPowers/{className}", method = RequestMethod.GET)
    public ResponseEntity<List<Power>> getClassPowers(
            @PathVariable ("className") String className) {
        List<Power> powers = PowerManager.getPowerManager(className).getClassPowers();
        return ResponseEntity.ok().body(powers);
    }

    @RequestMapping(value = "/class/steward/{amount}", method = RequestMethod.GET)
    public ResponseEntity<List<Character>> getSteward(
            @PathVariable ("amount") Integer amount) {
        return ResponseEntity.ok().body(CharacterManager.createRandomStewards(3));
    }

    @RequestMapping(value = "/race/raceList", method = RequestMethod.GET)
    public List<String> getRaces() {
        List<String> raceList = Race.getRaces();
        raceList.add(0, "");
        return raceList;
    }

    @RequestMapping(value = "/race/raceDescription/{race}", method = RequestMethod.GET)
    public String getRaceDescription(
            @PathVariable ("race") String race) {
        return Race.getRaceDescription(race);
    }

    @RequestMapping(value = "/race/racialTraits/{race}", method = RequestMethod.GET)
    public List<String> getRacialTraits(
            @PathVariable ("race") String race) {
        return RaceManager.getRacialTraits(race);
    }

    @RequestMapping(value = "/race/racialPowers/{race}", method = RequestMethod.GET)
    public ResponseEntity<Power> getRacialPowers(
            @PathVariable ("race") String race) {
        Power racialPower = RaceManager.getRacialPower(race);
        return ResponseEntity.ok().body(racialPower);
    }

    @RequestMapping(value = "/race/HalfElfChoice", method = RequestMethod.GET)
    public ResponseEntity<List<Power>> getHalfElfChoicePowers() {
        Power human = RaceManager.getRacialPower("Human");
        Power highElf = RaceManager.getRacialPower("High Elf");
        Power woodElf = RaceManager.getRacialPower("Wood Elf");

        List<Power> powers = new ArrayList<>();
        powers.add(human);
        powers.add(highElf);
        powers.add(woodElf);

        return ResponseEntity.ok().body(powers);
    }

    @RequestMapping(value = "/class/validate", method = RequestMethod.POST)
    public Boolean isClassValid(
            @RequestBody String classSequence,
            @RequestBody Integer strength,
            @RequestBody Integer quickness,
            @RequestBody Integer intelligence,
            @RequestBody Integer leadership) {

        ClassType selectedClass = ClassType.getClassType(classSequence);
        List<ClassType> possibleClasses = StatResolver.getPossibleClasses(strength, quickness, intelligence, leadership);

        return possibleClasses.contains(selectedClass);
    }

    @RequestMapping(value = "/race/validate", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Boolean areRaceAndClassValid(
            @RequestBody SelectedRaceAndClass selectedRaceAndClass) {
        Boolean isValid = TraitManager.validateRaceAndClass(selectedRaceAndClass.getSelectedRace(), selectedRaceAndClass.getSelectedClass());
        return isValid;
    }

    @RequestMapping(value = "/beast/nonMounts", method = RequestMethod.GET)
    public List<Beast> getNonMounts() {
        return BeastManager.getNonMounts();
    }

    @RequestMapping(value = "/beast/all", method = RequestMethod.GET)
    public List<Beast> getAllBeasts() {
        return BeastManager.getAllBeasts();
    }

    @RequestMapping(value = "/beast/mounts", method = RequestMethod.GET)
    public List<Beast> getMounts() {
        return BeastManager.getMounts();
    }

    @RequestMapping(value = "/beast/conjurer", method = RequestMethod.GET)
    public List<Beast> getConjurerBeasts() {
        return BeastManager.getConjurerBeasts();
    }

    @RequestMapping(value = "/beast/viper", method = RequestMethod.GET)
    public List<Beast> getViper() {
        List<Beast> beasts = new ArrayList<>();
        beasts.add(new Viper());
        return beasts;
    }

    @RequestMapping(value = "/beast/powers", method = RequestMethod.GET)
    public List<Power> getBeastPowers() {
        List<Beast> beasts = BeastManager.getAllBeasts();
        List<Power> beastPowers = new ArrayList<>();
        for (Beast beast : beasts) {
            if (beast.getType().equalsIgnoreCase("Pony")){
                continue;
            }
            beastPowers.addAll(beast.getPowers());
        }
        return beastPowers;
    }


//    private List<String> restrictRacesByClass() {
//        List<String> restrictions = TraitManager.getClassRestrictions(selectedClassType.toString());
//    }

}
