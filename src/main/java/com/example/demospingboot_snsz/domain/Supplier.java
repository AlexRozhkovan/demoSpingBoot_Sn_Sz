package com.example.demospingboot_snsz.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table( name = "SUPPLIERS" )
public class Supplier
{
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private long id;
    
    private String name;
    
    @Column( name = "is_deleted" )
    private Boolean isDeleted = Boolean.FALSE;
    
    @OneToMany( fetch = FetchType.EAGER )
    @JoinColumn(name = "person_fk")
    private final List <Person> personsList = new ArrayList <>();
    
    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "address_fk" )
    private Address address;
    
    public Boolean getDeleted()
    {
        return isDeleted;
    }
    
    public void setDeleted( Boolean deleted )
    {
        isDeleted = deleted;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName( String name )
    {
        this.name = name;
    }
    
    public List <Person> getPersonsList()
    {
        return personsList;
    }
    
    public Address getAddress()
    {
        return address;
    }
    
    public void setAddress( Address address )
    {
        this.address = address;
    }
}
