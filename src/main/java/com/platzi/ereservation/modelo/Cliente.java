/**
 * 
 */
package com.platzi.ereservation.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQuery;

import lombok.Data;

/**
 * Clase que representa la tabla cliente
 * @author jona_
 *
 */
@Entity
@Table(name="cliente")
@Data
@NamedQuery(name="Cliente.findByIDentificacion",query="Select c from Cliente c where c.identificacion = ?1")
public class Cliente {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid2")
	private String idCliente;
	private String nombre;
	private String apellido;
	private String identificacion;
	private String direccion;
	private String email;
	@OneToMany(mappedBy="cliente")
	private Set<Reserva> reservas;
	 
}
