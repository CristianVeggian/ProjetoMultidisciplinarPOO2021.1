package proj;

public class Usuario implements ILogin{
	
	private int id;
	private static int count = 0;

	protected String nome;
	protected String senha;
	protected boolean logado;
	
	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
		count = count + 1;
		this.id = count;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}
	
	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public boolean logar(String nome, String senha) {
		try{
			if(!this.nome.equals(nome)) throw new ExceptionLogin("Usuário incorreto!");
			if(!this.senha.equals(senha)) throw new ExceptionLogin("Senha incorreta!");
			return true;
		}catch(ExceptionLogin e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Usuario registrar(String nome, String senha) {
		return new Usuario(nome, senha);
	}
	
}
