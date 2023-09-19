package imobiliaria;

public class SalaComercial extends Imovel {
	private int qtdBanheiro;
	private int qtdComodo;
	
	public SalaComercial (SalaComercial sc) {
		super(sc.getCodigo(), sc.getStatus(), sc.getArea(), sc.getDataConstrucao(), sc.getEndereco(), sc.getBairro(), sc.getValorSuge(), sc.getValorReal(), sc.getValorImob(), sc.getCpfProp(), sc.getDataEntrada(), sc.isRetirado());
		setQtdBanheiro(sc.getQtdBanheiro());
		setQtdComodo(sc.getQtdComodo());
	}
	
	public SalaComercial (String cod, int s, float a, String dc, String e, String b, float vs, float vr, float vi, String cp, String de, boolean ret, int qtdba, int qtdco) {
		super(cod, s, a, dc, e, b, vs, vr, vi, cp, de, ret);
		setQtdBanheiro(qtdba);
		setQtdComodo(qtdco);
	}
	
	public int getQtdBanheiro() {
		return qtdBanheiro;
	}
	public boolean setQtdBanheiro(int qtdBanheiro) {
		if (qtdBanheiro < 0)
			return false;
		else {
			this.qtdBanheiro = qtdBanheiro;
			return true;
		}
	}
	
	public int getQtdComodo() {
		return qtdComodo;
	}
	
	public boolean setQtdComodo(int qtdComodo) {
		if (qtdComodo < 0)
			return false;
		else {
			this.qtdComodo = qtdComodo;
			return true;
		}
	}
	
	public void mostrarDados() {
		super.mostrarDados();
		System.out.println("Quantidade de banheiros: " + qtdBanheiro);
		System.out.println("Quantidade de comodos: " + qtdComodo);	
	}
	
	public String toString() {
		return String.format("\nCódigo: %s\nStatus: %s\nÁrea: %s\nData da construção: %s\nEndereço: %s\nBairro: %s\nValor Sugerido: %s\nValor acordado: %s\nValor repassado para imobiliária: %s\nCPF do Proprietário: %s\nImóvel retirado: %s\nQuantidade de banheiros: %s\nQuantidade de comôdos: %s\n=========================================================\n",
				super.getCodigo(), super.getStatus(), super.getArea(), super.getDataConstrucao(), super.getEndereco(), super.getBairro(), super.getValorSuge(), super.getValorReal(), super.getValorImob(), super.getCpfProp(), super.isRetirado(), qtdBanheiro, qtdComodo);
	}

}
