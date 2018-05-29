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
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            Connection conexion = new Conexion().fabricarConexion();

            PreparedStatement ps = conexion.prepareStatement(sql1);
            PreparedStatement ps2 = conexion.prepareStatement(sql2);
            ResultSet rs;
            ResultSet rs2;
            rs = ps.executeQuery();
            rs2 = ps2.executeQuery();
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
            Image imagenes = Image.getInstance("C:\\Users\\420NiggaBytes\\Pictures\\Duoc\\PORTFOLIO\\Codigo\\HostalWeb\\logo_hostal.png");
            imagenes.setAlignment(Element.ALIGN_LEFT);
            imagenes.scalePercent(50);
            documento.add(imagenes);

            //parrafo titulo
            
            Paragraph par1 = new Paragraph();
            par1.add(new Phrase(Chunk.NEWLINE));
            par1.add(new Phrase(Chunk.NEWLINE));
            Font fontitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLACK);
            par1.add(new Phrase("DETALLE ORDEN DE COMPRA", fontitulo));
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

            PdfPTable tabla = new PdfPTable(7); 
            tabla.setWidthPercentage(100);
            PdfPCell celda1 = new PdfPCell(new Paragraph("Nombre Huesped", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda2 = new PdfPCell(new Paragraph("Rut Huesped", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda3 = new PdfPCell(new Paragraph("Cargo", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda4 = new PdfPCell(new Paragraph("Correo", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda5 = new PdfPCell(new Paragraph("Telefono", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda6 = new PdfPCell(new Paragraph("Habitacion", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda7 = new PdfPCell(new Paragraph("Precio", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));

            tabla.addCell(celda1);
            tabla.addCell(celda2);
            tabla.addCell(celda3);
            tabla.addCell(celda4);
            tabla.addCell(celda5);
            tabla.addCell(celda6);
            tabla.addCell(celda7);          

            while (rs.next()) {              
                tabla.addCell(rs.getString(1) + " " + rs.getString(2));
                tabla.addCell(rs.getString(3) +"-"+rs.getString(4));
                tabla.addCell(rs.getString(5));
                tabla.addCell(rs.getString(6));
                tabla.addCell(String.valueOf(rs.getInt(7)));
                tabla.addCell(rs.getString(8));
                tabla.addCell(String.valueOf(rs.getInt(9)));  
                                              
            }            
            documento.add(tabla);
            
            Paragraph par3 = new Paragraph();
            par3.add(new Phrase(Chunk.NEWLINE));
            Font fontprecio = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
            while (rs2.next()) {
            par3.add(new Phrase("Precio Total: $" + String.valueOf(rs2.getInt(1)),fontprecio));
            par3.setAlignment(Element.ALIGN_RIGHT);
            }
            
            documento.add(par3);            
           
            documento.close();
            rs.close();
            rs2.close();
            conexion.close();
        } catch (Exception ex) {

        }
    }catch(Exception ex) {
        
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
