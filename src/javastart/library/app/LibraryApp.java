package src.javastart.library.app;

public class LibraryApp {
    private static final String appName = "BOBLIOTEKA v1.3";

    public static void main(String[] args) {
        System.out.println (appName);

        LibraryControl libraryControl = new LibraryControl ();
        libraryControl.controlLoop ();
    }
}
