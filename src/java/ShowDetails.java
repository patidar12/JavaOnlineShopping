

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author manoj
 */
public class ShowDetails extends HttpServlet {

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
        String s=request.getParameter("code");
        try{
            String sql="select * from products where pcode=?";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(s));
            ResultSet rs=ps.executeQuery();
            out.println("<html>");
            out.println("<body>");
            out.println("<hr>");
             rs.next();
             String id=rs.getString(1);
             String nm=rs.getString(2);
             String ds=rs.getString(3);
             String ct=rs.getString(4);
             String pr=rs.getString(5);
             out.println("<table border=2>");
             out.println("<tr>");
             out.println("<td>pcode</td>");
             out.println("<td>"+id+"</td>");
             out.println("</tr>");
             out.println("<tr>");
             out.println("<td>pname</td>");
             out.println("<td>"+nm+"</td>");
             out.println("</tr>");
             out.println("<tr>");
             out.println("<td>desc</td>");
             out.println("<td>"+ds+"</td>");
             out.println("</tr>");
             out.println("<tr>");
             out.println("<td>catg</td>");
             out.println("<td>"+ct+"</td>");
             out.println("</tr>");
             out.println("<tr>");
             out.println("<td>price</td>");
             out.println("<td>"+pr+"</td>");
             out.println("</tr>");
             out.println("</table>");
             out.println("<hr>");
             out.println("<a href=CartManager?code="+id+">ADD-TO-Cart</a><br>");
             out.println("<a href=BuyerHome.jsp>Home</a><br>");
             out.println("<a href=ShowCategories>Category-Page</a><br>");
             out.println("</body>");
             out.println("</html>");
        
        }catch(Exception e){ out.println(e);}
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
