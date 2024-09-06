package com.dio.space.model;

import com.dio.space.model.DTO.AddressDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    @Column(unique = true)
    @NotNull()
    private String email;

    @Min(18)
    @Max(80)
    private int age;
    @NotNull
    private int credential;

    @Column(name = "insertion_date")
    @NotNull
    private LocalDateTime insertionDate;

    @OneToMany(mappedBy = "manager")
    private Set<ManagerAddresses> addresses;


    public Set<ManagerAddresses> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<ManagerAddresses> addresses) {
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCredential() {
        return credential;
    }

    public void setCredential(int credential) {
        this.credential = credential;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getInsertionDate() {
        return insertionDate;
    }

    public void setInsertionDate(LocalDateTime insertionDate) {
        this.insertionDate = insertionDate;
    }


    //    @JsonManagedReference
//    public List<AddressDTO> getAddresses() {
//        return addressDTOS;
//    }
//
//    public void setAddresses(List<AddressDTO> addressDTOS) {
//        this.addressDTOS = addressDTOS;
//    }
//
//    public void setAddress(AddressDTO addressDTO){
//        this.addressDTOS.add(addressDTO);
//    }
}
