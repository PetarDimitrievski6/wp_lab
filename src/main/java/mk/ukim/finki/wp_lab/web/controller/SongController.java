package mk.ukim.finki.wp_lab.web.controller;

import mk.ukim.finki.wp_lab.model.Album;
import mk.ukim.finki.wp_lab.model.Artist;
import mk.ukim.finki.wp_lab.model.Song;
import mk.ukim.finki.wp_lab.service.AlbumService;
import mk.ukim.finki.wp_lab.service.ArtistService;
import mk.ukim.finki.wp_lab.service.SongService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = {"/songs", "/"})
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;
    private final ArtistService artistService;

    public SongController(SongService songService, AlbumService albumService, ArtistService artistService) {
        this.songService = songService;
        this.albumService = albumService;
        this.artistService = artistService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Song> songs = this.songService.listSongs();
        model.addAttribute("songs", songs);
        return "listSongs";
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveSong(
            @RequestParam(required = false) Long id,
            @RequestParam String title,
            @RequestParam String genre,
            @RequestParam int releaseYear,
            @RequestParam Long album
    ){
        if (id != null){
            this.songService.edit(id, title, genre, releaseYear, album);
        } else {
            this.songService.save(title, genre, releaseYear, album);
        }
        return "redirect:/songs";
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteSong(@PathVariable Long id){
        this.songService.deleteById(id);
        return "redirect:/songs";
    }
    @GetMapping("/edit-form/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String getEditSongForm(@PathVariable Long id, Model model){
        if (this.songService.findById(id).isPresent()){
            Song song = this.songService.findById(id).get();
            List<Album> albums = this.albumService.findAll();
            model.addAttribute("song", song);
            model.addAttribute("albums", albums);
            return "add-song";
        }
        return "redirect:/songs?error=SongNotFound";
    }
    @GetMapping("/add-form")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAddSongPage(Model model){
        List<Album> albums = this.albumService.findAll();
        model.addAttribute("albums", albums);
        return "add-song";
    }
    @PostMapping("/details")
    public String getSongDetails(@RequestParam(name = "song") Long songId,
                                 @RequestParam(name = "artistChoice") Long artistId,
                                 Model model){
        Song song = this.songService.findById(songId).get();
        Artist artist = this.artistService.artistFindById(artistId);
        songService.addArtistToSong(artist, song);
        model.addAttribute("song", song);
        return "songDetails";
    }
}
