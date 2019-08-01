//package fi.academy.frisbeebackend;
//
//import javax.persistence.*;
//
//@Entity
//public class Places {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "location")
//    private String location;
//
//    @Column(name = "tracks")
//    private String tracks;
//
//    @Column(name = "min points")
//    private Integer min_points;
//
//    public Places() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getTracks() {
//        return tracks;
//    }
//
//    public void setTracks(String tracks) {
//        this.tracks = tracks;
//    }
//
//    public Integer getMin_points() {
//        return min_points;
//    }
//
//    public void setMin_points(Integer min_points) {
//        this.min_points = min_points;
//    }
//
//    @Override
//    public String toString() {
//        return "Places{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", location='" + location + '\'' +
//                ", tracks='" + tracks + '\'' +
//                ", min_points=" + min_points +
//                '}';
//    }
//}
