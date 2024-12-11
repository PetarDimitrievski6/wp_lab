package mk.ukim.finki.wp_lab.repository.impl;

import mk.ukim.finki.wp_lab.bootstrap.DataHolder;
import mk.ukim.finki.wp_lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryArtistRepository {
    public List<Artist> findAll() {
        return DataHolder.artists;
    }

    public Optional<Artist> findById(Long id) {
        return DataHolder.artists
                .stream()
                .filter(artist -> artist.getId().equals(id))
                .findFirst();
    }
}