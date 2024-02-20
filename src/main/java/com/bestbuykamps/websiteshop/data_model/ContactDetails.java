package com.bestbuykamps.websiteshop.data_model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "contact_details")
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", length = 50)
    @Length(min = 3, max = 50, message = "First name has to be between 3 and 50 characters long")
    private String firstName;

    @Column(name = "last_name", length = 50)
    @Length(min = 3, max = 50, message = "Last name has to be between 3 and 50 characters long")
    private String lastName;

    @Column(name = "street", length = 300)
    @Length(min = 5, max = 300, message = "Street has to be between 5 and 300 characters long")
    private String street;

    @Column(name = "house_number", length = 10)
    @Length(min = 1, max = 10, message = "House number has to be between 1 and 10 characters long")
    private String houseNumber;

    @Column(name = "apartment_number", length = 10)
    @Length(min = 1, max = 10, message = "Apartment number has to be between 1 and 10 characters long")
    private String apartmentNumber;

    @Column(name = "postal_code", length = 6)
    @Length(min = 4, max = 6, message = "Postal code has to be between 4 and 6 characters long")
    private String postalCode;

    @Column(name = "city", length = 30)
    @Length(min = 3, max = 30, message = "City has to be between 3 and 30 characters long")
    private String city;

    @Column(name = "phone_number", length = 9)
    @Length(min = 6, max = 9, message = "Phone number has to be between 6 and 9 characters long")
    private String phoneNumber;

    @Column(name = "email", length = 30)
    @Length(min = 6, max = 30, message = "Email has to be between 6 and 30 characters long")
    private String email;


    @Column(name = "country", length = 20)
    @Length(min = 3, max = 20, message = "Country has to be between 3 and 20 characters long")
    private String country;

    @OneToOne(mappedBy = "contactDetails")
    private Cart cart;

    //konstruktor domyślny
    public ContactDetails() {
    }

    // gettery i settery
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setCountry(String country) {
        this.country = country;

    }

    @Override
    public String toString() {
        return "ContactDetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
