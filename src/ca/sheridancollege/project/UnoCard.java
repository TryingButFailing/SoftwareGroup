package ca.sheridancollege.project;
public class UnoCard extends Card {

    private final String color;
    private final String value;

    public UnoCard(String color, String value) {
        super(color, value);
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getDescription() {
        return color + " " + value;
    }
}
