
package entity;

/**
 * create object contact;
 *
 *  @author DELL
 */
public class Contact {

    private String telephone;
    private String email;
    private String faceUrl;
    private String twitterUrl;
    private String googleUrl;
    private String about;
    private String address;
    private String city;
    private String country;
    private String mapUrl;
    private String imageMain;
    private String iconFace;
    private String iconTwitter;
    private String iconGoogle;

    /**
     * create constructors no object;
     *
     */
    public Contact() {
    }
    /**
     * Create constructor have object
     * @param telephone
     * @param email
     * @param faceUrl
     * @param twitterUrl
     * @param googleUrl
     * @param about
     * @param address
     * @param city
     * @param country
     * @param mapUrl
     * @param imageMain
     * @param iconFace
     * @param iconTwitter
     * @param iconGoogle 
     */

    public Contact(String telephone, String email, String faceUrl, String twitterUrl, String googleUrl, String about, String address, String city, String country, String mapUrl, String imageMain, String iconFace, String iconTwitter, String iconGoogle) {
        this.telephone = telephone;
        this.email = email;
        this.faceUrl = faceUrl;
        this.twitterUrl = twitterUrl;
        this.googleUrl = googleUrl;
        this.about = about;
        this.address = address;
        this.city = city;
        this.country = country;
        this.mapUrl = mapUrl;
        this.imageMain = imageMain;
        this.iconFace = iconFace;
        this.iconTwitter = iconTwitter;
        this.iconGoogle = iconGoogle;
    }
    

    /**
     * Get icon face
     * @author 
     * @return icon 
     * @throws Exception
     */
    public String getIconFace() throws Exception {
        return iconFace;
    }

    /**
     * Use to set icon face
     * @author 
     * @param iconFace String
     */
    public void setIconFace(String iconFace) {
        this.iconFace = iconFace;
    }

    /**
     *  Use to get icon twitter
     * @author 
     * @return icon twitter
     * @throws Exception
     */
    public String getIconTwitter() throws Exception {
        return iconTwitter;
    }

    /**
     * Use to set icon twitter
     * @author 
     * @param iconTwitter String
     */
    public void setIconTwitter(String iconTwitter) {
        
        this.iconTwitter = iconTwitter;
    }

    /**
     * Use to get icon web;
     * @author 
     * @return icon web;
     * @throws Exception
     */
    public String getIconGoogle() throws Exception {
        return iconGoogle;
    }

    /**
     * Use to set icon web;
     * @author 
     * @param iconGoogle String
     */
    public void setIconGoogle(String iconGoogle) {
        this.iconGoogle = iconGoogle;
    }

    /**
     * Use to get image main
     * @author 
     * @return image main
     * @throws Exception
     */
    public String getImageMain() throws Exception {
        return  imageMain;
    }

    /**
     * Use to set image main
     * @author 
     * @param imageMain String
     */
    public void setImageMain(String imageMain) {
        this.imageMain = imageMain;
    }

    /**
     * Use to get telephone
     * @author 
     * @return telephone number
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Use to set telephone
     * @author 
     * @param telephone String
     */ 
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Use to get email
     * @author 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Use to set email
     * @author
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Use to get link face
     * @author 
     * @return link face
     */
    public String getFaceUrl() {
        return faceUrl;
    }

    /**
     * Use to set link face
     * @author 
     * @param faceUrl String
     */
    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    /**
     * Use to get link twitter
     * @author 
     * @return link twitter
     */
    public String getTwitterUrl() {
        return twitterUrl;
    }

    /**
     * Use to set link twitter
     * @author 
     * @param twitterUrl String
     */
    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    /**
     * Use to get link web;
     * @author 
     * @return link web;
     */
    public String getGoogleUrl() {
        return googleUrl;
    }

    /**
     * Use to set link web
     * @author 
     * @param googleUrl String
     */
    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }

    /**
     * Use to get about
     * @author 
     * @return  about
     */
    public String getAbout() {
        return about;
    }

    /**
     * Set about
     * @author 
     * @param about String
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * Use to get address
     * @author 
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Use to set address
     *  @author 
     * @param address String
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get city
     * @author 
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set city
     * @author 
     * @param city String
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get country
     * @author 
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set country
     * @author 
     * @param country String
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get map link
     * @author 
     * @return map link
     */
    public String getMapUrl() {
        return mapUrl;
    }

    /**
     * Set map link
     * @author
     * @param mapUrl String
     */
    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

}
