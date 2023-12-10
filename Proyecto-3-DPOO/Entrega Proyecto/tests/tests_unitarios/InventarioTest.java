package tests_unitarios;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import modelo.Categoria;
import modelo.Categorias;
import modelo.Inventario;
import modelo.Sede;
import modelo.Vehiculo;
 

import org.junit.Before;
import org.junit.Test;

public class InventarioTest {

    private Inventario inventario;
    private File testArchivo;

    @Before
    public void setUp() {
        testArchivo = new File("testInventario.csv");
        inventario = new Inventario(testArchivo);
    }

    @Test
    public void testCargarInventarioDesdeArchivoExistente() {
        // Crear un HashMap de prueba
        Map<String, ArrayList<Vehiculo>> datosDePrueba = new HashMap<>();
        // Agregar datos de prueba al HashMap

        try {
            // Guardar el HashMap en el archivo de prueba
            inventario.guardarVehiculo();

            // Crear un nuevo objeto Inventario y cargar desde el archivo de prueba
            Inventario nuevoInventario = new Inventario(testArchivo);

            // Verificar que los datos cargados sean iguales a los datos de prueba
            assertEquals(datosDePrueba, nuevoInventario.getInventario());
        } catch (IOException e) {
            fail("Excepción al cargar el archivo de prueba: " + e.getMessage());
        }
    }

    @Test
    public void testCargarInventarioDesdeArchivoInexistente() {
        // Verificar que el inventario esté vacío si el archivo no existe
        assertEquals(new HashMap<String, ArrayList<Vehiculo>>(), inventario.getInventario());
    }
    public void testAgregarVehiculoExistente() {
        // Verificar que no se dupliquen vehículos en una misma sede
        Vehiculo vehiculo = new Vehiculo(/* Datos del vehículo */);
        inventario.agregarVehiculo(vehiculo);

        int cantidadInicial = inventario.getInventario().get(vehiculo.getnombreSede()).size();
        inventario.agregarVehiculo(vehiculo);
        int cantidadDespues = inventario.getInventario().get(vehiculo.getnombreSede()).size();

        assertEquals(cantidadInicial, cantidadDespues);
    }
    @Test
    public void testEliminarVehiculoInexistente() {
        // Verificar que no haya cambios si se intenta eliminar un vehículo que no existe
        String placaInexistente = "PLACA_NO_EXISTE";
        int cantidadAntes = inventario.getInventario().values().stream().mapToInt(List::size).sum();
        inventario.eliminarVehiculo(placaInexistente);
        int cantidadDespues = inventario.getInventario().values().stream().mapToInt(List::size).sum();

        assertEquals(cantidadAntes, cantidadDespues);
    }
    @Test
    public void testConseguirCarroDisponible() {
        // Verificar que se obtenga un vehículo disponible en una sede específica
        Sede sede = new Sede("ASD", null, null);
        LocalDateTime fechaRecoleccion = LocalDateTime.now();

        Vehiculo vehiculo = new Vehiculo(null, null, null, null, null, null, null, false, "ASD");
        inventario.agregarVehiculo(vehiculo);

        Vehiculo vehiculoObtenido = inventario.conseguirCarro(fechaRecoleccion, sede, null);

        assertNotNull(vehiculoObtenido);
        assertTrue(vehiculo.estaDisponible(fechaRecoleccion, categoria));
    }
    @Test
    public void testConseguirCarroNoDisponible() {
        // Verificar que se devuelva null si no hay vehículos disponibles
        Sede sede = new Sede("Caros", "Diagonal 182#12-21", null);
        LocalDateTime fechaRecoleccion = LocalDateTime.now();

        Vehiculo vehiculo = new Vehiculo(null, null, null, null, null, sede, fechaRecoleccion, false, null);
        inventario.agregarVehiculo(vehiculo);

        // Marcar el vehículo como no disponible para la categoría y fecha específica
        vehiculo.getRegistro();

        Vehiculo vehiculoObtenido = inventario.conseguirCarro(fechaRecoleccion, sede, categoria);

        assertNull(vehiculoObtenido);
    }
}