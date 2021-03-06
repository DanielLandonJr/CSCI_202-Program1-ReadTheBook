/**
 * <h1>ProcessTheBook</h1>
 * 
 * <p><strong><em>Notes: </em></strong>This class does not have a constructor. The class will take a text file and process it for word and line count and display relevant information once completed.</p>
 * 
 * <p><strong><em>Notes: </em></strong>In order to use @custom.precondition and @ custom.postcondition in javadocs you must include the folloinwing in the command line to generate the docs. This part must be after you have indicated what files to process;
 *  -tag custom.precondition:a:"Pre-Condition"
 *  -tag custom.postcondition:a:"Post-Condition"
 * The first part identifies the tag in the code, the second part in quotes indentifies what will be printed in the javadocs when they are generated. If you do not include this in the command to generate the docs you will get an error/warning.</p>
 * 
 * <p><strong>author:</strong> <em>Daniel C. Landon Jr.</em></p>
 * <p><strong>instructor:</strong> <em>Dr. Bob Walsh</em></p>
 * <p><strong>class:</strong> <em>CSCI 202 - Introduction to Software Systems</em></p>
 * <p><strong>date:</strong> <em>01.22.2020</em></p>
 * 
 * @author Daniel C. Landon Jr.
 * @version 0.1
 */

package app;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class ProcessTheBook {

    /**
     * <h1>StartProcessing</h1>
     * 
     * <p><strong><em>Notes: </em></strong>This is the start point for processing the book.</p>
     * 
     * @custom.precondition text file must be supplied for processing
     * 
     * @custom.postcondition application will process book successfully
     * 
     * @param _bookToProcess string indicating the name of the file containg the book to process.
     * @return true if successful, false if there was a problem
     */
    public boolean StartProcessing(String _bookToProcess) {

        try {
            System.out.println("\nStarting Book Processing ...");

            // start time
            Instant _startTime = Instant.now();

            System.out.println("\n START TIME: " + _startTime);

            // open file
            File _readFile = new File(_bookToProcess);

            // read object
            Scanner _dataInput = new Scanner(_readFile);

            // variables
            int _lineCounter = 0;
            int _wordCounter = 0;
            String _longestWord = "";
            String _cleanLine = "";
            String[] _parse;
            
            while(_dataInput.hasNext()){
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

                // echo out every 100,000th line
                if(_lineCounter % 100000 == 0) System.out.println("\nEvery 100,000th line: " + _line);

            } // end while

            // close scanner object
            _dataInput.close();

            // output to console
            ConsoleOutput(_lineCounter, _wordCounter, _longestWord);
            
            // end time
            Instant _endTime = Instant.now();
            
            // differrence in _startTime and _endTime
            Duration _timeElapsed = Duration.between(_startTime, _endTime);

            System.out.println("\n END TIME: " + _endTime);
            
            System.out.println("\nTime for completion (milliseconds): " + _timeElapsed.toMillis());

        } // end try

        catch (Exception e) {

            // boom the ninja strikes
            System.out.println("\nSomething Went Wrong");
            System.out.println(e.getMessage());

            return false; // short circuit and return

        } // end catch

        return true;

    } //  end StartProcessing

    /**
     * <h1>FindWordCount</h1>
     * 
     * <p><strong><em>Notes: </em></strong>Takes an array of words and counts them, but it skips anything that is blank.</p>
     * 
     * @custom.precondition an array of words must be supplied
     * 
     * @custom.postcondition a count of how many words in the array
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
     * <p><strong><em>Notes: </em></strong>Takes a line of text and removes all non-alpha characters.</p>
     * 
     * @custom.precondition must be supplied a line of text
     * 
     * @custom.postcondition line will be modified to where only alpha characters will be available
     * 
     * @param _lineToProcess the line of text to process for special characters
     * @return the line after it has been processed
     */
    protected String StripSpecialCharacters(String _lineToProcess) {

        // remove all special characters from line
        _lineToProcess = _lineToProcess.replaceAll("[^a-zA-Z]", " ");
        
        // return the processed line
        return _lineToProcess;

    } // end StripSpecialCharacters

    /**
     * <h1>FindLongestWord</h1>
     * 
     * <p><strong><em>Notes: </em></strong>This will sort through the array of words supplied to determine which one is the largest. Once a word is found it will be kept. Any words that come after that are of the same size will be ignored and the first word found will be kept.</p>
     * 
     * @custom.precondition an array of words, with no special characters must be supplied as well as a variable containing the current largest word
     * 
     * @custom.postcondition a new variable will be returned showing the current largest word
     * 
     * @param _wordArray an array containg the words from the parsed line of text
     * @param _currentWord the largest word found.
     * @return the largest word
     */
    protected String FindLongestWord(String[] _wordArray, String _currentWord) {

        // loop the array comparing the words to find the largest one
        for(String _item: _wordArray) {

            // if the words are the same length then do nothing and keep the first word
            if(_item.length() == _currentWord.length()) return _currentWord; //short circuit and get out

            // new word is larger than current largest word so replace current largest word with new word
            if(_item.length() > _currentWord.length()) _currentWord = _item;

        } // end for

        // return new word
        return _currentWord;

    } // end FindLongestWord

    /**
     * <h1>ConsoleDisplay</h1>
     * 
     * <p><strong><em>Notes: </em></strong>Displays results of the book being processed.</p>
     * 
     * @custom.precondition variable containing line/word count as well as largest word
     * 
     * @custom.postcondition simple output to console based on information supplied
     * 
     * @param _lineCount number of lines counted
     * @param _wordCount number of words counted
     * @param _largestWord largest word found
     */
    protected void ConsoleOutput(int _lineCount, int _wordCount, String _largestWord) {

        // give me some output
        System.out.println("\nNumber of lines read: " 
            + _lineCount);
        System.out.println("\nNumber of words read: " 
            + _wordCount);
        System.out.println("\nAverage number of words per line: " 
            + (_wordCount / _lineCount));
        System.out.printf("\nThe FIRST word found with the most characters was '%s', it is %d characters long.\n", 
            _largestWord, _largestWord.length());

    } // end ConsoleDisplay
    
} // end class