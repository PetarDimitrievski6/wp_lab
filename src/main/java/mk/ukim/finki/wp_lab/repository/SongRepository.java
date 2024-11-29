package mk.ukim.finki.wp_lab.repository;

import mk.ukim.finki.wp_lab.bootstrap.DataHolder;
import mk.ukim.finki.wp_lab.model.Album;
import mk.ukim.finki.wp_lab.model.Artist;
import mk.ukim.finki.wp_lab.model.Song;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {
    public List<Song> findAll(){
        return DataHolder.songs;
    }
    public Optional<Song> findByTrackId(Long id){
        return DataHolder.songs
                .stream()
                .filter(song -> song.getId().equals(id))
                .findFirst();
    }
    public Artist addArtistToSong(Artist artist, Song song){
        song.getPerformers().removeIf(artist1 -> artist1.getId().equals(artist.getId()));
        song.getPerformers().add(artist);
        return artist;
    }
    public Optional<Song> save(String title, Long id, String genre, int releaseYear, Album album){
        DataHolder.songs.removeIf(song -> song.getId().equals(id));
        Song song = new Song(title, genre, releaseYear, new ArrayList<>(), album);
        song.setId(id);
        DataHolder.songs.add(song);
        return Optional.of(song);
    }

    public void deleteById(Long id) {
        DataHolder.songs.removeIf(song -> song.getId().equals(id));
    }
}
