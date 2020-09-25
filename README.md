# Quotes  

## What is Quotes about?
### The app generates random quotes from a given json file

## How to Run the File
1. Clone the git repo into the terminal using the command   
```
git clone https://github.com/jnelsonjava/quotes.git
```

2. cd into quotes directory  
``` 
cd quotes  
```
3. For random quotes generated in the command line, run this command
```
./gradlew run
```
4. For a quote from an author, run this
```
./gradlew run --args 'Full-name-of-author'  
```
5. For a StarWars Quote from the Star Wars Site
```
./gradlew run --args internet
```

6. To run tests, type
```
./gradlew test
```

## Methods Used In The App Call
1. __printQuote(String filePath)__:    Method that takes in String filepath and then returns random quotes with author names

2. __printQuotes(String filePath, String author)__:  
Method that takes in String file path to json file and name of author and returns quotes by the author  

3. __starWarsQuote(String url)__:  
Method that takes in a String url and returns a String with a random quote from a Star Wars API.  It also caches the quote in a file in resources folder so that if the url access is not available, it can print a random cached quotes.  

4. __getRecentQuotes(String filePath)__:  
Method that takes in String file path to a json file and returns an array of Quote objects from the file.  

5. __writeRecentQuotes(String filePath, arrayList quoteObjects)__:  
Method that takes in a String File path and ArrayList of Quotes and converts them into json and saves them into a .json file in the path.



## Tests Done
Tests available for App file and Quote file     

## References  
[Gson Read Json ](https://attacomsian.com/blog/gson-read-json-file)  
[Math.random()](https://javatutorialhq.com/java/lang/math-class-tutorial-2/random-method-example/)  
[Http requests](https://www.baeldung.com/java-http-request)  
[Method Overloading](https://www.tutorialspoint.com/Does-Java-support-default-parameter-values-for-a-method)  
[String.split()](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html)  
[TypeToken](https://www.javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/com/google/gson/reflect/TypeToken.html)  
[File.exists()](https://alvinalexander.com/java/java-file-exists-directory-exists/#:~:text=To%20test%20to%20see%20if,directory%20exists%2C%20and%20false%20otherwise.)  
[Assert Throws](https://www.baeldung.com/junit-assert-exception)  
