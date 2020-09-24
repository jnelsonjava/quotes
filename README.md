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
5. To run tests, type
```
./gradlew test
```

## Methods Used In The App Call
1. __printQuote(String filePath)__:    Method that takes in String filepath and then returns random quotes with author names

2. __printQuotes(String filePath, String author)__:  
Method that takes in String file path to json file and name of author and returns quotes by the author   

## Tests Done
1. Tests available for App file and Quote file    
