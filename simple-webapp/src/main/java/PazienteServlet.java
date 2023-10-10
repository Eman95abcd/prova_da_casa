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

        // parte aggiunta (per filtrare per età)
        String ordineEtaDaFrontEnd = request.getParameter("OrdineEta");

        List<Paziente> pazientiFiltrati = pazienteDAO.getPazientiByFilter(pazienti, ordineEtaDaFrontEnd);
        request.setAttribute("pazienti", pazientiFiltrati);
        RequestDispatcher dispatcher2 = request.getRequestDispatcher("index.jsp");
        dispatcher2.forward(request, response);
        // fine parte aggiunta

        request.setAttribute("pazienti", pazienti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
        }
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {



        // PARTE CHE MODIFICA IL PAZIENTE
        String azioneDaFrontEnd = request.getParameter("azione");

        if ("modifica".equals(azioneDaFrontEnd)) {


        int idDaFrontEnd = Integer.parseInt(request.getParameter("idDaModificare"));
        String nomeDaModificareDaFrontEnd = request.getParameter("NomeDaModificare");
        String cognomeDaModificareDaFrontEnd = request.getParameter("CognomeDaModificare");
        String indirizzoDaModificareDaFrontEnd = request.getParameter("IndirizzoDaModificare");
        String emailDaModificareDaFrontEnd = request.getParameter("EmailDaModificare");
        String dataDiNascitaDaModificareDaFrontEnd = request.getParameter("DataDiNascitaDaModificare");
        String telefonoDaModificareDaFrontEnd = request.getParameter("TelefonoDaModificare");
        Integer telefonoDaModificareDaFrontEndInt = Integer.parseInt(telefonoDaModificareDaFrontEnd);

        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction2 = session2.beginTransaction();

        try {
            // Retrieve the User entity to update by its primary key (ID)
            Paziente pazienteDaModificare = session2.get(Paziente.class, idDaFrontEnd);

            if (pazienteDaModificare != null) {
                // Make changes to the user entity
                // pazienteDaModificare.setId(idDaFrontEnd);
                pazienteDaModificare.setNome(nomeDaModificareDaFrontEnd);
                pazienteDaModificare.setCognome(cognomeDaModificareDaFrontEnd);
                pazienteDaModificare.setIndirizzo(indirizzoDaModificareDaFrontEnd);
                pazienteDaModificare.setEmail(emailDaModificareDaFrontEnd);
                pazienteDaModificare.setDataDiNascita(dataDiNascitaDaModificareDaFrontEnd);
                pazienteDaModificare.setTelefono(telefonoDaModificareDaFrontEndInt);


                // Update the entity in the database
                session2.update(pazienteDaModificare);

                // Commit the transaction
                transaction2.commit();
                System.out.println("User updated successfully.");
            } else {
                System.out.println("User not found with ID: " + idDaFrontEnd);
            }
        } catch (Exception e) {
            // Handle exceptions, roll back the transaction if necessary
            if (transaction2!= null) {
                transaction2.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the session and the session factory
            session2.close();
        }
        } else {           //PARTE CHE INSERISCE IL PAZIENTE NUOVO
        String nomeDaInserireDaFrontEnd = request.getParameter("NomeDaInserire");
        String cognomeDaInserireDaFrontEnd = request.getParameter("CognomeDaInserire");
        String indirizzoDaInserireDaFrontEnd = request.getParameter("IndirizzoDaInserire");
        String emailDaInserireDaFrontEnd = request.getParameter("EmailDaInserire");
        String dataDiNascitaDaInserireDaFrontEnd = request.getParameter("DataDiNascitaDaInserire");
        String telefonoDaInserireDaFrontEnd = request.getParameter("TelefonoDaInserire");
        

        Integer telefonoDaInserireDaFrontEndInt = Integer.parseInt(telefonoDaInserireDaFrontEnd);

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



        }
        
        
        // Redirect to a success page or the index page
        response.sendRedirect("index"); // Replace "index.jsp" with the appropriate success page
    }
}