<nav class="navbar navbar-expand-lg navbar-dark bg-success">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">
    	<img src="system-images/ufabc.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
    	UFABCommerce</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Inicio</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="cart.jsp">Carrinho <span class="badge bg-danger px-2">${cart_list.size()}</span></a>
        </li>
        <% 
        if(auth != null){%> 
			<li class="nav-item">
            	<a class="nav-link" href="orders.jsp">Pedidos</a>
          	</li>
          	<li class="nav-item">
            	<a class="nav-link" href="Logout">Logout</a>
          	</li> 
        <%}
        else{%>
			<li class="nav-item">
            	<a class="nav-link" href="login.jsp">Login</a>
          	</li>
          	<%
        } %>                    
      </ul>      
    </div>
  </div>
</nav>