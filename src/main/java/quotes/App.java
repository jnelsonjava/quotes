/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(new App().getGreeting());
        if (args[0] != null){
            String authorName = "";
            for (int i = 0; i<args.length-1; i++){
                authorName += args[i]+ " ";
            }
            authorName += args[args.length-1];
            System.out.println(new App().printQuote("src/main/resources/recentquotes.json", authorName));

        } else {
            System.out.println(new App().printQuote("src/main/resources/recentquotes.json"));
        }
    }
    public String printQuote(String filePath) throws FileNotFoundException{
        Gson gson = new Gson();
        Scanner allQuotes = new Scanner (new File(filePath));
        String quotesJSON = "";
        while (allQuotes.hasNext()){
            quotesJSON+=allQuotes.nextLine();
        }
        ArrayList<Quote> quoteList = new ArrayList<>();
        quoteList = gson.fromJson(quotesJSON, new TypeToken<ArrayList<Quote>>(){}.getType());
        int nextIndex = (int) (Math.random()*quoteList.size());
        return quoteList.get(nextIndex).toString();
    }
    public String printQuote(String filePath, String author) throws FileNotFoundException{
        Gson gson = new Gson();
        Scanner allQuotes = new Scanner (new File(filePath));
        String quotesJSON = "";
        while (allQuotes.hasNext()){
            quotesJSON+=allQuotes.nextLine();
        }
        ArrayList<Quote> quoteList = new ArrayList<>();
        quoteList = gson.fromJson(quotesJSON, new TypeToken<ArrayList<Quote>>(){}.getType());
        for (Quote q:quoteList){
            System.out.println(q.author + author);
            if (q.author.equals(author)) {
                return q.toString();
            }
        }
        return "We do not have the author in our list!";

    }
}
