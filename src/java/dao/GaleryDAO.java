
package dao;

import entity.Galery;
import java.util.List;

/**
 * Processing and retrieving the information Gallery
 *
 * @author DELL
 */
public interface GaleryDAO {

    /**
     * Get top 3 gallery
     *
     * @param n <code>Integer</code>
     * @return list: top 3 gallery
     * @throws Exception
     */
    public List<Galery> getTop3Galery(int n) throws Exception;

    /**
     * Get gallery by id
     *
     * @param id <code>Integer</code>
     * @return gallery
     * @throws Exception
     */
    public Galery getGaleryByID(int id) throws Exception;

    /**
     * Count number of gallery
     *
     * @return count
     * @throws Exception
     */
    public int count() throws Exception;

    /**
     * Get list gallery with paging
     *
     * @param pageIndex <code>Integer</code>
     * @param pageSize <code>Integer</code>
     * @return list: gallery with paging
     * @throws Exception
     */
    public List<Galery> getListGaleryWithPaging(int pageIndex, int pageSize) throws Exception;

    /**
     * Count number image of gallery
     *
     * @param id <code>Integer</code>
     * @return number image
     * @throws Exception
     */
    public int countImage(int id) throws Exception;

}
