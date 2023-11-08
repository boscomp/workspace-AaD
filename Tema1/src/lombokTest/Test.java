package lombokTest;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		Betis b = new Betis();
		b.setDorsal(17);
		b.setNombre("Rodri");
		b.setPosicion("Medio");
		b.setFechaNacimiento(LocalDate.of(2000, 7, 15));
		System.out.println(b);
	}
}
