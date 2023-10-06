import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager; // Importa DriverManager da java.sql
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PazienteServlet extends HttpServlet {
    private PazienteDAO pazienteDAO;

    public void init() {
        String url = "jdbc:sqlite:ospedale.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante la connessione al database.", e);
        }
        pazienteDAO = new PazienteDAO(conn);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Paziente> pazienti = pazienteDAO.getAllPazienti();
        request.setAttribute("pazienti", pazienti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
        }
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String nomeDaInserireDaFrontEnd = request.getParameter("NomeDaInserire");
        String cognomeDaInserireDaFrontEnd = request.getParameter("CognomeDaInserire");
        String indirizzoDaInserireDaFrontEnd = request.getParameter("IndirizzoDaInserire");
        String emailDaInserireDaFrontEnd = request.getParameter("EmailDaInserire");
        String dataDiNascitaDaInserireDaFrontEnd = request.getParameter("DataDiNascitaDaInserire");
        String telefonoDaInserireDaFrontEnd = request.getParameter("TelefonoDaInserire");

        Integer telefonoDaInserireDaFrontEndInt = null; //Integer.parseInt(telefonoDaInserireDaFrontEnd);

        // Create a new Paziente object and set its properties
        Paziente pazienteDaInserire = new Paziente();
        pazienteDaInserire.setNome(nomeDaInserireDaFrontEnd);
        pazienteDaInserire.setCognome(cognomeDaInserireDaFrontEnd);
        pazienteDaInserire.setIndirizzo(indirizzoDaInserireDaFrontEnd);
        pazienteDaInserire.setEmail(emailDaInserireDaFrontEnd);
        pazienteDaInserire.setDataDiNascita(dataDiNascitaDaInserireDaFrontEnd);
        pazienteDaInserire.setTelefono(telefonoDaInserireDaFrontEndInt);

        // Perform database operations to insert the Paziente object
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            session.persist(pazienteDaInserire);
            transaction.commit();
        } catch (Exception e) {
            // Handle exceptions, e.g., validation errors or database errors
            transaction.rollback();
            // You can add error handling code here
        } finally {
            session.close();
        }

        // Redirect to a success page or the index page
        response.sendRedirect("index"); // Replace "index.jsp" with the appropriate success page
    }
}