
package dao;

/**
 * Processing Count view
 * 
 * @author DELL
 */
public interface ViewDAO {

    /**
     * Get total view
     *
     * @return
     * @throws Exception
     */
    public int getView() throws Exception;

    /**
     * change when new user view
     *
     * @throws Exception
     */
    public void updateView() throws Exception;
    
    public int getViewImage(int i) throws Exception;
    
    public void updateViewImage(int i) throws Exception;
}
