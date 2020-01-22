package app;

import java.io.File;
import java.util.Scanner;

/**
 * <h1>ProcessTheBook</h1>
 * 
 * <h2>Notes:</h2>
 * 
 * <h3>This class does not have a constructor. The class will take a text file and process it for word and line count and display relevant information once completed.</h3>
 * 
 * <p><strong>author:</strong> <em>Daniel C. Landon Jr.</em></p>
 * <p><strong>instructor:</strong> <em>Dr. Bob Walsh</em></p>
 * <p><strong>class:</strong> <em>CSCI 202 - Introduction to Software Systems</em></p>
 * <p><strong>date:</strong> <em>01.22.2020</em></p>
 * 
 * @author Daniel C. Landon Jr.
 * @version 0.1
 */

public class ProcessTheBook {

    /**
     * <h1>StartProcessing</h1>
     * 
     * <h2>Notes:</h2>
     * 
     * <h3>This is the start point for processing the book.</h3>
     * 
     * @param _bookToProcess string indicating the name of the file containg the book to process.
     * @return true if successful, false if there was a problem
     */
    public boolean StartProcessing(String _bookToProcess) {

        try {
            // open file
            File readFile = new File(_bookToProcess);

            // read object
            Scanner _dataInput = new Scanner(readFile);

            // variables
            int _lineCounter = 0;
            int _wordCounter = 0;
            String _longestWord = "";
            String _cleanLine = "";
            String[] _parse;
            
            // while(_dataInput.hasNext()){
                // read the line
                String _line = _dataInput.nextLine();

                // strinp special characters
                _cleanLine = StripSpecialCharacters(_line);
                
                // parse the sentence into individual words
                _parse = _cleanLine.split(" ");

                // find the first longest word
                _longestWord = FindLongestWord(_parse, _longestWord);

                // get the word count for words with length greater than zero
                _wordCounter+= FindWordCount(_parse);

                // number of lines processed
                _lineCounter++;
            // } // end while

            _dataInput.close();

            // output to console
            ConsoleOutput(_lineCounter, _wordCounter, _longestWord);

        } // end try

        catch (Exception e) {
            // boom the nija strikes
            System.out.println("Something Went Wrong");
            System.out.println(e.getMessage());

            return false; // short circuit and return
        } // end catch

        return true;

    } //  end StartProcessing

    /**
     * <h1>FindWordCount</h1>
     * 
     * <h2>Notes:</h2>
     * 
     * <h3>Takes and array of words and counts them, but it skips anything that is blank.</h3>
     * 
     * @param _wordArray array of words from parsed sentence
     * @return returns the numbers of words found
     */
    protected int FindWordCount(String[] _wordArray) {

        // variables
        int _tempCount = 0;

        // loop the array
        for(String _item: _wordArray){
            
            // if the word length is greater than zero count it.
            // i am doing this here. having trouble removing blank words using regex...if i do not do this my word count is off
            if(_item.length() > 0 ) _tempCount++; // end if

        } // end for

        // return the count
        return _tempCount;

    } // end FindWordCount

    /**
     * <h1>StripSpecialCharacters</h1>
     * 
     * <h2>Notes:</h2>
     * 
     * <h3>Takes a line of text and removes all non-alpha characters.</h3>
     * 
     * @param _lineToProcess the line of text to process for special characters
     * @return the line after it has been processed
     */
    protected String StripSpecialCharacters(String _lineToProcess) {

        // remove all special characters from line
        _lineToProcess =  _lineToProcess.replaceAll("[^a-zA-Z]", " ");
        
        // return the processed line
        return _lineToProcess;

    } // end StripSpecialCharacters

    /**
     * <h1>FindLongestWord</h1>
     * 
     * <h2>Notes:</h2>
     * 
     * <h3>This will sort through the array of words supplied to determine which one is the largest. Once a word is found it will be kept. Any words that come after that are of the same size will be ignored and the first word found will be kept.</h3>
     * 
     * @param _wordArray an array containg the words from the parsed line of text
     * @param _currentWord the largest word found.
     * @return the largest word
     */
    protected String FindLongestWord(String[] _wordArray, String _currentWord) {

        // loop the array comparing the words to find the largest one
        for(String _item: _wordArray) {

            // if the words are the same length then do nothing and keep the first word
            if(_item.length() == _currentWord.length()) {
                return _currentWord; //short circuit and get out
            } // end if

            // new word is larger than current largest word so replace current largest word with new word
            if(_item.length() > _currentWord.length()) _currentWord = _item;

        } // end for

        // return new word
        return _currentWord;

    } // end FindLongestWord

    /**
     * <h1>ConsoleDisplay</h1>
     * 
     * <h2>Notes:</h2>
     * 
     * <h3>Displays results of the book being processed.</h3>
     * 
     * @param _lineCount number of lines counted
     * @param _wordCount number of words counted
     * @param _largestWord largest word found
     */
    protected void ConsoleOutput(int _lineCount, int _wordCount, String _largestWord) {

        // geie me some output
        System.out.println("\nNumber of lines read: " + _lineCount);
        System.out.println("\nNumber of words read: " + _wordCount);
        System.out.println("\nAverage number of words per line: " + (_wordCount / _lineCount));
        System.out.printf("\nThe FIRST word found with the most characters was '%s', it is %d characters long.\n", _largestWord, _largestWord.length());

    } // ConsoleDisplay
    
} // end class