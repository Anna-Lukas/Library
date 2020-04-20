package src.javastart.library.io;

import src.javastart.library.model.Book;
import src.javastart.library.model.Magazine;
import src.javastart.library.model.Publication;

import java.util.Arrays;

public class ConsolePrinter {

    public void printBooks(Publication[] publications) {
        int countBooks = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                printLine(publication.toString());
                countBooks++;
            }
        }
        if (countBooks == 0) {
            printLine("Brak książków");
        }
    }


    public void printMagazine(Publication[] publications) {
        int countMagazines = 0;
        for (Publication publication : publications) {
            if (publication instanceof Magazine) {
                printLine(publication.toString());
                countMagazines++;
            }
        }
        if (countMagazines == 0) {
            printLine("Brak magazynów");
        }
    }

    public void printLine(String text) {
        System.out.println(text.toUpperCase());
    }
}
