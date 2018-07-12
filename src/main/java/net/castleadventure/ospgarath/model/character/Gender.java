package net.castleadventure.ospgarath.model.character;

public class Gender {

    private String value;

    public Gender(Boolean gender) {
        this.value = gender ? "Male" : "Female";
    }

    public String getValue() {
        return value;
    }

}
