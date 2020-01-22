package app;

import java.io.File;
import java.util.Scanner;

/**
 * <h1>ProcessTheBook</h1>
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
     * <h3>This method is the starting point for processing a book.</h3>
     * 
     * @param _bookToProcess This is the fille that contains the text for the book to process
     * @return boolean true if book is processed correctly, false if there was a problem
     */
    public boolean StartProcessing(String _bookToProcess) {

        try {
            File readFile = new File("oliver.txt");

            Scanner _dataInput = new Scanner(readFile);

            int _lineCounter = 0;
            int _wordCounter = 0;
            
            while(_dataInput.hasNext()){
                String _line = _dataInput.nextLine();
                String[] _parse;
                
                _parse = _line.split(" ");

                _wordCounter+= _parse.length;
                _lineCounter++;
            } // end while

            _dataInput.close();

            System.out.println("Number of lines read: " + _lineCounter);
            System.out.println("Number of words read: " + _wordCounter);

        } // end try

        catch (Exception e) {
            System.out.println("Something Went Wrong");
            System.out.println(e.getMessage());

            return false; // short circuit and return
        } // end catch

        return true;
    } //  end StartProcessing
    
} // end class