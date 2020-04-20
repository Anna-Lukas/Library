package src.javastart.library.io.file;

import src.javastart.library.model.Library;

 public interface FileManager {
    Library importData();
    void exportData(Library library);

}
