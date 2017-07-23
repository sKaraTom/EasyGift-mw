package fr.doranco.easygift.middleware.objetmetier.statistique;

import java.io.Serializable;
import java.time.Instant;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class StatistiqueApportAffairePK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Instant dateDebut;

	private Instant dateFin;

	private String referenceAffilie;

	public Instant getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Instant dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Instant getDateFin() {
		return dateFin;
	}

	public void setDateFin(Instant dateFin) {
		this.dateFin = dateFin;
	}

	public String getReferenceAffilie() {
		return referenceAffilie;
	}

	public void setReferenceAffilie(String referenceAffilie) {
		this.referenceAffilie = referenceAffilie;
	}
	
	public StatistiqueApportAffairePK() {
		super();
	}

	public StatistiqueApportAffairePK(Instant dateDebut, Instant dateFin, String referenceAffilie) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.referenceAffilie = referenceAffilie;
	}

	@Override
	public int hashCode() {
		
		return new HashCodeBuilder()
				.appendSuper(super.hashCode())
				.append(this.dateDebut)
				.append(this.dateFin)
				.append(this.referenceAffilie)
				.build();
	}

	@Override
	public boolean equals(final Object candidat) {
		
		if (candidat == this)
			return true;
		if (candidat == null)
			return false;
		if (!(candidat instanceof StatistiqueApportAffairePK))
			return false;
		
		final StatistiqueApportAffairePK autre = (StatistiqueApportAffairePK) candidat;
		
		return new EqualsBuilder()
				.append(this.dateDebut, autre.dateDebut)
				.append(this.dateFin, autre.dateDebut)
				.append(this.referenceAffilie, autre.referenceAffilie)
				.build();
	}

}
