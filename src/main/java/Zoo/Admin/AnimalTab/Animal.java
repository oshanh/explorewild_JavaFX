package Zoo.Admin.AnimalTab;

import java.util.Date;

public class Animal {
    int id;
    String name,family;
    Date date;

    public Animal(int id, String name, String family, Date date) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
