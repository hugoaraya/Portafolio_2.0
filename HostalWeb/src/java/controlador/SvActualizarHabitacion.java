/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static dao.HabitacionesDAO.modificarHabitaciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Habitacion;

/**
 *
 * @author 420NiggaBytes
 */
@WebServlet(name = "SvActualizarHabitacion", urlPatterns = {"/actualizarHabitacion"})
public class SvActualizarHabitacion extends HttpServlet {

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
          int idhabitacion = Integer.parseInt(request.getParameter("id_habitacion"));
          String tipo_cama = request.getParameter("tipo_cama");
          String accesorios = request.getParameter("accesorios");
          int precio = Integer.parseInt(request.getParameter("precio"));
          String descripcion = request.getParameter("descripcion");
          String nombre = request.getParameter("nombre");         
          int capacidad = Integer.parseInt(request.getParameter("capacidad"));
          
          Habitacion hab = new Habitacion();
          
          hab.setTipo_cama(tipo_cama);
          hab.setAccesorios(accesorios);
          hab.setPrecio_habitacion(precio);
          hab.setDescripcion(descripcion);
          hab.setNombre_habitacion(nombre);         
          hab.setCapacidad(capacidad);
          
          modificarHabitaciones(idhabitacion, tipo_cama, accesorios, precio, descripcion, nombre, capacidad); 
          
           response.sendRedirect("listaHabitaciones.jsp");
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
            Logger.getLogger(SvActualizarHabitacion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SvActualizarHabitacion.class.getName()).log(Level.SEVERE, null, ex);
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
