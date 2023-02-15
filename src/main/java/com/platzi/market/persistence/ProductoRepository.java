package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCRUDRepository;
import com.platzi.market.persistence.entities.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCRUDRepository productoCRUDRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCRUDRepository.findAll();
    }

    public List<Producto> getByCategoria(Long idCategoria){
        return productoCRUDRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCRUDRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(Long idProducto){
        return productoCRUDRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCRUDRepository.save(producto);
    }

    public void delete(Long idProducto){
        productoCRUDRepository.deleteById(idProducto);
    }



}
