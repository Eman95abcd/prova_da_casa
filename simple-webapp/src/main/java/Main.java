import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:ospedale.db")) {
            PazienteDAO pazienteDAO = new PazienteDAO(conn);
            // LocalDate dataDiNascita1 = LocalDate.of(1955, 2, 14);
            Paziente paz1 = new Paziente(1, "Mario", "Rossi", "Via XX Settembre", "mario.rossi@gmail.com", "1955-02-14", 123456 );

            
            pazienteDAO.insertPaziente(paz1);
            // System.out.println("Prodotti:");
            // for (Prodotto p : prodotti) {
            //     System.out.println(p.getId() + ": " + p.getNome() + " (" + p.getPrezzo() + ")");
            // }

           
            // List<Cliente> clienti = clienteDAO.getAllClienti();
            // System.out.println("\nClienti:");
            // for (Cliente c : clienti) {
            // System.out.println(c.getId() + ": " + c.getNome() + " (" + c.getEmail() +
            // ")");
            // }

            // // Stampa tutti gli acquisti
            // List<Acquisto> acquisti = acquistoDAO.getAllAcquisti();
            // System.out.println("\nAcquisti:");
            // for (Acquisto a : acquisti) {
            // System.out.println(a.getId() + ": Prodotto " + a.getIdProdotto() + ", Cliente
            // " + a.getIdCliente()
            // + ", Data " + a.getDataAcquisto());
            // }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}