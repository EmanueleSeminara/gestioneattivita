package it.prova.gestioneattivita.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "attivita")
public class Attivita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "titolo")
	private String titolo;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "data")
	private Date data;
	@Column(name = "priorita")
	private Integer priorita;

	@CreationTimestamp
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Attivita() {
		super();
	}

	public Attivita(String titolo, String descrizione, Date data, int priorita) {
		super();
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.data = data;
		this.priorita = priorita;
	}

	public Attivita(String titolo) {
		super();
		this.titolo = titolo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getPriorita() {
		return priorita;
	}

	public void setPriorita(int priorita) {
		this.priorita = priorita;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, descrizione, id, priorita, titolo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attivita other = (Attivita) obj;
		return Objects.equals(data, other.data) && Objects.equals(descrizione, other.descrizione)
				&& Objects.equals(id, other.id) && priorita == other.priorita && Objects.equals(titolo, other.titolo);
	}

	@Override
	public String toString() {
		return "Attivita [id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", data=" + data
				+ ", priorita=" + priorita + "]";
	}

}

// Attivita(id, titolo, descrizione, data, priorità)
