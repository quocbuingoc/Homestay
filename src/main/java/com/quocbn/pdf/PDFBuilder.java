package com.quocbn.pdf;

import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.quocbn.model.Booking;

public class PDFBuilder extends AbstractITextPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Booking listBooking = (Booking) model.get("listBooking");
        
		document.add(new Paragraph("Your booking ticket !!!"));
         
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {1.5f, 2.0f, 2.0f, 2.0f, 2.5f,2.5f,1.5f});
        table.setSpacingBefore(10);
         
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);
         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.GRAY);
        cell.setPadding(5);
         
        // write table header
        cell.setPhrase(new Phrase("Booking Id", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Room Number", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Homestay", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Username", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Check-In Date", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Check-Out Date", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Total", font));
        table.addCell(cell);
         
        // write table row data
            table.addCell(String.valueOf(listBooking.getBookingId()));
            table.addCell(String.valueOf(listBooking.getR().getRoomNumber()));
            table.addCell(String.valueOf(listBooking.getHs().getHomestayTitle()));
            table.addCell(listBooking.getAcc().getUserName());
            table.addCell(String.valueOf(listBooking.getCheckInDate()));
            table.addCell(String.valueOf(listBooking.getCheckOutDate()));
            table.addCell(String.valueOf(listBooking.getTotalAmount()));
         
        document.add(table);
	}

}
