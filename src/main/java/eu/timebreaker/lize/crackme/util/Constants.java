package eu.timebreaker.lize.crackme.util;

public enum Constants {
    NAME("Lize-Crackme"),
    MAJOR_VERSION("0"),
    MINOR_VERSION("1"),
    FIX_VERSION("0"),
    VERSION(String.format("%s.%s.%s", MAJOR_VERSION, MINOR_VERSION, FIX_VERSION)),
    AUTHOR("FurYzen");

    String value;

    Constants(String value) {
        this.value = value;
    }

    @Override public String toString() {
        return value;
    }
}
