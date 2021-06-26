
package dao.impl;

import context.DBContext;
import dao.ImageDAO;
import entity.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *.<br>
 *
 * <pre>
 * This class will be proceed these method below.
 *
 * </pre>
 *
 */
public class ImageDAOImpl extends DBContext implements ImageDAO {

    /**
     * Get image gallery by id
     *
     * @param id <code>Integer</code>
     * @return image by id
     * @throws Exception
     */
    @Override
    public List<Image> getImageByGaleryID(int id) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Image> list = new ArrayList<>();
        try {
            String query = "select ROW_NUMBER() over (order by id ASC) as rn, * from image where galery_id = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt(1));
                image.setGaleryId(rs.getInt(3));
                image.setImageUrl(rs.getString(4));
                image.setViewimage(rs.getInt(5));
                list.add(image);
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
     * Get list gallery with paging
     *
     * @param galeryID <code>Integer</code>
     * @param pageIndex <code>Integer</code>
     * @param pageSize <code>Integer</code>
     * @return list: image with paging
     * @throws Exception
     */
    @Override
    public List<Image> getListImageWithPaging(int galeryID, int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Image> list = new ArrayList<>();
        try {
            String query = "select * from ( select ROW_NUMBER() over (order by id ASC) as rn , * from  image where galery_id = ?) "
                    + "as b where rn between ((?*?) - ?)and (?*?)";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, galeryID);
            pr.setInt(2, pageSize);
            pr.setInt(3, pageIndex);
            pr.setInt(4, pageSize - 1);
            pr.setInt(5, pageSize);
            pr.setInt(6, pageIndex);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGaleryId(rs.getInt("galery_id"));
                image.setImageUrl(rs.getString("image_url"));
                image.setViewimage(rs.getInt("viewimage"));
                list.add(image);
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
     * Get image by id
     *
     * @param id <code>Integer</code>
     * @param galeryId <code>Integer</code>
     * @return image by id
     * @throws Exception
     */
    @Override
    public Image getImageID(int id, int galeryId) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * from image where id = ? and galery_id = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            pr.setInt(2, galeryId);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGaleryId(rs.getInt("galery_id"));
                image.setImageUrl(rs.getString("image_url"));
                image.setViewimage(rs.getInt("viewimage"));
                return image;
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
     * Get top 1 image of gallery
     *
     * @param galeryID <code>Integer</code>
     * @return top 1 image gallery
     * @throws Exception
     */
    @Override
    public Image getTop1ImageGalery(int galeryID) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT top 1 * from image where galery_id = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, galeryID);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGaleryId(rs.getInt("galery_id"));
                image.setImageUrl(rs.getString("image_url"));
                image.setViewimage(rs.getInt("viewimage"));
                return image;
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
}
