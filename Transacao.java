package imobiliaria;

public class Transacao {
	private Imovel prop;
	private ClienteUsuario cliente;
	private Corretor funcCorretor;
	private String data;
	private String nrocontrato;
	private String formapgto;
	
	public Transacao(Imovel i, ClienteUsuario uc, String dt) {
		setProp(i);
		setCliente(uc);
		setData(dt);
	}
	
	
	public Transacao(Imovel i, ClienteUsuario uc, Corretor co, String dt, String nro, String pgto) {
		setProp(i);
		setCliente(uc);
		setFuncCorretor(co);
		setData(dt);
		setNrocontrato(nro);
		setFormapgto(pgto);
	}

	public ClienteUsuario getCliente() {
		return cliente;
	}
	
	public void setCliente(ClienteUsuario cliente) {
		this.cliente = cliente;
	}
	
	public Corretor getFunccorretor() {
		return funcCorretor;
	}
	
	public void setFuncCorretor(Corretor funccorretor) {
		this.funcCorretor = funccorretor;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getNrocontrato() {
		return nrocontrato;
	}
	
	public void setNrocontrato(String nrocontrato) {
		this.nrocontrato = nrocontrato;
	}
	
	public String getFormapgto() {
		return formapgto;
	}
	
	public void setFormapgto(String formapgto) {
		this.formapgto = formapgto;
	}
	
	public Imovel getProp() {
		return prop;
	}
	
	public void setProp(Imovel prop) {
		this.prop = prop;
	}
	
	// Atribuir venda ao corretor
	public void atributirVenda() {
		funcCorretor.ComissaoTotal(prop.getValorReal());
		funcCorretor.numVendas();
	}

}
