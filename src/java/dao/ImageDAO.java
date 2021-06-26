
package dao;

import entity.Image;
import java.util.List;

/**
 * Processing and retrieving the information Image
 *
 * @author DELL
 */
public interface ImageDAO {
    /**
     * Get Image by GaleryID
     * @param id  <code>Integer</code>
     * @return
     * @throws Exception 
     */
     public List<Image> getImageByGaleryID(int id) throws Exception;

    /**
     * Get list gallery with paging
     *
     * @param galeryID <code>Integer</code>
     * @param pageIndex <code>Integer</code>
     * @param pageSize <code>Integer</code>
     * @return list: image with paging
     * @throws Exception
     */
    public List<Image> getListImageWithPaging(int galeryID, int pageIndex, int pageSize) throws Exception;

    /**
     * Get image by id
     *
     * @param id <code>Integer</code>
     * @param galeryId <code>Integer</code>
     * @return image by id
     * @throws Exception
     */
    public Image getImageID(int id, int galeryId) throws Exception;

    /**
     * Get top 1 image of gallery
     *
     * @param galeryID <code>Integer</code>
     * @return top 1 image gallery
     * @throws Exception
     */
    public Image getTop1ImageGalery(int galeryID) throws Exception;
}


