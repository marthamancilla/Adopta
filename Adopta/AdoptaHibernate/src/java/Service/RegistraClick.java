/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import dao.ClickDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author medin
 */
@WebServlet(name = "RegistraClick", urlPatterns = {"/RegistraClick"})
public class RegistraClick extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClickDAO dao = new ClickDAO();
        if (dao.saveClick(
                request.getParameter("id"),
                request.getParameter("clase"))) {

        } else {

        }
    }
}
