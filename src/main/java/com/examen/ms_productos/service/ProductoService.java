package com.examen.ms_productos.service;

import com.examen.ms_productos.dto.*;
import com.examen.ms_productos.entity.Producto;
import com.examen.ms_productos.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoService {
	private final ProductoRepository repository;

    public ProductoResponseDTO crear(ProductoRequestDTO request) {
        Producto producto = new Producto();
        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());
        producto.setEstado(request.getEstado());
        
        Producto guardado = repository.save(producto);
        return mapToResponse(guardado);
    }

    public List<ProductoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ProductoResponseDTO buscarPorId(Long id) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        return mapToResponse(producto);
    }

    private ProductoResponseDTO mapToResponse(Producto p) {
        ProductoResponseDTO response = new ProductoResponseDTO();
        response.setId(p.getId());
        response.setNombre(p.getNombre());
        response.setDescripcion(p.getDescripcion());
        response.setPrecio(p.getPrecio());
        response.setStock(p.getStock());
        response.setEstado(p.getEstado());
        response.setFechaCreacion(p.getFechaCreacion());
        return response;
    }

	public Producto actualizar(Long id, Producto productoDetalles) {
		Producto producto = repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
	    
	    producto.setNombre(productoDetalles.getNombre());
	    producto.setDescripcion(productoDetalles.getDescripcion());
	    producto.setPrecio(productoDetalles.getPrecio());
	    producto.setStock(productoDetalles.getStock());
	    
	    return repository.save(producto);
	}

	public void eliminar(Long id) {
		if (!repository.existsById(id)) throw new RuntimeException("No se puede eliminar: Producto inexistente");
	    repository.deleteById(id);
	}
}
