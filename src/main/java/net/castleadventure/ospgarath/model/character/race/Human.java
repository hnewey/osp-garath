package net.castleadventure.ospgarath.model.character.race;

import net.castleadventure.ospgarath.model.ability.power.Power;
import net.castleadventure.ospgarath.model.ability.power.racialPowers.MansResolve;

import java.util.ArrayList;
import java.util.List;

public class Human {

    private enum HumanTraits {
        TRAIT_1("+2 to one ability and -2 to another -OR- no ability bonuses or penalties\n");

        private String description;

        HumanTraits(String description) {
            this.description = description;
        }
    }

    public static List<String> getRacialTraits() {
        List<String> racialTraits = new ArrayList<>();
        for (HumanTraits trait: HumanTraits.values()) {
            racialTraits.add(trait.description);
        }
        return racialTraits;
    }

    public static Power getRacialPower() {
        return new MansResolve();
    }

}
