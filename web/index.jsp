<%@taglib uri="/WEB-INF/tlds/mylib.tld" prefix="own"%>
<%@include file="Info.jsp"%>
<%
    Cookie c[]=request.getCookies();
    String v1="",v2="";
    if(c!=null){
    for(int i=0;i<c.length;i++){
        String name=c[i].getName();
        if(name.equals("id")){
             v1=c[i].getValue();
        }
         else if(name.equals("pwd")){
          v2=c[i].getValue();
         }
    }
  }

%>



<html>
    <head>
        <title>E-Shop_Log-In</title>
    </head>
    <body>
       <h2>Online Shop</h2>
        <own:welcome city="Susner" store="Tejra Store"/>
        <form action="VerifyUser">
           <table border=2>
             <tr>
                 <td> Userid</td><td><input type="text" name="userid" value="<%=v1%>"/> </td>
             </tr>
             <tr>
                 <td> Password</td><td><input type="password" name="password" value="<%=v2%>"/></td>
             </tr>
             <tr>
            <td>UserType</td><td><select name="usertype"><option>buyer</option><option>admin</option></select></td>
            <tr>
           <td> Save Pwd</td><td> <input type="checkbox" name="save"/></td>
           </tr>
           <tr>
           <td></td><td> <input type="submit" value="Login"/></td>
           </tr>
           </table>
            
         </form>
            <a href="registration.jsp">New-User</a>
                
    </body>
</html>
<%@include file="Footer.jsp"%>