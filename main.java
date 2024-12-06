import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {
    public static void Main (String [] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- Gestion des Ressources ----");
            System.out.println("1. Ajouter une réservation");
            System.out.println("2. Afficher les réservations");
            System.out.println("3. Supprimer une réservation");
            System.out.println("0. Quitter");
            System.out.print("Choix: ");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("ID de la réservation: ");
                    int id_reservation = scanner.nextInt();
                    System.out.print("ID de l'utilisateur: ");
                    int userId = scanner.nextInt();
                    System.out.print("ID de l'événement: ");
                    int id_event = scanner.nextInt();
                    System.out.print("ID de la salle: ");
                    int salleId = scanner.nextInt();
                    System.out.print("ID du terrain: ");
                    int id_terrain = scanner.nextInt();

                    System.out.print("Date de la réservation (YYYY-MM-DD): ");
                    String dateStr = scanner.next(); 

                    try {
        
                        Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr); 
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                        reservation reservation = new reservation(id_reservation, userId, id_event, salleId, id_terrain, sqlDate);
                        ReservationManagement.ajouterReservation(reservation);
                    } catch (Exception e) {
                        System.out.println("Erreur dans le format de la date. Utilisez 'YYYY-MM-DD'.");
                    }
                    break;

                case 2:
                    ReservationManagement.afficherReservations();
                    break;

                case 3:
                    System.out.print("ID de la réservation à supprimer: ");
                    int reservationIdToDelete = scanner.nextInt();
                    ReservationManagement.supprimerReservation(reservationIdToDelete);
                    break;

                case 0:
                    System.out.println("Au revoir!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Choix invalide. Réessayez.");
            }
        }
    }
}
