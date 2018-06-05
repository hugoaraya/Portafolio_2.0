/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Huesped;
import static dao.HuespedDAO.AgregarHuesped;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 420NiggaBytes
 */
@WebServlet(name = "SvAgregarHuesped", urlPatterns = {"/agregarHuesped"})
public class SvAgregarHuesped extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String rut = request.getParameter("rut");
          String dv = request.getParameter("dv");
          String nombre = request.getParameter("nombre_huesped");
          String apellido = request.getParameter("apellido_huesped");
          String cargo = request.getParameter("cargo");
          String correo = request.getParameter("correo");
          int telefono = Integer.parseInt(request.getParameter("telefono"));          
          int empresa_id = Integer.parseInt(request.getParameter("empresa_id"));
          int estado_huesped_id = Integer.parseInt(request.getParameter("id_estado_huesped"));
          
          Huesped hues = new Huesped();
          
          hues.setRut(rut);
          hues.setDv(dv);
          hues.setNombre(nombre);
          hues.setApellido(apellido);
          hues.setCargo(cargo);
          hues.setCorreo(correo);
          hues.setNumero_tefono(telefono);
          hues.setId_empresa(empresa_id);
          hues.setId_estado_huesped(estado_huesped_id);
          
          AgregarHuesped(hues);   
          
          
          response.sendRedirect("listaHuesped.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SvAgregarHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SvAgregarHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
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
