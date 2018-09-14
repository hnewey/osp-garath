package net.castleadventure.ospgarath.model.managers;

import net.castleadventure.ospgarath.model.character.condition.*;

import java.util.ArrayList;
import java.util.List;

public class ConditionManager {

    private List<PositiveCondition> positiveConditions = new ArrayList<>();
    private List<NegativeCondition> negativeConditions = new ArrayList<>();

    public void maintainConditions() {
        List<PositiveCondition> tempConditions = positiveConditions;
        for (PositiveCondition condition : tempConditions) {
            if (!condition.maintain()) {
                positiveConditions.remove(condition);
            }
        }
    }

    public void resistConditions() {
        List<NegativeCondition> tempConditions = negativeConditions;
        for (NegativeCondition condition : tempConditions) {
            if (!condition.resist()) {
                negativeConditions.remove(condition);
            }
        }
    }

    public void resistCondition(NegativeCondition.Type conditionType) {
        for (NegativeCondition condition : negativeConditions) {
            if (condition.getConditionType().equals(conditionType)) {
                condition.resist();
            }
        }
    }

    public void addPositiveCondition(PositiveCondition condition) {
        positiveConditions.add(condition);
    }

    public void addNegativeCondition(NegativeCondition condition) {
        negativeConditions.add(condition);
    }

    //---------------------------
    //Specific Condition checks
    //---------------------------

    public boolean isDetermined() {
        if (checkNegativeConditions(NegativeCondition.Type.HAMPERED)) {
            //if user is hampered, they are definitely not determined. If they have the determined condition, it is a wash
            return false;
        }
        return checkPositiveConditions(PositiveCondition.Type.DETERMINED);
    }

    public boolean isHampered() {
        if (checkPositiveConditions(PositiveCondition.Type.DETERMINED)) {
            return false;
        }
        return checkNegativeConditions(NegativeCondition.Type.HAMPERED);
    }

    private boolean checkPositiveConditions(PositiveCondition.Type conditionType) {
        for (Condition condition : positiveConditions) {
            switch(conditionType) {
                case DETERMINED:
                    if (condition instanceof Determined)
                        return true;
                case STEADIED:
                    if (condition instanceof Steadied)
                        return true;
                case STRENGTHENED:
                    if (condition instanceof Strengthened)
                        return true;
            }
        }
        return false;
    }

    private boolean checkNegativeConditions(NegativeCondition.Type conditionType) {
        for (Condition condition : negativeConditions) {
            switch(conditionType) {
                case BLEEDING:
                    if (condition instanceof Bleeding)
                        return true;
                case HAMPERED:
                    if (condition instanceof Hampered)
                        return true;
                case SLOWED:
                    if (condition instanceof Slowed)
                        return true;
                case STAGGERED:
                    if (condition instanceof Staggered)
                        return true;
                case WEAKENED:
                    if (condition instanceof Weakened)
                        return true;
                case IMMOBILIZED:
                    if (condition instanceof Immobilized)
                        return true;
            }
        }
        return false;
    }

    public List<PositiveCondition> getPositiveConditions() {
        return positiveConditions;
    }
    public List<NegativeCondition> getNegativeConditions() {
        return negativeConditions;
    }
}
