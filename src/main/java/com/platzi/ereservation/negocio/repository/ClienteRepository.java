/**
 * 
 */
package com.platzi.ereservation.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.ereservation.modelo.Cliente;


/**
 * Inteface para definir las operaciones relacionads con clientes
 * @author jona_
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, String> {
	
	/**
	 * Definicion de metodo para buscar clientes por apelledo
	 * @param apellido
	 * @return List<Cliente>
	 */
	public List<Cliente> findByApellido (String apellido);
	
	/**
	 * Definicion de metodo para buscar un cliente por identificacion
	 * @param identificacion
	 * @return Cliente
	 */
	public Cliente fincByIDentificacion(String identificacion);

	
	

}
