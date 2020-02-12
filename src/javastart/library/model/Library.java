package src.javastart.library.model;

public class Library {

    private static final int MAX_BOOKS = 1000;
    private static final int MAX_MAGAZINES = 1000;
    private Book[] books = new Book[MAX_BOOKS];
    private Magazine[] magazines = new Magazine[MAX_MAGAZINES];
    private int booksNumber;
    private int magazinesNumber;

    public void addBook(Book book){
        if (booksNumber< MAX_BOOKS){
            books[booksNumber] = book;
            booksNumber++;
        }else {
            System.out.println (" nie ma miejsca na ksiązki");
        }
    }
    public void printBooks(){
        if(booksNumber==0){
            System.out.println ("Brak książków");
        }
        for(int i = 0; i<booksNumber; i++){
            books[i].InfoBookPrinter ();
        }
    }

    public void addMagazine(Magazine magazine){
        if (magazinesNumber< MAX_MAGAZINES){
            magazines[magazinesNumber] = magazine;
            magazinesNumber++;
        }else {
            System.out.println (" nie ma miejsca na magazyn");
        }
    }
    public void printMagazine(){
        if(magazinesNumber==0){
            System.out.println ("Brak magazynów");
        }
        for(int i = 0; i<magazinesNumber; i++){
            magazines[i].printInfo ();
        }
    }
}
