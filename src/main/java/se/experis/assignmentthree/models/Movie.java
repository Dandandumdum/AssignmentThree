package se.experis.assignmentthree.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@DynamicUpdate
public class Movie {
    @Id//Auto-Incremented Id value
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String director;
    @JoinColumn(name = "movie_title")
    private String movieTitle;

    private String genre;

    @JoinColumn(name = "release_year")
    private String releaseYear;

    private String picture;//URL
    private String trailer;//URL

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "franchise_id")
    public Franchise franchise;

    @JsonGetter("franchise")
    public String franchise() {
        if(franchise!= null){
            return "/api/v1/franchise/" + franchise.getId();
        }else{
            return null;
        }
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "character_movie",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    public Set<Character> characters = new HashSet<Character>();

    @JsonGetter("characters")
    public List<String> characters() {
        return characters.stream()
                .map(characters -> {
                    return "/api/v1/characters/" + characters.getId();
                }).collect(Collectors.toList());
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
