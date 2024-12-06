import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class SalleManagement {
    public static void ajouterSalle(salle salle) {
        String query = "INSERT INTO salles (id_salle, nom_salle, capacite) VALUES (?, ?, ?)";
        try (Connection connection = gestion_evenements.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, salle.getId());
            statement.setString(2, salle.getNom());
            statement.setInt(3, salle.getCapacite()); // Corrected here

            statement.executeUpdate();
            System.out.println("Salle ajoutée avec succès!");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout de la salle: " + e.getMessage());
        }
    }
    public static void afficherSalles() {
        String query = "SELECT * FROM salles";
        try (Connection connection = gestion_evenements.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("Liste des salles:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_salle") +
                                   ", Nom: " + resultSet.getString("nom_salle") +
                                   ", Capacité: " + resultSet.getInt("capacite"));
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de l'affichage des salles: " + e.getMessage());
        }
    }

    public static void supprimerSalle(int id_salle) {
        String query = "DELETE FROM salles WHERE id_salle = ?";
        try (Connection connection = gestion_evenements.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id_salle);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Salle supprimée avec succès!");
            } else {
                System.out.println("Aucune salle trouvée avec cet ID.");
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression de la salle: " + e.getMessage());
        }
    }
}
