
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manoj
 */
public class SaveUser extends HttpServlet {
    Connection con;PreparedStatement ps;

    /**
     *
     */
    @Override
    public void init(){
    try{
        String sql="insert into users values(?,?,?,?,?,?)";
         Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","root");
         ps=con.prepareStatement(sql);
         
     }
    catch(ClassNotFoundException | SQLException e){}
     }

    /**
     *
     */
    @Override
    public void destroy(){
    try{
        con.close();
      }catch(SQLException e){}
    }
        
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String s1=request.getParameter("userid");
        String s2=request.getParameter("password");
        String s3=request.getParameter("username");
        String s4=request.getParameter("address");
        String s5=request.getParameter("mobile");
        String s6=request.getParameter("email");
        try{    
        ps.setString(1, s1); ps.setString(2, s2);
        ps.setString(3, s3); ps.setString(4, s4);
        ps.setString(5, s5); ps.setString(6, s6);
            ps.executeUpdate();
            out.println("<h3>REGISTRATION COMPLETED</h3>");
            out.println("<h4><a href=index.jsp>Login-Now</a></h4>");
        }catch(SQLException e){
            out.println(e);
        }
         
        
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  

}
