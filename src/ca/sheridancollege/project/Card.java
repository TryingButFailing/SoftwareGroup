package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Card {
    private String color;
    private String value;

    public Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    public abstract String getDescription();
}