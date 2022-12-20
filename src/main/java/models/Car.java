package models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private int year;
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
@JoinTable(
        name= "car_wheels",
        joinColumns = @JoinColumn(name= "car_id"),
        inverseJoinColumns = @JoinColumn(name ="wheels_id")
)
    private List<Wheels> wheels;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public Car(String brand, String model, int year, List<Wheels> wheels) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.wheels = wheels;
    }
}

