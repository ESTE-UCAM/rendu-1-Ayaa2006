import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReservationManagement {
    public static void ajouterReservation(reservation reservation) {
        String query = "INSERT INTO reservations (id_reservation, id_user, id_salle, id_terrain, date_reservation) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = gestion_evenements.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, reservation.getId());
            statement.setInt(2, reservation.getUserId());
            statement.setInt(3, reservation.getSalleId());
            statement.setInt(4, reservation.getTerrainId());
            statement.setDate(5, reservation.getDateReservation()); 

            statement.executeUpdate();
            System.out.println("Réservation ajoutée avec succès!");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout de la réservation: " + e.getMessage());
        }
    }

    public static void afficherReservations() {
        String query = "SELECT * FROM reservations";
        try (Connection connection = gestion_evenements.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery()) {
        System.out.println("Liste des réservations:");
        while (resultSet.next()) {
        System.out.println("ID: " + resultSet.getInt("id_reservation") +
        ", User ID: " + resultSet.getInt("id_user") +
         ", Salle ID: " + resultSet.getInt("id_salle") +
         ", Terrain ID: " + resultSet.getInt("id_terrain") +
         ", Date: " + resultSet.getDate("date_reservation"));
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de l'affichage des réservations: " + e.getMessage());
        }
    }

    public static void supprimerReservation(int id_reservation) {
        String query = "DELETE FROM reservations WHERE id_reservation = ?";
        try (Connection connection = gestion_evenements.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id_reservation);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Réservation supprimée avec succès!");
            } else {
                System.out.println("Aucune réservation trouvée avec cet ID.");
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression de la réservation: " + e.getMessage());
        }
    }
}
