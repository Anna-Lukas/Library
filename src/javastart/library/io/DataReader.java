package src.javastart.library.io;

import src.javastart.library.model.Book;
import src.javastart.library.model.Magazine;

import java.util.Scanner;

public class DataReader {

    Scanner scanner = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer){
        this.printer = printer;
    }

    public Book readAndCreateBook(){
        printer.printLine("Podaj Tytuł: ");
        String title = scanner.nextLine();
        printer.printLine("Podaj autora: ");
        String writer = scanner.nextLine();
        printer.printLine("podaj rok wydania: ");
        int yearRelease = scanner.nextInt();
        scanner.nextLine();
        printer.printLine("podaj ilość stron: ");
        int pagesAmount = scanner.nextInt();
        scanner.nextLine();
        printer.printLine("Podaj wydawnictwo");
        String publishingHouse = scanner.nextLine();
        printer.printLine("Podaj ISBN: ");
        String ISBN = scanner.nextLine();

        return new Book(title,writer,yearRelease,pagesAmount,publishingHouse,ISBN);
    }


    public Magazine readAndCreateMagazine(){
        printer.printLine("Podaj Tytuł: ");
        String title = scanner.nextLine();

        printer.printLine("Podaj wydawnictwo");
        String publishingHouse = scanner.nextLine();

        printer.printLine("Język: ");
        String language = scanner.nextLine();

        printer.printLine("podaj rok wydania: ");
        int yearRelease = getInt();

        printer.printLine("podaj miesiąc wydania: ");
        int month = getInt();

        printer.printLine("podaj dzień wydania: ");
        int day= getInt();

        return new Magazine (title,publishingHouse,language,yearRelease,month,day);
    }

    public int getInt() {
        try {
            return scanner.nextInt();
        }finally {
            scanner.nextLine();
        }
    }


    public void close(){
        scanner.close();

    }
}
