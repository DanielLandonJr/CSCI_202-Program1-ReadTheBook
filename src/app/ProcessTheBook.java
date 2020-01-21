package app;

import java.io.DataInput;
import java.io.File;
import java.util.Scanner;

public class ProcessTheBook {
    
    public boolean StartProcessing() {

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
        } // end catch

        finally {

            System.out.println("Hello There");
        }

        return true;
    } //  end StartProcessing
    
} // end class