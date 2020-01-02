package src.javastart.library.app;
import src.javastart.library.io.DataReader;
import src.javastart.library.model.Book;

import java.util.Scanner;


class Library {

    public static void main(String[] args) {

    final String appName = "Biblioteka v0.7";

    Book [] books = new Book[1000];

    DataReader dataReader = new DataReader();

    books[0]= dataReader.readAndCreateBook();
    books[1]= dataReader.readAndCreateBook();
    dataReader.close();

    System.out.println (appName);
    System.out.println(books[0].getPublishingHouse());
    System.out.println ("W Bibliotece aktualnie znajdują się książki: ");
    books[0].InfoBookPrinter();


        System.out.println("W tablicy books znajduje się: "+ books.length+ "ksiązek.");
    }
}
