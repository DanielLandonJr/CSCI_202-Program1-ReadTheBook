package app;

public class App {
    public static void main(String[] args) throws Exception {
        ProcessTheBook theBook = new ProcessTheBook();

        if(theBook.StartProcessing()) {
            System.out.println("Book Processed Successfully");
        }; // end if
    }
}