package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private int year;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "engine_id",referencedColumnName = "id")
    private Engine engine;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "car_driver",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "dreivers_id")
    )
    private List<Driver> drivers;

    public Car(String brand, String model, int year, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    public Car(String brand, String model, int year, Engine engine, List<Driver> drivers) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.drivers = drivers;
    }
}
