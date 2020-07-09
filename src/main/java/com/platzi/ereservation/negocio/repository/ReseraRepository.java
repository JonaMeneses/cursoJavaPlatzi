/**
 * 
 */
package com.platzi.ereservation.negocio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platzi.ereservation.modelo.Reserva;

/**
 * interface para definir todas las operaciones relacionadas con Resrvas
 * @author jona_
 *
 */
public interface ReseraRepository extends JpaRepository<Reserva, String> {

	@Query("Select r from Reserva r where r.fechaIngreso =:fechaInicio and r.fechaSalida =:fechaSalida")
	public List<Reserva> find(@Param("fechaInicio") Date fechaInicio,@Param("fechaSalida") Date fechaSalida);
	
}
