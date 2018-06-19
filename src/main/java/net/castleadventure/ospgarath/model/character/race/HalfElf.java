package net.castleadventure.ospgarath.model.character.race;

import net.castleadventure.ospgarath.model.ability.power.Power;
import net.castleadventure.ospgarath.model.ability.power.racialPowers.HalfElfChoice;

import java.util.ArrayList;
import java.util.List;

public class HalfElf {

    private enum HalfElfTraits {
        TRAIT_1("+3 in one ability category"),
        TRAIT_2("-3 to one other ability");

        private String description;

        HalfElfTraits(String description) {
            this.description = description;
        }
    }

    public static List<String> getRacialTraits() {
        List<String> racialTraits = new ArrayList<>();
        for (HalfElfTraits trait: HalfElfTraits.values()) {
            racialTraits.add(trait.description);
        }
        return racialTraits;
    }

    public static Power getRacialPower() {
        return new HalfElfChoice();
    }

}
