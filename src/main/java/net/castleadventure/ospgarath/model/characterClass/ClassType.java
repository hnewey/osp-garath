package net.castleadventure.ospgarath.model.character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum ClassType {

    CHAMPION(1, "SQIL", "Champion"),
    BARBARIAN(2, "SQLI", "Barbarian"),
    OUTRIDER(3, "SIQL", "Outrider"),
    SKINCHANGER(4, "SILQ", "Skinchanger"),
    WEAPON_MASTER(5, "SLQI", "Weapon Master"),
    PALADIN(6, "SLIQ", "Paladin"),
    RANGER(7, "QSIL", "Ranger"),
    BRAWLER(8, "QSLI", "Brawler"),
    BOWMAN(9, "QISL", "Bowman"),
    BURGLAR(10, "QILS", "Burglar"),
    HUNTER(11, "QLSI", "Hunter"),
    ASSASSIN(12, "QLIS", "Assassin"),
    MAGE(13, "ISQL", "Mage"),
    NECROMANCER(14, "ISLQ", "Necromancer"),
    SORCERER(15, "IQSL", "Sorcerer"),
    ALCHEMIST(16, "IQLS", "Alchemist"),
    CONJURER(17, "ILSQ", "Conjurer"),
    HEALER(18, "ILQS", "Healer"),
    CAPTAIN(19, "LSQI", "Captain"),
    MARINER(20, "LSIQ", "Mariner"),
    SOVEREIGN(21, "LQSI", "Sovereign"),
    SHEPHERD(22, "LQIS", "Shepherd"),
    SCHOLAR(23, "LISQ", "Scholar"),
    BARD(24, "LIQS", "Bard");

    private int value;
    private String classCombo;
    private String className;

    private static final int NUM_CLASSES = 24;

    ClassType(int value, String classCombo, String className) {
        this.value = value;
        this.classCombo = classCombo;
        this.className = className;
    }

    public int getValue() {
        return value;
    }

    public String getClassCombo() {
        return classCombo;
    }

    public String getClassName() {
        return className;
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

    public static List<String> getAllClassNames() {
        List<String> classNames = new ArrayList<>();
        for (int i = 0; i < ClassType.values().length; i++) {
            classNames.add(ClassType.values()[i].className);
        }
        return classNames;
    }

    public static List<String> getAllClassNamesWithCombos() {
        List<String> classNames = new ArrayList<>();
        for (int i = 0; i < ClassType.values().length; i++) {
            classNames.add(ClassType.values()[i].className + " (" + ClassType.values()[i].classCombo + ")");
        }
        return classNames;
    }

}
