package fi.academy.frisbeebackend;

import fi.academy.frisbeebackend.repositories.FrisbeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

//Conroller-class, johon lisätty alku url-annotaatio, CrossOrigin estämään CORS-ongelmat ja Springin vaatima RestController annotaatio.

@RestController
@CrossOrigin
@RequestMapping("/api/frisbee")
public class FrisbeeController {
    private FrisbeeRepository fr;
//    private int seuraavaArvo;

//    Konstruktori, jossa tuodaan FrisbeeRepositori konstruktorin käyttöön.
    @Autowired
    public FrisbeeController(FrisbeeRepository fr) {
        this.fr = fr;
//        this.seuraavaArvo = 0;
    }

//    Kaikkien kiekkojen hakutoiminto.
    @GetMapping("")
    public Iterable<Frisbee> findAll() {
        return fr.findAll();
    }

//    Uuden kiekon lisääminen.
    @PostMapping("")
    public ResponseEntity<Frisbee> addFrisbee(@RequestBody Frisbee frisbee, UriComponentsBuilder builder) {
//        List<Frisbee> list = new ArrayList<>();
//        for(Frisbee f : fr.findAll()) {
//            if(seuraavaArvo < f.getId()) seuraavaArvo = f.getId();
//        }
//        seuraavaArvo++;
//        frisbee.setId(seuraavaArvo);
//        fr.findById(frisbee.getId()).ifPresent(list::add);
//        if (list.size() > 0) {
//            return new ResponseEntity("Adding failed, Frisbee with that id already exists",HttpStatus.CONFLICT);
//        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/{id}").buildAndExpand(frisbee.getId()).toUri());
            fr.save(frisbee);
            return new ResponseEntity<>(frisbee, HttpStatus.CREATED);
        }
//    }

//    Kiekon poistaminen Id:n perusteella.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFrisbee(@PathVariable("id") int id) {
        List<Frisbee> list = new ArrayList<>();
        fr.findById(id).ifPresent(list::add);
        if (list.size() > 0) {
            fr.delete(list.get(0));
            return new ResponseEntity("Deletion succesful", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity("Deleting failed", HttpStatus.CONFLICT);
        }
    }

//    Kiekon muokkaus, löytö Id:llä. Vain yhden tiedon muokkaus tehty mahdolliseksi.
    @PutMapping("/{id}")
    public ResponseEntity<Frisbee> updateFrisbee(@PathVariable("id") int id,@RequestBody Frisbee frisbee) {
        frisbee.setId(id);
        Frisbee tempFrisbee = fr.findOne(id);
        if(frisbee.getName() != null) tempFrisbee.setName(frisbee.getName());
        if(frisbee.getSpeed() != null) tempFrisbee.setSpeed(frisbee.getSpeed());
        if(frisbee.getGlide() != null) tempFrisbee.setGlide(frisbee.getGlide());
        if(frisbee.getTurn() != null) tempFrisbee.setTurn(frisbee.getTurn());
        if(frisbee.getFade() != null) tempFrisbee.setFade(frisbee.getFade());

        fr.save(tempFrisbee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
