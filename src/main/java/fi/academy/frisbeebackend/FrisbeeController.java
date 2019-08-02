package fi.academy.frisbeebackend;

import fi.academy.frisbeebackend.repositories.FrisbeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

//    Konstruktori, jossa tuodaan FrisbeeRepositori konstruktorin käyttöön.
    @Autowired
    public FrisbeeController(FrisbeeRepository fr) {
        this.fr = fr;
    }

//    Kaikkien kiekkojen hakutoiminto.
    @GetMapping("")
    public Iterable<Frisbee> findAll() {
        return fr.findAll();
    }

//    Uuden kiekon lisääminen.
    @PostMapping("")
    public ResponseEntity<Frisbee> addFrisbee(@RequestBody Frisbee frisbee, UriComponentsBuilder builder) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/{id}").buildAndExpand(frisbee.getId()).toUri());
            fr.save(frisbee);
            return new ResponseEntity<>(frisbee, HttpStatus.CREATED);
        }

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
        if(frisbee.getName() != null && frisbee.getName() != "") tempFrisbee.setName(frisbee.getName());
        if(frisbee.getSpeed() != null) tempFrisbee.setSpeed(frisbee.getSpeed());
        if(frisbee.getGlide() != null) tempFrisbee.setGlide(frisbee.getGlide());
        if(frisbee.getTurn() != null) tempFrisbee.setTurn(frisbee.getTurn());
        if(frisbee.getFade() != null) tempFrisbee.setFade(frisbee.getFade());

        fr.save(tempFrisbee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

// haetaan annetaan parametrin perusteella Pageable metodilla jolla voidaan maarittaa tulosten ja sivujen maara,
//    annetaan tulos nousevassa järjestyksessä
    @GetMapping("/frisbeeascending")
    public Iterable<Frisbee>findFrisbeeByParamAsc(@RequestParam int page, String param){
        Pageable p = PageRequest.of(page, 15, Sort.Direction.ASC, param);
        return fr.findAll(p);
    }
    // haetaan annetun parametrin perusteella Pageable metodilla jolla voidaan määrittää tulosten ja sivujen määrä,
//    annetaan tulos laskevassa järjestyksessä
    @GetMapping("/frisbeedescending")
    public Iterable<Frisbee>findFrsibeeByParamDesc(@RequestParam int page, String param) {
        Pageable p = PageRequest.of(page, 15, Sort.Direction.DESC, param);
        return fr.findAll(p);
    }

//   Haetaan kiekkoja, jotka sisältävät hakusanan, välittämättä isoista/pienistä kirjaimista.
    @GetMapping("/{haku}")
    public Iterable<Frisbee>findByName(@PathVariable String haku) {
        return fr.findByNameContainsIgnoreCase(haku);
    }
}
