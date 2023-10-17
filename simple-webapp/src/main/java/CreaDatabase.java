import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreaDatabase {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Nome del database non fornito. Uso 'database_pazienti'come nome di default.");
            args = new String[] { "database_pazienti" };
        }

        Connection conn = null;
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:ospedale.db";
            // String url = "database.db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            // Creo le tabelle
            String sqlCreaTabellaPazienti = "CREATE TABLE IF NOT EXISTS pazienti (" +
                    "id INTEGER PRIMARY KEY," +
                    "nome TEXT NOT NULL," +
                    "cognome TEXT NOT NULL," +
                    "indirizzo TEXT NOT NULL," +
                    "email TEXT NOT NULL," +
                    "data_di_nascita TEXT NOT NULL," +
                    "telefono INT NOT NULL" +
                    ");";

            String sqlCreaTabellaLetti = "CREATE TABLE IF NOT EXISTS letti (" +
                    "codice INTEGER PRIMARY KEY," +
                    "unita_operativa TEXT NOT NULL" +
                    ");";

            String sqlCreaTabellaPrenotazioni = "CREATE TABLE IF NOT EXISTS prenotazioni (" +
                    "id INTEGER PRIMARY KEY," +
                    "id_paziente INTEGER NOT NULL," +
                    "codice_Letto INTEGER NOT NULL," +
                    "data TEXT NOT NULL," +
                    "FOREIGN KEY (id_paziente) REFERENCES pazienti(id)," +
                    "FOREIGN KEY (codice_letto) REFERENCES letti(codice)" +
                    ");";
                    
            // String sqlCreaTabellaCategorie = "CREATE TABLE IF NOT EXISTS categorie (" +
            //         "id INTEGER PRIMARY KEY," +
            //         "nome TEXT NOT NULL" +
            //         ");";

            // String sqlCreaTabellaAcquisti = "CREATE TABLE IF NOT EXISTS acquisti (" +
            //         "id INTEGER PRIMARY KEY," +
            //         "id_prodotto INTEGER NOT NULL," +
            //         "id_cliente INTEGER NOT NULL," +
            //         "data_acquisto TEXT NOT NULL," +
            //         "FOREIGN KEY(id_prodotto) REFERENCES prodotti(id)," +
            //         "FOREIGN KEY(id_cliente) REFERENCES clienti(id)" +
            //         ");";

            Statement stmt = conn.createStatement();
            stmt.execute(sqlCreaTabellaPazienti);

            Statement stmt2 = conn.createStatement();
            stmt2.execute(sqlCreaTabellaLetti);

            Statement stmt3 = conn.createStatement();
            stmt3.execute(sqlCreaTabellaPrenotazioni);

            // stmt.execute(sqlCreaTabellaCategorie);
            // stmt.execute(sqlCreaTabellaAcquisti);

            System.out.println("Tabelle create con successo.");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}