package imobiliaria;

public class Terreno extends Imovel {
	private float largura;
	private float comprimento;
	private int acliveDeclive;
	
	public Terreno(Terreno t) {
		super(t.getCodigo(), t.getStatus(), t.getArea(), t.getDataConstrucao(), t.getEndereco(), t.getBairro(), t.getValorSuge(), t.getValorReal(), t.getValorImob(), t.getCpfProp(), t.getDataEntrada(), t.isRetirado());
		setLargura(t.getLargura());
		setComprimento(t.getComprimento());
		setAcliveDeclive(t.getAcliveDeclive());
	}
	
	public Terreno (String cod, int s, float a, String dc, String e, String b, float vs, float vr, float vi, String cp, String de, boolean ret, float l, float c, int ad) {
		super(cod, s, a, dc, e, b, vs, vr, vi, cp, de, ret);
		setLargura(l);
		setComprimento(c);
		setAcliveDeclive(ad);
	}
	
	public float getLargura() {
		return largura;
	}
	
	public boolean setLargura(float largura) {
		if (largura < 0)
			return false;
		else {
			this.largura = largura;
			return true;
		}
	}
	
	public float getComprimento() {
		return comprimento;
	}
	
	public boolean setComprimento(float comprimento) {
		if (comprimento < 0)
			return false;
		else {
			this.comprimento = comprimento;
			return true;
		}
	}
	
	public int getAcliveDeclive() {
		return acliveDeclive;
	}
	
	// Legenda: 0 = Tem aclive	1 = Tem declive
	public boolean setAcliveDeclive(int acliveDeclive) {
		if ((acliveDeclive != 0) || (acliveDeclive != 1))
			return false;
		else {
			this.acliveDeclive = acliveDeclive;
			return true;
		}
	}
	
	public void mostrarDados() {
		super.mostrarDados();
		System.out.println("Largura: " + largura);
		System.out.println("Comprimento: " + comprimento);
		System.out.println("Aclive ou declive: " + acliveDeclive);
	}
	
	public String toString() {
		return String.format("\nCódigo: %s\nStatus: %s\nÁrea: %s\nData da construção: %s\nEndereço: %s\nBairro: %s\nValor Sugerido: %s\nValor acordado: %s\nValor repassado para imobiliária: %s\nCPF do Proprietário: %s\nImóvel retirado: %s\nLargura: %s\nComprimento: %s\nAclive ou declive: %s\n=========================================================\n",
				super.getCodigo(), super.getStatus(), super.getArea(), super.getDataConstrucao(), super.getEndereco(), super.getBairro(), super.getValorSuge(), super.getValorReal(), super.getValorImob(), super.getCpfProp(), super.isRetirado(), largura, comprimento, acliveDeclive);
	}
	
}
