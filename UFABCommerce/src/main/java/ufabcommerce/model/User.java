package ufabcommerce.model;

//import java.util.Date;

public class User {
	private int id;
	private String name;
	private String data_nasc;
	private int cpf;
	private String email;
	private String password;
	
	
	public User() {

	}


	public User(int id, String name, String data_nasc, int cpf, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.data_nasc = data_nasc;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getData_nasc() {
		return data_nasc;
	}


	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}


	public int getCpf() {
		return cpf;
	}


	public void setCpf(int cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", data_nasc=" + data_nasc + ", cpf=" + cpf + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
}
