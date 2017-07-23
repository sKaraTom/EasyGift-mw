package fr.doranco.easygift.middleware.objetmetier.catalogue;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import fr.doranco.easygift.middleware.objetmetier.produit.Produit;

@Entity
@Table(name = "T_CATALOGUE")
public class Catalogue implements Serializable {

	private static final long serialVersionUID = 1L;

	private String reference;
	
	private String label;
	
	private Map<String, Produit> produits;
	
	private Instant dateCreation;
	
	public Catalogue() {
		super();
		this.produits = new HashMap<String, Produit>();
	}

	public Catalogue(final String reference, final String label,
			final Map<String, Produit> produits, final Instant dateCreation) {
		super();
		this.reference = reference;
		this.label = label;
		this.produits = produits;
		this.dateCreation = dateCreation;
	}

	@Id
	@Column(name = "CAT_REFERENCE")
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Column(name = "CAT_LABEL")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@ManyToMany(
			fetch = FetchType.EAGER,
			cascade = { CascadeType.PERSIST, CascadeType.MERGE }
		)
	@Fetch(FetchMode.SELECT)
	@MapKey
	@JoinTable(name = "TJ_PRO_CAT")
	public Map<String, Produit> getProduits() {
		return produits;
	}

	public void setProduits(Map<String, Produit> produits) {
		this.produits = produits;
	}

	@Column(name = "CAT_DATECREATION")
	public Instant getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Instant dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public boolean equals(final Object candidat) {
		
		if (candidat == this)
			return true;
		
		if (candidat == null)
			return false;
		
		if (!(candidat instanceof Catalogue))
			return false;
		
		final Catalogue autre = (Catalogue) candidat;
		
		return new EqualsBuilder()
				.append(this.dateCreation, autre.dateCreation)
				.append(this.label, autre.label)
				.append(this.reference, autre.reference)
				.build();
	}
	
	@Override
	public int hashCode() {
		
		return new HashCodeBuilder()
				.append(this.dateCreation)
				.append(this.label)
				.append(this.reference)
				.build();
	}

	@Override
	public String toString() {
		
		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
				.append("Label", this.label)
				.build();
	}
	
}
