import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager; // Importa DriverManager da java.sql
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LettoServlet extends HttpServlet {
    private LettoDAO lettoDAO;

    public void init() {
        String url = "jdbc:sqlite:ospedale.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante la connessione al database.", e);
        }
        lettoDAO = new LettoDAO(conn);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Letto> letti = lettoDAO.getAllLetti();


        request.setAttribute("letti", letti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("letti.jsp");
        dispatcher.forward(request, response);
        }
}