package fr.doranco.easygift.middleware.objetmetier.apport;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "T_APPORTAFFAIRE")
public class ApportAffaire implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String referenceProduit;
	
	private Instant dateVente;
	
	private Double montant;
	
	private String referenceAffilie;
	
	public ApportAffaire() {
		super();
	}

	public ApportAffaire(String referenceProduit, Instant dateVente, Double montant, String referenceAffilie) {
		super();
		this.referenceProduit = referenceProduit;
		this.dateVente = dateVente;
		this.montant = montant;
		this.referenceAffilie = referenceAffilie;
	}

	@Id
	@Column(name = "APP_REFERENCEPRODUIT")
	public String getReferenceProduit() {
		return referenceProduit;
	}

	public void setReferenceProduit(String referenceProduit) {
		this.referenceProduit = referenceProduit;
	}

	@Column(name ="APP_DATEVENTE")
	public Instant getDateVente() {
		return dateVente;
	}

	public void setDateVente(Instant dateVente) {
		this.dateVente = dateVente;
	}

	@Column(name = "APP_MONTANT")
	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	@Column(name = "APP_REFERENCEAFFILIE")
	public String getReferenceAffilie() {
		return referenceAffilie;
	}

	public void setReferenceAffilie(String referenceAffilie) {
		this.referenceAffilie = referenceAffilie;
	}

	@Override
	public int hashCode() {
		
		return new HashCodeBuilder()
				.append(this.dateVente)
				.append(this.montant)
				.append(this.referenceProduit)
				.append(this.referenceAffilie)
				.build();
	}

	@Override
	public boolean equals(Object candidat) {
		
		if (candidat == this)
			return true;
		if (candidat == null)
			return false;
		if (!(candidat instanceof ApportAffaire))
			return false;
		
		final ApportAffaire autre = (ApportAffaire) candidat;
		
		return new EqualsBuilder()
				.append(this.dateVente, autre.dateVente)
				.append(this.montant, autre.montant)
				.append(this.referenceProduit, autre.referenceProduit)
				.append(this.referenceAffilie, autre.referenceAffilie)
				.build();
	}

	@Override
	public String toString() {
		
		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
				.append("Référence du produit", this.referenceProduit)
				.append("Référence de l'affilié", this.referenceAffilie)
				.append("Date de vente", this.dateVente)
				.append("Montant", this.montant)
				.build();
	}
	
}
