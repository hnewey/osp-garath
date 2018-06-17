package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class BarbarianTraits {

    private enum BarbarianTraitDescription {
        TRAIT_1("Can use two handed weapons with one hand, but applicable 2-handed weapon penalties still apply"),
        TRAIT_2("+1 to movement"),
        TRAIT_3("Can make ranged attack with S roll instead of Q if using throwing weapons"),
        TRAIT_4("Rolls to resist or maintain conditions are increased by amount of Strength bonus");

        private String description;

        BarbarianTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (BarbarianTraitDescription trait : BarbarianTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
