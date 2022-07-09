package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeSet;

import org.junit.Test;

public class TestVeterinaria {

	@Test
	public void queSePuedaAgregarDosMascotasAUnDuenio() throws MascotaDuplicadaException {

		Duenio duenio = new Duenio(1, "pepito");

		Mascota mascotaUno = new Mascota(1, "gato", "michu", TipoDeMascota.domestica);
		Mascota mascotaDos = new Mascota(2, "perro", "dog", TipoDeMascota.domestica);

		duenio.agregarMascota(mascotaUno);
		duenio.agregarMascota(mascotaDos);

		Integer cantidadDeMascotasEsperadas = 2;
		Integer cantidadDeMascotasObtenidas = duenio.cantidadDeMascotasPorDuenio();

		assertEquals(cantidadDeMascotasEsperadas, cantidadDeMascotasObtenidas);
	}

	@Test(expected = MascotaDuplicadaException.class)
	public void queAlAgregarDosMascotasConMismoIdParaUnMismoDuenioLanceUnaExcepcionMascotaDuplicadaException()
			throws MascotaDuplicadaException {
		Duenio duenio = new Duenio(1, "pepito");

		Mascota mascota = new Mascota(1, "gato", "michu", TipoDeMascota.domestica);

		duenio.agregarMascota(mascota);
		duenio.agregarMascota(mascota);

	}

	@Test
	public void queSePuedaCrearUnMedicamentoConIdDescripcionYPrecio() {

		Integer id = 1;
		String descripcion = "..";
		Double precio = 0.0;

		Medicamento medicamento = new Medicamento(id, descripcion, precio);
		assertNotNull(medicamento);
	}

	@Test
	public void queSePuedanAgregarDueniosDeMascotasAUnaVeterinaria() {
		Veterinaria veterinaria = new Veterinaria("...");

		Duenio duenio = new Duenio(1, "pepito");
		veterinaria.agregarDuenio(duenio);

		Integer cantidadDeDueniosEsperados = 1;
		Integer cantidadDeDueniosObtenidos = veterinaria.cantidadDeDuenios();

		assertEquals(cantidadDeDueniosEsperados, cantidadDeDueniosObtenidos);

	}

	@Test
	public void queSePuedaCrearUnaAtencionConDuenioYMascotaYPrecio()
			throws DuenioInexistenteException, MascotaNoEncontradaException {
		Integer id = 1;
		Duenio duenio = new Duenio(1, ",,,");
		Mascota mascota = new Mascota(1, "...", "...", TipoDeMascota.domestica);
		Double precio = 0.0;
		Atencion a = new Atencion(id,duenio, mascota, precio);

		assertNotNull(a);
	}

	
	@Test
	public void queSePuedaAsignarVariosMedicamentosAUnaAtencion() {
		Integer id = 1;
		Duenio duenio = new Duenio(1, ",,,");
		Mascota mascota = new Mascota(1, "...", "...", TipoDeMascota.domestica);
		Double precio = 0.0;
		Atencion atencion = new Atencion(id,duenio, mascota, precio);
		
		Medicamento medicamento = new Medicamento(1, "vacuna", 500.0);
		Medicamento medicamento2 = new Medicamento(1, "pastilla", 100.0);
		
		atencion.agregarMedicamentoALaAtencion(medicamento);
		atencion.agregarMedicamentoALaAtencion(medicamento2);
		
		Integer cantidadDeMedicamentosEnLaAtencionEsperados = 2;
		Integer cantidadDeMedicamentosEnLaAtencionObtenidos = atencion.cantidadDeMedicamentos();
		
        assertEquals(cantidadDeMedicamentosEnLaAtencionEsperados,cantidadDeMedicamentosEnLaAtencionObtenidos);
	}

	@Test
	public void queSePuedaCalcularElPrecioTotalDeUnaAtencion() {
		// El precio total de la atencion será la suma del precio de la
		// atencion mas la suma del precio de todos los medicamentos
		Integer id = 1;
		Duenio duenio = new Duenio(1, ",,,");
		Mascota mascota = new Mascota(1, "...", "...", TipoDeMascota.domestica);
		Double precio = 500.0;
		Atencion atencion = new Atencion(id,duenio, mascota, precio);
		
		Medicamento medicamento = new Medicamento(1, "vacuna", 500.0);
		Medicamento medicamento2 = new Medicamento(1, "pastilla", 100.0);
		
		atencion.agregarMedicamentoALaAtencion(medicamento);
		atencion.agregarMedicamentoALaAtencion(medicamento2);
		
		Double precioEsperado = 1100.0;
		Double precioObtenido = atencion.getPrecioDeLaAtencion();
		
		assertEquals(precioEsperado,precioObtenido);
		
	}

	@Test
	public void queSePuedaObtenerDeUnDuenioUnaListaDeMascotasDomesticasOrdenadasPorApodo() throws MascotaDuplicadaException {
		Duenio duenio = new Duenio(1,"Jorgito");
		Mascota mascotaUno = new Mascota(1, "gato", "michu", TipoDeMascota.domestica);
		Mascota mascotaDos = new Mascota(2, "perro", "negro", TipoDeMascota.domestica);
		Mascota mascotaTres = new Mascota(3, "loro", "azul", TipoDeMascota.exotica);
		
		duenio.agregarMascota(mascotaUno);
		duenio.agregarMascota(mascotaDos);
		duenio.agregarMascota(mascotaTres);
		
		duenio.ordenarMascotaPorApodo();
	
	}

	@Test
	public void queSePuedaObtenerUnMapaConIdDeAtencionYIdDeMascota() {
		Veterinaria veterinaria = new Veterinaria("...");
		
		Integer idAtencion = 1;
		Integer idMascota = 1;
		Duenio duenio = new Duenio(1, "Jorge");
		Mascota mascota = new Mascota(idMascota, "gato", "michu", TipoDeMascota.domestica);
		Double precio = 500.0;
		Atencion atencion = new Atencion(idAtencion,duenio, mascota, precio);
		
		Map<Integer,Integer> mapa = veterinaria.devolverMapa(idAtencion, idMascota);
		
		for (Map.Entry<Integer, Integer> entry : mapa.entrySet()) {
	        System.out.println(entry.getKey() + " = " + entry.getValue()); 
	    }
		
		
		
	}
}
