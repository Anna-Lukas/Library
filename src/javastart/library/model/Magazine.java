package src.javastart.library.model;

public class Magazine extends Publication {

    private int month;
    private int day;
    private String language;

    private int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    private int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Magazine(String title, String publishingHouse, String language, int releaseYear,int month, int day) {
        super(title,releaseYear,publishingHouse);
        this.month = month;
        this.day = day;
        this.language = language;
    }
    public void printInfo(){
        String info = getTitle ()+ "; " +getPublishingHouse ()+ "; " +getReleaseYear ()+ "- " +getMonth ()+ "- " +getDay ()+ "; " +getLanguage ();
        System.out.println (info);
    }
}
