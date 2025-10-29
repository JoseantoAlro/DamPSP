package Amazon;

public class Pedido {
	private String nombre;
	private int numUnidades;
	private int importe;
	private int numreferencia;
	private String direccion;
	private String provincia;
	private String fecha;

	public Pedido(String nombre, int numUnidades, int importe, int numreferencia, String direccion, String provincia,
			String fecha) {
		super();
		this.nombre = nombre;
		this.numUnidades = numUnidades;
		this.importe = importe;
		this.numreferencia = numreferencia;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNumUnidades() {
		return numUnidades;
	}

	public void setNumUnidades(int numUnidades) {
		this.numUnidades = numUnidades;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public int getNumreferencia() {
		return numreferencia;
	}

	public void setNumreferencia(int numreferencia) {
		this.numreferencia = numreferencia;
	}

}
