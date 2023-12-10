import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import modelo.*;

public class SistemaReservaAlquilerTest {

    private SistemaReservaAlquiler sistema;
    private File testArchivo;

    @Before
    public void setUp() {
        testArchivo = new File("testReservasAlquileres.dat");
        sistema = new SistemaReservaAlquiler(testArchivo);
    }

    @Test
    public void testCrearAlquilerYReserva() throws IOException {
        // Datos de prueba
        Categoria categoria = Categorias.getCategorias().get(0);
        Sede sedeRecogida = new Sede("Sede1", "Dirección1", new HorarioAtencion(/* Horario de atención */));
        Sede sedeEntrega = new Sede("Sede2", "Dirección2", new HorarioAtencion(/* Horario de atención */));
        LocalDateTime fechaRecoleccion = LocalDateTime.now();
        LocalDateTime fechaEntrega = fechaRecoleccion.plusDays(1);
        Inventario inventario = new Inventario(new File("testInventario.dat"));

        // Crear un usuario con datos de prueba
        Usuario usuario = new Usuario("testUser", "testPassword", "Cliente");
        usuario.aniadirDatosCliente("John", "Doe", "123456789", "john@example.com", LocalDateTime.of(1990, 1, 1, 0, 0), "US", null, null, "D1234567");

        // Crear vehículo disponible
        Vehiculo vehiculo = new Vehiculo(categoria, "Modelo1", "Rojo", "Automático", "Disponible", sedeRecogida, fechaRecoleccion.plusDays(1), true, "ABC123");
        inventario.agregarVehiculo(vehiculo);

        // Crear reserva
        assertTrue(sistema.crearReserva(categoria, sedeRecogida, fechaRecoleccion, sedeEntrega, fechaEntrega, inventario));

        // Crear alquiler
        assertTrue(sistema.crearAlquiler(categoria, sedeRecogida, fechaRecoleccion, sedeEntrega, fechaEntrega, inventario, usuario));

        // Verificar que la reserva y el alquiler estén en la lista
        assertEquals(1, sistema.getReservas().size());
        assertEquals(1, sistema.getAlquileres().size());
    }

    @Test
    public void testCrearAlquilerSinVehiculoDisponible() throws IOException {
        // Datos de prueba
        Categorias categoria = Categorias.getCategorias().get(0);
        Sede sedeRecogida = new Sede("Sede1", "Dirección1", new HorarioAtencion(/* Horario de atención */));
        Sede sedeEntrega = new Sede("Sede2", "Dirección2", new HorarioAtencion(/* Horario de atención */));
        LocalDateTime fechaRecoleccion = LocalDateTime.now();
        LocalDateTime fechaEntrega = fechaRecoleccion.plusDays(1);
        Inventario inventario = new Inventario(new File("testInventario.dat"));
        Usuario usuario = new Usuario("testUser", "testPassword", "Cliente");

        // Marcar todos los vehículos como no disponibles
        inventario.getInventario().values().forEach(listaVehiculos -> listaVehiculos.forEach(vehiculo -> vehiculo.getRegistro().registrarOcupacion(fechaRecoleccion, categoria)));

        // Crear alquiler
        assertFalse(sistema.crearAlquiler(categoria, sedeRecogida, fechaRecoleccion, sedeEntrega, fechaEntrega, inventario, usuario));

        // Verificar que no haya alquiler creado
        assertEquals(0, sistema.getAlquileres().size());
    }

    @Test
    public void testGuardarYRecuperarReservasAlquileres() throws IOException {
        // Datos de prueba
        Categorias categoria = Categorias.getCategorias().get(0);
        Sede sedeRecogida = new Sede("Sede1", "Dirección1", new HorarioAtencion(/* Horario de atención */));
        Sede sedeEntrega = new Sede("Sede2", "Dirección2", new HorarioAtencion(/* Horario de atención */));
        LocalDateTime fechaRecoleccion = LocalDateTime.now();
        LocalDateTime fechaEntrega = fechaRecoleccion.plusDays(1);
        Inventario inventario = new Inventario(new File("testInventario.dat"));
        Usuario usuario = new Usuario("testUser", "testPassword", "Cliente");
        usuario.aniadirDatosCliente("John", "Doe", "123456789", "john@example.com", LocalDateTime.of(1990, 1, 1, 0, 0), "US", null, null, "D1234567");

        // Crear vehículo disponible
        Vehiculo vehiculo = new Vehiculo(categoria, "Modelo1", "Rojo", "Automático", "Disponible", sedeRecogida, fechaRecoleccion.plusDays(1), true, "ABC123");
        inventario.agregarVehiculo(vehiculo);

        // Crear reserva y alquiler
        sistema.crearReserva(categoria, sedeRecogida, fechaRecoleccion, sedeEntrega, fechaEntrega, inventario);
        sistema.crearAlquiler(categoria, sedeRecogida, fechaRecoleccion, sedeEntrega, fechaEntrega, inventario, usuario);

        // Guardar reservas y alquileres
        sistema.guardarReservasAlquileres();

        // Crear un nuevo sistema para simular la carga desde el archivo
        SistemaReservaAlquiler nuevoSistema = new SistemaReservaAlquiler(testArchivo);

        // Verificar que los datos cargados sean correctos
        assertEquals(1, nuevoSistema.getReservas().size());
        assertEquals(1, nuevoSistema.getAlquileres().size());
    }

    @Test
    public void testCrearSedeYRealizarReserva() throws IOException {
        // Crear una nueva sede
        Sedes sedes = new Sedes(new File("testSedes.dat"));
        sedes.crearSede("NuevaSede", "NuevaDirección", new HorarioAtencion(/* Horario de atención */));

        // Datos de prueba
        Categorias categoria = Categorias.getCategorias().get(0);
        Sede sedeRecogida = sedes.getSede("NuevaSede");
        Sede sedeEntrega = sedes.getSede("OtraSede"); // Asegúrate de que haya otra sede en tu configuración
        LocalDateTime fechaRecoleccion = LocalDateTime.now();
        LocalDateTime fechaEntrega = fechaRecoleccion.plusDays(1);
        Inventario inventario = new Inventario(new File("testInventario.dat"));

        // Crear vehículo disponible
        Vehiculo vehiculo = new Vehiculo(categoria, "Modelo1", "Rojo", "Automático", "Disponible", sedeRecogida, fechaRecoleccion.plusDays(1), true, "ABC123");
        inventario.agregarVehiculo(vehiculo);

        // Crear reserva
        assertTrue(sistema.crearReserva(categoria, sedeRecogida, fechaRecoleccion, sedeEntrega, fechaEntrega, inventario));

        // Verificar que la reserva se realizó correctamente
        assertEquals(1, sistema.getReservas().size());
    }

    @Test
    public void testUsuarioPuedeAlquilar() {
        // Crear un usuario con datos incompletos
        Usuario usuarioIncompleto = new Usuario("testUser", "testPassword", "Cliente");
        assertFalse(usuarioIncompleto.puedeAlquilar());

        // Crear un usuario con datos completos
        Usuario usuarioCompleto = new Usuario("testUser", "testPassword", "Cliente");
        usuarioCompleto.aniadirDatosCliente("John", "Doe", "123456789", "john@example.com", LocalDateTime.of(1990, 1, 1, 0, 0), "US", null, null, "D1234567");
        assertTrue(usuarioCompleto.puedeAlquilar());
    }
    
    @Test
    public void testUsuarioVerificarCredenciales() {
        // Crear un usuario con credenciales correctas
        Usuario usuarioCorrecto = new Usuario("testUser", "testPassword", "Cliente");
        assertTrue(usuarioCorrecto.verificarCredenciales("testUser", "testPassword"));

        // Crear un usuario con credenciales incorrectas
        Usuario usuarioIncorrecto = new Usuario("testUser", "testPassword", "Cliente");
        assertFalse(usuarioIncorrecto.verificarCredenciales("testUser", "wrongPassword"));
    }
}