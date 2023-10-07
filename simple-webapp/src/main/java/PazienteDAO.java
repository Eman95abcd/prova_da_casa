import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PazienteDAO {

    private Connection conn;

    public PazienteDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Paziente> getAllPazienti() {
        List<Paziente> pazienti = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM pazienti")) {

            while (rs.next()) {
                Paziente p = new Paziente();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCognome(rs.getString("cognome"));
                p.setIndirizzo(rs.getString("indirizzo"));
                p.setEmail(rs.getString("email"));
                p.setDataDiNascita(rs.getString("data_di_nascita"));
                p.setTelefono(rs.getInt("telefono"));
                pazienti.add(p);
            }

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }

        return pazienti;
    }

    public Paziente getPazienteById(int id) {
        Paziente p = null;

        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pazienti WHERE id = ?")) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    p = new Paziente();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setCognome(rs.getString("cognome"));
                    p.setIndirizzo(rs.getString("indirizzo"));
                    p.setEmail(rs.getString("email"));
                    p.setDataDiNascita(rs.getString("data_di_nascita"));
                    p.setTelefono(rs.getInt("telefono"));
                }

            }

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }

        return p;
    }

    public void insertPaziente(Paziente p) {
        try (PreparedStatement stmt = conn
                .prepareStatement("INSERT INTO pazienti (id,nome, cognome, indirizzo, email, data_di_nascita,telefono) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getCognome());
            stmt.setString(4, p.getIndirizzo());
            stmt.setString(5, p.getEmail());
            stmt.setString(6, p.getDataDiNascita());
            stmt.setInt(7, p.getTelefono());
            stmt.executeUpdate();

        } catch (SQLException e) {
            // Gestisci l'eccezione
            e.printStackTrace();
        }
    }

    public List<Paziente> getPazientiByFilter(List<Paziente> allPazienti, String ordineEta) {

        List<Paziente> pazientiFiltrati = new ArrayList<>();
        String sql = "SELECT * FROM pazienti ";
        
        if (ordineEta != null && !ordineEta.isEmpty()) {
            // dal più vecchio al più giovane
            if (ordineEta.equals("1")) {
                sql = sql + " ORDER BY data_di_nascita ASC";
                for (Paziente paziente : pazientiFiltrati) {
                    System.out.println(paziente);
                }
            }
            // dal più giovane al più vecchio
            else if (ordineEta.equals("2")) {
                sql = sql + " ORDER BY data_di_nascita DESC";
                for (Paziente paziente : pazientiFiltrati) {
                    System.out.println(paziente);
                }
            }
        }
                try (
                    Statement stmt = conn.createStatement();) {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {

                    Paziente p = new Paziente();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setCognome(rs.getString("cognome"));
                    p.setIndirizzo(rs.getString("indirizzo"));
                    p.setEmail(rs.getString("email"));
                    p.setDataDiNascita(rs.getString("data_di_nascita"));
                    p.setTelefono(rs.getInt("telefono"));
                    pazientiFiltrati.add(p);
                }

            } catch (SQLException e) {
                // gestisci l'eccezione
                e.printStackTrace();
            }
            return pazientiFiltrati;
    }
}