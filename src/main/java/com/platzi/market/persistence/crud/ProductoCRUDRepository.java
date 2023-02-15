package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entities.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ProductoCRUDRepository extends CrudRepository<Producto, Long> {

//    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
     List<Producto> findByIdCategoriaOrderByNombreAsc(Long idCategoria);

     Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);



}
