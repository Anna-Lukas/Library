package src.javastart.library.model;

public class Book extends Publication {


    private String writer;
    private int pagesAmount;
    private String ISBN;


    public Book(String title, String writer, int releaseYear, int pagesAmount, String publishingHouse, String ISBN) {
        super(title,releaseYear,publishingHouse);
        this.pagesAmount = pagesAmount;
        this.writer = writer;
        this.ISBN = ISBN;

    }


    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }


    public int getPagesAmount() {
        return pagesAmount;
    }

    public void setPagesAmount(int pagesAmount) {
        this.pagesAmount = pagesAmount;
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public void InfoBookPrinter() {
        String info = "Tytuł: " + getTitle () + ", " + "autor: " + writer + ", rok wydania: " + getReleaseYear () + ", ilość stron: "
                + pagesAmount + ", wydawnictwo: " + getPublishingHouse ();
        if (ISBN != null) {
            info = info + ", nr ISBN: " + ISBN + ".";
        }
        System.out.println (info);

    }

}
