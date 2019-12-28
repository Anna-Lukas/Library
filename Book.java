class Book {




    String title;
    String writer ;
    int releaseYear ;
    int pagesAmount ;
    String publishingHouse;
    String ISBN ;

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


    void InfoBookPrinter(){
        System.out.println("Tytuł: "+ title + ", "+ "autor: "+ writer+ ", rok wydania: "+ releaseYear+ ", ilość stron: "
                            + pagesAmount+ ", wydawnictwo: "+ publishingHouse+ ", nr ISBN"+ ISBN+ ".");
    }

}
