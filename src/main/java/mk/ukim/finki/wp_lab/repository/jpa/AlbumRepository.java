package mk.ukim.finki.wp_lab.repository.jpa;

import mk.ukim.finki.wp_lab.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
