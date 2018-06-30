/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static consultas.Query.*;
import dao.Conexion;
import dao.HabitacionesDAO;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Habitacion;

/**
 *
 * @author 420NiggaBytes
 */
@WebServlet(name = "SvOrden_Habitacion", urlPatterns = {"/detalle_orden_compra.pdf"})
public class SvOrden_Habitacion extends HttpServlet {

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
            throws ServletException, IOException {
        try{
       response.setContentType("aplication/pdf");
        OutputStream out = response.getOutputStream();

        int nro_orden = Integer.parseInt(request.getParameter("nro_orden"));        
        try {

            String sql1 = SQL_LISTAR_DETALLE_ORDEN_COMPRA_METODO(nro_orden);
            String sql2 = SQL_PRECIO_TOTAL_ORDEN_COMPRA_METODO(nro_orden);
            String sql3 = SQL_LISTAR_DETALLE_ORDEN_HABITACION_METODO(nro_orden);
            Connection conexion = new Conexion().fabricarConexion();

            PreparedStatement ps = conexion.prepareStatement(sql1);
            PreparedStatement ps2 = conexion.prepareStatement(sql2);
            PreparedStatement ps3 = conexion.prepareStatement(sql3);
            ResultSet rs;
            ResultSet rs2;
            ResultSet rs3;
            rs = ps.executeQuery();
            rs2 = ps2.executeQuery();
            rs3 = ps3.executeQuery();
            //fecha
            Date fechahoy = new Date();
            SimpleDateFormat formato
                    = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = formato.format(fechahoy);
            //generar el documento
            Document documento = new Document();
            PdfWriter.getInstance(documento, out);
            documento.open();
            //Imagen
              String relativeWebPath = "/img/logo_hostal.png";
            String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
            Image imagenes = Image.getInstance(absoluteDiskPath);
            imagenes.setAlignment(Element.ALIGN_CENTER);
            imagenes.scalePercent(50);
            documento.add(imagenes);

            //parrafo titulo
            
            Paragraph par1 = new Paragraph();
            par1.add(new Phrase(Chunk.NEWLINE));
            par1.add(new Phrase(Chunk.NEWLINE));
            Font fontitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLACK);
            par1.add(new Phrase("DETALLE DE FACTURA", fontitulo));
            par1.setAlignment(Element.ALIGN_CENTER);
            par1.add(new Phrase(Chunk.NEWLINE));
            par1.add(new Phrase(Chunk.NEWLINE));
            documento.add(par1);

            Paragraph par2 = new Paragraph();
            Font fontdescripcion = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
            par2.add(new Phrase("Fecha: " + fecha + "       Nro Orden: " + nro_orden, fontdescripcion));
            par2.setAlignment(Element.ALIGN_LEFT);
            par2.add(new Phrase(Chunk.NEWLINE));
            par2.add(new Phrase(Chunk.NEWLINE));     
            documento.add(par2);

             Paragraph par3 = new Paragraph();
            Font fontHuesped = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
            par3.add(new Phrase(Chunk.NEWLINE));          
            par3.add(new Phrase("Detalle de Huespedes", fontHuesped));
            par3.setAlignment(Element.ALIGN_CENTER);
            par3.add(new Phrase(Chunk.NEWLINE));
            par3.add(new Phrase(Chunk.NEWLINE));  
              
            documento.add(par3);
            
            PdfPTable tabla = new PdfPTable(6); 
            tabla.setWidthPercentage(100);
            PdfPCell celda1 = new PdfPCell(new Paragraph("Nombre Huesped", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda2 = new PdfPCell(new Paragraph("Rut Huesped", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda3 = new PdfPCell(new Paragraph("Cargo", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda4 = new PdfPCell(new Paragraph("Correo", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda5 = new PdfPCell(new Paragraph("Telefono", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda6 = new PdfPCell(new Paragraph("Tipo Servicio", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));

            tabla.addCell(celda1);
            tabla.addCell(celda2);
            tabla.addCell(celda3);
            tabla.addCell(celda4);
            tabla.addCell(celda5);
            tabla.addCell(celda6);    
            while (rs.next()) {              
                tabla.addCell(rs.getString(1) + " " + rs.getString(2));
                tabla.addCell(rs.getString(3) +"-"+rs.getString(4));
                tabla.addCell(rs.getString(5));
                tabla.addCell(rs.getString(6));
                tabla.addCell(String.valueOf(rs.getInt(7)));
                tabla.addCell(rs.getString(8));            
                                              
            }       
             
            //
            documento.add(tabla);
            //
             Paragraph par4 = new Paragraph();
            Font fontHabi = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
            par4.add(new Phrase(Chunk.NEWLINE));
            par4.add(new Phrase(Chunk.NEWLINE));
            par4.add(new Phrase("Detalle de Habitaciones", fontHabi));
            par4.setAlignment(Element.ALIGN_CENTER);
            par4.add(new Phrase(Chunk.NEWLINE));
            par4.add(new Phrase(Chunk.NEWLINE));     
            documento.add(par4);

            PdfPTable tablah = new PdfPTable(6); 
            tablah.setWidthPercentage(100);
            PdfPCell hcelda1 = new PdfPCell(new Paragraph("Nombre Habitacion", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell hcelda2 = new PdfPCell(new Paragraph("Tipo Cama", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell hcelda3 = new PdfPCell(new Paragraph("Accesorios", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell hcelda4 = new PdfPCell(new Paragraph("Descripcion", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell hcelda5 = new PdfPCell(new Paragraph("Capacidad", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell hcelda6 = new PdfPCell(new Paragraph("Precio", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));

            tablah.addCell(hcelda1);
            tablah.addCell(hcelda2);
            tablah.addCell(hcelda3);
            tablah.addCell(hcelda4);
            tablah.addCell(hcelda5);
            tablah.addCell(hcelda6);  
            
            while (rs3.next()) {              
                tablah.addCell(rs3.getString(1));
                tablah.addCell(rs3.getString(2));
                tablah.addCell(rs3.getString(3));
                tablah.addCell(rs3.getString(4));
                tablah.addCell(rs3.getString(5)); 
                tablah.addCell(rs3.getString(6));            
                                              
            }       
             
            //
            documento.add(tablah);
            //
            
            Paragraph par5 = new Paragraph();
            par5.add(new Phrase(Chunk.NEWLINE));
            par5.add(new Phrase(Chunk.NEWLINE));
            Font fontprecio = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
            while (rs2.next()) {
            HabitacionesDAO daoco = new HabitacionesDAO();
            Habitacion con = new Habitacion();
            Habitacion con2 = new Habitacion();
            Habitacion con3 = new Habitacion();
            con3 = daoco.getHabitacionIdOrden(nro_orden);
            con2 = daoco.getHabitacionPorId(con3.getId_habitacion());
            con = daoco.getFehasPorId(con2.getId_fechas());
         
            //
            int dias = con.getTotal_dias();
            int precio = rs2.getInt(1);
            int total = precio * dias;
            //
           
            par5.add(new Phrase("Cantidad de dias: " +dias+"     Precio Total: $" + String.valueOf(total),fontprecio));
            par5.setAlignment(Element.ALIGN_RIGHT);
            }
            
            documento.add(par5);            
           
            documento.close();
            rs.close();
            rs2.close();
            rs3.close();
            conexion.close();
        } catch (Exception ex) {
            System.out.println("error"+ex);
        }
    }catch(Exception ex) {
          System.out.println("error"+ex);
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
