import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LettoDAO {

    private Connection conn;

    public LettoDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Letto> getAllLetti() {
        List<Letto> letti = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM letti")) {

            while (rs.next()) {
                Letto l = new Letto();
                l.setCodice(rs.getInt("codice"));
                l.setUnitaOperativa(rs.getString(("unita_operativa")));
                letti.add(l);
            }

        } catch (SQLException e) {
            // gestisci l'eccezione
            e.printStackTrace();
        }

        return letti;
    }
}
