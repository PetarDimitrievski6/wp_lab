package mk.ukim.finki.wp_lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp_lab.model.Album;
import mk.ukim.finki.wp_lab.model.Artist;
import mk.ukim.finki.wp_lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists = new ArrayList<>();
    public static List<Song> songs = new ArrayList<>();
    public static List<Album> albums = new ArrayList<>();

//    @PostConstruct
//    public void init() {
//        Artist tupac = new Artist("Tupac", "Shakur", "An influential rapper known for his powerful lyrics on social issues.");
//        Artist biggie = new Artist("Christopher", "Wallace", "Known as The Notorious B.I.G., a central figure in East Coast hip-hop.");
//        Artist dre = new Artist("Andre", "Young", "Known as Dr. Dre, a rapper and producer who helped popularize West Coast rap.");
//        Artist snoop = new Artist("Calvin", "Broadus", "Known as Snoop Dogg, a laid-back West Coast rapper with iconic hits.");
//        Artist iceCube = new Artist("O'Shea", "Jackson", "Known as Ice Cube, a rapper, actor, and founding member of N.W.A.");
//        artists.add(tupac);
//        artists.add(biggie);
//        artists.add(dre);
//        artists.add(snoop);
//        artists.add(iceCube);
//
//
//        Album allEyezOnMe = new Album("All Eyez on Me", "Hip-Hop", "1996");
//        Album readyToDie = new Album("Ready to Die", "Hip-Hop", "1994");
//        Album chronic = new Album("The Chronic", "Hip-Hop", "1992");
//        Album dstyle = new Album("Dstyle", "Hip-Hop", "1993");
//        Album predator = new Album("The Predator", "Hip-Hop", "1992");
//
//        albums.add(allEyezOnMe);
//        albums.add(readyToDie);
//        albums.add(chronic);
//        albums.add(dstyle);
//        albums.add(predator);
//
//        songs.add(new Song("California Love", "Hip-Hop", 1995, new ArrayList<>(), allEyezOnMe));
//        songs.add(new Song("Juicy", "Hip-Hop", 1994, new ArrayList<>(), readyToDie));
//        songs.add(new Song("Nuthin' But a G Thang", "Hip-Hop", 1992, new ArrayList<>(), chronic));
//        songs.add(new Song("It Was a Good Day", "Hip-Hop", 1992, new ArrayList<>(), dstyle));
//        songs.add(new Song("Hit 'Em Up", "Hip-Hop", 1996, new ArrayList<>(), predator));
//    }
}