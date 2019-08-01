//package fi.academy.frisbeebackend;
//
//import fi.academy.frisbeebackend.repositories.TracksRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//    public class TracksService {
//
//        private TracksRepository tracksRepository;
//
//        public TracksService(TracksRepository tracksRepository) {
//            this.tracksRepository = tracksRepository;
//        }
//
//        public Iterable<Tracks> list() {
//            return tracksRepository.findAll();
//        }
//
//        public Iterable<Tracks> save(List<Tracks> tracks) {
//            return tracksRepository.saveAll(tracks);
//        }
//
//    }