<%@page import="ufabcommerce.dao.OrderDao"%>
<%@page import="ufabcommerce.dao.ProductDao"%>
<%@page import="ufabcommerce.dao.AddressDao"%>
<%@page import="ufabcommerce.connection.DbCon"%>
<%@page import="ufabcommerce.model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
	DecimalFormat dcf = new DecimalFormat("#.##");
	request.setAttribute("dcf", dcf);
	User auth = (User) request.getSession().getAttribute("auth");
	List<Order> orders = null;
	AddressDao addrDao = null;
	if(auth!=null){
		request.setAttribute("auth", auth);	 
		 orders = new OrderDao(DbCon.getConnection()).userOrders(auth.getId());
		 addrDao = new AddressDao(DbCon.getConnection());
	}else{
		//response.sendRedirect("login.jsp");
	}
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");	
	if(cart_list != null){
		request.setAttribute("cart_list", cart_list);
	}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>UFABCommerce - Pedido</title>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>
	<div class="container">
		<div class="card-header my-3">Todos os pedidos</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Data</th>
					<th scope="col">Nome</th>
					<th scope="col">Descrição</th>
					<th scope="col">Quantidade</th>
					<th scope="col">Preço</th>
					<th scope="col">Endereço</th>
					<th scope="col">Ação</th>
				</tr>
			</thead>
			<tbody>
			
			<%
			if(orders != null){
				for(Order o:orders){
				Address addr = addrDao.getSingleAddress(o.getAid());
				%>
					<tr>
						<td><%=o.getDate() %></td>
						<td><%=o.getName() %></td>
						<td><%=o.getDescription() %></td>
						<td><%=o.getQuantity() %></td>
						<td>R$<%=dcf.format(o.getPrice()) %></td>
						<td><%=addr.getLogradouro()%></td>
						<td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%=o.getOrderId()%>">Cancelar Pedido</a></td>
					</tr>
				<%}
			}
			%>
			
			</tbody>
		</table>
	</div>
	<%@include file="/includes/footer.jsp"%>
</body>
</html>