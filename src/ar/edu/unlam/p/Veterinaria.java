package ar.edu.unlam.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Veterinaria {

	private String nombre;
	private Set<Duenio> duenios;
	private Set<Mascota> mascotas;
	private Map<Integer,Integer> atencionRealizada;
	private List<Atencion> atenciones;

	public Veterinaria(String nombre) {
		this.nombre = nombre;
		this.duenios = new TreeSet<>();
		this.atenciones = new ArrayList<>();
		this.mascotas = new TreeSet<>();
		this.atencionRealizada = new HashMap<>();
	}

	public void agregarDuenio(Duenio d) {
		this.duenios.add(d);

	}
	
	public void agregarMascota(Mascota mascota) {
		this.mascotas.add(mascota);
	}

	public Integer cantidadDeDuenios() {

		return this.duenios.size();
	}

	public Mascota buscarMascota(Integer id) throws MascotaNoEncontradaException {
		for (Mascota mascota : mascotas) {
			if (mascota.getId().equals(id)) {
				return mascota;
			}
		}
		throw new MascotaNoEncontradaException("La mascota no existe");
	}

	public Duenio buscarDuenio(Integer dni) throws DuenioInexistenteException {
		for (Duenio duenio : duenios) {
			if (duenio.getDni().equals(dni)) {
				return duenio;
			}
		}
		throw new DuenioInexistenteException("El due�o no existe");
	}
	
	public void registroDeAtenciones(Integer id, Integer dni, Integer idMascota, Double precio) throws MascotaNoEncontradaException, DuenioInexistenteException{
		Duenio duenio = buscarDuenio(dni);
		Mascota mascota = buscarMascota(idMascota);
		Atencion atencion = new Atencion(id,duenio,mascota,precio);
		this.atenciones.add(atencion);
		
	}
	
	public Integer cantidadDeRegistrosDeAtencion() {
		return this.atenciones.size();
	}
	
	public Map<Integer, Integer> devolverMapa(Integer idAtencion, Integer idMascota){
		atencionRealizada.put(idAtencion, idMascota);
		return atencionRealizada;
	}
	
}
