public class UsedCurrency {
    //Для любой валюты будет только три падежа, так что, при её смене, надо будет переписать три слова в Main
    public final String imPadej;
    public final String rodPadej;
    public final String rodPadejMultiple;

    public UsedCurrency(String imPadej, String rodPadej, String rodPadejMultiple) {
        this.imPadej = imPadej;
        this.rodPadej = rodPadej;
        this.rodPadejMultiple = rodPadejMultiple;
    }
    public String getNameUnits(Digit digit, UsedCurrency currency) {
        String word = "";
        switch (digit.getValue()) {
            case 1 -> word = currency.imPadej;
            case 2,3,4 -> word = currency.rodPadej;
            default -> word = currency.rodPadejMultiple;
        }
        return word;
    }
}
