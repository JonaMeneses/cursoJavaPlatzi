/**
 * 
 */
package com.platzi.ereservation.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.negocio.repository.ClienteRepository;

/**
 * Clase para definir los servicios de clientes
 * 
 * @author jona_
 *
 */
@Service
@Transactional(readOnly=true)
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	/**
	 * Metodo para realizar operacion guardar cliente
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	/**
	 * Metodo para realizar actualizacion de un cliente
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	/**
	 * Metodo para eliminar un cliente
	 * @param cliente
	 */
	@Transactional
	public void delete(Cliente cliente) {
				this.clienteRepository.delete(cliente);
	}
	
	/**
	 * Metodo para obtener un cliente por su identificacion
	 * @param identificacion
	 * @return
	 */
	@Transactional
	public Cliente findByIDentificacion(String identificacion) {
		return this.findByIDentificacion(identificacion);
	}
	
	/**
	 * Metodo que obtiene un acolecicon de clientes 
	 * @return
	 */
	public List<Cliente> findAll(){
		return this.clienteRepository.findAll();
	}

}
