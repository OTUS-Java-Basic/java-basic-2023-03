import java.util.Objects;

public class Digit {
    //Просто хранилище разряда и значения цифры
    private final int digitID;
    private final int value;
    public Digit(int digitID, int value) {
        this.digitID = digitID;
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public int getDigitID() {
        return digitID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Digit digit)) return false;
        return digitID == digit.digitID && value == digit.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(digitID, value);
    }
}
