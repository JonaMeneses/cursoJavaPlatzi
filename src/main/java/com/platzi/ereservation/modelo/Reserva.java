/**
 * 
 */
package com.platzi.ereservation.modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 *  Clase que representa la tabla reservas
 * @author jona_
 *
 */

@Data
@Entity
@Table(name="reserva")
public class Reserva {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid2")
	private String Id;
	private Date fechaIngreso;
	private Date fechaSalida;
	private int cantidadPersonas;
	private String descripcion;
	@ManyToOne
	@JoinColumn(name="id")
	private Cliente cliente;
}
