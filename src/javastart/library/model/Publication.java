package src.javastart.library.model;

public class Publication {
    private String title;
    private int releaseYear;
    private String publishingHouse;

    public Publication(String title, int releaseYear, String publishingHouse) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.publishingHouse = publishingHouse;
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


}
