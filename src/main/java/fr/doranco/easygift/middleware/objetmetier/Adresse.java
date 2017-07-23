package fr.doranco.easygift.middleware.objetmetier;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.UUID;

@XmlRootElement
public class Adresse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private UUID uuid;

	private String ligne1;
	
	private String ligne2;
	
	private String codeZip;

	public Adresse() {
		super();
	}

	public Adresse(UUID uuid, String ligne1, String ligne2, String codeZip) {
		super();
		this.uuid = uuid;
		this.ligne1 = ligne1;
		this.ligne2 = ligne2;
		this.codeZip = codeZip;
	}

	@XmlElement(name = "identifiant")
	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getLigne1() {
		return ligne1;
	}

	public void setLigne1(String ligne1) {
		this.ligne1 = ligne1;
	}

	public String getLigne2() {
		return ligne2;
	}

	public void setLigne2(String ligne2) {
		this.ligne2 = ligne2;
	}

	public String getCodeZip() {
		return codeZip;
	}

	public void setCodeZip(String codeZip) {
		this.codeZip = codeZip;
	}

	@Override
	public int hashCode() {

		return new HashCodeBuilder()
				.append(this.uuid)
				.append(this.codeZip)
				.append(this.ligne1)
				.append(this.ligne2)
				.build();
	}

	@Override
	public boolean equals(final Object candidat) {
		
		if (candidat == this)
			return true;
		if (candidat == null)
			return false;
		if (!(candidat instanceof Adresse))
			return false;
		
		final Adresse autre = (Adresse) candidat;
		
		return new EqualsBuilder()
				.append(this.uuid, autre.uuid)
				.append(this.codeZip, autre.codeZip)
				.append(this.ligne1, autre.ligne1)
				.append(this.ligne2, autre.ligne2)
				.build();
	}
	
}
