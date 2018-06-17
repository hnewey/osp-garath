package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class BowmanTraits {

    private enum BowmanTraitDescription {
        TRAIT_1("+1 to ranged attack rolls with a bow"),
        TRAIT_2("May increase ranged attack range up to 8 spaces with no penalty if no movement or quick action is taken before the attack"),
        TRAIT_3("May roll damage to all ranged attacks from a bow as though they were melee attacks"),
        TRAIT_4("Additional +2 to attack rolls against birds or other flying characters");

        private String description;

        BowmanTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (BowmanTraitDescription trait : BowmanTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
