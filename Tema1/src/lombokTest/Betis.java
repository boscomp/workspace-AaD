package lombokTest;

import java.time.LocalDate;

import lombok.Data;

public @Data class Betis {

	private Integer dorsal;
	private String nombre;
	private String posicion;
	private LocalDate fechaNacimiento;

}
