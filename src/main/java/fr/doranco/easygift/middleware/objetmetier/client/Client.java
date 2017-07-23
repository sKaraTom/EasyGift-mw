package fr.doranco.easygift.middleware.objetmetier.client;

import java.io.Serializable;

import javax.mail.internet.InternetAddress;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "T_CLIENT")
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String nom;
	
	private String prenom;
	
	private InternetAddress email;


	public Client() {
		super();
	}

	public Client(String nom, String prenom, InternetAddress email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	@Column(name = "CLI_NOM")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "CLI_PRENOM")
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Id
	@Column(name = "CLI_EMAIL")
	public InternetAddress getEmail() {
		return email;
	}

	public void setEmail(InternetAddress email) {
			this.email = email;
	}

	@Override
	public int hashCode() {
		
		return new HashCodeBuilder()
				.append(this.email)
				.append(this.nom)
				.append(this.prenom)
				.build();
	}

	@Override
	public boolean equals(final Object candidat) {
		
		if (candidat == this)
			return true;
		
		if (candidat == null)
			return false;
		
		if (!(candidat instanceof Client))
			return false;
		
		final Client autre = (Client) candidat; 
		
		return new EqualsBuilder()
				.append(this.email, autre.email)
				.append(this.nom, autre.nom)
				.append(this.prenom, autre.prenom)
				.build();
	}

	@Override
	public String toString() {
		
		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
				.append("Nom", this.nom)
				.append("Prenom", this.prenom)
				.append("Email", this.email)
				.build();
	}
	
}
