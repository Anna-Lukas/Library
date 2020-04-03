package src.javastart.library.app;

import src.javastart.library.io.DataReader;
import src.javastart.library.model.Book;
import src.javastart.library.model.Library;
import src.javastart.library.model.Magazine;

public class LibraryControl {



    private DataReader dataReader = new DataReader ();
    private Library library = new Library();

    public void controlLoop() {
        Option option;

        do {
            printOptions ();
            option = Option.createFromInt (dataReader.getInt());
            switch (option) {
                case ADD_BOOKS:
                    addBook ();
                    break;
                case ADD_MAGAZINE:
                    addMagazine ();
                    break;
                case PRINT_BOOKS:
                    printBooks ();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines ();
                    break;
                case EXIT:
                    exit ();
                    break;
                default:
                    System.out.println ("Bledna opcja");
            }

            }while (option!= option.EXIT);
        }

    private void printOptions() {
        System.out.println ("Wybierz opcje: ");
        for (Option value : Option.values()) {
            System.out.println(value);
            
        }
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
