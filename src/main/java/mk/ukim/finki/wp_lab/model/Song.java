package mk.ukim.finki.wp_lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private int releaseYear;
    @ManyToMany
    private List<Artist> artists;
    @ManyToOne
    private Album album;


    public Song(String title, String genre, int releaseYear, List<Artist> artists, Album album) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.artists = artists;
        this.album = album;
    }
}