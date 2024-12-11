package mk.ukim.finki.wp_lab.service.impl;

import mk.ukim.finki.wp_lab.model.Artist;
import mk.ukim.finki.wp_lab.repository.impl.InMemoryArtistRepository;
import mk.ukim.finki.wp_lab.repository.jpa.ArtistRepository;
import mk.ukim.finki.wp_lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist artistFindById(Long id) {
        return artistRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}