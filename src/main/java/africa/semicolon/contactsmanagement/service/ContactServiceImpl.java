package africa.semicolon.contactsmanagement.service;

import africa.semicolon.contactsmanagement.data.model.Contact;
import africa.semicolon.contactsmanagement.data.repository.ContactRepository;
import africa.semicolon.contactsmanagement.dtos.request.DeleteContactRequest;
import africa.semicolon.contactsmanagement.dtos.request.DisplayContactRequest;
import africa.semicolon.contactsmanagement.dtos.request.UpdateContactRequest;
import africa.semicolon.contactsmanagement.dtos.response.DeleteContactResponse;
import africa.semicolon.contactsmanagement.dtos.response.DisplayContactResponse;
import africa.semicolon.contactsmanagement.dtos.response.UpdateContactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public UpdateContactResponse update(UpdateContactRequest updateContactRequest) {
        Contact contact = findByPhoneNumber(updateContactRequest.getNewPhoneNumber());
        contact.setFirstName(updateContactRequest.getFirstName());
        contact.setLastName(updateContactRequest.getLastName());
        contact.setPhoneNumber(updateContactRequest.getNewPhoneNumber());
        contactRepository.save(contact);

        UpdateContactResponse updateContactResponse = new UpdateContactResponse();
        updateContactResponse.setFirstName(updateContactRequest.getFirstName());
        updateContactResponse.setLastName(updateContactRequest.getLastName());
        updateContactResponse.setNewPhoneNumber(updateContactRequest.getNewPhoneNumber());

        return updateContactResponse;
    }

    private Contact findByPhoneNumber(String phoneNumber) {
        Contact contact = contactRepository.findContactByPhoneNumber(phoneNumber);
        if (contact == null) throw new RuntimeException("user not found");
        return contact;
    }
    @Override
    public DeleteContactResponse delete(DeleteContactRequest deleteContactRequest) {
        String phoneNumber = deleteContactRequest.getPhoneNumber();
        Contact contact = findByPhoneNumber(phoneNumber);
        contactRepository.delete(contact);

        DeleteContactResponse deleteContactResponse = new DeleteContactResponse();
        deleteContactResponse.setFirstName(deleteContactResponse.getFirstName());
        deleteContactResponse.setLastname(deleteContactResponse.getLastname());
        deleteContactResponse.setPhoneNumber(deleteContactResponse.getPhoneNumber());

        return deleteContactResponse;
    }
}
