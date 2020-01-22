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
            File readFile = new File("oliver.txt");

            Scanner _dataInput = new Scanner(readFile);

            int _lineCounter = 0;
            int _wordCounter = 0;
            String _longestWord = "";
            
            while(_dataInput.hasNext()){
                String _line = _dataInput.nextLine();
                String _cleanLine = "";
                String[] _parse;

                // remove all special characters from line except spaces
                _cleanLine = _line.replaceAll("[^a-zA-Z0-9\\s]", "");
                
                _parse = _cleanLine.split(" ");

                _longestWord = FindLongestWord(_parse, _longestWord);

                _wordCounter+= _parse.length;
                _lineCounter++;
            } // end while

            _dataInput.close();

            System.out.println("\nNumber of lines read: " + _lineCounter);
            System.out.println("\nNumber of words read: " + _wordCounter);
            System.out.println("\nAverage number of words per line: " + (_wordCounter / _lineCounter));
            System.out.printf("\nThe FIRST word found with the most characters was '%s', it is %d characters long.\n", _longestWord, _longestWord.length());

        } // end try

        catch (Exception e) {
            System.out.println("Something Went Wrong");
            System.out.println(e.getMessage());

            return false; // short circuit and return
        } // end catch

        return true;
    } //  end StartProcessing

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

            if(_item.length() > _currentWord.length()) _currentWord = _item;

        } // end for

        return _currentWord;

    } // end FindLongestWord
    
} // end class