package net.castleadventure.ospgarath.model.character.condition;

import net.castleadventure.ospgarath.game.GameState;

public class Hampered extends NegativeCondition {

    public Hampered() {
        this.conditionType = Type.HAMPERED;
    }

    @Override
    public void doEffect() {
        GameState.getInstance().getPlayerCharacter().changeAttackDice(-1);
    }

    @Override
    public void endEffect() {
        GameState.getInstance().getPlayerCharacter().changeAttackDice(1);
    }
}
