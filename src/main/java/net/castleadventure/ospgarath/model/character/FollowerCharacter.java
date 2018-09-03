package net.castleadventure.ospgarath.model.character;

public class FollowerCharacter extends Character {

    public FollowerCharacter(int s, int q, int i, int l, int e, int m) {
        super(s, q, i, l, e, m);
    }

    @Override
    public String getPlayerName() {
        return null;
    }

    @Override
    public void setPlayerName(String playerName) {

    }
}
