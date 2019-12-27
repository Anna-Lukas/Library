class Book {

    String title;
    String writer ;
    int releaseYear ;
    int pagesAmount ;
    String publishingHouse;
    String ISBN ;

    Book (String booktitle, String bookwriter, int bookreleaseYear, int bookpagesAmount, String bookpublishingHouse,
          String bookISBN){
        title = booktitle;
        writer = bookwriter;
        releaseYear = bookreleaseYear;
        pagesAmount = bookpagesAmount;
        publishingHouse = bookpublishingHouse;
        ISBN = bookISBN;

    }
    void InfoBookPrinter(){
        System.out.println("Tytuł: "+ title + ", "+ "autor: "+ writer+ ", rok wydania: "+ releaseYear+ ", ilość stron: "
                            + pagesAmount+ ", wydawnictwo: "+ publishingHouse+ ", nr ISBN"+ ISBN+ ".");
    }

}
