package src.javastart.library.app;


import src.javastart.library.exception.DataExportException;
import src.javastart.library.exception.DataImportException;
import src.javastart.library.exception.InvalidDataException;
import src.javastart.library.exception.NoSuchOptionException;
import src.javastart.library.io.ConsolePrinter;
import src.javastart.library.io.DataReader;
import src.javastart.library.io.file.FileManager;
import src.javastart.library.io.file.FileManagerBuilder;
import src.javastart.library.model.Book;
import src.javastart.library.model.Library;
import src.javastart.library.model.Magazine;
import src.javastart.library.model.Publication;

import java.util.InputMismatchException;

public class LibraryControl {


    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private FileManager fileManager;

    private Library library;

    LibraryControl() {
        fileManager = new FileManagerBuilder(printer, dataReader).build();
        try {
            library = fileManager.importData();
            printer.printLine("Zaimportowano dane z pliku");
        }catch (DataImportException | InvalidDataException e){
            printer.printLine(e.getMessage());
            printer.printLine("Zainicjowanno nową bazę.");
            library = new Library();
        }
    }

    void controlLoop() {
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

        } while (option != Option.EXIT);
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage()+", podaj ponownie: ");
            } catch (InputMismatchException ignored) {
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

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addPublication(book);
        } catch (InputMismatchException e) {
            printer.printLine("Nieudało się wprowadzić numeru");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pojemności, nie da się dodac ksiązki");
        }
    }

    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addPublication(magazine);
        } catch (InputMismatchException e) {
            printer.printLine("Nieudało się wprowadzić numeru");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pojemności, nie da się dodac Magazynu");
        }
    }

    private void printMagazines() {
        Publication[] publications = library.getPublications();
        printer.printMagazine(publications);
    }


        private void exit () {
        try {
            fileManager.exportData(library);
            printer.printLine("Ekspot danych do pliku zakończona pomyhśnie");
        }catch (DataExportException e){
            printer.printLine(e.getMessage());
        }
            printer.printLine("Koniec programu");
            dataReader.close();
        }

    enum Option {
        EXIT(0, "Wyjście z programu"),
        ADD_BOOKS(1, "Utwórz książkę"),
        ADD_MAGAZINE(2, "Utwórz magazyn"),
        PRINT_BOOKS(3, "wyświetl dostępne ksiązki"),
        PRINT_MAGAZINES(4, "Wyświetl dostępne magazyny");



        private final int value;
        private final String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return  value +
                    " - " + description;
        }


        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            }catch (ArrayIndexOutOfBoundsException e){
                throw new NoSuchOptionException("Brak opcji o id" + option);

            }
        }
    }
}

