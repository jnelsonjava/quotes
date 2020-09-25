package quotes;

public class StarWarsQuote extends Quote {
    String starWarsQuote;

    public StarWarsQuote(String text) {
        super(text);
    }

    public void normalizeToQuote() {
        this.text = this.starWarsQuote.split("\\s—\\s")[0].toString();
        this.author = this.starWarsQuote.split("\\s—\\s")[1].toString();
    }
}
