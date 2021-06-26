
package dao.impl;

import context.DBContext;
import dao.GaleryDAO;
import entity.Galery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * .<br>
 *
 * <pre>
 * This class will be proceed these method below.
 *
 * </pre>
 *
 */
public class GaleryDAOImpl extends DBContext implements GaleryDAO {

    /**
     * Get top 3 gallery
     *
     * @param n
     * @return list: top 3 gallery
     * @throws Exception
     */
    @Override
    public List<Galery> getTop3Galery(int n) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Galery> listGalery = new ArrayList<>();
        try {
            String query = "SELECT top (?) * from galery";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, n);
            rs = pr.executeQuery();
            while (rs.next()) {
                Galery galery = new Galery();
                galery.setID(rs.getInt("ID"));
                galery.setTitle(rs.getString("title"));
                galery.setDescription(rs.getString("description"));
                galery.setName(rs.getString("name"));
                galery.setAvatar("avatar");
                listGalery.add(galery);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
        return listGalery;
    }

    /**
     * Get information gallery by id
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Galery getGaleryByID(int id) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * from galery where ID = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while (rs.next()) {
                Galery galery = new Galery();
                galery.setID(rs.getInt("ID"));
                galery.setTitle(rs.getString("title"));
                galery.setDescription(rs.getString("description"));
                galery.setName(rs.getString("name"));
                return galery;
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
        return null;
    }

    /**
     * Count number of gallery
     *
     * @return count
     * @throws Exception
     */
    @Override
    public int count() throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT count(*) from galery";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            rs = pr.executeQuery();
            int cout = 0;
            while (rs.next()) {
                cout = rs.getInt(1);
            }
            return cout;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
    }

    /**
     * Get list gallery with paging
     *
     * @param pageIndex <code>Integer</code>
     * @param pageSize <code>Integer</code>
     * @return list: gallery with paging
     * @throws Exception
     */
    @Override
    public List<Galery> getListGaleryWithPaging(int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Galery> list = new ArrayList<>();
        try {
            String query = "select * from ( select ROW_NUMBER() over (order by id ASC) as rn , * from  galery )"
                    + "as b where rn between ((?*?) - ?)and (?*?)";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, pageSize);
            pr.setInt(2, pageIndex);
            pr.setInt(3, pageSize - 1);
            pr.setInt(4, pageSize);
            pr.setInt(5, pageIndex);
            rs = pr.executeQuery();
            while (rs.next()) {
                Galery galery = new Galery();
                galery.setID(rs.getInt("ID"));
                galery.setTitle(rs.getString("title"));
                galery.setDescription(rs.getString("description"));
                galery.setName(rs.getString("name"));
                galery.setAvatar(rs.getString("avatar"));
                list.add(galery);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
        return list;
    }

    /**
     * Count number image of gallery
     *
     * @param id <code>Integer</code>
     * @return number image
     * @throws Exception
     */
    @Override
    public int countImage(int id) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT count(*) from image where galery_id = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            rs = pr.executeQuery();
            int cout = 0;
            while (rs.next()) {
                cout = rs.getInt(1);
            }
            return cout;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
    }
}
