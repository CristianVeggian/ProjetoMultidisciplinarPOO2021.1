package proj;

public class Medico extends Usuario {

	private int CRM;
	private String clinica;
	
	public Medico(String nome, String senha) {
		super(nome, senha);
	}
	
	public Medico(String nome, String senha, int CRM, String clinica) {
		super(nome, senha);
		this.CRM = CRM;
		this.clinica = clinica;
	}

	public int getCRM() {
		return CRM;
	}

	public void setCRM(int cRM) {
		CRM = cRM;
	}

	public String getClinica() {
		return clinica;
	}

	public void setClinica(String clinica) {
		this.clinica = clinica;
	}
	
	public String toString() {
		return "Dr. " + this.nome + " - " + this.clinica + " CRM: " + Integer.toString(this.CRM);
	}

}
