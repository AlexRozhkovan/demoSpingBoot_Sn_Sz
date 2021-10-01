package com.AlexRozhkovan.demospingboot_snsz.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "SUPPLIERS")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    @Column(name = "is_deleted")
    private Boolean isDeleted = Boolean.FALSE;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_fk")
    private Address address;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "person_fk")
    private List<Person> persons = new ArrayList<>();

    public void setPersons(List<Person> personList)
    {
        persons = personList;
    }

    public List<Person> getPersons()
    {
        return persons;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Boolean getDeleted()
    {
        return isDeleted;
    }

    public void setDeleted(Boolean Deleted)
    {
        isDeleted = Deleted;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

}