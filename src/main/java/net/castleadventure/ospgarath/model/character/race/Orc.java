package net.castleadventure.ospgarath.model.character.race;

import net.castleadventure.ospgarath.model.ability.power.Power;
import net.castleadventure.ospgarath.model.ability.power.racialPowers.Bloodlust;

import java.util.ArrayList;
import java.util.List;

public class Orc {

    private enum OrcTraits {
        TRAIT_1("+4 to strength ability"),
        TRAIT_2("-6 to Intelligence or Leadership ability"),
        TRAIT_3("Cannot be female"),
        TRAIT_4("Can see in the dark");

        private String description;

        OrcTraits(String description) {
            this.description = description;
        }
    }

    public static List<String> getRacialTraits() {
        List<String> racialTraits = new ArrayList<>();
        for (OrcTraits trait: OrcTraits.values()) {
            racialTraits.add(trait.description);
        }
        return racialTraits;
    }

    public static Power getRacialPower() {
        return new Bloodlust();
    }

}
