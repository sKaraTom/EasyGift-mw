package fr.doranco.easygift.middleware.dao.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "T_OCCASION")
public class OccasionJpaEntity {

	private static final long serialVersionUID = 1L;

	private String code;
	
	private String label;
	
	private String description;
	
	private Calendar dateDebut;
	
	private Calendar dateFin;

	public OccasionJpaEntity() {
		super();
	}

	public OccasionJpaEntity(String code, String label, String description,
			Calendar dateDebut, Calendar dateFin) {
		super();
		this.code = code;
		this.label = label;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	@Id
	@Column(name = "OCC_CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "OCC_LABEL")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Column(name = "OCC_DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "OCC_DATEDEBUT")
	public Calendar getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Calendar dateDebut) {
		this.dateDebut = dateDebut;
	}

	@Column(name = "OCC_DATEFIN")
	public Calendar getDateFin() {
		return dateFin;
	}
	
	public void setDateFin(Calendar dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public int hashCode() {
		
		return new HashCodeBuilder()
				.append(this.code)
				.append(this.dateDebut)
				.append(this.dateFin)
				.append(this.description)
				.append(this.label)
				.build();
	}

	@Override
	public boolean equals(final Object candidat) {
		
		if (candidat == this)
			return true;
		if (candidat == null)
			return false;
		if (!(candidat instanceof OccasionJpaEntity))
			return false;
		
		final OccasionJpaEntity autre = (OccasionJpaEntity) candidat;
		
		return new EqualsBuilder()
				.append(this.code, autre.code)
				.append(this.dateDebut, autre.dateDebut)
				.append(this.dateFin, autre.dateFin)
				.append(this.description, autre.description)
				.append(this.label, autre.label)
				.build();
	}

	@Override
	public String toString() {
		
		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
				.append("Code", this.code)
				.append("Label", this.label)
				.append("Description", this.description)
				.append("Date de début", this.dateDebut)
				.append("Date de fin", this.dateDebut)
				.build();
	}
	
}
