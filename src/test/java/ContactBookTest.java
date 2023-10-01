import lv.gb.unittest.hw5.Contact;
import lv.gb.unittest.hw5.ContactList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ContactBookTest {

    /**
     * testAddContact проверяет, добавляется ли контакт в список контактов
     */
    @Test
    public void testAddContact(){
        ContactList contactList = new ContactList();
        Contact contact = new Contact();
        assertTrue(contactList.add(contact));
    }
    /**
     * testNotDoubleContact проверяет, что нельзя добавить уже существующий контакт в список контактов.
     */
    @Test
    public void testNotDoubleContact(){
        ContactList contactList = new ContactList();
        Contact contact = new Contact();
        contactList.add(contact);
        assertFalse(contactList.add(contact));
    }
    /**
     * testContactInfo проверяет, что добавленный контакт отображается в заданном шаблоне.
     */
    @Test
    public void testContactInfo(){
        ContactList contactList = new ContactList();
        Contact contact = new Contact();
        contactList.add(contact);
        String expectedText = "This book contains 1 objects: \n" +
                "ID: 1, Name: surname name, Phone number: proneNumber.\n";
        assertEquals(expectedText,contactList.getInfo());
    }

    /**
     * testSuccessfulRemoveContact проверяет, что добавленный контакт можно удалить из списка.
     */
    @Test
    public void testSuccessfulRemoveContact(){
        ContactList contactList = new ContactList();
        Contact c1 = new Contact("TestName","TestSurname", "TestPhone");
        contactList.add(c1);
        assertTrue(contactList.removeContact(1));
    }
    /**
     * testFailedRemoveContact проверяет, что нельзя удалить несуществующий контакт.
     */
    @Test
    public void testFailedRemoveContact(){
        ContactList contactList = new ContactList();
        Contact c1 = new Contact("TestName","TestSurname", "TestPhone");
        contactList.add(c1);
        assertFalse(contactList.removeContact(2));
    }

    /**
     * testFindContact проверяет, что можно найти контакт по ID в списке контактов.
     */
    @Test
    public void testFindContact(){
        ContactList contactList = mock(ContactList.class);
        when(contactList.getById(1)).thenReturn(new Contact("Name", "Note", "phone"));
        assertEquals(contactList.getById(1).getInfo(), "ID: 1, Name: Note Name, Phone number: phone.");
    }
    /**
     * testChangeContact проверяет, что можно изменить фамилию в уже занесённом в список контакте.
     */
    @Test
    public void testChangeContact(){
        ContactList contactList = new ContactList();
        Contact c1 = new Contact("TestName","TestSurname", "TestPhone");
        contactList.add(c1);
        contactList.changeSurname(1, "NewSurname");
        String expectedText = "This book contains 1 objects: \n" +
                "ID: 1, Name: NewSurname TestName, Phone number: TestPhone.\n";
        assertEquals(expectedText, contactList.getInfo());
    }
    /**
     * testAddName проверяет, что можно изменить имя в уже существующем контакте.
     */
    @Test
    public void testAddName(){
        Contact c = new Contact();
        c.setName("NewName");
        assertEquals("NewName",c.getName());
    }
    /**
     * testAddPhone проверяет, что можно изменить номер телефона в уже существующем контакте.
     */
    @Test
    public void testAddPhone(){
        Contact c = new Contact();
        c.setProneNumber("2346756789");
        assertEquals("2346756789",c.getProneNumber());
    }

    /**
     * testAll имитирует работу пользователя со списком контактов.
     */
    @Test
    public void testAll(){
        ContactList contactList = new ContactList();
        Contact c1 = new Contact("TestName1","TestSurname1", "TestPhone1");
        Contact c2 = new Contact("TestName2","TestSurname2", "TestPhone2");
        contactList.add(c1);
        contactList.add(c2);
        assertEquals("ID: 2, Name: TestSurname2 TestName2, Phone number: TestPhone2.", contactList.getById(2).getInfo());
        contactList.removeContact(2);
        String expectedText = "This book contains 1 objects: \n" +
                "ID: 1, Name: TestSurname1 TestName1, Phone number: TestPhone1.\n";
        assertEquals(expectedText, contactList.getInfo());
        contactList.changeSurname(1,"NewSurname");
        assertEquals("NewSurname",c1.getSurname());
    }

}
