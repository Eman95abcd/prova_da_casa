import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "prenotazioni")
@SecondaryTable(name = "pazienti", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
@SecondaryTable(name = "letti", pkJoinColumns = @PrimaryKeyJoinColumn(name = "codice"))
public class PrenotazioneLetto {
    

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(table = "pazienti", name = "id_paziente")
        private Paziente idPaziente;

        @ManyToOne
        @JoinColumn(table = "letti", name="codice_letto", nullable=true)
        private Letto codiceLetto;

        @Column(name="DATA", length=20, nullable=true)
        private String data;


        public PrenotazioneLetto(Paziente idPaziente, Letto codiceLetto, String data)
        {
            this.idPaziente = idPaziente;
            this.codiceLetto = codiceLetto;
            this.data = data;
        }
        
        public PrenotazioneLetto() {
        }

        public Paziente getIdPAziente() {
            return idPaziente;
        }
        public void setIdPaziente(Paziente idPaziente) {
            this.idPaziente = idPaziente;
        }
        
        public Letto getCodiceLetto() {
            return codiceLetto;
        }
        public void setCodiceLetto(Letto codiceLetto) {
            this.codiceLetto = codiceLetto;
        }

        public String getData() {
            return data;
        }
        public void setData(String data) {
            this.data = data;
        }
        
	}

