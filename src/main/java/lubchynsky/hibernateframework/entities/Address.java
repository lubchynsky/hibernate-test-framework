package lubchynsky.hibernateframework.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ADDRESS")
@NoArgsConstructor
public class Address {

    @Id
    @Column(name = "ID")
    @Getter
    private int id;

    @Column(name = "COUNTRY")
    @Getter
    @Setter
    private String country;

    @Column(name = "CITY")
    @Getter
    @Setter
    private String city;

    @Column(name = "POSTAL_CODE")
    @Getter
    @Setter
    private int postalCode;

    public Address(int id, String country, String city, int postalCode) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
    }
}
