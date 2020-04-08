package src.javastart.library.app;


import src.javastart.library.exception.NoSuchOptionException;
import src.javastart.library.io.ConsolePrinter;
import src.javastart.library.io.DataReader;
import src.javastart.library.model.Book;
import src.javastart.library.model.Library;
import src.javastart.library.model.Magazine;
import src.javastart.library.model.Publication;

import java.util.InputMismatchException;

public class LibraryControl {


    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private Library library = new Library();

    public void controlLoop() {
        Option option;

        do {
            printOptions();
            option = getOption();
            switch (option) {
                case ADD_BOOKS:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    printer.printLine("Bledna opcja");
            }

        } while (option != option.EXIT);
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage());

            } catch (InputMismatchException e) {
                printer.printLine("Wprowadzono wartość która nie jest liczbą, wprowadź dane ponownie");
            }

        }
        return option;
    }

    private void printOptions() {
        printer.printLine("Wybierz opcje: ");
        for (Option option : Option.values()) {
            printer.printLine(option.toString());

        }
    }

    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printMagazine(publications);
    }


    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addBook(book);
        } catch (InputMismatchException e) {
            printer.printLine("Nieudało się wprowadzić numeru");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pojemności, nie da się dodac ksiązki");
        }
    }

    private void printMagazines() {
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addMagazine(magazine);
        } catch (InputMismatchException e) {
            printer.printLine("Nieudało się wprowadzić numeru");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pojemności, nie da się dodac Magazynu");
        }

    }
        private void exit () {
            printer.printLine("Koniec programu");
            dataReader.close();
        }
    }

