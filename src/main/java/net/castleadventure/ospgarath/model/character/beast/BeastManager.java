package net.castleadventure.ospgarath.model.character.beast;

import java.util.Arrays;
import java.util.List;

public class BeastManager {

    public static List<Beast> getAllBeasts() {
        return Arrays.asList(new Dog(), new Cat(), new Weasel(), new Bird(), new Falcon(), new Viper(),
                new Bear(), new Wolf(), new Horse(), new Pony());
    }

    public static List<Beast> getMounts() {
        return Arrays.asList(new Horse(), new Pony());
    }

    public static List<Beast> getNonMounts() {
        return Arrays.asList(new Dog(), new Cat(), new Weasel(), new Bird(), new Falcon(), new Viper(), new Bear(), new Wolf());
    }

    public static List<Beast> getConjurerBeasts() {
        return Arrays.asList(new Bird(), new Falcon());
    }
}
