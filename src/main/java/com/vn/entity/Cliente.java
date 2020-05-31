package com.vn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* Classe entidad que se mapea contra una tabla de BD */
@Entity
/* @Table anotación opcional que nos serviría para renombrar la tabla a la que hacemos referencia desde objeto Cliente */
//@Table(name = "APP_CLIENTE")
public class Cliente {

	@Id // Indica clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto genera un identificador en base a una secuencia
	private Integer id;
	
	@Column(name = "first_name") // Indica contra qué columna se mapea el atributo de la clase
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email") // No es necesario si la columna se llama igual
    private String email;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}
