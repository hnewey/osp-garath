package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class OutriderTraits {

    private enum OutriderTraitDescription {
        TRAIT_1("Starts with mount animal exclusive to him and may begin with one additional power for it from the animal power list"),
        TRAIT_2("Not including damage, all attack rolls when not on mount are made as though hampered"),
        TRAIT_3("+5 to L rolls to resist negative conditions"),
        TRAIT_4("Without dismounting, can perform any and all of the same movements as characters not on mounts"),
        TRAIT_5("May split movements and actions with mount"),
        TRAIT_6("Can make ranged attacks with S roll instead of Q roll"),
        TRAIT_7("Successful I rolls to evaluate monsters grant an extra stat, trait, or power learned, depending on roll type");

        private String description;

        OutriderTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (OutriderTraitDescription trait : OutriderTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
