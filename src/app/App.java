/**
 * <h1>App</h1>
 * 
 * <h2>Notes:</h2>
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

package app;

public class App {

    /**
     * <h1>main</h1>
     * 
     * <p><strong><em>Notes:</em></strong> Nothing special here, entry point</p>
     * 
     * @custom.precondition if a custom file is not supplied in the command line then the "oliver.txt" file must be available in the same directory as the application, this is the default text file.
     * 
     * @custom.postcondition successful execution of program
     * 
     * @param args argument list supplied through command prompt
     * @throws Exception any errors
     */
    public static void main(String[] args) throws Exception {

        // variables
        ProcessTheBook _theBook = new ProcessTheBook();
        String _processMessage = "";

        // check to see if args is empty
        if(args.length == 0) {
            // no command line arguments supplied so use default

            if(_theBook.StartProcessing("oliver.txt")) {

                _processMessage = "SUCCESS: Book Processed.";

            } // end if
        
            else {

                _processMessage = "ERROR: Book Not Processed!";

            } // end else

        } // end if

        else {
            // command line argument supplied, use the value

            if(_theBook.StartProcessing(args[0])) {

                _processMessage = "SUCCESS: Book Processed.";

            } // end if
            else {

                _processMessage = "ERROR: Book Not Processed!";
                
            } // end else

        } // end else

        System.out.println("\n" + _processMessage);

    } // end main

} // end class