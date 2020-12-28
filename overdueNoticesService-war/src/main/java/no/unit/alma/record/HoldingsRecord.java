package no.unit.alma.record;

public enum HoldingsRecord {
    RETAIN("retain"),
    DELETE("delete"),
    SUPPRESS("suppress");
    private final String stringValue;

    HoldingsRecord(final String s) {
        stringValue = s;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
