package mk.ukim.finki.wp_lab.service.impl;


import mk.ukim.finki.wp_lab.model.Album;
import mk.ukim.finki.wp_lab.repository.impl.InMemoryAlbumRepository;
import mk.ukim.finki.wp_lab.repository.jpa.AlbumRepository;
import mk.ukim.finki.wp_lab.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }
}