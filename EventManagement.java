import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EventManagement {
    public static void ajouterEvent(event event) {
        String query = "INSERT INTO events (id_event, nom_event, description, id_user) VALUES (?, ?, ?, ?)";
        try (Connection connection = gestion_evenements.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, event.getId());
            statement.setString(2, event.getNom());
            statement.setString(3, event.getDescription());
            statement.setInt(4, event.getUserId());

            statement.executeUpdate();
            System.out.println("evenement ajoute avec succes!");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout de l'evenement: " + e.getMessage());
        }
    }
    public static void afficherEvents() {
        String query = "SELECT * FROM events";
        try (Connection connection = gestion_evenements.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_event") +
                                   ", Nom: " + resultSet.getString("nom_event") +
                                   ", Description: " + resultSet.getString("description") +
                                   ", User ID: " + resultSet.getInt("id_user"));
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de l'affichage des evenements: " + e.getMessage());
        }
    }

    // Supprimer
    public static void supprimerEvent(int id_event) {
        String query = "DELETE FROM events WHERE id_event = ?";
        try (Connection connection = gestion_evenements.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id_event);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("evenement supprime avec succes!");
            } else {
                System.out.println("Aucun evenement trouve avec cet ID.");
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression de l'evenement: " + e.getMessage());
        }
    }
}
