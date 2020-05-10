package src.javastart.library.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Publication implements Serializable, Comparable<Publication> {

    private String title;
    private int releaseYear;
    private String publishingHouse;

    public Publication(String title, String publishingHouse, int releaseYear) {
        this.title = title;
        this.publishingHouse = publishingHouse;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public void InfoBookPrinter(){
    }

    @Override
    public String toString() {
        return  title + ", " + publishingHouse+ ", " + releaseYear ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return releaseYear == that.releaseYear &&
                Objects.equals(title, that.title) &&
                Objects.equals(publishingHouse, that.publishingHouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title,  publishingHouse, releaseYear);
    }

    public abstract String toCsv();

    @Override
    public int compareTo(Publication p) {
        return title.compareToIgnoreCase(p.title);
    }
}
