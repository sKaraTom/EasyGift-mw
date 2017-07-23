package fr.doranco.easygift.middleware.objetmetier.avis;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_AVIS")
public class Avis implements Serializable {
	
	@EmbeddedId
	private AvisPK pk;
	
	@Column(name = "AVI_CORPS")
	private String corps;

	public AvisPK getPk() {
		return pk;
	}

	public void setPk(AvisPK pk) {
		this.pk = pk;
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}
	
	@Embeddable
	public class AvisPK implements Serializable {
		
		private String referenceProduit;
		
		private String identifiantAuteur;
		
		private Instant dateCreation;

		@Id
		@Column(name = "AVI_REFERENCEPRODUIT")
		public String getReferenceProduit() {
			return referenceProduit;
		}

		public void setReferenceProduit(String referenceProduit) {
			this.referenceProduit = referenceProduit;
		}

		@Id
		@Column(name = "AVI_IDENTIFIANTAUTEUR")
		public String getIdentifiantAuteur() {
			return identifiantAuteur;
		}

		public void setIdentifiantAuteur(String identifiantAuteur) {
			this.identifiantAuteur = identifiantAuteur;
		}

		@Id
		@Column(name = "AVI_DATECREATION")
		public Instant getDateCreation() {
			return dateCreation;
		}

		public void setDateCreation(Instant dateCreation) {
			this.dateCreation = dateCreation;
		}
		
	}

}