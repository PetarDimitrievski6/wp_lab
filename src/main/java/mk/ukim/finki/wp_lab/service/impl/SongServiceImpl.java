package mk.ukim.finki.wp_lab.service.impl;

import mk.ukim.finki.wp_lab.model.Album;
import mk.ukim.finki.wp_lab.model.Artist;
import mk.ukim.finki.wp_lab.model.Song;
import mk.ukim.finki.wp_lab.repository.AlbumRepository;
import mk.ukim.finki.wp_lab.repository.SongRepository;
import mk.ukim.finki.wp_lab.service.SongService;
import org.springframework.stereotype.Service;

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
        return songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Optional<Song> findByTrackId(Long id) {
        return songRepository.findByTrackId(id);
    }

    @Override
    public Optional<Song> save(String title, Long id, String genre, int releaseYear, Long albumId) {
        Album album = this.albumRepository.findAll().stream().filter(album1 -> album1.getId().equals(albumId)).findFirst().orElseThrow(RuntimeException::new);
        return this.songRepository.save(title, id, genre, releaseYear, album);
    }

    @Override
    public void deleteById(Long id) {
        this.songRepository.deleteById(id);
    }
}