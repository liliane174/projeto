package imobiliaria;

public class Apartamento extends Imovel {
	private int qtdQuartos;
	private int qtdSuites;
	private int qtdSalaEstar;
	private int numVaga;
	private boolean armario;
	private String descricao;
	private int andar;
	private float valorCondo;
	private boolean portaria;
	
	public Apartamento(Apartamento a) {
		super(a.getCodigo(), a.getStatus(), a.getArea(), a.getDataConstrucao(), a.getEndereco(), a.getBairro(), a.getValorSuge(), a.getValorReal(), a.getValorImob(), a.getCpfProp(), a.getDataEntrada(), a.isRetirado());
		setQtdQuartos(a.getQtdQuartos());
		setQtdSuites(a.getQtdSuites());
		setQtdSalaEstar(a.getQtdSalaEstar());
		setNumVaga(a.getNumVaga());
		setArmario(a.isArmario());
		setDescricao(a.getDescricao());
		setAndar(a.getAndar());
		setValorCondo(a.getValorCondo());
		setPortaria(a.isPortaria());
	}
	
	public Apartamento (String cod, int s, float a, String dc, String e, String b, float vs, float vr, float vi, String cp, String de, boolean ret, int qtdq, int qtdsu, 
							int qtdsala, int numvg, boolean arm, String desc, int and, float vcond, boolean port) {
		super(cod, s, a, dc, e, b, vs, vr, vi, cp, de, ret);
		setQtdQuartos(qtdq);
		setQtdSuites(qtdsu);
		setArmario(arm);
		setDescricao(desc);
		setAndar(and);
		setValorCondo(vcond);
		setPortaria(port);
	}
	
	public int getQtdQuartos() {
		return qtdQuartos;
	}
	
	public boolean setQtdQuartos(int qtdQuartos) {
		if (qtdQuartos <= 0)
			return false;
		else {
			this.qtdQuartos = qtdQuartos;
			return true;
		}
	}
	
	public int getQtdSuites() {
		return qtdSuites;
	}
	
	public boolean setQtdSuites(int qtdSuites) {
		if (qtdSuites < 0)
			return false;
		else {
			this.qtdSuites = qtdSuites;
			return true;
		}
	}
	
	public int getQtdSalaEstar() {
		return qtdSalaEstar;
	}
	
	public boolean setQtdSalaEstar(int qtdSalaEstar) {
		if (qtdSalaEstar < 0)
			return false;
		else {
			this.qtdSalaEstar = qtdSalaEstar;
			return true;
		}
	}
	
	public int getNumVaga() {
		return numVaga;
	}
	
	
	public boolean setNumVaga(int numVaga) {
		if (numVaga < 0)
			return false;
		else {
			this.numVaga = numVaga;
			return true;
		}
	}

	public boolean isArmario() {
		return armario;
	}
	
	public void setArmario(boolean armario) {
		this.armario = armario;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public boolean setDescricao(String descricao) {
		if (descricao.length() > 0) {
			this.descricao = descricao;
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getAndar() {
		return andar;
	}
	public boolean setAndar(int andar) {
	if (andar >= 0) {
		this.andar = andar;
		return true;		
	}
	else
		return false;
		
	}
	public float getValorCondo() {
		return valorCondo;
	}
	
	public boolean setValorCondo(float valorCondo) {
		if (valorCondo <= 0)
			return false;
		else {
			this.valorCondo = valorCondo;
			return true;
		}
	}
	
	public boolean isPortaria() {
		return portaria;
	}
	
	public void setPortaria(boolean portaria) {
		this.portaria = portaria;
	}
	
	public void mostrarDados() {
		super.mostrarDados();
		System.out.println("Quantidade de quartos: " + qtdQuartos);
		System.out.println("Quantidade de su�tes: " + qtdSuites);
		System.out.println("Quantidade de salas de estar: " + qtdSalaEstar);
		System.out.println("N�mero de vagas: " + numVaga);
		System.out.println("Arm�rios: " + armario);
		System.out.println("Descri��o: " + descricao);
		System.out.println("Andar: " + andar);
		System.out.println("Valor do condom�nio: " + valorCondo);
		System.out.println("Portaria: " + portaria);
	}
	
	public String toString() {
		return String.format("\nC�digo: %s\nStatus: %s\n�rea: %s\nData da constru��o: %s\nEndere�o: %s\nBairro: %s\nValor Sugerido: %s\nValor acordado: %s\nValor repassado para imobili�ria: %s\n"
				+ "CPF do Propriet�rio: %s\nIm�vel retirado: %s\nQuantidade de quartos: %s\nQuantidade de su�tes: %s\nQuantidade de salas de estar: %s\nN�mero de vagas: %s\nArm�rios: %s\nDescri��o: %s\n"
				+ "Andar: %s\nValor do condom�nio:%s\nPortaria: %s\n=========================================================\n", super.getCodigo(), super.getStatus(), super.getArea(), super.getDataConstrucao(),
				super.getEndereco(), super.getBairro(), super.getValorSuge(), super.getValorReal(), super.getValorImob(), super.getCpfProp(), super.isRetirado(), qtdQuartos, qtdSuites, qtdSalaEstar, numVaga, armario, descricao, andar, valorCondo, portaria);
	}
}
