package net.castleadventure.ospgarath.model.character.race;

import net.castleadventure.ospgarath.model.ability.power.Power;

import java.util.List;

public class RaceManager {

    public static List<String> getRacialTraits(String race) {
        switch(race) {
            case "Dwarf":
                return Dwarf.getRacialTraits();
            case "Half-Elf":
                return HalfElf.getRacialTraits();
            case "Half-Orc":
                return HalfOrc.getRacialTraits();
            case "High Elf":
                return HighElf.getRacialTraits();
            case "Hobbit":
                return Hobbit.getRacialTraits();
            case "Human":
                return Human.getRacialTraits();
            case "Orc":
                return Orc.getRacialTraits();
            default:
                return WoodElf.getRacialTraits();
        }
    }

    public static Power getRacialPower(String race) {
        switch(race) {
            case "Dwarf":
                return Dwarf.getRacialPower();
            case "Half-Elf":
                return HalfElf.getRacialPower();
            case "Half-Orc":
                return HalfOrc.getRacialPower();
            case "High Elf":
                return HighElf.getRacialPower();
            case "Hobbit":
                return Hobbit.getRacialPower();
            case "Human":
                return Human.getRacialPower();
            case "Orc":
                return Orc.getRacialPower();
            default:
                return WoodElf.getRacialPower();
        }
    }
}
