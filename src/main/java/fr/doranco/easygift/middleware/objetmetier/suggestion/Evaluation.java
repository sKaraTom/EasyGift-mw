package fr.doranco.easygift.middleware.objetmetier.suggestion;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

import fr.doranco.easygift.middleware.objetmetier.client.Client;

@Entity
@Table(name = "T_EVALUATION")
public class Evaluation {

	private UUID uuid;
	
	private Client client;
	
	private Integer note;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "EVA_UUID")
	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	
	@ManyToOne
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "EVA_NOTE")
	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Evaluation() {
		super();
	}

	public Evaluation(UUID uuid, Client client, Integer note) {
		super();
		this.uuid = uuid;
		this.client = client;
		this.note = note;
	}

	@Override
	public int hashCode() {
		
		return new HashCodeBuilder()
				.append(this.client)
				.append(this.note)
				.append(this.uuid)
				.build();
	}

	@Override
	public boolean equals(final Object candidat) {
		
		if (candidat == this)
			return true;
		if (candidat == null)
			return false;
		if (!(candidat instanceof Evaluation))
			return false;
		
		final Evaluation autre = (Evaluation) candidat;
		
		return new EqualsBuilder()
				.append(this.client, autre.client)
				.append(this.note, autre.note)
				.append(this.uuid, autre.uuid)
				.build();
	}

	@Override
	public String toString() {
		
		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
				.append("Client", this.client)
				.append("Note", this.note)
				.append("UUID", this.uuid)
				.build();
	}
	
}
