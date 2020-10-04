package loveletter;

public class Baron extends Carta {

	public Baron() {
		this.fuerza = 3;
		this.nombre = "Baron";
	}
	@Override
	public Carta efecto() {
		
		return this;
		
	}
}
