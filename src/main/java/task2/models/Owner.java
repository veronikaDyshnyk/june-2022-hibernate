package task2.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Owner {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;
   @OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
   @JoinColumn(name = "car_id", referencedColumnName = "id")
   private Car car;

   public Owner(String name, Car car) {
      this.name = name;
      this.car = car;
   }
}
