package src.javastart.library.app;

public class LibraryApp {
    public static void main(String[] args) {
        final String appName = "BOBLIOTEKA v0.9";
        System.out.println (appName);

        LibraryControl libraryControl = new LibraryControl ();
        libraryControl.controlLoop ();

    }
}
