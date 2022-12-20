package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity

public class Wheels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int inch;

    public Wheels(int inch) {
        this.inch = inch;
    }

}
