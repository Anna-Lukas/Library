package src.javastart.library.model;

public class Book {

    private String title;
    private String writer;
    private int releaseYear;
    private int pagesAmount;
    private String publishingHouse;
    private String ISBN;

    public Book(String title, String writer, int releaseYear, int pagesAmount, String publishingHouse, String ISBN) {
        this(title, writer, releaseYear, pagesAmount, publishingHouse);
        this.ISBN = ISBN;
    }

    public Book(String title, String writer, int releaseYear, int pagesAmount, String publishingHouse) {
        this.title = title;
        this.writer = writer;
        this.releaseYear = releaseYear;
        this.pagesAmount = pagesAmount;
        this.publishingHouse = publishingHouse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getPagesAmount() {
        return pagesAmount;
    }

    public void setPagesAmount(int pagesAmount) {
        this.pagesAmount = pagesAmount;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void InfoBookPrinter() {
        String info = "Tytuł: " + title + ", " + "autor: " + writer + ", rok wydania: " + releaseYear + ", ilość stron: "
                + pagesAmount + ", wydawnictwo: " + publishingHouse;
        if (ISBN != null) {
            info = info + ", nr ISBN: " + ISBN + ".";
        }
        System.out.println(info);

    }

}
