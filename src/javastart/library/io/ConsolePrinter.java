package src.javastart.library.io;

import src.javastart.library.model.Book;
import src.javastart.library.model.Magazine;
import src.javastart.library.model.Publication;

public class ConsolePrinter {
    public void printBooks(Publication[] publications) {
        int countBooks = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                System.out.println(publication);
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
                System.out.println(publications);
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
