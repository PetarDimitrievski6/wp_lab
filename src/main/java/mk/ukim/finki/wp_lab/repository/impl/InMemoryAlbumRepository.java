package mk.ukim.finki.wp_lab.repository.impl;


import mk.ukim.finki.wp_lab.bootstrap.DataHolder;
import mk.ukim.finki.wp_lab.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryAlbumRepository {
    public List<Album> findAll(){
        return DataHolder.albums;
    }
}