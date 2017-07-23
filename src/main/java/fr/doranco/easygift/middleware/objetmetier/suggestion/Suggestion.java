package fr.doranco.easygift.middleware.objetmetier.suggestion;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_SUGGESTION")
public class Suggestion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private UUID uuid;
	
	private List<Evaluation> evaluations;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(
			name = "uuid",
			strategy = "org.hibernate.id.UUIDGenerator"
		)
	@Column(name = "SUG_UUID")
	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	@OneToMany
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

}
