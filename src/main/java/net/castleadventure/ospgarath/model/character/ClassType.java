package net.castleadventure.ospgarath.model.character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum ClassType {

    CHAMPION(1, "SQIL"),
    BARBARIAN(2, "SQLI"),
    OUTRIDER(3, "SIQL"),
    SKINCHANGER(4, "SILQ"),
    WEAPON_MASTER(5, "SLQI"),
    PALADIN(6, "SLIQ"),
    RANGER(7, "QSIL"),
    BRAWLER(8, "QSLI"),
    BOWMAN(9, "QISL"),
    BURGLAR(10, "QILS"),
    HUNTER(11, "QLSI"),
    ASSASSIN(12, "QLIS"),
    MAGE(13, "ISQL"),
    NECROMANCER(14, "ISLQ"),
    SORCERER(15, "IQSL"),
    ALCHEMIST(16, "IQLS"),
    CONJURER(17, "ILSQ"),
    HEALER(18, "ILQS"),
    CAPTAIN(19, "LSQI"),
    MARINER(20, "LSIQ"),
    SOVEREIGN(21, "LQSI"),
    SHEPHERD(22, "LQIS"),
    SCHOLAR(23, "LISQ"),
    BARD(24, "LIQS");

    private int value;
    private String classCombo;

    private static final int NUM_CLASSES = 24;

    ClassType(int value, String classCombo) {
        this.value = value;
        this.classCombo = classCombo;
    }

    public int getValue() {
        return value;
    }

    public String getClassCombo() {
        return classCombo;
    }

    public static ClassType getClassType(int value) {
        for(ClassType classType : ClassType.values()){
            if(classType.value == value){
                return classType;
            }
        }
        throw new IllegalArgumentException();
    }

    public static ClassType getClassType(String combo) {
        for(ClassType classType : ClassType.values()) {
            if(classType.classCombo.equalsIgnoreCase(combo)) {
                return classType;
            }
        }
        throw new IllegalArgumentException();
    }

    public static ClassType generateRandomClass() {
        Random random = new Random();
        int value = random.nextInt(NUM_CLASSES) + 1;

        return getClassType(value);
    }

    public static List<ClassType> getStrengthBasedClasses() {
        List<ClassType> strengthClasses = new ArrayList<>();
        for(ClassType classType : ClassType.values()) {
            if (classType.classCombo.startsWith("S")) {
                strengthClasses.add(classType);
            }
        }
        return strengthClasses;
    }

    public static List<ClassType> getQuicknessBasedClasses() {
        List<ClassType> quicknessClasses = new ArrayList<>();
        for(ClassType classType : ClassType.values()) {
            if (classType.classCombo.startsWith("Q")) {
                quicknessClasses.add(classType);
            }
        }
        return quicknessClasses;
    }

    public static List<ClassType> getIntelligenceBasedClasses() {
        List<ClassType> intelligenceClasses = new ArrayList<>();
        for(ClassType classType : ClassType.values()) {
            if (classType.classCombo.startsWith("I")) {
                intelligenceClasses.add(classType);
            }
        }
        return intelligenceClasses;
    }

    public static List<ClassType> getLeadershipBasedClasses() {
        List<ClassType> leadershipClasses = new ArrayList<>();
        for(ClassType classType : ClassType.values()) {
            if (classType.classCombo.startsWith("L")) {
                leadershipClasses.add(classType);
            }
        }
        return leadershipClasses;
    }

    public static List<ClassType> getAllClasses() {
        return Arrays.asList(ClassType.values());
    }

}
