
package entity;


/**
 * Create constructor image;
 *
 * @author DELL
 */
public class Image {

    private int id;
    private int galleryID;
    private String imageUrl;
    int viewimage;

    /**
     * Create constructor image no object;
     *
     */
    public Image() {
    }

    /**
     * Create constructor image
     *
     * @param id Integer
     * @param galleryId Integer
     * @param imageUrl String
     */
    public Image(int id, int galleryId, String imageUrl, int viewimage) {
        this.id = id;
        this.galleryID = galleryId;
        this.imageUrl = imageUrl;
        this.viewimage = viewimage;
    }

    /**
     * Use to get id of image
     *
     * @return id of image
     */
    public int getId() {
        return id;
    }

    /**
     * Use to set id of image
     *
     * @param id Integer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Use to get galleryID
     *
     * @return galleryID
     */
    public int getGaleryId() {
        return galleryID;
    }

    /**
     * Use to set galleryID
     *
     * @param galery_id Integer
     */
    public void setGaleryId(int galery_id) {
        this.galleryID = galery_id;
    }

    /**
     * Use to get imageUrl 
     *
     * @return gallery id
     * @throws Exception
     */
    public String getImageUrl() throws Exception {
        return  imageUrl;
    }

    /**
     * Use to set imageUrl
     *
     * @param imageUrl String
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getViewimage() {
        return viewimage;
    }

    public void setViewimage(int viewimage) {
        this.viewimage = viewimage;
    }
    
    
    
    
}
