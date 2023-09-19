package imobiliaria;

public class Imovel {
	private String codigo; // atributo colocado para ser usado na classe DadosImoveis
	private int status;
	private float area;
	private String dataConstrucao;
	private String endereco;
	private String bairro;
	private float valorSuge;
	private float valorReal;
	private float valorImob;
	private String cpfProp;
	private String dataEntrada;
	private boolean retirado;
	
	public Imovel (String cod, int s, float a, String dc, String e, String b, float vs, float vr, float vi, String cpfcp, String de, boolean ret) {
		setCodigo(cod);
		setStatus(s);
		setArea(a);
		setDataConstrucao(dc);
		setEndereco(e);
		setBairro(b);
		setValorSuge(vs);
		setValorReal(vr);
		setValorImob(vi);
		setCpfProp(cpfcp);
		setDataEntrada(de);
		setRetirado(ret);
	}
	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getStatus() {
		return status;
	}
	
	// Status -> 0 = Aluguel, 1 = Venda, 2 = Locado, 3 = Vendido
	public boolean setStatus(int status) {
		if ((status >= 0) && (status <= 3)) {
			this.status = status;
			return true;
		}
		return false;
	}
	
	public float getArea() {
		return area;
	}
	
	public boolean setArea(float area) {
		if (area >= 0) {
			this.area = area;
			return true;
		}
		return false;
	}
	
	public String getDataConstrucao() {
		return dataConstrucao;
	}
	
	public boolean setDataConstrucao(String dataConstrucao) {
		if (dataConstrucao.length() > 0) {
			this.dataConstrucao = dataConstrucao;
			return true;
		}
		else {
			return false;
		}
	}
		
	public String getEndereco() {
		return endereco;
	}
	
	public boolean setEndereco(String endereco) {
		if (endereco.length() > 0) {
			this.endereco = endereco;
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public boolean setBairro(String bairro) {
		if (bairro.length() > 0) {
			this.bairro = bairro;
			return true;
		}
		else {
			return false;
		}
	}
	
	public float getValorSuge() {
		return valorSuge;
	}
	
	public boolean setValorSuge(float valorSuge) {
		if (valorSuge > 0) {
			this.valorSuge = valorSuge;
			return true;
		}
		return false;
	}
	
	public float getValorReal() {
		return valorReal;
	}
		
	public boolean setValorReal(float valorReal) {
		if (valorReal > 0) {
			this.valorReal = valorReal;
			return true;
		}
		return false;
	}
	
	public float getValorImob() {
		return valorImob;
	}
	
	public boolean setValorImob(float valorImob) {
		if (valorImob > 0) {
			this.valorImob = valorImob;
			return true;
		}
		return false;
	}
	
	
	public String getCpfProp() {
		return cpfProp;
	}


	public void setCpfProp(String cpfProp) {
		this.cpfProp = cpfProp;
	}


	/* public ClienteProp getProp() {
		return prop;
	}

	public void setProp(ClienteProp prop) {
		this.prop = prop;
	}
	
	*/
	public String getDataEntrada() {
		return dataEntrada;
	}
	
	public boolean setDataEntrada(String dataEntrada) {
		if (dataEntrada.length() > 0) {
			this.dataEntrada = dataEntrada;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isRetirado() {
		return retirado;
	}
	
	public void setRetirado(boolean retirado) {
		this.retirado = retirado;
	}
	
	public void mostrarDados() {
		System.out.println("\nCódigo: " + codigo);
		System.out.println("Status: " + status);
		System.out.println("Área: " + area);
		System.out.println("Data da construção: " + dataConstrucao);
		System.out.println("Endereço: " + endereco);
		System.out.println("Bairro: " + bairro);
		System.out.println("Valor Sugerido: " + valorSuge);
		System.out.println("Valor acordado: " + valorReal);
		System.out.println("Valor repassado para imobiliária: " + valorImob);
		System.out.println("Cpf do Proprietário: " + cpfProp);
		System.out.println("Imóvel retirado: " + retirado);
	}
	
	public String toString() {
		return String.format("Código: %s\nStatus: %s\nÁrea: %s\nData da construção: %s\nEndereço: %s\nBairro: %s\nValor Sugerido: %s\nValor acordado: %s\nValor repassado para imobiliária: %sCPF do Proprietário: %s\nImóvel retirado: %s\n", codigo, status, area, dataConstrucao, endereco, bairro, valorSuge, valorReal, valorImob, cpfProp, retirado);
	}
}
	