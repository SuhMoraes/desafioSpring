package br.com.suhmoraes.desafioorangetalents.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="users")
public class UserEntity {
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Id
	@Column(name = "cpf", nullable = false, unique = true)
	private String registerId;
	
	@Column(nullable = false)
	private LocalDate birthDate;
	
	
	public UserEntity() {
		this.name = "";
		this.email = "";
		this.registerId = "";
		this.birthDate = LocalDate.EPOCH;
	}


	public UserEntity(String name, String email, String registerId, LocalDate birthDate) {
		super();
		this.name = name;
		this.email = email;
		this.registerId = registerId;
		this.birthDate = birthDate;
	}


	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}


	public String getRegisterId() {
		return registerId;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((registerId == null) ? 0 : registerId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (registerId == null) {
			if (other.registerId != null)
				return false;
		} else if (!registerId.equals(other.registerId))
			return false;
		return true;
	}
	
	
	
	
	
	
}
