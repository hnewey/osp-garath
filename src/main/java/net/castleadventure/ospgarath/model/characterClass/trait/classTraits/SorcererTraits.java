package net.castleadventure.ospgarath.model.characterClass.trait.classTraits;

import java.util.ArrayList;
import java.util.List;

public class SorcererTraits {

    private enum SorcererTraitDescription {
        TRAIT_1("Begins with a viper animal companion that is tamed for the sorcerer. If lost or killed, the sorcerer may get a new one at the start a new game"),
        TRAIT_2("Adds +1 to Intelligence for each kill. These additional Intelligence points are lost at the end of game"),
        TRAIT_3("Takes no unarmed penalties, or free attacks for failing an unarmed attack"),
        TRAIT_4("At time of level up, may choose to add in place of a necromancer class power the conjurer\'s \"Counterspell\" power, or any powers listed in the conjurer\'s right side column"),
        TRAIT_5("Damage range is calculated with Int. ability score");

        private String description;

        SorcererTraitDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }


    public static List<String> getTraitList() {
        List<String> traitList = new ArrayList<>();
        for (SorcererTraitDescription trait : SorcererTraitDescription.values()) {
            traitList.add(trait.getDescription());
        }
        return traitList;
    }

}
