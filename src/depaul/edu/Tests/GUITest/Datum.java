package depaul.edu.Tests.GUITest;

/**
 * A class for storing information.
 **/
class Datum {
    private String name;
    private String second;
    private int value;

    public Datum(String name, String second, int value) {
        this.name = name;
        this.second = second;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getSecond() {
        return second;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%s : %s (%d)", name, second, value);
    }
}
