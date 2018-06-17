package net.castleadventure.ospgarath.model.monster;

import net.castleadventure.ospgarath.model.characterClass.ClassType;

import java.util.*;

public class StatResolver {

    private static Map<String, Integer> statMapping = new HashMap<>();

    private static List<String> highestKeys = new ArrayList<>();

    public int getStatBonus(int stat) {
        if (stat > 20) {
            return 4;
        }
        if (stat > 18) {
            return 3;
        }
        if (stat > 15) {
            return 2;
        }
        if (stat > 11) {
            return 1;
        }
        if (stat > 9) {
            return 0;
        }
        if (stat > 5) {
            return -1;
        }
        if (stat > 2) {
            return -2;
        }
        return -3;
    }

    public int getDamageMax(int strength) {
        if (strength > 20) {
            return 5;
        }
        if (strength > 15) {
            return 4;
        }
        if (strength > 10) {
            return 3;
        }
        if (strength > 5) {
            return 2;
        }
        return 1;
    }

    public static ClassType getClass(int s, int q, int i, int l) {
        statMapping.put("S", s);
        statMapping.put("Q", q);
        statMapping.put("I", i);
        statMapping.put("L", l);

        List<String> possibleClasses = generatePossibleClasses();

        int randomRange = possibleClasses.size();
        int classIdx = new Random().nextInt(randomRange) + 1;

        return ClassType.getClassType(possibleClasses.get(classIdx-1));
    }

    public static List<ClassType> getPossibleClasses(int s, int q, int i, int l) {
        statMapping.put("S", s);
        statMapping.put("Q", q);
        statMapping.put("I", i);
        statMapping.put("L", l);

        List<String> possibleClassSequences = generatePossibleClasses();
        List<ClassType> possibleClasses = new ArrayList<>();
        for (String sequence : possibleClassSequences) {
            possibleClasses.add(ClassType.getClassType(sequence));
        }
        return possibleClasses;
    }

    public static List<String> generatePossibleClasses() {
        List<String> possibleClasses = new ArrayList<>();

        while (true) {
            highestKeys = highestValueKeys();
            if (highestKeys.isEmpty()) {
                break;
            }
            if (highestKeys.size() == 1) {
                String key = highestKeys.get(0);
                possibleClasses = addToExistingCombos(possibleClasses, key);
                statMapping.remove(key);
            }
            else {
                int n = highestKeys.size();

                if (highestKeys.size() == 2) {
                    possibleClasses = addToExistingCombos(possibleClasses, getAllCombinations(highestKeys, 0));
                }
                else {
                    List<String> tempCombos = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        List<String> highestKeysCopy = new ArrayList<>(highestKeys);
                        tempCombos.addAll(getAllCombinations(highestKeysCopy, i));
                    }
                    possibleClasses = addToExistingCombos(possibleClasses, tempCombos);
                }
                for (String key : highestKeys) {
                    statMapping.remove(key);
                }
            }
        }
        return possibleClasses;
    }

    private static List<String> highestValueKeys() {
        List<String> highestKeys = new ArrayList<>();

        int highestValue = 0;
        for(String key : statMapping.keySet()) {
            int currentValue = statMapping.get(key);
            if (currentValue >= highestValue) {
                if (currentValue > highestValue) {
                    highestKeys.clear();
                }
                highestValue = currentValue;
                highestKeys.add(key);
            }
        }
        return highestKeys;
    }

    private static List<String> getAllCombinations(List<String> keys, int index) {
        if (keys.size() == 2) {
            List<String> combos = new ArrayList<>();
            String combo = keys.get(0) + keys.get(1);
            combos.add(combo);
            combos.add(new StringBuilder(combo).reverse().toString());
            return combos;
        }

        String currentBase = keys.get(index);
        keys.remove(index);

        List<String> tempCombos = new ArrayList<>();
        if (keys.size() > 2) {
            for (int i = 0; i < keys.size(); i++) {
                List<String> keysCopy = new ArrayList<>(keys);
                tempCombos.addAll(getAllCombinations(keysCopy, i));
            }
        }
        else {
            tempCombos = getAllCombinations(keys, index);
        }
        List<String> allCombos = new ArrayList<>();
        for (String combo : tempCombos) {
            allCombos.add(currentBase + combo);
        }
        return allCombos;
    }

    private static List<String> addToExistingCombos(List<String> existingCombos, String newAddition) {
        if (existingCombos.size() == 0) {
            existingCombos.add(newAddition);
            return existingCombos;
        }
        List<String> newCombos = new ArrayList<>();
        for (String combo : existingCombos) {
            newCombos.add(combo + newAddition);
        }
        return newCombos;
    }

    private static List<String> addToExistingCombos(List<String> existingCombos, List<String> newAdditions) {
        if (existingCombos.size() == 0) {
            return newAdditions;
        }
        List<String> newCombos = new ArrayList<>();
        for (String combo : existingCombos) {
            for (String addition : newAdditions) {
                newCombos.add(combo + addition);
            }
        }
        return newCombos;
    }

    //only used for testing
    public static void setStatMapping(int s, int q, int i, int l) {
        statMapping = new HashMap<>();

        statMapping.put("S", s);
        statMapping.put("Q", q);
        statMapping.put("I", i);
        statMapping.put("L", l);
    }
}
