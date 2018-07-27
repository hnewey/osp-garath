package net.castleadventure.ospgarath.model.character;

import java.util.HashMap;
import java.util.Map;

public class Stat {

    private Integer value;
    private Integer rollModifier;
    private Map<String, Integer> modifiers = new HashMap<>();

    public Stat(Integer value) {
        this.value = value;
        this.rollModifier = calcRollModifier(this.value);
    }

    public Stat(String value) throws Exception {
        try {
            this.value = Integer.valueOf(value);
            this.rollModifier = calcRollModifier(this.value);
        } catch (IllegalArgumentException e) {
            throw new Exception("Invalid ability stat input");
        }
    }

    public void changePermanent(Integer change) {
        value += change;
        resetRollModifier();
    }

    public void addModifier(Integer change, String reason) {
        modifiers.put(reason, change);
        resetRollModifier();
    }

    public void removeModifier(String reason) {
        modifiers.remove(reason);
        resetRollModifier();
    }

    public void setValue(Integer value) {
        this.value = value;
        resetRollModifier();
    }

    public Integer getValue() {
        return value + sumModifiers();
    }

    public Integer getRollModifier() {
        return rollModifier;
    }

    private void resetRollModifier() {
        rollModifier = calcRollModifier(value);
    }

    private Integer calcRollModifier(Integer statValue) {
        statValue += sumModifiers();
        if (statValue > 20)
            return 4;
        if (statValue >= 19)
            return 3;
        if (statValue >= 16)
            return 2;
        if (statValue >= 12)
            return 1;
        if (statValue >= 10)
            return 0;
        if (statValue >= 6)
            return -1;
        if (statValue >= 3)
            return -2;
        else
            return -3;
    }

    private Integer sumModifiers() {
        Integer sum = 0;
        for (String reason : modifiers.keySet()) {
            sum += modifiers.get(reason);
        }
        return sum;
    }

    @Override
    public String toString() {
        return value + (value > 9 ? " (+" : " (") + rollModifier + ")";
    }
}
