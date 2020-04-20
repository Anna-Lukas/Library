package src.javastart.library.model;

public class Magazine extends Publication {

    public static final String TYPE = "Magazyn";
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

    public Magazine(String title,String publishingHouse,int releaseYear,  int month, int day,String language) {
        super(title,publishingHouse,releaseYear);
        this.month = month;
        this.day = day;
        this.language = language;
    }
    @Override
    public void InfoBookPrinter(){
        String info = getTitle ()+ "; " +getReleaseYear ()+ "; " +getPublishingHouse ()+ "; " +getMonth ()+ "- " +getDay ()+ "; " +getLanguage ();
        System.out.println (info);
    }
    @Override
    public String toString() {
        return super.toString() + ", " + month + ", " + day + ", " + language;
    }

    @Override

    public String toCsv() {
        return TYPE + ";"+
                getTitle()+";"+

                getPublishingHouse()+";"+
                getReleaseYear()+";"+
                month+";"+
                day+";"+
                language;
    }
}
