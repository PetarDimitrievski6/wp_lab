package mk.ukim.finki.wp_lab.service;

import mk.ukim.finki.wp_lab.model.Artist;
import mk.ukim.finki.wp_lab.model.Song;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();

    Artist addArtistToSong(Artist artist, Song song);

    Optional<Song> findById(Long id);

    Optional<Song> save(String title, String genre, int releaseYear, Long albumId);
    Optional<Song> edit(Long id, String title, String genre, int releaseYear, Long albumId);
    void deleteById(Long id);
}
