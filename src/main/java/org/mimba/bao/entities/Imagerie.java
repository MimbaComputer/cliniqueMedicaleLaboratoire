package org.mimba.bao.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Imagerie implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Lob
	private byte[] photo;
	@NotNull
	@Size(min = 5, max = 50)
	private String libelle;
	@NotNull
	@Size(min = 5, max = 50)
	private String remarque;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idPatient")
	private Patient patient;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idCasASuivre")
	private CasASuivre casASuivre;

	public Imagerie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Imagerie(byte[] photo, String libelle, String remarque, Patient patient, CasASuivre casASuivre) {
		super();
		this.photo = photo;
		this.libelle = libelle;
		this.remarque = remarque;
		this.patient = patient;
		this.casASuivre = casASuivre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public CasASuivre getCasASuivre() {
		return casASuivre;
	}

	public void setCasASuivre(CasASuivre casASuivre) {
		this.casASuivre = casASuivre;
	}

}
@Entity
class Patient implements Serializable{
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "patient")
	private Collection<Imagerie>  imagerie;
	@OneToMany(mappedBy = "patient")
	private Collection<CasASuivre> casASuivre;
	
	
}
@Entity
class CasASuivre implements Serializable{
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idPatient")
	private Patient patient;
	@OneToMany(mappedBy="casASuivre")
	private Collection<Imagerie> imagerie;
	

}
