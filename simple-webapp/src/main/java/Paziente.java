
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pazienti")
public class Paziente {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="NOME", length=20, nullable=true)
	private String nome;

	@Column(name="COGNOME", length=20, nullable=true)
	private String cognome;

	@Column(name="INDIRIZZO", length=20, nullable=true)
	private String indirizzo;

	@Column(name="EMAIL", length=20, nullable=true)
	private String email;

	@Column(name="DATA_DI_NASCITA", length=20, nullable=true)
	private String dataDiNascita;

	@Column(name="TELEFONO", length=20, nullable=true)
	private Integer telefono;

	@ManyToMany
    @JoinTable(
        name = "prenotazioni",
        joinColumns = @JoinColumn(name = "id_paziente"),
        inverseJoinColumns = @JoinColumn(name = "codice_letto")
    )
    private List<PrenotazioneLetto> prenotazioniLetti;
	
	public Paziente(int id, String nome, String cognome, String indirizzo, String email, String dataDiNascita, int telefono){
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.email = email;
		this.dataDiNascita = dataDiNascita;
		this.telefono = telefono;
	}
	
	
	public Paziente() {
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
}