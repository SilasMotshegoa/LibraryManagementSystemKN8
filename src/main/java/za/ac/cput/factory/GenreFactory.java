package za.ac.cput.factory;

import za.ac.cput.domain.Genre;

public class GenreFactory {
    public static Genre create() {
        return new Genre.GenreBuilder()
                .setGenreID(001)
                .build();
    }
}
