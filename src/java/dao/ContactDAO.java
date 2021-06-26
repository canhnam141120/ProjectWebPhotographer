
package dao;

import entity.Contact;

/**
 *  Processing and retrieving the information Contact
 *
 * @author DELL
 */
public interface ContactDAO {
     /**
     * Get contact
     *
     * @return contact
     * @throws Exception
     */
    public Contact getContact() throws Exception;
}
