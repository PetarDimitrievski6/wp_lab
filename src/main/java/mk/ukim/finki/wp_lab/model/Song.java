package mk.ukim.finki.wp_lab.model;

import lombok.Data;

import java.util.List;

@Data
public class Song {
    private Long id;
    private String title;
    private String genre;
    private int releaseYear;
    private List<Artist> performers;
    private Album album;


    public Song(String title, String genre, int releaseYear, List<Artist> performers, Album album) {
        this.id = (long) (Math.random() * 1000);
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
    }
}