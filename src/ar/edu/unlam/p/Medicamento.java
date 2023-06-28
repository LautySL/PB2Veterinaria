package ar.edu.unlam.p;

public class Medicamento {

	private Integer id;
	private String descripcion;
	private Double precio;

	public Medicamento(Integer id, String descripcion, Double precio) {
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Double getPrecio() {
		// TODO Auto-generated method stub
		return precio;
	}
	
	

}
