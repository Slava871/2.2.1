package hiber.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Car() { }


    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

//    @Column(name = "user_id")
//    private int userId;

    public Car(String model, int series){
        this.model = model;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }





//    @Autowired
//    public void setUser(User userCar) {
//        this.userCar = userCar;
//    }


}
