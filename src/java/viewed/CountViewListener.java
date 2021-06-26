
package viewed;

import dao.ViewDAO;
import dao.impl.ViewDAOImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application view listener.
 *
 * @author DELL
 */
public class CountViewListener implements HttpSessionListener {

    /**
     * Count total view, and update view.
     *
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        try {
            ViewDAO dao = new ViewDAOImpl();
            int sessionCount = dao.getView();
            ServletContext ctx;
            dao.updateView();
            //format 6 number of viewed
            String format = String.format("%06d", sessionCount);
            StringBuffer stringBuffer = new StringBuffer(format);
		String result =  stringBuffer.reverse().toString();
		
            //set ctx
            ctx = se.getSession().getServletContext();
            //set attribute for count view
            ctx.setAttribute("totalView", result);

        } catch (Exception ex) {
            Logger.getLogger(CountViewListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
