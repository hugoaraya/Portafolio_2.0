/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static consultas.Query.SQL_PRECIO_TOTAL_ORDEN_COMPRA_METODO;
import dao.Conexion;
import dao.HabitacionesDAO;
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
import static dao.HabitacionesDAO.AgregarFechas;
import static dao.HabitacionesDAO.modificarEstadoHabitacion;
import static dao.HuespedDAO.modificarEstadoHuesped;
import dao.MinutaDAO;
import dao.PlatoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Habitacion;
import modelo.Huesped;
import modelo.Minuta;
import modelo.Orden_comedor;
import modelo.Orden_compra;
import modelo.Plato;

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
            String fecha_inicio = request.getParameter("fecha_inicio");
            String fecha_fin = request.getParameter("fecha_fin");
            Habitacion habf = new Habitacion();
            habf.setFecha_inicio(convertirFecha(fecha_inicio));
            habf.setFecha_fin(convertirFecha(fecha_fin));
            AgregarFechas(habf);
            //obtener la id de la fecha agregada
            HabitacionesDAO daof = new HabitacionesDAO();
            Habitacion fhab = new Habitacion();

            fhab = daof.getFechaId(convertirFecha(fecha_inicio), convertirFecha(fecha_fin));

            //
            //variables para insertar en huesped habitacion
            String id_habitacion[] = request.getParameterValues("id_habitacion");
            String id_huesped[] = request.getParameterValues("id_huesped");
            //variables para insertar en orden de compra 
            int empresa_id = Integer.parseInt(request.getParameter("empresa_id"));
            int nro_orden = (int) Math.round(Math.random() * 89999) + 10000;
            LocalDate localDate = LocalDate.now();
            //insertar orden comedor
            //se obtiene la cantidad de minutas insertadas
            MinutaDAO dao2 = new MinutaDAO();
            ArrayList<Minuta> dCon = dao2.listarMinuta();
            int contm = 1;
            for (Minuta temp : dCon) {
                contm++;
            }
            //se obtiene la cantidad de platos insertadas
            PlatoDAO dao30 = new PlatoDAO();
            ArrayList<Plato> dCona = dao30.listarPlato();
            int contp = 1;
            for (Plato temp : dCona) {
                contp++;
            }
            //insertar datos del servicio y plato con minuta aleatoria
            String servicio_id = request.getParameter("tipo_servicio");
            int id_plato = (int) (Math.floor(Math.random() * contp) + 1);
            int id_minuta = (int) (Math.floor(Math.random() * contm) + 1);  
            out.print("<h1>"+contp+"</h1>");
            out.print("<h1>"+contm+"</h1>");
            //           
            //
            // se recorren los huesped y habitaciones seleccionadas
            for (String id_huesped1 : id_huesped) {
                for (String id_habitacion1 : id_habitacion) {

                    //Actualizar estado huesped
                    int id_huespedes = Integer.parseInt(id_huesped1);
                    modificarEstadoHuesped(id_huespedes);
                    //actualizar estado y fechas habitacion
                    int idfechas = fhab.getId_fechas();
                    Habitacion hab = new Habitacion();
                    hab.setId_fechas(idfechas);
                    modificarEstadoHabitacion(id_habitacion1, idfechas);
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

                    ArrayList<Orden_compra> oc1 = Orden_CompraDAO.listaHuespedHabitacion(id_huesped1, id_habitacion1);
                    //recorre orden comedor y recupera la id

                    ArrayList<Orden_comedor> ocomedors = Orden_CompraDAO.ObtenerOrdenComedor(id_plato, id_minuta);
                    for (Orden_compra orden : oc1) {
                        for (Orden_comedor ordensita : ocomedors) {
                            //se insertan los datos en la orden de compra
                            String fecha = localDate.toString();
                            Orden_compra oc20 = new Orden_compra();
                            oc20.setNro_orden(nro_orden);
                            oc20.setEmpresa_id(empresa_id);
                            oc20.setFecha_orden(convertirFecha(fecha));
                            oc20.setOrden_comedor_id(ordensita.getId_orden_comedor());
                            oc20.setHuesped_habitacion_id(orden.getHuesped_habitacion_id());
                            AgregarOrdenCompra(oc20);
                            break;
                        }
                        break;
                    }

                }

            }
            // 
            for (String id_habitacion1 : id_habitacion) {
                HabitacionesDAO daoco = new HabitacionesDAO();
                Habitacion con = new Habitacion();
                Habitacion con2 = new Habitacion();
                con = daoco.getHabitacionPorId(Integer.parseInt(id_habitacion1));

                //
                con2 = daoco.getFehasPorId(con.getId_fechas());
                int dias = con2.getTotal_dias();

                //
                String sql2 = SQL_PRECIO_TOTAL_ORDEN_COMPRA_METODO(nro_orden);
                Connection conexion = new Conexion().fabricarConexion();
                PreparedStatement ps2 = conexion.prepareStatement(sql2);
                ResultSet rs2;
                rs2 = ps2.executeQuery();
                while (rs2.next()) {
                    int precio = rs2.getInt(1);
                    //
                    String fecha = localDate.toString();
                    response.sendRedirect("formulario_orden_compra_3.jsp?nro=" + nro_orden + "&fecha=" + convertirFecha(fecha) + "&precio=" + precio * dias + "");
                    rs2.close();

                }
            }
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
