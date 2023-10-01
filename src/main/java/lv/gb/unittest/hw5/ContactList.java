package lv.gb.unittest.hw5;

import lv.gb.unittest.hwt.model.note.Note;

import java.util.ArrayList;
import java.util.List;

public class ContactList extends Contact {
    private int contactID;
    private List<Contact> contactList;

    public ContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public ContactList() {
        this(new ArrayList<>());
    }

    public boolean add(Contact contact) {
        if (!contactList.contains(contact)) {
            contactList.add(contact);
            contact.setId(++contactID);
            return true;
        }
        return false;
    }

    public boolean removeContact(int id) {
        if (checkID(id)) {
            Contact contact = getById(id);
            return contactList.remove(contact);
        }
        return false;
    }

    private boolean checkID(int id) {
        if (id > contactID || id < 0) {
            return false;
        }
        for (Contact c : contactList
        ) {
            if (c.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Contact getById(int id) {
        for (Contact c : contactList) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder st = new StringBuilder();
        st.append("This book contains ");
        st.append(contactList.size());
        st.append(" objects: \n");
        for (Contact c : contactList
        ) {
            st.append(c);
            st.append("\n");
        }

        return st.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public void changeSurname(int id, String newSurname) {
        if (checkID(id)) {
            Contact contact = getById(id);
            contact.setSurname(newSurname);
        }
    }
}
