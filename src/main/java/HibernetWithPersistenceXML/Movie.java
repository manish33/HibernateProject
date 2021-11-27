package HibernetWithPersistenceXML;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    private Long id;

    private String movieName;

    private Integer releaseYear;

    private String language;

    public Movie(Long id, String movieName, Integer releaseYear, String language) {
        this.id = id;
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.language = language;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
// standard constructor, getters, setters
}
