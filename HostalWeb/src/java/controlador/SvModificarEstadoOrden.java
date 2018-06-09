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
import modelo.Orden_pedido;
import static dao.Orden_pedidoDAO.modificarEstadoOrdenPedido;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 420NiggaBytes
 */
@WebServlet(name = "SvModificarEstadoOrden", urlPatterns = {"/modificarEstadoOrden"})
public class SvModificarEstadoOrden extends HttpServlet {

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
             int idorden_pedido = Integer.parseInt(request.getParameter("idordenpedido"));
             int  estado_orden_id = Integer.parseInt(request.getParameter("estado_orden_id"));
            String comentarios = request.getParameter("comentarios");
            
            Orden_pedido orden = new Orden_pedido();
            orden.setEstado_orden_id(estado_orden_id);
            orden.setComentarios(comentarios);
            
            if( estado_orden_id == 3){
            modificarEstadoOrdenPedido(idorden_pedido,estado_orden_id,comentarios);           
            response.sendRedirect("ordenes_pedido.jsp");
            }else
            {
            String coment = "Sin comentarios";
            modificarEstadoOrdenPedido(idorden_pedido,estado_orden_id,coment);           
            response.sendRedirect("ordenes_pedido.jsp");
            }
            
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
            Logger.getLogger(SvModificarEstadoOrden.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SvModificarEstadoOrden.class.getName()).log(Level.SEVERE, null, ex);
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
