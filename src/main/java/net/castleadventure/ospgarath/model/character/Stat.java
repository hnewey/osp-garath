package net.castleadventure.ospgarath.model.character;

public class Stat {

    private Integer baseValue;
    private Integer currentValue;
    private Integer baseModifier;
    private Integer currentModifier;

    public Stat(Integer value) {
        this.baseValue = value;
        this.currentValue = value;
        this.baseModifier = calcModifier(baseValue);
        this.currentModifier = calcModifier(currentValue);
    }

    public Stat(String value) throws Exception {
        try {
            Integer val = Integer.valueOf(value);
            this.baseValue = val;
            this.currentValue = val;
            this.baseModifier = calcModifier(baseValue);
            this.currentModifier = calcModifier(currentValue);
        } catch (IllegalArgumentException e) {
            throw new Exception("Invalid ability stat input");
        }
    }

    public void changePermanent(Integer change) {
        baseValue += change;
    }

    public void changeTemp(Integer change) {
        currentValue += change;
    }

    public void setBaseValue(Integer baseValue) {
        this.baseValue = baseValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    public Integer getBaseValue() {
        return baseValue;
    }

    public Integer getValue() {
        return currentValue;
    }

    public Integer getBaseModifier() {
        return baseModifier;
    }

    public Integer getCurrentModifier() {
        return currentModifier;
    }

    public void resetBaseModifier() {
        baseModifier = calcModifier(baseValue);
    }

    public void resetCurrentModifier() {
        currentModifier = calcModifier(currentValue);
    }

    private Integer calcModifier(Integer statValue) {
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

    @Override
    public String toString() {
        return baseValue + (baseValue > 9 ? " (+" : " (") + baseModifier + ")";
    }
}
