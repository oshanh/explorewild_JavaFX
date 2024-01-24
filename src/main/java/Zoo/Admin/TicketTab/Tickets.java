package Zoo.Admin.TicketTab;

public class Tickets {
    int id;
    String name,family;
    String date;

    public Tickets(int id, String name, String date, String family) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
