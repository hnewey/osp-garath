package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class HunterTraits {

    private enum HunterTraitDescription {
        TRAIT_1("Hunters pick a specific enemy race. Against that race, the hunter gets a +2 to all attack, grapple, or evaluate rolls, adds +1 to max damage, and increases the range of its critical successes to 19-20. Hunters treat all beasts as an enemy race, gaining these same benefits against them"),
        TRAIT_2("Can throw a 1-handed melee polearm as a ranged weapon and roll damage on a successful attack as though it were a melee attack"),
        TRAIT_3("+5 to rolls to hunt on overmap");

        private String description;

        HunterTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (HunterTraitDescription trait : HunterTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
