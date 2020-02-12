package src.javastart.library.app;

import src.javastart.library.io.DataReader;
import src.javastart.library.model.Book;
import src.javastart.library.model.Library;
import src.javastart.library.model.Magazine;

public class LibraryControl {

    private static final int EXIT = 0;
    private static final int ADD_BOOK = 1;
    private static final int ADD_MAGAZINE = 2;
    private static final int PRINT_BOOK = 3;
    private static final int PRINT_MAGAZINE = 4;

    private DataReader dataReader = new DataReader ();

    private Library library = new Library();

    public void controlLoop() {
        int options;

        do {
            printOptions ();
            options = dataReader.getInt ();
            switch (options) {
                case ADD_BOOK:
                    addBook ();
                    break;
                case ADD_MAGAZINE:
                    addMagazine ();
                    break;
                case PRINT_BOOK:
                    printBooks ();
                    break;
                case PRINT_MAGAZINE:
                    printMagazines ();
                    break;
                case EXIT:
                    exit ();
                    break;
                default:
                    System.out.println ("Bledna opcja");
            }

            }while (options!= EXIT);
        }

    private void printOptions() {
        System.out.println ("Wybierz opcje: ");
        System.out.println (EXIT + " - wyjscie z programu");
        System.out.println (ADD_BOOK + " dodanie nowej książki");
        System.out.println (ADD_MAGAZINE + " dodanie nowego magazynu");
        System.out.println (PRINT_BOOK+" wyświetl dostępne książki");
        System.out.println (PRINT_MAGAZINE+" wyświetl dostępne magazyny");
    }

    private void printBooks() {
        library.printBooks ();
    }


    private void addBook() {
        Book book =  dataReader.readAndCreateBook ();
        library.addBook (book);

    }
    private void printMagazines(){
        library.printMagazine ();
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine ();
        library.addMagazine (magazine);
    }


    private void exit() {
        System.out.println ("Koniec programu");
        dataReader.close ();
    }
}
