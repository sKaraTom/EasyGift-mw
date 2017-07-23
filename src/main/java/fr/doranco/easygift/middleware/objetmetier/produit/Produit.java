package fr.doranco.easygift.middleware.objetmetier.produit;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import fr.doranco.easygift.middleware.objetmetier.catalogue.Catalogue;

// Convention Java Bean

// Disposer au moins d'un constructeur sans argument
// Proposer ses variables membres importantes au travers d'accesseurs
// Ne pas etre final
// Dispose de methodes .equals(), .hashCode() consistantes.

@Entity
@Table(name = "T_PRODUIT")
@XmlRootElement
public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;

	private String reference;
	
	private String label;
	
	private String description;
	
	private Instant dateCreation;
	
	private List<Catalogue> catalogues;

	public Produit() {
		super();
	}

	public Produit(final String reference, final String label,
			final String description, final Instant dateCreation) {
		super();
		this.reference = reference;
		this.label = label;
		this.description = description;
		this.dateCreation = dateCreation;
	}

	@Id
	@Column(name = "PRO_REFERENCE")
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Column(name = "PRO_LABEL")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Column(name = "PRO_DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "PRO_DATECREATION")
	public Instant getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Instant dateCreation) {
		this.dateCreation = dateCreation;
	}

	@ManyToMany(mappedBy = "produits")
	public List<Catalogue> getCatalogues() {
		return catalogues;
	}

	public void setCatalogues(List<Catalogue> catalogues) {
		this.catalogues = catalogues;
	}

	@Override
	public boolean equals(final Object candidat) {
		
		if (candidat == this)
			return true;
		
		if (candidat == null)
			return false;
		
		if (!(candidat instanceof Produit))
			return false;
		
		final Produit autre = (Produit) candidat;
		
		return new EqualsBuilder()
				.append(this.dateCreation, autre.dateCreation)
				.append(this.description, autre.description)
				.append(this.label, autre.label)
				.append(this.reference, autre.reference)
				.build();
	}
	
	@Override
	public int hashCode() {
		
		return new HashCodeBuilder()
				.append(this.dateCreation)
				.append(this.description)
				.append(this.label)
				.append(this.reference)
				.build();
	}

	@Override
	public String toString() {
		
		return new ToStringBuilder(this)
				.append("Référence", this.reference)
				.append("Date Création", this.dateCreation)
				.append("Label", this.label)
				.append("Description", this.description)
				.build();
	}

}
