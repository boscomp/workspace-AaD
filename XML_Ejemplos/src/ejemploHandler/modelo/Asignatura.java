package ejemploHandler.modelo;

public class Asignatura {


		private Integer id;
		private String nombre;
		private String ciclo;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getCiclo() {
			return ciclo;
		}
		public void setCiclo(String ciclo) {
			this.ciclo = ciclo;
		}
		@Override
		public String toString() {
			return "Asignatura [id=" + id + ", nombre=" + nombre + ", ciclo=" + ciclo + "]";
		}
		
		public String toCsv() {
			return id + ";" + nombre + ";" + ciclo;
		}
		
		
		
		
		
	}