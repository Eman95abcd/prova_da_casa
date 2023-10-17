import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "letti")
public class Letto {
    

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int codice;

        @Column(name="UNITA_OPERATIVA", length=20, nullable=true)
        private String unitaOperativa;

        @ManyToMany(mappedBy = "prenotazioniLetti")
        private List<Paziente> pazientiPrenotati;
    

        public Letto(int codice, String unitaOperativa)
        {
            this.codice = codice;
            this.unitaOperativa = unitaOperativa;
        }
        
        
        public Letto() {
        }

        public int getCodice() {
            return codice;
        }
        public void setCodice(int codice) {
            this.codice = codice;
        }
        public String getUnitaOperativa() {
            return unitaOperativa;
        }
        public void setUnitaOperativa(String unitaOperativa) {
            this.unitaOperativa = unitaOperativa;
        }
        
	}

