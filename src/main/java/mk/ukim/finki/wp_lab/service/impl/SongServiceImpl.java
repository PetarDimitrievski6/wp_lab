package mk.ukim.finki.wp_lab.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.wp_lab.model.Album;
import mk.ukim.finki.wp_lab.model.Artist;
import mk.ukim.finki.wp_lab.model.Song;
import mk.ukim.finki.wp_lab.repository.impl.InMemoryAlbumRepository;
import mk.ukim.finki.wp_lab.repository.impl.InMemorySongRepository;
import mk.ukim.finki.wp_lab.repository.jpa.AlbumRepository;
import mk.ukim.finki.wp_lab.repository.jpa.SongRepository;
import mk.ukim.finki.wp_lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }


    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        if (!song.getArtists().stream().filter(a -> a.getId().equals(artist.getId())).toList().isEmpty()){
            throw new RuntimeException();
        }
        song.getArtists().add(artist);
        this.songRepository.save(song);
        return artist;
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Song> save(String title, String genre, int releaseYear, Long albumId) {
        Album album = this.albumRepository.findById(albumId).orElseThrow(RuntimeException::new);
        Song song = new Song(title, genre, releaseYear, new ArrayList<>(), album);
        this.songRepository.deleteByTitle(title);
        return Optional.of(this.songRepository.save(song));
    }

    @Override
    @Transactional
    public Optional<Song> edit(Long id, String title, String genre, int releaseYear, Long albumId) {
        Song song = this.songRepository.findById(id).orElseThrow(RuntimeException::new);
        Album album = this.albumRepository.findById(albumId).orElseThrow(RuntimeException::new);

        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(album);

        return Optional.of(this.songRepository.save(song));
    }

    @Override
    public void deleteById(Long id) {
        this.songRepository.deleteById(id);
    }
}