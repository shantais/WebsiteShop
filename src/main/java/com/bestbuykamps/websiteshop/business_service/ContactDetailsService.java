package com.bestbuykamps.websiteshop.business_service;

import com.bestbuykamps.websiteshop.data_model.ContactDetails;
import com.bestbuykamps.websiteshop.data_model.ContactDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ContactDetailsService {

    private final ContactDetailsRepository contactDetailsRepository;

    @Autowired
    public ContactDetailsService(ContactDetailsRepository contactDetailsRepository) {
        this.contactDetailsRepository = contactDetailsRepository;
    }

    public ContactDetails addContactDetails(ContactDetails contactDetails) {
        return contactDetailsRepository.save(contactDetails);
    }

    public ContactDetails updateContactDetails(ContactDetails contactDetails) {
        return contactDetailsRepository.save(contactDetails);
    }

    public void deleteContactDetails(Long id) {
        contactDetailsRepository.deleteById(id);
    }

    public void createContactDetailsFromModel(String name, String lastName,String email,String phone,String address,String country,String city,String zip){
        ContactDetails newContactDetails= new ContactDetails();
        newContactDetails.setFirstName(name);
        newContactDetails.setLastName(lastName);
        newContactDetails.setCountry(country);
        newContactDetails.setCity(city);
        newContactDetails.setPostalCode(zip);
        newContactDetails.setAdress(address);
        newContactDetails.setEmail(email);
        newContactDetails.setPhoneNumber(phone);

        System.out.println(newContactDetails.toString());
        contactDetailsRepository.save(newContactDetails);
        contactDetailsRepository.flush();
    }

}
