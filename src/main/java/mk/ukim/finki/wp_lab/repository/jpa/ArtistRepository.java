package mk.ukim.finki.wp_lab.repository.jpa;

import mk.ukim.finki.wp_lab.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
