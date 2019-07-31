package fi.academy.frisbeebackend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

    @Data
    @AllArgsConstructor
    @Entity
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Tracks {

        @Id
        @GeneratedValue( strategy = GenerationType.IDENTITY )
        @Column(name="ID")
        private Integer id;
        @Column(name="Fullname")
        private String fullname;

        @Column(name="City")
        private String city;

        @Column(name="Location")
        private String location;

        @Column(name="X")
        private Double x;

        @Column(name="Y")
        private Double y;


        public Tracks() {}

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Tracks{" +
                    "id=" + id +
                    ", fullname='" + fullname + '\'' +
                    ", city='" + city + '\'' +
                    ", location='" + location + '\'' +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }

    }
