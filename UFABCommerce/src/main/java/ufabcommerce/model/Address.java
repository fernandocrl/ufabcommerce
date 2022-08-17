package ufabcommerce.model;

public class Address extends User{
	private int id;
	private int uid;
	private int cep;
	private int active;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;
	
	public Address() {}

	public Address(int id, int uid, int cep, int active, String logradouro, String bairro, String cidade, String uf) {
		super();
		this.id = id;
		this.uid = uid;
		this.cep = cep;
		this.active = active;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", uid=" + uid + ", cep=" + cep + ", active=" + active + ", logradouro="
				+ logradouro + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + "]";
	}
	
	

}