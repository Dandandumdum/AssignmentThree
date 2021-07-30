package se.experis.assignmentthree.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@DynamicUpdate
public class Character {
    @Id //Auto-Incremented Id value
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 0, max = 20)
    @JoinColumn(name = "full_name")
    private String fullName;

    private String alias;
    private String gender;
    private String picture; //URL

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

    @ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
    public Set<Movie> movies = new HashSet<Movie>();

    @JsonGetter("movies")
    public List<String> movies() {
        if(movies != null) {
            return movies.stream()
                    .map(movie -> {
                        return "/api/v1/movies/" + movie.getId();
                    }).collect(Collectors.toList());
        }
        return null;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
