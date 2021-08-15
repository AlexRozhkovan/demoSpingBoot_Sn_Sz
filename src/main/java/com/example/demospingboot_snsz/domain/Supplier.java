package com.example.demospingboot_snsz.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

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
    
    @OneToMany( mappedBy = "supplier",
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER )
    private Collection <Person> contactperson_fk;
    
    public Collection <Person> getContactperson_fk()
    {
        return contactperson_fk;
    }
    
    public void setContactperson_fk( Collection <Person> contactperson_fk )
    {
        this.contactperson_fk = contactperson_fk;
    }
    
    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "address_fk" )
    private Address address;
    
    public Address getAddress()
    {
        return address;
    }
    
    public void setAddress( Address address )
    {
        this.address = address;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId( Long id )
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName( String name )
    {
        this.name = name;
    }
    
    public Boolean getIsDeleted()
    {
        return isDeleted;
    }
    
    public void setIsDeleted( Boolean deleted )
    {
        isDeleted = deleted;
    }
}
