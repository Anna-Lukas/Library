package src.javastart.library.io;

import src.javastart.library.model.Book;

import java.util.Scanner;

public class DataReader {
    public void close(){
        scanner.close();
    }
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
}
