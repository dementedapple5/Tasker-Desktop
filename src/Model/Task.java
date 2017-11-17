package Model;

public class Task {

	private String id;
	private String titulo;
	private String fecha;
	private String encargado;
	private String coments;
	private String prioridad;
	private String contenido;
	private String estado;
	private String visible;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Task() {
	}

	/**
	 *
	 * @param id
	 * @param titulo
	 * @param estado
	 * @param visible
	 * @param fecha
	 * @param contenido
	 * @param prioridad
	 * @param coments
	 * @param encargado
	 */
	public Task(String id, String titulo, String fecha, String encargado, String coments, String prioridad,
			String contenido, String estado, String visible) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fecha = fecha;
		this.encargado = encargado;
		this.coments = coments;
		this.prioridad = prioridad;
		this.contenido = contenido;
		this.estado = estado;
		this.visible = visible;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public String getComents() {
		return coments;
	}

	public void setComents(String coments) {
		this.coments = coments;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}
	
	@Override
	public String toString(){
		
		 return "Task{" +
	                "title='" + titulo + '\'' +
	                ", attendant='" + encargado + '\'' +
	                ", comment='" + coments + '\'' +
	                ", description='" + contenido + '\'' +
	                ", priority=" + prioridad +
	                ", creationDate='" + fecha + '\'' +
	                ", state=" + estado +
	                '}';
		 } 
	
}
