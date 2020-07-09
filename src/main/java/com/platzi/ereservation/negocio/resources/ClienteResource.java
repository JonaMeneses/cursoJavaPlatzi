/**
 * 
 */
package com.platzi.ereservation.negocio.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.negocio.resources.vo.ClienteVO;
import com.platzi.ereservation.negocio.services.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el WS de clientes
 * @author jona_
 *
 */
@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {
	private final ClienteService clienteService;
	
	public ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	/**
	 * Metodo que realiza la creacion de un cliente
	 * @param clienteVO
	 * @return
	 */
	@PostMapping
	@ApiOperation(value="Crear cliente",notes = "Servicio para crear un nuevo cliente")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Cliente creado correctamente"),
						@ApiResponse(code=400,message="Solicitud invalida")})
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVO){
		Cliente cliente = new Cliente();
		cliente.setNombre(clienteVO.getNombre());
		cliente.setApellido(clienteVO.getApellido());
		cliente.setDireccion(clienteVO.getDireccion());
		cliente.setTelefono(clienteVO.getTelefono());
		cliente.setEmail(clienteVO.getEmail());
		return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
	}
	
	/**
	 * Metodo para actualizar un cliente
	 * @param identificacion
	 * @return
	 */
	@PutMapping("/{identificacion}")
	@ApiOperation(value="Actualizar cliente",notes = "Servicio para actualizar un nuevo cliente")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Cliente actualizado correctamente"),
			@ApiResponse(code=404,message="Cliente no encontrado")})
	public ResponseEntity<Cliente> updateCliente(@PathVariable("identificacion") String identificacion,ClienteVO clienteVO){
		
		Cliente cliente = this.clienteService.findByIDentificacion(identificacion);
		if(cliente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
		cliente.setNombre(clienteVO.getNombre());
		cliente.setApellido(clienteVO.getApellido());
		cliente.setDireccion(clienteVO.getDireccion());
		cliente.setTelefono(clienteVO.getTelefono());
		cliente.setEmail(clienteVO.getEmail());
		}
		
		return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);
	}
	
	/**
	 * Metodo para eliminar un cliente
	 * @param identificacion
	 */
	@DeleteMapping("/{identificacion}")
	@ApiOperation(value="Eliminar cliente",notes = "Servicio para Eliminar un nuevo cliente")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Cliente eliminado correctamente"),
			@ApiResponse(code=404,message="Cliente no encontrado")})
	public void RemoveCliente(@PathVariable("identificacion") String identificacion) {
		Cliente cliente = this.clienteService.findByIDentificacion(identificacion);
		if(cliente != null) {
			this.clienteService.delete(cliente);
		}
		
	}
	
	/**
	 * Metodo para obtener un listado de clientes
	 * @return
	 */
	@GetMapping
	@ApiOperation(value="Obtener clientes",notes = "Servicio para obtener clientes")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Clientes encontrados correctamente"),
			@ApiResponse(code=404,message="Clientes no encontrados")})
	public ResponseEntity<List<Cliente>> findAll(){
		return new ResponseEntity<>(this.clienteService.findAll(),HttpStatus.FOUND);
	}
}
