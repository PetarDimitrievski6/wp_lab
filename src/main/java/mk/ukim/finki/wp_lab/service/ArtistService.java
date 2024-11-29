package mk.ukim.finki.wp_lab.service;

import mk.ukim.finki.wp_lab.model.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> listArtists();
    Artist artistFindById(Long id);
}
