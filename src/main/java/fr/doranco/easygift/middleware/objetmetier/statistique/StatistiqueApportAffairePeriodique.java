package fr.doranco.easygift.middleware.objetmetier.statistique;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "T_STATISTIQUE")
@IdClass(value = StatistiqueApportAffairePK.class)
public class StatistiqueApportAffairePeriodique implements Serializable {
	
	private Instant dateDebut;
	
	private Instant dateFin;

	private String referenceAffilie;
	
	private Double volume;

	public StatistiqueApportAffairePeriodique() {
		super();
	}
	
	public StatistiqueApportAffairePeriodique(Instant dateDebut, Instant dateFin, String referenceAffilie,
			Double volume) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.referenceAffilie = referenceAffilie;
		this.volume = volume;
	}

	@Id
	@Column(name = "STA_DATEDEBUT")
	public Instant getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Instant dateDebut) {
		this.dateDebut = dateDebut;
	}

	@Id
	@Column(name = "STA_DATEFIN")
	public Instant getDateFin() {
		return dateFin;
	}

	public void setDateFin(Instant dateFin) {
		this.dateFin = dateFin;
	}

	@Id
	@Column(name = "STA_REFERENCEAFFILIE")
	public String getReferenceAffilie() {
		return referenceAffilie;
	}

	public void setReferenceAffilie(String referenceAffilie) {
		this.referenceAffilie = referenceAffilie;
	}

	@Column(name = "STA_VOLUME")
	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	@Override
	public int hashCode() {
		
		return new HashCodeBuilder()
				.append(this.dateDebut)
				.append(this.dateFin)
				.append(this.referenceAffilie)
				.append(this.volume)
				.build();
	}

	@Override
	public boolean equals(Object candidat) {
		
		if (candidat == this)
			return true;
		if (candidat == null)
			return false;
		if (!(candidat instanceof StatistiqueApportAffairePeriodique))
			return false;
		
		final StatistiqueApportAffairePeriodique autre = (StatistiqueApportAffairePeriodique) candidat;
		
		return new EqualsBuilder()
				.append(this.dateDebut, autre.dateDebut)
				.append(this.dateFin, autre.dateFin)
				.append(this.referenceAffilie, autre.referenceAffilie)
				.append(this.volume, autre.volume)
				.build();
	}

	@Override
	public String toString() {
		
		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
				.append("Référence Affilié", this.referenceAffilie)
				.append("Date de début", this.dateDebut)
				.append("Date de fin", this.dateFin)
				.append("Volume", this.volume)
				.build();
	}
	
}
