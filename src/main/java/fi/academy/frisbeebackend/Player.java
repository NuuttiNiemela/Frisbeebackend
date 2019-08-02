package fi.academy.frisbeebackend;

import javax.persistence.*;

//Keskeneräinen luokka tulevia inkrementtejä varten.
@Entity
public class Player {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Integer id;

        @Column(name="name", nullable = false)
        private String name;

        @Column(name="frisbee")
        private String frisbee;

        @Column(name="scores")
        private Integer scores;

        @Column(name="places")
        private String places;

        public Player(){
        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrisbee() {
        return frisbee;
    }

    public void setFrisbee(String frisbee) {
        this.frisbee = frisbee;
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", frisbee='" + frisbee + '\'' +
                ", scores=" + scores +
                ", places='" + places + '\'' +
                '}';
    }
}
