package fi.academy.frisbeebackend;

import javax.persistence.*;


@Entity
public class Frisbee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="speed")
    private Double speed;

    @Column(name="glide")
    private Integer glide;

    @Column(name="turn")
    private Integer turn;

    @Column(name="fade")
    private Double fade;

    public Frisbee(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getGlide() {
        return glide;
    }

    public void setGlide(Integer glide) {
        this.glide = glide;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public Double getFade() {
        return fade;
    }

    public void setFade(Double fade) {
        this.fade = fade;
    }

    @Override
    public String toString() {
        return "Frisbee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", glide=" + glide +
                ", turn=" + turn +
                ", fade=" + fade +
                '}';
    }
}