package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class CaptainTraits {

    private enum CaptainTraitDescription {
        TRAIT_1("+2 to all rolls against minions, other than damage rolls"),
        TRAIT_2("Enemies take a -2 penalty to all rolls against the Captain when he is defending an unconscious teammate"),
        TRAIT_3("Gains the positive condition Determined while defending an unconscious teammate; ends when no longer defending the teammate.");

        private String description;

        CaptainTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (CaptainTraitDescription trait : CaptainTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
