/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "SvOrden_Producto", urlPatterns = {"/detalle_orden.pdf"})
public class SvOrden_Producto extends HttpServlet {

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
try{
       response.setContentType("aplication/pdf");
        OutputStream out = response.getOutputStream();

        int nro_orden = Integer.parseInt(request.getParameter("nro_orden"));        
        try {

            String sql1 = SQL_LISTAR_DETALLE_ORDEN_METODO(nro_orden);
            String sql2 = SQL_PRECIO_STOCK_TOTAL_METODO(nro_orden);
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
                    = new SimpleDateFormat("dd/MM/YYYY");
            String fecha = formato.format(fechahoy);
            //generar el documento
            Document documento = new Document();
            PdfWriter.getInstance(documento, out);
            documento.open();
            //Imagen
            String relativeWebPath = "/img/logo_hostal.png";
            String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
            Image imagenes = Image.getInstance(absoluteDiskPath);
            imagenes.setAlignment(Element.ALIGN_MIDDLE);
            imagenes.scalePercent(50);
            documento.add(imagenes);

            //parrafo titulo
            
            Paragraph par1 = new Paragraph();
            par1.add(new Phrase(Chunk.NEWLINE));
            par1.add(new Phrase(Chunk.NEWLINE));
            Font fontitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLACK);
            par1.add(new Phrase("DETALLE ORDEN DE PEDIDO", fontitulo));
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

            PdfPTable tabla = new PdfPTable(4); 
            tabla.setWidthPercentage(100);
            PdfPCell celda1 = new PdfPCell(new Paragraph("Nombre", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda2 = new PdfPCell(new Paragraph("Tipo De Producto", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda3 = new PdfPCell(new Paragraph("Marca", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda4 = new PdfPCell(new Paragraph("Stock", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));

            tabla.addCell(celda1);
            tabla.addCell(celda2);
            tabla.addCell(celda3);
            tabla.addCell(celda4);

       
                  

            while (rs.next()) {              
           
                tabla.addCell(rs.getString(1));
                tabla.addCell(rs.getString(2));
                tabla.addCell(rs.getString(3));
                tabla.addCell(String.valueOf(rs.getInt(4)));
                                                
            }            
            documento.add(tabla);
            
            Paragraph par3 = new Paragraph();
            par3.add(new Phrase(Chunk.NEWLINE));
            Font fontprecio = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
            while (rs2.next()) {
            par3.add(new Phrase("Total Productos: " + String.valueOf(rs2.getInt(1)), fontprecio));
            par3.setAlignment(Element.ALIGN_RIGHT);
            }
            
            documento.add(par3);            
           
            documento.close();
            rs.close();
            rs2.close();
            conexion.close();
        } catch (Exception ex) {
                System.out.println("error" + ex);
        }
    }catch(Exception ex) {
         System.out.println("error" + ex);
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(SvOrden_Producto.class.getName()).log(Level.SEVERE, null, ex);
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(SvOrden_Producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>
}

    
