<%@page import="ufabcommerce.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% User auth = (User) request.getSession().getAttribute("auth");
	if(auth!=null){
		response.sendRedirect("index.jsp");
	}
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");	
	if(cart_list != null){
		request.setAttribute("cart_list", cart_list);
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>UFABCommerce Login</title>
<%@include file="includes/head.jsp" %>
</head>
<body>

<section class="vh-100" style="background-image:url('system-images/fachada-ufabc.jpg');background-repeat: no-repeat;background-size: cover;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-xl-10">
        <div class="card" style="border-radius: 1rem;">
          <div class="row g-0">
            <div class="col-md-6 col-lg-5 d-flex align-items-center">
              <img src="system-images/ufabc_logo.png"
                alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
            </div>
            <div class="col-md-6 col-lg-7 d-flex align-items-center">
              <div class="card-body p-4 p-lg-5 text-black">

                <form action="user-login" method="post">

                  <div class="d-flex align-items-center mb-3 pb-1">                    
                    <span class="h1 fw-bold mb-0">UFABCommerce</span>
                  </div>

                  <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Acesse sua conta</h5>

                  <div class="form-outline mb-4">
                    <input type="email" id="email" name="login-email" class="form-control form-control-lg" />
                    <label class="form-label" for="email">Email</label>
                  </div>

                  <div class="form-outline mb-4">
                    <input type="password" name="login-password" id="password" class="form-control form-control-lg" />
                    <label class="form-label" for="password">Senha</label>
                  </div>

                  <div class="pt-1 mb-4">
                    <button class="btn btn-success btn-lg btn-block" type="submit" >Login</button>
                  </div>                  
                </form>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<%@include file="includes/footer.jsp" %>
</body>
</html>