package src.javastart.library.io;

import src.javastart.library.model.Book;
import src.javastart.library.model.Magazine;

import java.util.Scanner;

public class DataReader {

    Scanner scanner = new Scanner(System.in);
    public Book readAndCreateBook(){
        System.out.println("Podaj Tytuł: ");
        String title = scanner.nextLine();
        System.out.println("Podaj autora: ");
        String writer = scanner.nextLine();
        System.out.println("podaj rok wydania: ");
        int yearRelease = scanner.nextInt();
        scanner.nextLine();
        System.out.println("podaj ilość stron: ");
        int pagesAmount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj wydawnictwo");
        String publishingHouse = scanner.nextLine();
        System.out.println("Podaj ISBN: ");
        String ISBN = scanner.nextLine();

        return new Book(title,writer,yearRelease,pagesAmount,publishingHouse,ISBN);
    }


    public Magazine readAndCreateMagazine(){
        System.out.println("Podaj Tytuł: ");
        String title = scanner.nextLine();

        System.out.println("Podaj wydawnictwo");
        String publishingHouse = scanner.nextLine();

        System.out.println("Język: ");
        String language = scanner.nextLine();

        System.out.println("podaj rok wydania: ");
        int yearRelease = getInt();

        System.out.println("podaj miesiąc wydania: ");
        int month = getInt();

        System.out.println("podaj dzień wydania: ");
        int day= getInt();

        return new Magazine (title,publishingHouse,language,yearRelease,month,day);
    }

    public int getInt() {
        int number = scanner.nextInt ();
        scanner.nextLine ();
        return number;
    }


    public void close(){
        scanner.close();

    }
}
