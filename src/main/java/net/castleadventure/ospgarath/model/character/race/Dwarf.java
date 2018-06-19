package net.castleadventure.ospgarath.model.character.race;

import net.castleadventure.ospgarath.model.ability.power.Power;
import net.castleadventure.ospgarath.model.ability.power.racialPowers.StoutAndSturdy;

import java.util.ArrayList;
import java.util.List;

public class Dwarf {

    private enum DwarfTraits {
        TRAIT_1("+2 to Strength and Endurance abilities"),
        TRAIT_2("-4 to Intelligence ability"),
        TRAIT_3("Can see in the dark");

        private String description;

        DwarfTraits(String description) {
            this.description = description;
        }
    }

    public static List<String> getRacialTraits() {
        List<String> racialTraits = new ArrayList<>();
        for (DwarfTraits trait: DwarfTraits.values()) {
            racialTraits.add(trait.description);
        }
        return racialTraits;
    }

    public static Power getRacialPower() {
        return new StoutAndSturdy();
    }
}
