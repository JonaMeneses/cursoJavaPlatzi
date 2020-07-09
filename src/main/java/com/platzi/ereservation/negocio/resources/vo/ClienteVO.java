/**
 * 
 */
package com.platzi.ereservation.negocio.resources.vo;



import lombok.Data;

/**
 * Clase que representa la tabla cliente
 * @author jona_
 *
 */
@Data
public class ClienteVO {
	
	private String idCliente;
	private String nombre;
	private String apellido;
	private String identificacion;
	private String direccion;
	private String email;
	 
}
