package app;

import java.io.File;

public class ProcessTheBook {
    
    public boolean StartProcessing() {

        try {
            File readFile = new File("oliver.txt");
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