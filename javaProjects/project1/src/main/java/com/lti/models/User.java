package com.lti.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "u_id")
	private int id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String passwrod;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	
	@ManyToOne
    @JoinColumn(name="role_id")
	private UserRole ur;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String username, String passwrod, String firstName, String lastName, String email,
			UserRole ur) {
		super();
		this.id = id;
		this.username = username;
		this.passwrod = passwrod;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.ur = ur;
	}

	
	
	
	
	
	
	
	public User(String username, String passwrod, String firstName, String lastName, String email, UserRole ur) {
		super();
		this.username = username;
		this.passwrod = passwrod;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.ur = ur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getUr() {
		return ur;
	}

	public void setUr(UserRole ur) {
		this.ur = ur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((passwrod == null) ? 0 : passwrod.hashCode());
		result = prime * result + ((ur == null) ? 0 : ur.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (passwrod == null) {
			if (other.passwrod != null)
				return false;
		} else if (!passwrod.equals(other.passwrod))
			return false;
		if (ur == null) {
			if (other.ur != null)
				return false;
		} else if (!ur.equals(other.ur))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwrod=" + passwrod + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", ur=" + ur + "]";
	}

	
}
