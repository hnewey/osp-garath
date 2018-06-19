package net.castleadventure.ospgarath.model.character.race;

import net.castleadventure.ospgarath.model.ability.power.Power;
import net.castleadventure.ospgarath.model.ability.power.racialPowers.SilvanAccuracy;

import java.util.ArrayList;
import java.util.List;

public class WoodElf {

    private enum WoodElfTraits {
        TRAIT_1("+3 to Quickness or Intelligence ability"),
        TRAIT_2("-2 to Strength ability"),
        TRAIT_3("Immune to diseases");

        private String description;

        WoodElfTraits(String description) {
            this.description = description;
        }
    }

    public static List<String> getRacialTraits() {
        List<String> racialTraits = new ArrayList<>();
        for (WoodElfTraits trait: WoodElfTraits.values()) {
            racialTraits.add(trait.description);
        }
        return racialTraits;
    }

    public static Power getRacialPower() {
        return new SilvanAccuracy();
    }

}
