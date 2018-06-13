package net.castleadventure.ospgarath.game;

import java.util.Random;

public class Dice {

    private static Random random = new Random();

    public static Integer d20() {
        return random.nextInt(20) + 1;
    }

    public static Integer d12() {
        return random.nextInt(12) + 1;
    }

    public static Integer d8() {
        return random.nextInt(8) + 1;
    }

    public static Integer d4() {
        return random.nextInt(4) + 1;
    }

    public static Integer d3() {
        return random.nextInt(3) + 1;
    }

    public static Integer d2() {
        return random.nextInt(2) + 1;
    }
}
