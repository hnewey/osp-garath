package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class MageTraits {

    private enum MageTraitDescription {
        TRAIT_1("All rolls (other than damage) are made as though determined against intelligence based classes, or monsters/villains whose highest ability is intelligence"),
        TRAIT_2("Intelligence based classes and creatures may not take free attacks against the mage"),
        TRAIT_3("May double movement speed when using the \"Wizardbane\" power"),
        TRAIT_4("May make free attacks using an Intelligence roll"),
        TRAIT_5("At time of level up, may choose to add in place of a mage class power the conjurer\'s \"Counterspell\" power, or any powers listed in the conjurer\'s right side column");

        private String description;

        MageTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (MageTraitDescription trait : MageTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
