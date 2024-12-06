
    
public class reservations{
    private int id_reservation;
    private String id_user;    
    private String id_event;
    private String id_salle;
    private String id_terrain;
    public void adduser(int id_reservation, String id_user, String id_event, String id_salle) {
        this.id_reservation = id_reservation;
        this.id_user = id_user;
        this.id_event = id_event;
        this.id_salle = id_salle;
    }

    public void getId() { 
        System.out.println(id_reservation);
    }
    public void getId_user() {
        System.out.println(id_user);
    }
    public void getId_event() {
        System.out.println(id_event);
    }
    public void getId_salle() {
        System.out.println(id_salle);
    }
    public void getId_terrain() {
        System.out.println(id_terrain);
    

 
}
}

