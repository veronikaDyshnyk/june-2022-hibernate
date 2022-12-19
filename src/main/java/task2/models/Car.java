package task2.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     private String model;
    private int price;
    @Enumerated(EnumType.STRING)
    private Type type;
    private int power;
    private int year;

    public Car(String model, int price, Type type, int power, int year) {
        this.model = model;
        this.price = price;
        this.type = type;
        this.power = power;
        this.year = year;
    }
}
