package proj;

public class Paciente extends Usuario {
	
	private static int reg_count;
	
	private int registro;
	private char tipo_deficiencia;
	

	public Paciente(String nome, String senha) {
		super(nome, senha);
		reg_count = reg_count + 1;
		this.registro = reg_count;
	}

	public Paciente(String nome, String senha, char tipo_deficiencia) {
		super(nome, senha);
		reg_count = reg_count + 1;
		this.registro = reg_count;
		this.setTipo_deficiencia(tipo_deficiencia);
	}
	
	public int getRegistro() {
		return registro;
	}

	public char getTipo_deficiencia() {
		return tipo_deficiencia;
	}

	public void setTipo_deficiencia(char tipo_deficiencia) {
		this.tipo_deficiencia = tipo_deficiencia;
	}

	public String toString() {
		if(this.tipo_deficiencia == 'D')
			return Integer.toString(this.registro) + '.' + this.nome + " Diagnóstico: Deuteranopia";
		else if(this.tipo_deficiencia == 'T')
			return Integer.toString(this.registro) + '.' + this.nome + " Diagnóstico: Tritanopia";
		else 
			return Integer.toString(this.registro) + '.' + this.nome + " Diagnóstico: Protanopia";
	}
	
}
