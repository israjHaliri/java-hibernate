package id.or.greenlabs.demo.jpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author krissadewo
 * @Date 16/01/18
 **/
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Address> addresses = new ArrayList<Address>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> courses) {
        this.addresses = courses;
    }
}
