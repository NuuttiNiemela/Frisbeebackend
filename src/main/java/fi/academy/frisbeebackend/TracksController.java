package fi.academy.frisbeebackend;

import fi.academy.frisbeebackend.repositories.FrisbeeRepository;
import fi.academy.frisbeebackend.repositories.TracksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/tracks")
public class TracksController {
    private TracksRepository tr;


    private TracksService tracksService;

        public TracksController(TracksService tracksService) {
            this.tracksService = tracksService;
        }

    @Autowired
    public TracksController(TracksRepository tr) {
        this.tr = tr;
//        this.seuraavaArvo = 0;
    }
/*
    //    Kaikkien kiekkojen hakutoiminto.
    @GetMapping("")
    public Iterable<Frisbee> findAll() {
        return fr.findAll();
    }
*/

    @GetMapping("/api/list")
        public Iterable<Tracks> list() {
            return tracksService.list();
        }
    }

