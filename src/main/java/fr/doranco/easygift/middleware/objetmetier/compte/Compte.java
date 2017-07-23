package fr.doranco.easygift.middleware.objetmetier.compte;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import fr.doranco.easygift.middleware.objetmetier.client.Client;

@Entity
@Table(name = "T_COMPTE")
public class Compte implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Client client;
	
	private String identifiant;
	
	private String motDePasse;
	
	private Boolean connecte;
	
	public Compte() {
		super();
	}

	public Compte(Client client, String identifiant, String motDePasse) {
		super();
		this.client = client;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
	}

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Id
	@Column(name = "COM_IDENTIFIANT")
	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	@Column(name = "COM_MOTDEPASSE", length = 256, nullable = false)
	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Column(name = "COM_CONNECTE")
	public Boolean getConnecte() {
		return connecte;
	}

	public void setConnecte(Boolean connecte) {
		this.connecte = connecte;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.client)
				.append(this.identifiant)
				.append(this.motDePasse)
				.build();
	}

	@Override
	public boolean equals(final Object candidat) {
		
		if (candidat == this)
			return true;
		
		if (candidat == null)
			return false;
		
		if (!(candidat instanceof Compte))
			return false;
		
		final Compte autre = (Compte) candidat;
		
		return new EqualsBuilder()
				.append(this.client, autre.client)
				.append(this.identifiant, autre.identifiant)
				.append(this.motDePasse, autre.motDePasse)
				.build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
				.append("Identifiant", this.identifiant)
				.append("Client", this.client)
				.build();
	}
	
}
