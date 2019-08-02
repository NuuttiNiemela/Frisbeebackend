package fi.academy.frisbeebackend;

import fi.academy.frisbeebackend.repositories.TracksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Conroller-class, johon lisätty alku url-annotaatio, CrossOrigin estämään CORS-ongelmat ja Springin vaatima RestController annotaatio.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/tracks")
public class TracksController {
    private TracksRepository tr;

    /**
     * Konstruktori, jossa tuodaan TracksRepositorio konstruktorin käyttöön.
     */
    @Autowired
    public TracksController(TracksRepository tr) {
        this.tr = tr;
    }

    /**
     * Kaikkien tracksien haku
     */
    @GetMapping("")
        public Iterable<Tracks> findAll() {
            return tr.findAll();
        }

    /**
     * Kaikkien tracksien haku nimen perusteella.
     */
        @GetMapping("/haku")
        public Iterable<Tracks>findByName(@RequestParam String param){
            return tr.findByFullnameContainsIgnoreCase(param);
    }

    /**
     * Haetaan annetun parametrin perusteella Pageable metodilla jolla voidaan määrittää tulosten ja sivujen määrä,
     * annetaan tulos nousevassa järjestyksessä
     */
    @GetMapping("/tracksascending")
    public Iterable<Tracks>findTracksByParamAsc(@RequestParam int page, String param){
        Pageable pa = PageRequest.of(page, 15, Sort.Direction.ASC, param);
        return tr.findAll(pa);
    }

    /**
     * Haetaan annetun parametrin perusteella Pageable metodilla jolla voidaan määrittää tulosten ja sivujen määrä,
     * annetaan tulos laskevassa järjestyksessä
     */
    @GetMapping("/trackdescending")
    public Iterable<Tracks>findTracksByParamDesc(@RequestParam int page, String param){
        Pageable pa = PageRequest.of(page, 15, Sort.Direction.DESC, param);
        return tr.findAll(pa);
    }

    }

