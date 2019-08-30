package project;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DialogController {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastNumber;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField notes;

    private String[] getContactData() {
        String firstContactName = firstName.getText().trim();
        String lastName = lastNumber.getText().trim();
        String phoneContactNumber = phoneNumber.getText().trim();
        String note = notes.getText().trim();
        return new String[]{firstContactName, lastName, phoneContactNumber, note};
    }

    public Contact processAddContact() {
        String[] contactData = getContactData();
        Contact newContact = new Contact(contactData[0], contactData[1], contactData[2], contactData[3]);
        ContactData.getInstance().addContact(newContact);
        return newContact;
    }

    public Contact processEditContact(Contact oldContact) {
        String[] contactData = getContactData();
        Contact newContact = new Contact(contactData[0], contactData[1], contactData[2], contactData[3]);
        ContactData.getInstance().editContact(oldContact, newContact);
        return newContact;
    }

    public boolean verify() {
        String[] contactData = getContactData();
        Pattern firstNamePattern = Pattern.compile("[a-zA-Z]{2,16}");
        Pattern lastNamePattern = Pattern.compile("[a-zA-Z]{2,24}");
        Pattern numberPattern = Pattern.compile("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");
        Pattern notesPattern = Pattern.compile("[\\s\\S]{3,50}");
        if (!processVerification(contactData[0], firstNamePattern) || !processVerification(contactData[1], lastNamePattern)
               || !processVerification(contactData[2], numberPattern) || !processVerification(contactData[3], notesPattern)) {
            return false;
        }
        return true;
    }

    private boolean processVerification(String contactData, Pattern pattern) {
        if (contactData != null && !contactData.trim().isEmpty()) {
            Matcher matcher = pattern.matcher(contactData);
            return matcher.find() && matcher.group().equals(contactData);
        }
        return false;
    }


    public TextField getFirstName() {
        return firstName;
    }

    public TextField getLastNumber() {
        return lastNumber;
    }

    public TextField getPhoneNumber() {
        return phoneNumber;
    }

    public TextField getNotes() {
        return notes;
    }
}
