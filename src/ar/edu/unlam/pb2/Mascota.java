package ar.edu.unlam.pb2;

public class Mascota implements Comparable<Mascota> {

	private String nombre;
	private String apodo;
	private TipoDeMascota tipo;
	private Integer id;


	public Mascota(Integer id, String nombre, String apodo, TipoDeMascota tipo) {
		this.id = id;
		this.nombre = nombre;
		this.apodo = apodo;
		this.tipo = tipo;
	}


	public Integer getId() {
		return id;
	}


	@Override
	public int compareTo(Mascota o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}


	public String getApodo() {
		return apodo;
	}

	public TipoDeMascota getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Mascota [nombre=" + nombre + ", apodo=" + apodo + ", tipo=" + tipo + ", id=" + id + "]";
	}


}
