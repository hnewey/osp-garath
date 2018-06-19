package net.castleadventure.ospgarath.model.character.race;

import net.castleadventure.ospgarath.model.ability.power.Power;
import net.castleadventure.ospgarath.model.ability.power.racialPowers.HobbitLuck;

import java.util.ArrayList;
import java.util.List;

public class Hobbit {

    private enum HobbitTraits {
        TRAIT_1("+2 to Quickness and Intelligence abilities"),
        TRAIT_2("-4 to Strength ability"),
        TRAIT_3("-1 to movement"),
        TRAIT_4("Equipping 1H weapons other than daggers requires 2H. Cannot equip 2H melee weapons");

        private String description;

        HobbitTraits(String description) {
            this.description = description;
        }
    }

    public static List<String> getRacialTraits() {
        List<String> racialTraits = new ArrayList<>();
        for (HobbitTraits trait: HobbitTraits.values()) {
            racialTraits.add(trait.description);
        }
        return racialTraits;
    }

    public static Power getRacialPower() {
        return new HobbitLuck();
    }

}
