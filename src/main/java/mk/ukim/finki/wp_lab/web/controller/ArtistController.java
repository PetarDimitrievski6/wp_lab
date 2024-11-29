package mk.ukim.finki.wp_lab.web.controller;

import mk.ukim.finki.wp_lab.model.Song;
import mk.ukim.finki.wp_lab.service.ArtistService;
import mk.ukim.finki.wp_lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
@Controller
public class ArtistController {
    private final SongService songService;
    private final ArtistService artistService;
    public ArtistController(SongService songService, ArtistService artistService) {
        this.songService = songService;
        this.artistService = artistService;
    }

    @PostMapping("/artist-add")
    public String addArtist(@RequestParam(name = "songChoice") Long id, Model model){
        Song song = this.songService.findByTrackId(id).get();
        model.addAttribute("song", song);
        model.addAttribute("artists", this.artistService.listArtists());
        return "artistsList";
    }
}
