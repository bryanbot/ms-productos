package com.examen.ms_productos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class MsProductosApplicationTests {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	void contextLoads() {
	}
	
	@Test
    void listarProductos() throws Exception {
        mockMvc.perform(get("/api/productos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
	
	@Test
	void noDebeCrearProductoConPrecioNegativo() throws Exception {
	    String productoInvalido = "{\"nombre\":\"Test\", \"precio\": -10.0, \"stock\": 5}";
	    
	    mockMvc.perform(post("/api/productos")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(productoInvalido))
	            .andExpect(status().isBadRequest());
	}
	
	@Test
	void noDebeCrearProductoSinNombre() throws Exception {
	    String productoInvalido = "{\"nombre\":\"\", \"descripcion\":\"Laptop para desarrollo de software\", \"precio\": 4500.00, \"stock\": 5}";
	    
	    mockMvc.perform(post("/api/productos")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(productoInvalido))
	            .andExpect(status().isBadRequest());
	}
	
	@Test
	void noDebeCrearProductoConStockNegativo() throws Exception {
	    String productoInvalido = "{\"nombre\":\"Test\", \"descripcion\":\"Test\", \"precio\": 4500.00, \"stock\": -5}";
	    
	    mockMvc.perform(post("/api/productos")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(productoInvalido))
	            .andExpect(status().isBadRequest());
	}
	
	@Test
	void debeCrearProductoValido() throws Exception {
	    String nuevoProducto = "{\"nombre\":\"Monitor Gamer\", \"descripcion\":\"144Hz\", \"precio\": 850.0, \"stock\": 15}";
	    
	    mockMvc.perform(post("/api/productos")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(nuevoProducto))
	            .andExpect(status().isCreated())
	            .andExpect(jsonPath("$.nombre").value("Monitor Gamer"));
	}
	
	@Test
	void debeRetornar404SiProductoNoExiste() throws Exception {
	    mockMvc.perform(get("/api/productos/99999"))
	            .andExpect(status().isNotFound());
	}
}
