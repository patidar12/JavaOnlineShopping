
package mypkg;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.sql.*;

/**
 *
 * @author manoj
 */
public class ShowHandeler extends SimpleTagSupport {
       private String code="111";

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }
       
    /**
     *
     * @throws JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
             String sql="select * from products where pcode="+code;
             Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","MANOJpatidar");
             PreparedStatement ps=con.prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             rs.next();
             String s1=rs.getString(1);
             String s2=rs.getString(2);
             String s3=rs.getString(3);
             String s4=rs.getString(4);
             String s5=rs.getString(5);
             out.println("<hr>");
             out.println(s1+"<br>");
             out.println(s2+"<br>");
             out.println(s3+"<br>");
             out.println(s4+"<br>");
             out.println(s5+"<br>");
             out.println("<hr>");
        }catch(Exception e) {
           
        }
    }
    
}
