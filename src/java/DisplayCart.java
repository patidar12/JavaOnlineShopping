

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 *
 * @author manoj
 */
public class DisplayCart extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        ArrayList list=(ArrayList)session.getAttribute("cart");
        out.println("<html>");
        out.println("<body>");
        if(list==null){
        out.println("<h3>YourCart Is Empty</h3>");
        out.println("<h4><a href=ShowCategories>Start-Buying</a></h4>");
        }
        else{
             out.println("<h3>Your Cart: </h3>");
             String s=list.toString();
            String sql="select * from products where pcode IN "+s;
            sql=sql.replace('[','(');
            sql=sql.replace(']',')');
            try{
                 Class.forName("com.mysql.jdbc.Driver"); 
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","root"); 
                 PreparedStatement ps=con.prepareStatement(sql);
                 ResultSet rs=ps.executeQuery();
                 out.println("<table border=2>");
                 out.println("<tr>");
                 out.println("<td>PCode</td>");
                 out.println("<td>Name</td>");
                 out.println("<td>Desc</td>");
                 out.println("<td>Catg</td>");
                 out.println("<td>Price</td>");
                 out.println("<td>Rem</td>");
                 out.println("</tr>");
                 int sum=0;
                 while(rs.next()){
                     String s1=rs.getString(1);
                     String s2=rs.getString(2);
                     String s3=rs.getString(3);
                     String s4=rs.getString(4);
                     String s5=rs.getString(5);
                     sum=sum+Integer.parseInt(s5);
                     out.println("<tr>");
                     out.println("<td>"+s1+"</td>");
                     out.println("<td>"+s2+"</td>");
                     out.println("<td>"+s3+"</td>");
                     out.println("<td>"+s4+"</td>");
                     out.println("<td align=right>"+s5+"</td>");
                     out.println("<td align=center><a href=RemoveItem?id="+s1+">[X]</a></td>");
                     out.println("</tr>");
                 }
                    out.println("<tr>");
                    out.println("<td></td><td></td><td></td>");
                    out.println("<td>Total</td>");
                    out.println("<td>"+sum+"</td>");
                    out.println("</tr>");
                 out.println("</table>");
                 
            
            }catch(Exception e){out.println(e);}
            
        }
        out.println("<hr>");
        out.println("<a href=BuyerHome.jsp>Home</a><br>");
        out.println("<a href=ShowCategories>Buy-More</a>");
        out.println("</body>");
        out.println("</html>");
          
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
