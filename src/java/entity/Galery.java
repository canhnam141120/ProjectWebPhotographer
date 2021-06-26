
package entity;

/**
 * Create object ;
 *
 * @author DELL
 */
public class Galery {

    private int id;
    private String title;
    private String description;
    private String name;
    private String avatar;

    /**
     * Create constructor no object;
     *
     */
    public Galery() {
    }

    /**
     * Create constructor have object;
     *
     * @param id
     * @param title String
     * @param description String
     */
    public Galery(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    /**
     * Use to get name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Use to set name
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Use to get id
     *
     * @return id
     */
    public int getID() {
        return id;
    }

    /**
     * Use to set id
     *
     * @param id
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Get title
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Use to get title
     *
     * @param title String
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Use to get description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Use to set description
     *
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * set avatar
     *
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     *
     * @return to string
     */
    @Override
    public String toString() {
        return "Galery{" + "ID=" + id + ", title=" + title + ", description=" + description + '}';
    }

}
