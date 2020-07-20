package Clases;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Chunk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JTable;

public class PDF {
    
    public void GenerarPDFPedido(JTable Tabla,String id,String total,String cliente,String empleado,String fecha) throws IOException, DocumentException{
        Document document = new Document(PageSize.A8, 0, 0, 0, 0);
        String ruta = "src/PDFs/Pedidos/Pedido-No."+id+".pdf";
        PdfWriter.getInstance(document, new FileOutputStream(ruta));
        document.open();
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);
        
        Font black = new Font(FontFamily.COURIER, 5, Font.BOLD, BaseColor.BLACK);
        Font black1 = new Font(FontFamily.COURIER, 4, Font.NORMAL, BaseColor.BLACK);
        Chunk C4 = new Chunk("Pedido No."+id+"", black);
        PdfPCell cell = new PdfPCell(new Phrase(C4));
        cell.setColspan(10);
        
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(1.0f);
        cell.setBackgroundColor(new BaseColor(255,255,255));
        table.addCell(cell);
        
        table.addCell(new Phrase(new Chunk("ID",black1)));
        table.addCell(new Phrase(new Chunk("Nombre",black1)));
        table.addCell(new Phrase(new Chunk("Cantidad",black1)));
        table.addCell(new Phrase(new Chunk("Precio (u)",black1)));
        table.addCell(new Phrase(new Chunk("Precio (p)",black1)));
        /////////////////////////////////////////////////////////////
        for(int i = 0; i < Tabla.getRowCount();i++){
            table.addCell(new Phrase(new Chunk(Tabla.getValueAt(i, 0).toString(),black1)));
            table.addCell(new Phrase(new Chunk(Tabla.getValueAt(i, 1).toString(),black1)));
            table.addCell(new Phrase(new Chunk(Tabla.getValueAt(i, 2).toString(),black1)));
            table.addCell(new Phrase(new Chunk(Tabla.getValueAt(i, 3).toString(),black1)));
            table.addCell(new Phrase(new Chunk(Tabla.getValueAt(i, 4).toString(),black1)));
        }
        ////////////////////////////////////////////////////////////
        Chunk C1 = new Chunk("Tortillas de Harina Efraín ", black);
        Chunk C2 = new Chunk("Dirección Avenida Bicentenario Juárez, Francisco Villa, 82127 Mazatlán, Sin.  ", black);
        Chunk C3 = new Chunk("668 3983 ", black);
        Chunk INFO1 = new Chunk("El pedido se entregará el día "+fecha, black);
        Chunk INFO2 = new Chunk("Total: "+total,black);
        document.add(new Paragraph(C1));
        document.add(new Paragraph(C2));
        document.add(new Paragraph(C3));
        document.add(new Paragraph(" "));
        document.add(table);
        document.add(new Paragraph(INFO2));
        document.add(new Paragraph(INFO1));
        document.close();
    }
    
    public void GenerarPDFVenta(JTable Tabla,String id,String total,String cliente,String empleado,String fecha) throws IOException, DocumentException{
        Document document = new Document(PageSize.A8, 0, 0, 0, 0);
        String ruta = "src/PDFs/Ventas/Venta-No."+id+".pdf";
        PdfWriter.getInstance(document, new FileOutputStream(ruta));
        document.open();
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);
        
        Font black = new Font(FontFamily.COURIER, 5, Font.BOLD, BaseColor.BLACK);
        Font black1 = new Font(FontFamily.COURIER, 4, Font.NORMAL, BaseColor.BLACK);
        Chunk C4 = new Chunk("Venta No."+id+"", black);
        PdfPCell cell = new PdfPCell(new Phrase(C4));
        cell.setColspan(10);
        
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(1.0f);
        cell.setBackgroundColor(new BaseColor(255,255,255));
        table.addCell(cell);
        
        table.addCell(new Phrase(new Chunk("ID",black1)));
        table.addCell(new Phrase(new Chunk("Nombre",black1)));
        table.addCell(new Phrase(new Chunk("Cantidad",black1)));
        table.addCell(new Phrase(new Chunk("Precio (u)",black1)));
        table.addCell(new Phrase(new Chunk("Precio (p)",black1)));
        /////////////////////////////////////////////////////////////
        for(int i = 0; i < Tabla.getRowCount();i++){
            table.addCell(new Phrase(new Chunk(Tabla.getValueAt(i, 0).toString(),black1)));
            table.addCell(new Phrase(new Chunk(Tabla.getValueAt(i, 1).toString(),black1)));
            table.addCell(new Phrase(new Chunk(Tabla.getValueAt(i, 2).toString(),black1)));
            table.addCell(new Phrase(new Chunk(Tabla.getValueAt(i, 3).toString(),black1)));
            table.addCell(new Phrase(new Chunk(Tabla.getValueAt(i, 4).toString(),black1)));
        }
        ////////////////////////////////////////////////////////////
        Chunk C1 = new Chunk("Tortillas de Harina Efraín ", black);
        Chunk C2 = new Chunk("Dirección Avenida Bicentenario Juárez, Francisco Villa, 82127 Mazatlán, Sin.  ", black);
        Chunk C3 = new Chunk("668 3983 ", black);
        Chunk INFO1 = new Chunk("Fecha: "+fecha, black);
        Chunk INFO2 = new Chunk("Total: "+total,black);
        Chunk INFO3 = new Chunk("Muchas gracias por comprar en la Tortillería Efraín, dónde tus sueños se hacen realidad",black1);
        document.add(new Paragraph(C1));
        document.add(new Paragraph(C2));
        document.add(new Paragraph(C3));
        document.add(new Paragraph(INFO1));
        document.add(new Paragraph(" "));
        document.add(table);
        document.add(new Paragraph(INFO2));
        document.add(new Paragraph(INFO3));
        document.close();
    }
    
}
