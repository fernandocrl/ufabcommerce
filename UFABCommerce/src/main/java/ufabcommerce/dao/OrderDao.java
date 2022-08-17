package ufabcommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ufabcommerce.model.*;

public class OrderDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public OrderDao(Connection con) {
		this.con = con;
	}
	
	public boolean insertOrder(Order model) {
		boolean result = false;
		
		try {
			query = "insert into orders (p_id, u_id, a_id, o_quantity, o_date) values(?,?,?,?,?)";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, model.getId());
			pst.setInt(2, model.getUid());
			pst.setInt(3, model.getAid());
			pst.setInt(4, model.getQuantity());
			pst.setString(5, model.getDate());
			pst.executeUpdate();
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<Order> userOrders(int id){
		List<Order> list = new ArrayList<>();
		try {
			query = "select * from orders where u_id=? order by orders.o_id desc";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Order order = new Order();
				ProductDao productDao = new ProductDao(this.con);				
				int pID = rs.getInt("p_id");				
				Product product = productDao.getSingleProduct(pID);				
				order.setOrderId(rs.getInt("o_id"));
				order.setAid(rs.getInt("a_id"));
				order.setId(pID);
				order.setName(product.getName());
				order.setDescription(product.getDescription());
				order.setPrice(product.getPrice()*rs.getInt("o_quantity"));
				order.setQuantity(rs.getInt("o_quantity"));
				order.setDate(rs.getString("o_date"));
				list.add(order);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void cancelOrder(int id) {
        //boolean result = false;
        try {
            query = "delete from orders where o_id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        //return result;
    }
}
