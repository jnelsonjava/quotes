package quotes;

public class StarWarsQuote extends Quote {
    String starWarsQuote;

    public StarWarsQuote(String text) {
        super(text);
    }

    @Override
    public String toString() {
        return "StarWarsQuote{" +
                "starWarsQuote='" + starWarsQuote + '\'' +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public void normalizeToQuote() {
        this.text = this.starWarsQuote;
    }
}
