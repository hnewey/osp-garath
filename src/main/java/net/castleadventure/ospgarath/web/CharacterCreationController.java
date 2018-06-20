package net.castleadventure.ospgarath.web;

import net.castleadventure.ospgarath.model.ability.power.Power;
import net.castleadventure.ospgarath.model.ability.power.PowerManager;
import net.castleadventure.ospgarath.model.character.race.Race;
import net.castleadventure.ospgarath.model.character.race.RaceManager;
import net.castleadventure.ospgarath.model.characterClass.ClassType;
import net.castleadventure.ospgarath.model.characterClass.ClassDescription;
import net.castleadventure.ospgarath.model.characterClass.trait.TraitManager;
import net.castleadventure.ospgarath.model.monster.StatResolver;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value =  "" )
public class CharacterCreationController {

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
    public List<Power> getClassPowers(
            @PathVariable ("className") String className) {
        return PowerManager.getPowerManager(className).getClassPowers();
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
    public String getRacialPowers(
            @PathVariable ("race") String race) {
        return RaceManager.getRacialPower(race).toString();
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
}
