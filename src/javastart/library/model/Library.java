package src.javastart.library.model;

public class Library {


    private static final int MAX_PUBLICATION = 2000;
    private int publicationNumber;
    private Publication[] publications = new Publication[MAX_PUBLICATION];

    public void addBook(Book book) {
        if (publicationNumber < MAX_PUBLICATION) {
            publications[publicationNumber] = book;
            publicationNumber++;
        } else {
            System.out.println (" nie ma miejsca na ksiązki");
        }
    }

    public void printBooks() {
        int countBooks = 0;
        for (int i = 0; i < publicationNumber; i++) {
            if (publications[i] instanceof Book){
                publications[i].InfoBookPrinter ();
            countBooks++;
        }
    }
    if (countBooks == 0) {
        System.out.println ("Brak książków");
    }
    }

    public void addMagazine(Magazine magazine) {
        if (publicationNumber < MAX_PUBLICATION) {
            publications[publicationNumber] = magazine;
            publicationNumber++;
        } else {
            System.out.println (" nie ma miejsca na magazyn");
        }
    }

    public void printMagazine() {
        int countMagazines = 0;
        for (int i = 0; i < publicationNumber; i++) {
            if (publications[i] instanceof Magazine) {
                publications[i].InfoBookPrinter ();
                countMagazines++;
            }
            if (countMagazines == 0) {
                System.out.println ("Brak magazynów");
            }
        }
    }
}
