package kitabook.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/*
 * 	un créneau horaire appartient à un médecin – un médecin a 0 ou plusieurs créneaux horaires ;
	un rendez-vous réunit à la fois un client et un médecin via un créneau horaire de ce dernier ;
	un client a 0 ou plusieurs rendez-vous ;
	à un créneau horaire est associé 0 ou plusieurs rendez-vous (à des jours différents).
 */

//indique que la classe annotée est parente d'entités JPA
@MappedSuperclass
public class AbstractEntity implements Serializable {
	
	/*
	 * Definissent la cle primaire des entites filles de cette classe
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	/* définissent la version de chaque entité. L'implémentation JPA va incrémenter ce n° de version à chaque fois
	que l'entité sera modifiée. 
	Ce n° sert à empêcher la mise à jour simultanée de l'entité par deux utilisateur différents : 
	deux utilisateurs U1 et U2 lisent l'entité E avec un n° de version égal à V1. 
	U1 modifie E et persiste cette modification en base : le n° de version passe alors à V1+1. 
	U2 modifie E à son tour et persiste cette modification en base : il recevra une
	exception car il possède une version (V1) différente de celle en base (V1+1) */
	@Version
	protected Long version;

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	// initialisation
	public AbstractEntity build(Long id, Long version) {
		this.id = id;
		this.version = version;
		return this;
	}

	@Override
	public boolean equals(Object entity) {
		String class1 = this.getClass().getName();
		String class2 = entity.getClass().getName();
		if (!class2.equals(class1)) {
			return false;
		}
		AbstractEntity other = (AbstractEntity) entity;
		return this.id == other.id;
	}

	// getters et setters
	public Long getId() {
		return id;
	}

	public Long getVersion() {
		return version;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
