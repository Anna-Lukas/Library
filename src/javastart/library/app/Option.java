package src.javastart.library.app;

 enum Option {
    EXIT(0, "Wyjście z programu"),
    ADD_BOOKS(1, "Utwórz książkę"),
    ADD_MAGAZINE(2, "Utwórz magazyn"),
    PRINT_BOOKS(3, "wyświetl dostępne ksiązki"),
    PRINT_MAGAZINES(4, "Wyświetl dostępne magazyny");



    private final int value;
    private final String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return  value +
                " - " + description;
    }
    static Option createFromInt(int option){
        return Option.values()[option];

    }

}
