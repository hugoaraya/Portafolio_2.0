/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.Orden_CompraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static dao.Orden_CompraDAO.AgregarHuespedHabitacion;
import static dao.Orden_CompraDAO.AgregarOrdenCompra;
import static dao.Orden_CompraDAO.AgregarOrdenComedor;
import static dao.Orden_CompraDAO.ObtenerOrdenComedor;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Orden_comedor;
import modelo.Orden_compra;

/**
 *
 * @author 420NiggaBytes
 */
@WebServlet(name = "SvHuespedHabitacion", urlPatterns = {"/insertarHuespedHabitacion"})
public class SvHuespedHabitacion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //insertar fechas
            
            //
            //variables para insertar en huesped habitacion
            String id_habitacion[] = request.getParameterValues("id_habitacion");
            String id_huesped[] = request.getParameterValues("id_huesped");
            //variables para insertar en orden de compra 
            int empresa_id = Integer.parseInt(request.getParameter("empresa_id"));
            int nro_orden = (int)Math.round(Math.random() * 89999) + 10000;
            LocalDate localDate = LocalDate.now();
            //insertar orden comedor
            String servicio_id = request.getParameter("tipo_servicio");
            int id_plato = (int)Math.round(Math.random() * 1) + 4;
            int id_minuta = (int)Math.round(Math.random() * 1) + 4;
            //           
            //
            // se recorren los huesped y habitaciones seleccionadas
            for (String id_huesped1 : id_huesped) {                
                for (String id_habitacion1 : id_habitacion) {
                    //insertar nueva orden de comedor
                Orden_comedor oco = new Orden_comedor();
                oco.setPlato_id(id_plato);
                oco.setMinuta_id(id_minuta);
                oco.setServicio_id(servicio_id);                
                AgregarOrdenComedor(oco);      
                 //
                    Orden_compra oc = new Orden_compra();
                    oc.setHuesped_id(id_huesped1);
                    oc.setHabitacion_id(id_habitacion1);
                    //se insertan las id de huesped y habitacion
                    AgregarHuespedHabitacion(oc);
                    // se recorren y se recupera la id de huesped habitacion 
                    Orden_CompraDAO ocs = new Orden_CompraDAO();
                    ArrayList<Orden_compra> oc1 = ocs.listaHuespedHabitacion(id_huesped1, id_habitacion1);
                    //recorre orden comedor y recupera la id
                     Orden_CompraDAO ocomedor = new Orden_CompraDAO();
                     ArrayList<Orden_comedor> ocomedors = ocomedor.ObtenerOrdenComedor(id_plato, id_minuta);                                        
                    for (Orden_compra orden : oc1) {
                        for (Orden_comedor ordensita : ocomedors){    
                        //se insertan los datos en la orden de compra
                        String fecha = localDate.toString();
                        Orden_compra oc20 = new Orden_compra();
                        oc20.setNro_orden(nro_orden);
                        oc20.setEmpresa_id(empresa_id);
                        oc20.setFecha_orden(convertirFecha(fecha));
                        oc20.setOrden_comedor_id(ordensita.getId_orden_comedor());
                        oc20.setHuesped_habitacion_id(orden.getHuesped_habitacion_id());                    
                        AgregarOrdenCompra(oc20);       
                    }
                }

                }
            }

            response.sendRedirect("ordenes_compra.jsp");
        } catch (Exception ex) {
            System.out.println("error" + ex);
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
            Logger.getLogger(SvHuespedHabitacion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SvHuespedHabitacion.class.getName()).log(Level.SEVERE, null, ex);
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
