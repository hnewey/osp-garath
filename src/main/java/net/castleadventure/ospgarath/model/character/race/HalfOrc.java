package net.castleadventure.ospgarath.model.character.race;

import net.castleadventure.ospgarath.model.ability.power.Power;
import net.castleadventure.ospgarath.model.ability.power.racialPowers.SavageResilience;

import java.util.ArrayList;
import java.util.List;

public class HalfOrc {

    private enum HalfOrcTraits {
        TRAIT_1("+4 to one ability category"),
        TRAIT_2("-2 to all other ability categories"),
        TRAIT_3("Can see in the dark");

        private String description;

        HalfOrcTraits(String description) {
            this.description = description;
        }
    }

    public static List<String> getRacialTraits() {
        List<String> racialTraits = new ArrayList<>();
        for (HalfOrcTraits trait: HalfOrcTraits.values()) {
            racialTraits.add(trait.description);
        }
        return racialTraits;
    }

    public static Power getRacialPower() {
        return new SavageResilience();
    }

}
