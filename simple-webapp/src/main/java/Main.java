import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
    

                Session session = HibernateUtil.getSessionFactory().openSession();
                Paziente entity = new Paziente();
                entity.setNome("John");
                entity.setCognome("Smith");
                entity.setIndirizzo("Via XX Settembre");
                entity.setEmail("john.smith@google.com");
                entity.setDataDiNascita("1955-03-14");
                entity.setTelefono(123456);

                Paziente entity2 = new Paziente();
                entity2.setNome("Mario");
                entity2.setCognome("Rossi");
                entity2.setIndirizzo("Corso Torino");
                entity2.setEmail("mario.rossi@google.com");
                entity2.setDataDiNascita("1988-08-17");
                entity2.setTelefono(456789);
    
                Transaction transaction = session.beginTransaction();
                session.persist(entity);
                session.persist(entity2);
                transaction.commit();




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
    }
}
