package guru.springframework.spring5webapp.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(value = AccessType.FIELD)
    private Long id;

    @Access(value = AccessType.FIELD)
    private String name;

    @Access(value = AccessType.FIELD)
    private String address;

    @Deprecated
    Publisher() {
        this("", "");
    }

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}