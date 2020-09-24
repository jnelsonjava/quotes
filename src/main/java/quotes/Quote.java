package quotes;

public class Quote {
    public String author;
    public String text;

    public Quote(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public Quote(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "By  " + author + '\'' +
                 text + '\'';
    }
}
