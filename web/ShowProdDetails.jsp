<%@include file="Info.jsp"%>
<%!
      int getGst(int price){
          int gst=0;
          if(price>=10000){
            gst=price*10/100;
          }else{
            gst=price*5/100;
          }
           return gst;
      }
%>
<%
     String id=request.getParameter("t1");
     String sql="Select * from products where pcode=?";
     Class.forName("com.mysql.jdbc.Driver");
     java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","root");
     java.sql.PreparedStatement ps=con.prepareStatement(sql);
     ps.setInt(1,Integer.parseInt(id));
     java.sql.ResultSet rs=ps.executeQuery();
     rs.next();
     String s1=rs.getString(1);
     String s2=rs.getString(2);
     String s3=rs.getString(3);
     String s4=rs.getString(4);
     String s5=rs.getString(5);

%>
<html>
    <head>
        <title>Show-Details</title>
    </head>
    <body>
        <h2>Product-Details</h2>
        <hr>
        <table border="2">
           <tbody>
                <tr>
                    <td>Code</td>
                    <td><%=s1%></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><%=s2%></td>
                </tr>
                <tr>
                    <td>Desc</td>
                    <td><%=s3%></td>
                </tr>
                <tr>
                    <td>Catg</td>
                    <td><%=s4%></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><%=s5%></td>
                </tr>
                <tr>
                    <td>GST</td>   
                    <td><%=getGst(Integer.parseInt(s5))%></td>
                 
                </tr>
            </tbody>
        </table>
         <hr>
         <a href="BuyerHome.jsp">Home</a>
       
    </body>
</html>
<%
   con.close();
%>