package fr.doranco.easygift.middleware.objetmetier.apport;

import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class HistoriqueApportAffaire {

	private Set<ApportAffaire> historiqueApportsAffaire;
	
	private String referenceAffilie;

	public HistoriqueApportAffaire() {
		super();
	}

	public HistoriqueApportAffaire(Set<ApportAffaire> historiqueApportsAffaire, String referenceAffilie) {
		super();
		this.historiqueApportsAffaire = historiqueApportsAffaire;
		this.referenceAffilie = referenceAffilie;
	}

	public Set<ApportAffaire> getHistoriqueApportsAffaire() {
		return historiqueApportsAffaire;
	}

	public void setHistoriqueApportsAffaire(Set<ApportAffaire> historiqueApportsAffaire) {
		this.historiqueApportsAffaire = historiqueApportsAffaire;
	}

	public String getReferenceAffilie() {
		return referenceAffilie;
	}

	public void setReferenceAffilie(String referenceAffilie) {
		this.referenceAffilie = referenceAffilie;
	}

	@Override
	public int hashCode() {
		
		return new HashCodeBuilder()
				.append(this.referenceAffilie)
				.build();
	}

	@Override
	public boolean equals(Object candidat) {
		
		if (candidat == this)
			return true;
		if (candidat == null)
			return false;
		if (!(candidat instanceof HistoriqueApportAffaire))
			return false;
		
		final HistoriqueApportAffaire autre = (HistoriqueApportAffaire) candidat;
		
		return new EqualsBuilder()
				.append(this.referenceAffilie, autre.referenceAffilie)
				.build();
	}

	@Override
	public String toString() {
		
		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
				.append("Référence Affilié", this.referenceAffilie)
				.append("Historique", this.historiqueApportsAffaire)
				.build();
	}
	
}
