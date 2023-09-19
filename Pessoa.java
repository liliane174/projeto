package imobiliaria;
import java.util.InputMismatchException;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	
	public Pessoa (String n, String cpf){
		setNome(n);
		setCpf(cpf);
	}
	
	public Pessoa() {
		
	}
	
	public Pessoa (String n, String cpf, String e, String t) {
		setNome(n);
		setCpf(cpf);
		setEndereco(e);
		setTelefone(t);
	}
	
	public String getNome() {
		return nome;
	}
	public boolean setNome(String nome) {
		if (nome.length() > 0) {
			this.nome = nome;
			return true;
		}
	else
		return false;
	}

	public String getCpf() {
		return cpf;
	}
	
	// Atribuindo o CPF válido ao objeto
	public boolean setCpf (String cpf) {
		if (VerificaCpf(cpf) == true) {
			this.cpf = cpf;
			return true;
		}
		else return false;
	}
	
	// Verifica se o CPF é válido
	public boolean VerificaCpf(String cpf) {
		String cpf_sem;
		
		cpf_sem = removeCaracteresEspeciais(cpf);
		
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (cpf_sem.equals("00000000000") || cpf_sem.equals("11111111111") || cpf_sem.equals("22222222222") || cpf_sem.equals("33333333333") || cpf_sem.equals("44444444444") || cpf_sem.equals("55555555555") || cpf_sem.equals("66666666666") || cpf_sem.equals("77777777777") || cpf_sem.equals("88888888888") || cpf_sem.equals("99999999999") || (cpf_sem.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0        
				// (48 eh a posicao de '0' na tabela ASCII)        
				num = (int) (cpf_sem.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf_sem.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == cpf_sem.charAt(9)) && (dig11 == cpf_sem.charAt(10))) {
				return true;
			}
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}
	
	// Removendo caracteres especiais do CPF
	public String removeCaracteresEspeciais(String doc) {
		if (doc.contains(".")) {
			doc = doc.replace(".", "");
		}
		if (doc.contains("-")) {
			doc = doc.replace("-", "");
		}
		if (doc.contains("/")) {
			doc = doc.replace("/", "");
		}
		return doc;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public boolean setEndereco(String endereco) {
		if (endereco.length() > 0) {
			this.endereco = endereco;
			return true;
		}
	else
		return false;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public boolean setTelefone(String telefone) {
		if (telefone.length() > 0) {
			this.telefone = telefone;
			return true;
		}
	else
		return false;
	}
	
	public abstract void mostraDadosPessoais();
	
}