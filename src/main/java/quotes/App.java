/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {
        //1. command line options are local vs internet
        // 2. if internet API call to SW and catch it
        //3. catch should be to pick a random quote
        //4. jf local without author then get random quote
        //5. if local with author name, search for author in recent quotes

//        if (args.length>0) {
//            String authorName = "";
//            for (int i = 0; i < args.length - 1; i++) {
//                authorName += args[i] + " ";
//            }
//            authorName += args[args.length - 1];
//            System.out.println(new App().printQuote("src/main/resources/recentquotes.json", authorName));
//        } else {
//            try {
                System.out.println(new App().starWarsQuote());
//            } catch (Exception e) {
//                System.out.println(new App().printQuote("src/main/resources/recentquotes.json"));
//            }
//        }

        StarWarsQuote testStarWars = new StarWarsQuote( "any string");
        System.out.println(testStarWars);
    }

    public String starWarsQuote() throws IOException {
        Gson gson = new Gson();


        URL url = new URL("http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String firstLine = input.readLine();
        StringBuffer entireStringFromResponse = new StringBuffer();

        while (firstLine != null) {
            entireStringFromResponse.append(firstLine);
            firstLine = input.readLine();
        }
        input.close();

        StarWarsQuote swQuote = gson.fromJson(entireStringFromResponse.toString(), StarWarsQuote.class);
        swQuote.normalizeToQuote();
        // getting all the quotes from the recentquotes.json file
        ArrayList<Quote> allQuotes = getRecentQuotes("src/main/resources/recentquotes.json");
        allQuotes.add((swQuote));
        // write the file into the recentquotes.json file
        writeRecentQuotes("src/main/resources/recentquotes.json", allQuotes);
        return entireStringFromResponse.toString();
    }

    public String printQuote(String filePath) throws FileNotFoundException{
//        Gson gson = new Gson();
//        Scanner allQuotes = new Scanner (new File(filePath));
//        String quotesJSON = "";
//        while (allQuotes.hasNext()){
//            quotesJSON+=allQuotes.nextLine();
//        }
//        ArrayList<Quote> quoteList = new ArrayList<>();
//        quoteList = gson.fromJson(quotesJSON, new TypeToken<ArrayList<Quote>>(){}.getType());
        ArrayList<Quote> quoteList = getRecentQuotes(filePath);
        int nextIndex = (int) (Math.random()*quoteList.size());
        return quoteList.get(nextIndex).toString();
    }
    //this method takes
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
            if (q.author.equals(author)) {
                return q.toString();
            }
        }
        return "We do not have the author in our list!";

    }
    // this method takes in a string filepath and gets all the quotes from a .json file
    public ArrayList<Quote> getRecentQuotes(String filePath) throws FileNotFoundException {
        Gson gson = new Gson();
        Scanner allQuotes = new Scanner (new File(filePath));
        String quotesJSON = "";
        while (allQuotes.hasNext()){
            quotesJSON+=allQuotes.nextLine();
        }
        ArrayList<Quote> quoteList = new ArrayList<>();
        quoteList = gson.fromJson(quotesJSON, new TypeToken<ArrayList<Quote>>(){}.getType());
        return quoteList;
    }
    public void writeRecentQuotes(String filepath, ArrayList<Quote> allQuotes) throws IOException {
        File jsonFile = new File(filepath);
        jsonFile.createNewFile();
        FileWriter jsonFileWriter = new FileWriter(filepath);
        Gson gson = new Gson();
        gson.toJson(allQuotes, jsonFileWriter);
        jsonFileWriter.close();

    }
}
