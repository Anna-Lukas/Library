package src.javastart.library.app;

import src.javastart.library.io.DataReader;
import src.javastart.library.model.Book;
import src.javastart.library.model.Library;

public class LibraryControl {

    private final int exit = 0;
    private final int addBook = 1;
    private final int printBooks = 2;

    private DataReader dataReader = new DataReader ();

    private Library library = new Library();

    public void controlLoop() {
        int options;

        do {
            printOptions ();
            options = dataReader.getInt ();
            switch (options) {
                case addBook:
                    addBook ();
                    break;
                case printBooks:
                    printBooks ();
                    break;
                case exit:
                    exit ();
                    break;
                default:
                    System.out.println ("Bledna opcja");
            }

            }while (options!= exit);
        }





    private void exit() {
        System.out.println ("Koniec programu");
        dataReader.close ();
    }

    private void printBooks() {
        library.printBooks ();
    }

    private void printOptions() {
        System.out.println ("Wybierz opcje: ");
        System.out.println (exit + " - wyjscie z programu");
        System.out.println (addBook + " dodanie nowej książki");
        System.out.println (printBooks+" wyświetl dostępne książki");
    }
    private void addBook() {
        Book book =  dataReader.readAndCreateBook ();
        library.addBook (book);

    }
}
