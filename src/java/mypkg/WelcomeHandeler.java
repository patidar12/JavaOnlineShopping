
package mypkg;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author manoj
 */
public class WelcomeHandeler extends SimpleTagSupport {

    private String store="XYZ Store";
    private String city="Indore";

    /**
     *
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        
       

        out.println("<h2>Welcome to "+store+" In "+city+"</h2>");
       out.println("<h3>Best Store In India</h3>");
    }

    /**
     *
     * @return
     */
    public String getStore() {
        return store;
    }

    /**
     *
     * @param store
     */
    public void setStore(String store) {
        this.store = store;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }
    
}
