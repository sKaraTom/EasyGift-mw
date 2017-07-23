package fr.doranco.easygift.middleware.objetmetier.abonne;

import java.io.Serializable;
import java.time.Instant;

import javax.mail.internet.InternetAddress;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "T_ABONNE")
public class Abonne implements Serializable {
	
	private static final long serialVersionUID = 2L;

	@Id
	@Column(name = "ABO_MAIL")
	private InternetAddress mail;
	
	@Column(name = "ABO_DATEABONNEMENT")
	private Instant dateAbonnement;
	
	public Abonne() {
		super();
	}

	public Abonne(InternetAddress mail) {
		super();
		this.mail = mail;
	}

	public InternetAddress getMail() {
		return mail;
	}

	public void setMail(InternetAddress mail) {
		this.mail = mail;
	}

	public Instant getDateAbonnement() {
		return dateAbonnement;
	}

	public void setDateAbonnement(Instant dateAbonnement) {
		this.dateAbonnement = dateAbonnement;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(mail)
				.build();
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Abonne)) {
			return false;
		}
		
		final Abonne abonne = (Abonne) obj; 
		
		return new EqualsBuilder()
				.append(this.mail, abonne.mail)
				.build();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("Email", this.mail)
				.build();
	}

}
