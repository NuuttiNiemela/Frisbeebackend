package fi.academy.frisbeebackend;

import fi.academy.frisbeebackend.repositories.FrisbeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/frisbee")
public class FrisbeeController {
    private FrisbeeRepository fr;

    @Autowired
    public FrisbeeController(FrisbeeRepository fr) {
        this.fr = fr;
    }

    @GetMapping("")
    public Iterable<Frisbee> findAll() {
        return fr.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Frisbee> addFrisbee(@RequestBody Frisbee frisbee, UriComponentsBuilder builder) {
        List<Frisbee> list = fr.findById(frisbee.getId());
        if (list.size() > 0) {
            return new ResponseEntity("Adding failed, Frisbee with that id already exists",HttpStatus.CONFLICT);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/{id}").buildAndExpand(frisbee.getId()).toUri());
            fr.save(frisbee);
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
    }

}
