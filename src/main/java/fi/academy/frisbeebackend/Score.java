package fi.academy.frisbeebackend;

import javax.persistence.*;

//Keskeneräinen luokka tulevia inkrementtejä varten.
    @Entity
    public class Score {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer id;

        @Column(name="points", nullable = false)
        private Integer points;

        @Column(name="player")
        private String player;

        @Column(name="places")
        private String places;

        public Score(){
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getPoints() {
            return points;
        }

        public void setPoints(Integer points) {
            this.points = points;
        }

        public String getPlayer() {
            return player;
        }

        public void setPlayer(String player) {
            this.player = player;
        }

        public String getPlaces() {
            return places;
        }

        public void setPlaces(String places) {
            this.places = places;
        }

        @Override
        public String toString() {
            return "Score{" +
                    "id=" + id +
                    ", points=" + points +
                    ", player='" + player + '\'' +
                    ", places='" + places + '\'' +
                    '}';
        }
    }
