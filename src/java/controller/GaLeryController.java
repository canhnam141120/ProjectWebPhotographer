
package controller;

import dao.ContactDAO;
import dao.GaleryDAO;
import dao.ImageDAO;
import dao.ViewDAO;
import dao.impl.ContactDAOImpl;
import dao.impl.GaleryDAOImpl;
import dao.impl.ImageDAOImpl;
import dao.impl.ViewDAOImpl;
import entity.Image;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Processing information on gallery pages forward data to jsp page;
 *
 * @author DELL
 */
public class GaLeryController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  <code>HttpServletRequest</code>
     * @param response <code>HttpServletResponse</code>
     * @throws ServletException if a Servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            GaleryDAO galeryDao = new GaleryDAOImpl();
            ImageDAO imagedao = new ImageDAOImpl();
            ContactDAO contact = new ContactDAOImpl();
            ViewDAO viewDao = new ViewDAOImpl();
            String galeryID = request.getParameter("galeryID");
            String imgID = request.getParameter("imgID");
            
            boolean invalid = true;
            boolean indexValid = true;
            int galery = 0;
            //check galery id
            try {
                if (galeryID != null) {
                    galery = Integer.parseInt(galeryID);

                } else {
                    // set default galery id
                    galery = 1;
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "This galery is invalid!!");
                request.getRequestDispatcher("Error.jsp").forward(request, response);
                invalid = false;
            }
            if (invalid == true) {
                int pageSize = 8;

                //count total imge in galery 
                int totalRecord = galeryDao.countImage(galery);
                if (totalRecord <= 0) {
                    request.setAttribute("error", "No image in galery!!");
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                }
                int maxPage = totalRecord / pageSize;
                if ((totalRecord % pageSize) != 0) {
                    maxPage++;
                }

                //get top 1 image of galery
                int image = 0;

                String pageIndex = request.getParameter("index");
                int index = 0;

                //check index page
                try {
                    if (pageIndex != null) {

                        index = Integer.parseInt(pageIndex);
                    } else {
                        index = 1;
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "This page is invalid!!");
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                    indexValid = false;
                }

                if (indexValid == true && index > 0 && index <= maxPage) {
                    //check image id valid
                    try {
                        if (imgID != null) {
                            int imgIdInt = Integer.parseInt(imgID);
                            viewDao.updateViewImage(imgIdInt);
                            image = Integer.parseInt(imgID);
                        } else {
                            // set default image id
                            image = imagedao.getTop1ImageGalery(galery).getId();
                        }
                    } catch (Exception e) {
                        request.setAttribute("error", "This image not found!!");
                        request.getRequestDispatcher("Error.jsp").forward(request, response);
                    }
                    // check image in galery or not
                    if (imagedao.getImageID(image, galery) != null) {
                        request.setAttribute("top1Galery", imagedao.getImageID(image, galery));
                    } else {
                        request.setAttribute("error", "This image not found!!");
                        request.getRequestDispatcher("Error.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("error", "This page is invalid!!");
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                }

                try {
                    //get list image with paging 
                    List<Image> imagelList = imagedao.getListImageWithPaging(galery, index, pageSize);
                    request.setAttribute("listImage", imagelList);

                } catch (Exception ex) {
                    request.setAttribute("error", "This galery is invalid!!");
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                }

                request.setAttribute("index", index);
                request.setAttribute("maxPage", maxPage);
                request.setAttribute("galeryID", galery);
                request.setAttribute("totalRecord", totalRecord);

            }
            
            
            
            List<Image> list = imagedao.getImageByGaleryID(galery);
            request.setAttribute("slideShow", list);
            //get top 3 galery
            
            //request.setAttribute("viewimage", viewImage);
            
            request.setAttribute("top3", galeryDao.getTop3Galery(3));
            //get contact infor
            request.setAttribute("contact", contact.getContact());
            request.setAttribute("active", galeryID);
            request.setAttribute("galery", galeryDao.getGaleryByID(galery));
            request.getRequestDispatcher("Gallery.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
