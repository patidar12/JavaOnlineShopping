
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author manoj
 */
public class ShowCategories extends HttpServlet {
    Connection con;PreparedStatement ps;ResultSet rs;

    /**
     *
     */
    public void init(){
        try{
        String sql="select distinct category from products order by category";
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","root");
        ps=con.prepareStatement(sql);
       
    }catch(Exception e){}
        
 }

    /**
     *
     */
    public void destroye(){
       try{
          con.close();
       }catch(Exception e){}
    }
    
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
        int n=0;
        PrintWriter out = response.getWriter();
         HttpSession session=request.getSession();
        String name=(String)session.getAttribute("unm");
        if(name==null){
            response.sendRedirect("index.jsp");
        }
        ArrayList list=(ArrayList)session.getAttribute("cart");
        if(list!=null){
           n=list.size();
        }
         
        try{
        rs=ps.executeQuery();
        out.println("<html>");
        out.println("<body>");
        out.println("<h2>Welcome "+name+"</h2>");
        out.println("<h4>Total products in Cart: "+n+"</h4>");
        out.println("<h3>Select Desired Category</h3>");
        out.println("<hr>");
        out.println("<html>");
         while(rs.next()){
             String s=rs.getString(1);
             out.println("<a href=ShowItems?cat="+s+">");
              out.println(s);
              out.println("</a>");
              out.println("<br>");
         }
              out.println("<hr>");
              out.println("</body>");
              out.println("</html>");
         
   
        }catch(Exception e){out.println(e);} 
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
