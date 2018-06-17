package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class ScholarTraits {

    private enum ScholarTraitDescription {
        TRAIT_1("At character creation, may choose to switch Intelligence and Leadership ability scores so that Intelligence becomes the highest score. This is a permanent change and cannot be reversed."),
        TRAIT_2("+1 to game secrets prior to game, and can make one additional game secrets check at a campfire"),
        TRAIT_3("Automatically succeeds on identify rolls"),
        TRAIT_4("Evaluation rolls are made as though determined"),
        TRAIT_5("Successful evaluation roll reveal an additional stat or weakness, depending on roll type");

        private String description;

        ScholarTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (ScholarTraitDescription trait : ScholarTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
