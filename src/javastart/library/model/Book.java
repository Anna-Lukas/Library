package src.javastart.library.model;

import java.util.Objects;

public class Book extends Publication {

    public static final String TYPE = "Książka";
    private String writer;
    private int pagesAmount;
    private String ISBN;


    public Book(String title, String publishingHouse, int releaseYear,int pagesAmount, String writer,    String ISBN) {
        super(title,publishingHouse,releaseYear);
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
    public String toCsv() {
        return TYPE + ";"+
                getTitle()+";"+
                getPublishingHouse()+";"+
                getReleaseYear()+";"+
                pagesAmount+";"+
                writer+";"+
                ISBN;
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

    @Override
    public String toString(){
        return super.toString() +", " +pagesAmount+", "+writer+", "+ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pagesAmount == book.pagesAmount&&
                Objects.equals(writer, book.writer) &&
                Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), writer, pagesAmount, ISBN);
    }



}
