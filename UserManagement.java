import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserManagement {
    public static void ajouterUser(user user) {
        String query = "INSERT INTO users (id_user, nom, prenom, email, type) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = gestion_evenements.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, user.getId());
            statement.setString(2, user.getNom());
            statement.setString(3, user.getPrenom());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getType());

            statement.executeUpdate();
            System.out.println("User ajouté avec succès!");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout de l'utilisateur: " + e.getMessage());
        }
    }

    // Afficher
    public static void afficherUsers() {
        String query = "SELECT * FROM users";
        try (Connection connection = gestion_evenements.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_user") +
                                   ", Nom: " + resultSet.getString("nom") +
                                   ", Prénom: " + resultSet.getString("prenom") +
                                   ", Email: " + resultSet.getString("email") +
                                   ", Type: " + resultSet.getString("type"));
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de l'affichage des utilisateurs ");
        }
    }

    // Supprimer
    public static void supprimerUser(int id_user) {
        String query = "DELETE FROM users WHERE id_user = ?";
        try (Connection connection = gestion_evenements.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id_user);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Utilisateur supprimé avec succès!");
            } else {
                System.out.println("Aucun utilisateur trouvé avec cet ID.");
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression de l'utilisateur: " + e.getMessage());
        }
    }
}
