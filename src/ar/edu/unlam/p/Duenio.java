package ar.edu.unlam.p;

import java.awt.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Duenio implements Comparable<Duenio> {

	private Integer dni;
	private String nombre;
	private Set<Mascota> mascotas;

	public Duenio(Integer dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
		this.mascotas = new TreeSet<>();
	}

	public void agregarMascota(Mascota m) throws MascotaDuplicadaException {
		for (Mascota mascota : mascotas) {
			if (mascota.getId().equals(m.getId())) {
				throw new MascotaDuplicadaException("Mascota duplicada");
			}
		}
		this.mascotas.add(m);

	}

	public Integer cantidadDeMascotasPorDuenio() {

		return this.mascotas.size();
	}

	public Integer getDni() {
		return dni;
	}

	@Override
	public int compareTo(Duenio o) {
		// TODO Auto-generated method stub
		return this.dni.compareTo(o.getDni());
	}

	public TreeSet<Mascota> ordenarMascotaPorApodo() {
		TreeSet<Mascota> mascotasOrdenadasPorApodo = new TreeSet<>(new OrdenarPorApodo());
		for (Mascota mascota : mascotas) {
			if (mascota.getTipo().equals(TipoDeMascota.domestica)) {
				mascotasOrdenadasPorApodo.add(mascota);
			}
		}
		return mascotasOrdenadasPorApodo;

	}


}
