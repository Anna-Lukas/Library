package src.javastart.library.model;

public class Library {


    private static final int MAX_PUBLICATION = 2000;
    private int publicationNumber;
    private Publication[] publications = new Publication[MAX_PUBLICATION];

    public Publication[] getPublications(){
        Publication [] result = new Publication[publicationNumber];
        for (int i = 0; i < result.length ; i++) {
            result[i] = publications[i];
        }
        return result;
    }


    public void addBook(Book book) {
       addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }


    private void addPublication(Publication publication){
        if(publicationNumber>=MAX_PUBLICATION){
            throw new ArrayIndexOutOfBoundsException("Max Publication exceeded" + MAX_PUBLICATION);
        }
        publications[publicationNumber] = publication;
        publicationNumber++;
    }
}
