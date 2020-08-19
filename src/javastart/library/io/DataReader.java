package src.javastart.library.io;

import src.javastart.library.model.Book;
import src.javastart.library.model.LibraryUser;
import src.javastart.library.model.Magazine;

import java.util.Scanner;

public class DataReader {


    Scanner scanner = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer){
        this.printer = printer;
    }

    public void close(){
        scanner.close();
    }


    public int getInt() {
        try {
            return scanner.nextInt();
        }finally {
            scanner.nextLine();
        }
    }

    public String getString(){
            return scanner.nextLine();
        }


    public Book readAndCreateBook(){
        printer.printLine("Podaj Tytuł: ");
        String title = scanner.nextLine();

        printer.printLine("Podaj wydawnictwo");
        String publishingHouse = scanner.nextLine();

        printer.printLine("podaj rok wydania: ");
        int yearRelease = getInt();


        printer.printLine("podaj ilość stron: ");
        int pagesAmount = getInt();


        printer.printLine("Podaj autora: ");
        String writer = scanner.nextLine();

        printer.printLine("Podaj ISBN: ");
        String ISBN = scanner.nextLine();

        return new Book(title,publishingHouse,yearRelease, pagesAmount,writer,ISBN);
    }


    public Magazine readAndCreateMagazine(){
        printer.printLine("Podaj Tytuł: ");
        String title = scanner.nextLine();

        printer.printLine("Podaj wydawnictwo");
        String publishingHouse = scanner.nextLine();

        printer.printLine("podaj rok wydania: ");
        int yearRelease = getInt();

        printer.printLine("podaj miesiąc wydania: ");
        int month = getInt();

        printer.printLine("podaj dzień wydania: ");
        int day= getInt();

        printer.printLine("Język: ");
        String language = scanner.nextLine();


        return new Magazine ( title,  publishingHouse, yearRelease,  day,    month,  language);
    }
    public LibraryUser createLibraryUser(){
        printer.printLine("Imię");
        String firstName = scanner.nextLine();
        printer.printLine("Nazwisko");
        String lastName = scanner.nextLine();
        printer.printLine("Pesel");
        String pesel = scanner.nextLine();
        return new LibraryUser(firstName,lastName,pesel);
    }
}
