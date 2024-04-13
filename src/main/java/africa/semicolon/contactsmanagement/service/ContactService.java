package africa.semicolon.contactsmanagement.service;

import africa.semicolon.contactsmanagement.data.model.Contact;
import africa.semicolon.contactsmanagement.dtos.request.DeleteContactRequest;
import africa.semicolon.contactsmanagement.dtos.request.UpdateContactRequest;
import africa.semicolon.contactsmanagement.dtos.response.DeleteContactResponse;
import africa.semicolon.contactsmanagement.dtos.response.UpdateContactResponse;

import java.util.ArrayList;
import java.util.List;


public interface ContactService {
    List<Contact> contacts = new ArrayList<>();
 DeleteContactResponse delete(DeleteContactRequest deleteContactRequest);
 UpdateContactResponse update(UpdateContactRequest updateContactRequest);


}
