package src.javastart.library.io.file;

import src.javastart.library.exception.DataExportException;
import src.javastart.library.exception.DataImportException;
import src.javastart.library.exception.InvalidDataException;
import src.javastart.library.model.*;

import java.io.*;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class CsvFileManager implements FileManager {
    private static final String FILE_NAME = "Library.csv";
    private static final String USERS_FILE_NAME = "Library_users.csv";

    @Override
    public Library importData() {
        Library library = new Library();
        importPublications(library);
        importUSers(library);

        return library;
    }

    private void importUSers(Library library) {
        try (Scanner fileReader = new Scanner(new File(USERS_FILE_NAME))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                LibraryUser libraryUser = createUserFromString(line);
                library.addUser(libraryUser);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak plikuL: " + USERS_FILE_NAME);
        }

    }

    private LibraryUser createUserFromString(String line) {
        String[] split = line.split(";");
        String firstName = split[0];
        String lastName = split[1];
        String pesel = split[2];
        return new LibraryUser(firstName,lastName,pesel);


    }

    private void importPublications(Library library) {
        try (Scanner fileReader = new Scanner(new File(FILE_NAME))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                Publication publication = createObjectFromString(line);
                library.addPublication(publication);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak plikuL: " + FILE_NAME);
        }

    }


    private Publication createObjectFromString(String line) {
        //Książka; Anna Karenina; Wydawnictwi; 1877; Tołstoj; 890; 098876098
        String[] split = line.split(";");
        String type = split[0];
        if (Book.TYPE.equals(type)) {
            return createBook(split);

        } else if (Magazine.TYPE.equals(type)) {
            return createMagazine(split);
        }
        throw new InvalidDataException("Nieznany typ publikacji " + type);
    }

    private Magazine createMagazine(String[] data) {
        String title = data[1];

        String publishingHouse = data[2];
        int releaseYear = Integer.valueOf(data[3]);
        int month = Integer.valueOf(data[4]);
        int day = Integer.valueOf(data[5]);
        String language = data[6];

        return new Magazine(title, publishingHouse, releaseYear, month, day, language);
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

        return new Book(title, publishingHouse, releaseYear, pagesAmount, writer, ISBN);
    }

    @Override
    public void exportData(Library library) {
        exportPublication(library);
        exportUsers(library);
    }


    private void exportPublication(Library library) {
        Collection<Publication> publications = library.getPublications().values();
        exportToCSV(publications, FILE_NAME);
    }

    private void exportUsers(Library library) {

        Collection<LibraryUser> users = library.getUsers().values();
        exportToCSV(users, USERS_FILE_NAME);
    }

    private <T extends CsvConvertible> void exportToCSV(Collection<T> collection, String fileName) {
        try(var fileWriter = new FileWriter(fileName);
            var bufferedWriter = new BufferedWriter(fileWriter)){
            for(T element:collection){
                bufferedWriter.write(element.toCsv());
                bufferedWriter.newLine();
            }
        }catch(IOException e){
                throw new DataExportException("Błąd zapisu danych do pliku"+ fileName);
            }
    }
}
