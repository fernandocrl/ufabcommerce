<%@page import="java.util.*"%>
<%@page import="ufabcommerce.dao.ProductDao"%>
<%@page import="ufabcommerce.connection.DbCon"%>
<%@page import="ufabcommerce.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% User auth = (User) request.getSession().getAttribute("auth");
	if(auth!=null){
		request.setAttribute("auth", auth);
	}
	
	ProductDao pd = new ProductDao(DbCon.getConnection());
	List<Product> products = pd.getAllProducts();
	
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");	
	if(cart_list != null){
		request.setAttribute("cart_list", cart_list);
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>UFABCommerce</title>
<%@include file="includes/head.jsp" %>
</head>
<body>
	<%@include file="includes/navbar.jsp" %>
	
	<div class ="container">
		<div class="card-header my-3">Todos Produtos</div>
		<div class="row row-cols-3 row-cols-md-3 g-4">
		<% 
			if( !products.isEmpty()){
				for(Product p:products){ %>
				
					<div class="col">
						<div class="card h-100 border-success mb-3">
						  <img src="product-images/<%=p.getImage()%>" class="card-img-top" alt="..." >
						  <div class="card-body text-success">
						    <h5 class="card-title"><%=p.getName()%></h5>						    
						    <h6 class="description"><%=p.getDescription()%></h6>
						    <h6 class="price">Preço: R$ <%=p.getPrice()%></h6>
						   </div>
						   <div class="card-footer mt-3 d-flex">
						   	<a href="add-to-cart?id=<%=p.getId()%>" class="btn btn-outline-dark m-1">Carrinho</a>
						    <a href="order-now?quantity=1&id=<%= p.getId() %>" class="btn btn-outline-success m-1">Comprar</a>
						   </div>						  
						</div>
					</div>
				<%	
				}
			}
		%>

		</div>
	</div>
	
	<%@include file="includes/footer.jsp" %>
</body>
</html>