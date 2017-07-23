package fr.doranco.easygift.middleware.objetmetier.occasion;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Occasion implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	
	private String label;
	
	private String description;
	
	private Calendar dateDebut;
	
	private Calendar dateFin;

	public Occasion() {
		super();
	}

	public Occasion(String code, String label, String description,
			Calendar dateDebut, Calendar dateFin) {
		super();
		this.code = code;
		this.label = label;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Calendar dateDebut) {
		this.dateDebut = dateDebut;
	}

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
		if (!(candidat instanceof Occasion))
			return false;
		
		final Occasion autre = (Occasion) candidat;
		
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
