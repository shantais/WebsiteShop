package com.example.myapp.services;

import com.bestbuykamps.websiteshop.data_model.ContactDetails;
import com.bestbuykamps.websiteshop.data_model.ContactDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
