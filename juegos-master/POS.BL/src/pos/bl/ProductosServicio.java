/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.bl;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ProductosServicio {
    private final ArrayList<Producto> listadeProductos;

    public ProductosServicio() {
        listadeProductos = new ArrayList<>();
        
        crearDatosdePrueba();
    }

    public ArrayList<Producto> obtenerProductos() {
        return listadeProductos;
    }

    public ArrayList<Producto> obtenerProductos(String buscar) {
        
        if (buscar == null && buscar.equals("")) {
            return listadeProductos;
        }
        
        String buscarMinuscula = buscar.toLowerCase();
        ArrayList<Producto> resultado = new ArrayList<>();
        
        listadeProductos.forEach(producto -> {
            if (producto.getDescripcion().toLowerCase().contains(buscar) == true) {
                resultado.add(producto);
            }
        });
        
        return resultado;
    }
    
    public String guardar(Producto producto) { 
        String resultado = validarProducto(producto);
        
        if (resultado.equals("")) {                   

            if (producto.getId().equals(0)) {
                Integer id = obtenerSiguienteId();

                producto.setId(id);

                listadeProductos.add(producto);
            } else {
                listadeProductos.forEach(productoExistente -> {
                    if (productoExistente.getId().equals(producto.getId())) {
                        productoExistente.setDescripcion(producto.getDescripcion());
                        productoExistente.setPlataforma(producto.getPlataforma());
                        productoExistente.setPrecio(producto.getPrecio());
                        productoExistente.setExistencia(producto.getExistencia());
                        productoExistente.setActivo(producto.getActivo());
                    }            
                });
            }
            return "";
        } 
        
        return resultado;
    }
    
    public void eliminar(Producto producto) {
        listadeProductos.remove(producto);
    }
    
    private void crearDatosdePrueba() {
        Plataforma plataforma1 = new Plataforma("Nintendo Switch");
        plataforma1.setId(1);
        
        Plataforma plataforma2 = new Plataforma("PlayStation 4");
        plataforma1.setId(1);
        
        Producto producto1 = new Producto();
        producto1.setId(1);
        producto1.setDescripcion("FIFA 2020");
        producto1.setPlataforma(plataforma2);
        producto1.setPrecio(1000.00);
        producto1.setExistencia(80);

        Producto producto2 = new Producto();
        producto2.setId(2);
        producto2.setDescripcion("Super Mario Odyssey");
        producto2.setPlataforma(plataforma1);
        producto2.setPrecio(1500.00);
        producto2.setExistencia(50);
        
        Producto producto3 = new Producto();
        producto3.setId(3);
        producto3.setDescripcion("Call of Duty Modern Warfare");
        producto3.setPlataforma(plataforma1);
        producto3.setPrecio(1500.00);
        producto3.setExistencia(20);
        
        Producto producto4 = new Producto();
        producto4.setId(4);
        producto4.setDescripcion("God of War");
        producto4.setPlataforma(plataforma1);
        producto4.setPrecio(1600.00);
        producto4.setExistencia(100);
        
        Producto producto5 = new Producto();
        producto5.setId(5);
        producto5.setDescripcion("Kingdom Hearts");
        producto5.setPlataforma(plataforma2);
        producto5.setPrecio(1800.00);
        producto5.setExistencia(15);
        
        listadeProductos.add(producto1);
        listadeProductos.add(producto2);
        listadeProductos.add(producto3);
        listadeProductos.add(producto4);
        listadeProductos.add(producto5);
    }   

    private Integer obtenerSiguienteId() {
        Integer maxId = 1;
        for(Producto producto: listadeProductos) {
            if (producto.getId() >= maxId) {
                maxId = producto.getId() + 1;
            }
        }
        return maxId;
    }

    private String validarProducto(Producto producto) {
        if (producto.getDescripcion() == null || 
                producto.getDescripcion().equals("")) {
            return "Ingrese la descripción";
        }
        if (producto.getPlataforma() == null) {
            return "Seleccione una plataforma";
        }
        if (producto.getPrecio() < 0) {
            return "Ingrese un precio mayor o igual a cero";
        }
        if (producto.getExistencia() < 0) {
            return "La existencia debe ser mayor que cero";
        }
        
        return "";
    }
}
