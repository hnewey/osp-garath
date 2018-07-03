package net.castleadventure.ospgarath.web;

import net.castleadventure.ospgarath.model.ability.power.Power;
import net.castleadventure.ospgarath.model.ability.power.PowerManager;
import net.castleadventure.ospgarath.model.character.race.Race;
import net.castleadventure.ospgarath.model.character.race.RaceManager;
import net.castleadventure.ospgarath.model.characterClass.ClassType;
import net.castleadventure.ospgarath.model.characterClass.ClassDescription;
import net.castleadventure.ospgarath.model.characterClass.trait.SelectedRaceAndClass;
import net.castleadventure.ospgarath.model.characterClass.trait.TraitManager;
import net.castleadventure.ospgarath.model.monster.StatResolver;
import net.castleadventure.ospgarath.model.monster.beast.Beast;
import net.castleadventure.ospgarath.model.monster.beast.BeastManager;
import net.castleadventure.ospgarath.model.monster.beast.Viper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping( value =  "" )
public class CharacterCreationController {

    private ClassType selectedClassType;

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

    @RequestMapping(value = "/race/raceList", method = RequestMethod.GET)
    public List<String> getRaces() {
        List<String> raceList = Race.getRaces();
        raceList.add(0, "");
//        raceList = restrictRacesByClass();
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


//    private List<String> restrictRacesByClass() {
//        List<String> restrictions = TraitManager.getClassRestrictions(selectedClassType.toString());
//    }

}
