package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class ConjurerTraits {

    private enum ConjurerTraitDescription {
        TRAIT_1("The conjurer designates one particular polearm to act as his \"staff.\" This staff can act as a light source and may be changed at the beginning of a game"),
        TRAIT_2("Begins with a bird or falcon animal companion, and may get a new one at the beginning of a new game if it is killed or lost"),
        TRAIT_3("At time of level up, may choose to add in place of a necromancer class power the conjurer\'s \"Counterspell\" power, or any powers listed in the conjurer\'s right side column"),
        TRAIT_4("Rolls made to disarm the conjurer are made L vs I"),
        TRAIT_5("May converse in a limited sense with small animals, if successful on a I v L roll");

        private String description;

        ConjurerTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (ConjurerTraitDescription trait : ConjurerTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
