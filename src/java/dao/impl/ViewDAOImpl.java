
package dao.impl;

import context.DBContext;
import dao.ViewDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Process count views;
 *
 * @author 
 */
public class ViewDAOImpl extends DBContext implements ViewDAO{

    /**
     * Get total view
     * @author 
     * @return
     * @throws Exception
     */
    @Override
    public int getView() throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        int count = 0;
        try {
            String query = "SELECT * from [view]";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            rs = pr.executeQuery();
            if (rs.next()) {
               count = rs.getInt("viewed");
            }
            return count;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
    }

    /**
     * Fix view when have new user
     * @author 
     * @throws Exception
     */
    @Override
    public void updateView() throws Exception{
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "Update [view] set viewed = viewed + 1";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
    }
    
    @Override
    public int getViewImage(int i) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        int count = 0;
        try {
            String query = "SELECT viewimage from image where id = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, i);
            rs = pr.executeQuery();
            if (rs.next()) {
               count = rs.getInt("viewed");
            }
            return count;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
    }
    
    
    @Override
    public void updateViewImage(int i) throws Exception{
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "Update [image] set viewimage = viewimage + 1 where image.id = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, i);
            pr.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
    }
    
      
}

