package ufabcommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ufabcommerce.model.Address;
import ufabcommerce.model.Product;
import ufabcommerce.model.User;

public class AddressDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public AddressDao(Connection con) {
		this.con = con;
	}
	
	public Address getActiveAddress(int uid){		
		Address addr = null;
		try {	
			query = "select * from address where user_id=? and active=1";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, uid);
			rs = pst.executeQuery();
			while(rs.next()) {
				addr = new Address();
				addr.setId(rs.getInt("id"));
				addr.setUid(rs.getInt("user_id"));
				addr.setCep(rs.getInt("cep"));
				addr.setLogradouro(rs.getString("logradouro"));
				addr.setBairro(rs.getString("bairro"));
				addr.setCidade(rs.getString("cidade"));
				addr.setUf(rs.getString("uf"));
				addr.setActive(rs.getInt("active"));				
		}			
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return addr;
	}
	
	 public Address getSingleAddress(int id) {
		 Address addr = null;
	        try {
	            query = "select * from address where id=? ";

	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, id);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	            	addr = new Address();
					addr.setId(rs.getInt("id"));
					addr.setUid(rs.getInt("user_id"));
					addr.setCep(rs.getInt("cep"));
					addr.setLogradouro(rs.getString("logradouro"));
					addr.setBairro(rs.getString("bairro"));
					addr.setCidade(rs.getString("cidade"));
					addr.setUf(rs.getString("uf"));
					addr.setActive(rs.getInt("active"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return addr;
	    }
}
