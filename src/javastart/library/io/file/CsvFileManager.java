package src.javastart.library.io.file;

import src.javastart.library.exception.DataExportException;
import src.javastart.library.exception.DataImportException;
import src.javastart.library.exception.InvalidDataException;
import src.javastart.library.model.Book;
import src.javastart.library.model.Library;
import src.javastart.library.model.Magazine;
import src.javastart.library.model.Publication;

import java.io.*;
import java.util.Scanner;

public class CsvFileManager implements FileManager {
    private static final String FILE_NAME = "Library.csv";

    @Override
    public Library importData() {
        Library library = new Library();
        try(Scanner fileReader = new Scanner(new File(FILE_NAME))){
        while(fileReader.hasNextLine()){
            String line = fileReader.nextLine();
            Publication publication = createObjectFromString(line);
            library.addPublication(publication);
        }
        }catch (FileNotFoundException e){
            throw new DataImportException("Brak plikuL: "+ FILE_NAME);
        }
        return library;
    }

    private Publication createObjectFromString(String line) {
        //Książka; Anna Karenina; Wydawnictwi; 1877; Tołstoj; 890; 098876098
        String[] split = line.split(";");
        String type = split[0];
        if(Book.TYPE.equals(type)){
            return createBook(split);

        }else if(Magazine.TYPE.equals(type)){
            return createMagazine(split);
        }
        throw new InvalidDataException("Nieznany typ publikacji "+type);
    }

    private Magazine createMagazine(String[] data) {
        String title = data[1];

        String publishingHouse = data[2];
        int releaseYear = Integer.valueOf(data[3]);
        int month = Integer.valueOf(data[4]);
        int day = Integer.valueOf(data[5]);
        String language = data[6];

        return new Magazine(title,publishingHouse,releaseYear, month,day,language);
    }


    /*private String title;
    private int releaseYear;
    private String publishingHouse;
*/
    private Book createBook(String[] data) {
        String title = data[1];
        String publishingHouse = data[2];
        int releaseYear = Integer.valueOf(data[3]);
        int pagesAmount = Integer.valueOf(data[4]);
        String writer = data[5];
        String ISBN = data[6];

        return new Book(title,publishingHouse,releaseYear,pagesAmount,writer,ISBN);
    }

    @Override
    public void exportData(Library library) {
        Publication[] publications =  library.getPublications();

        try (   var fileWriter = new FileWriter(FILE_NAME);
                var bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Publication publication: publications) {
                bufferedWriter.write(publication.toCsv());
                bufferedWriter.newLine();
            }

        }catch(IOException e ){
            throw new DataExportException("Błąd zapisu danych do pliku "+FILE_NAME);
        }
    }
}
