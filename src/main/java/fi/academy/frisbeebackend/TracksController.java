package fi.academy.frisbeebackend;

import fi.academy.frisbeebackend.repositories.TracksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/tracks")
public class TracksController {
    private TracksRepository tr;

    //    Konstruktori, jossa tuodaan TracksRepositorio konstruktorin käyttöön.
    @Autowired
    public TracksController(TracksRepository tr) {
        this.tr = tr;
    }

//    kaikkien tracksien haku
    @GetMapping("")
        public Iterable<Tracks> findAll() {
            return tr.findAll();
        }

        @GetMapping("/haku")
        public Iterable<Tracks>findByName(@RequestParam String param){
            return tr.findByFullnameContainsIgnoreCase(param);
    }

    // haetaan annetaan parametrin perusteella Pageable metodilla jolla voidaan maarittaa tulosten ja sivujen maara,
//    annetaan tulos nousevassa järjestyksessä
    @GetMapping("/tracksascending")
    public Iterable<Tracks>findTracksByParamAsc(@RequestParam int page, String param){
        Pageable pa = PageRequest.of(page, 15, Sort.Direction.ASC, param);
        return tr.findAll(pa);
    }

    @GetMapping("/trackdescending")
    public Iterable<Tracks>findTracksByParamDesc(@RequestParam int page, String param){
        Pageable pa = PageRequest.of(page, 15, Sort.Direction.DESC, param);
        return tr.findAll(pa);
    }

    }

