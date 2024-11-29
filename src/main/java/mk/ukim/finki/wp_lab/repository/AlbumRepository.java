package mk.ukim.finki.wp_lab.repository;


import mk.ukim.finki.wp_lab.bootstrap.DataHolder;
import mk.ukim.finki.wp_lab.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumRepository {
    public List<Album> findAll(){
        return DataHolder.albums;
    }
}