package za.ac.cput.domain;

public class Genre {

    private Integer genreID;
    private String name;


    private Genre() {
    }


    private Genre(GenreBuilder builder) {
        this.genreID = builder.genreID;
        this.name = builder.name;
    }


    public Genre(Genre genre) {
        this.genreID = genre.getGenreID();
        this.name = genre.getName();
    }


    private Genre(Integer genreID, String name) {
        this.genreID = genreID;
        this.name = name;
    }


    public Genre(Integer genreID) {
        this.genreID = genreID;
    }


    public Integer getGenreID() {
        return genreID;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Genre{" +
                "genreID=" + genreID +
                ", name='" + name + '\'' +
                '}';
    }

    public static class GenreBuilder {
        private Integer genreID;
        private String name;

        public GenreBuilder setGenreID(Integer genreID) {
            this.genreID = genreID;
            return this;
        }

        public GenreBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public GenreBuilder copy(Genre genre) {
            this.genreID = genre.getGenreID();
            this.name = genre.getName();
            return this;
        }

        public Genre build() {
            return new Genre(this);
        }
    }
}


