import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "letti")
public class Letto {
    

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name="CODICE", length=20, nullable=true)
        private String codice;

        @Column(name="UNITÀ_OPERATIVA", length=20, nullable=true)
        private String unitaOperativa;


        public Letto(int id, String codice, String unitaOperativa)
        {
            this.id = id;
            this.codice = codice;
            this.unitaOperativa = unitaOperativa;
        }
        
        
        public Letto() {
        }


        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getCodice() {
            return codice;
        }
        public void setCodice(String codice) {
            this.codice = codice;
        }
        public String getUnitaOperativa() {
            return unitaOperativa;
        }
        public void setUnitaOperativa(String unitaOperativa) {
            this.unitaOperativa = unitaOperativa;
        }
        
	}

