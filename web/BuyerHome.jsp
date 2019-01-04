<%@taglib uri="/WEB-INF/tlds/mylib.tld" prefix="trial"%>
<%@include file="Info.jsp" %>
<%
   String name=(String)session.getAttribute("unm");
   if(name==null){
       response.sendRedirect("index.jsp");
   }
   
     int n=session.getMaxInactiveInterval();

%>
<html>
    <head>
       
        <title>Buyer-Home</title>
    </head>
    <body>
        <trial:welcome city="Banaras" store="Janata Garez"/>
        <h2>Welcome <%=name%></h2>
        <h3>If you remain idle for <%=n%> seconds your session will expire</h3>
        <hr>
        <a href="ShowCategories">Explore-Store</a><br>
        <a href="Search.jsp">Search-Product</a><br>
        <a href="DisplayCart">View-Cart</a><br>
        <a href="">Confirm-Order</a><br>
        <a href="">Logout</a>
        <hr>
    </body>
</html>
