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
    
    @OneToMany( fetch = FetchType.EAGER,
                cascade = CascadeType.ALL )
    @JoinColumn( name = "person_fk" )
    private List <Person> personsList = new ArrayList <>();
    
    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "address_fk" )
    @JsonIgnore
    private Address address;
    
    public void setPersonsList( List <Person> personList )
    {
        personsList = personList;
    }
    
    public List <Person> getPersonsList()
    {
        return personsList;
    }
    
    public long getId()
    {
        return id;
    }
    
    public void setId( long id )
    {
        this.id = id;
    }
    
    public Boolean getDeleted()
    {
        return isDeleted;
    }
    
    public void setDeleted( Boolean Deleted )
    {
        isDeleted = Deleted;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName( String name )
    {
        this.name = name;
    }
    
    public Address getAddress()
    {
        return address;
    }
    
    public void setAddress( Address address )
    {
        this.address = address;
    }
    
    @Override
    public String toString()
    {
        return String.format( "[id = %d, name = %s,\nadress = %s\n\t%s\nisDeleted = %b]" , getId() ,
                              getName() , getAddress() , getPersonsList().toString() ,
                              getDeleted() );
    }
}