package src.javastart.library.io.file;

import src.javastart.library.exception.NoSuchFileTypeException;
import src.javastart.library.io.ConsolePrinter;
import src.javastart.library.io.DataReader;

public class FileManagerBuilder {
    private ConsolePrinter printer;
    private DataReader reader;

    public FileManagerBuilder(ConsolePrinter printer, DataReader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    public FileManager build(){
        printer.printLine("Wybierz foramt danych");
        FileType fileType = getFileTape();
        switch (fileType){
            case SERIAL:
                return new SerializableFileManager();
            case CSV:
                return new CsvFileManager();
            default:
                throw new NoSuchFileTypeException("Nieobsługiwany typ danych");
        }

    }

    private FileType getFileTape() {
        boolean typeok = false;
        FileType result = null;
        do{printTypes();
        String type = reader.getString().toUpperCase();
        try {
            result = FileType.valueOf(type);
            typeok = true;
        }catch (IllegalArgumentException e){
            printer.printLine("Nieobsługiwany typ danych, wybierz ponownie. ");
        }

    }while (!typeok);
        return result;
}

    private void printTypes() {
        for (FileType value: FileType.values()){
            printer.printLine(value.name());

        }
    }
    }
