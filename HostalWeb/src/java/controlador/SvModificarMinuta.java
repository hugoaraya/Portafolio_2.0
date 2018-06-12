/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.SvAgregarMinuta.convertirFecha;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Minuta;
import static dao.MinutaDAO.modificarMinuta;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 420NiggaBytes
 */
@WebServlet(name = "SvModificarMinuta", urlPatterns = {"/modificarMinuta"})
public class SvModificarMinuta extends HttpServlet {

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
            int idminuta = Integer.parseInt(request.getParameter("idminuta"));
           String nombre_minuta = request.getParameter("nombre_minuta");
           String fecha_inicio = request.getParameter("fecha_inicio");
           String fecha_fin = request.getParameter("fecha_fin");
            
            Minuta min = new Minuta();
            
            String fecha_in = convertirFecha(fecha_inicio);
            String fecha_fi = convertirFecha(fecha_fin);
            
            min.setNombre_minuta(nombre_minuta);
            min.setFecha_inicio(fecha_in);
            min.setFecha_fin(fecha_fi);
            
            
            
            
            
            if(min != null){
              modificarMinuta(idminuta,nombre_minuta,fecha_in,fecha_fi); 
              response.sendRedirect("listaMinuta.jsp");
            }else{
                System.out.println("Error.");
            }
            
            
        }
     
    }
       
        public static String convertirFecha(String fechaEntrada) {
        String fechaNormal = "";
        String dia = "";
        String mes = "";
        String anio = "";
        int largoFechaQla = fechaEntrada.length();

        for (int i = 0; i < largoFechaQla; i++) {
            if (i < 4) {
                anio += fechaEntrada.charAt(i);
            } else if (i > 4 && i < 7) {
                mes += fechaEntrada.charAt(i);
            } else if (i > 7) {
                dia += fechaEntrada.charAt(i);
            }
 
        }
        fechaNormal = dia + "/" + mes + "/" + anio;
        return fechaNormal;
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
            Logger.getLogger(SvModificarMinuta.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SvModificarMinuta.class.getName()).log(Level.SEVERE, null, ex);
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
