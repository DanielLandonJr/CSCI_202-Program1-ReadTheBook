package app;

/**
 * <h1>App</h1>
 * 
 * <h3>Entry point for application. If a command line argument is supplied then that file name will be used to process otherwise defaults to "oliver.txt" per class requirements.</h3>
 *  
 * <p><strong>author:</strong> <em>Daniel C. Landon Jr.</em></p>
 * <p><strong>instructor:</strong> <em>Dr. Bob Walsh</em></p>
 * <p><strong>class:</strong> <em>CSCI 202 - Introduction to Software Systems</em></p>
 * <p><strong>date:</strong> <em>01.22.2020</em></p>
 * 
 * @author Daniel C. Landon Jr.
 * @version 0.1
 */

public class App {
    public static void main(String[] args) throws Exception {
        ProcessTheBook theBook = new ProcessTheBook();

        // check to see if args is empty
        if(args[0] == "") {
            // no command line arguments supplied so use default

            if(theBook.StartProcessing("oliver.txt")) {
                System.out.println("SUCCESS: Book Processed.");
            } // end if
            else {
                System.out.println("ERROR: Book Not Processed!");
            } // end else

        } // end if
    }
}