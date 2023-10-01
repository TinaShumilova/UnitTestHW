package lv.gb.unittest.hw5;

public class Contact {

    private int id;
    private String name;
    private String surname;
    private String proneNumber;

    public Contact(String name, String surname, String proneNumber) {
        this.id = 1;
        this.name = name;
        this.surname = surname;
        this.proneNumber = proneNumber;
    }

    public Contact(){
        this.name = "name";
        this.surname = "surname";
        this.proneNumber = "proneNumber";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getProneNumber() {
        return proneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setProneNumber(String proneNumber) {
        this.proneNumber = proneNumber;
    }



    public String getInfo(){
        StringBuilder st = new StringBuilder();
        st.append("ID: ");
        st.append(getId());
        st.append(", Name: ");
        st.append(getSurname());
        st.append(" ");
        st.append(getName());
        st.append(", Phone number: ");
        st.append(getProneNumber());
        st.append(".");
        return st.toString();
    }
    @Override
    public String toString(){
        return getInfo();
    }
}

