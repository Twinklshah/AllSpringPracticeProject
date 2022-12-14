package com.example.demo.config;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.model.User;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UserPdfConfig {
	
	private List<User> listUsers;
	
	public UserPdfConfig(List<User> listUsers) {
        this.listUsers = listUsers;
    }
 
	 private void pdfHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLACK);
	        cell.setPadding(5);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("User ID", font));
	         
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("UserName", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Age", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("User Address", font));
	        table.addCell(cell);
	              
	    }
	     
	    private void pdfBody(PdfPTable table) {
	        for (User user : listUsers) {
	        	table.addCell(String.valueOf(user.getUserId()));
	        	table.addCell(user.getUserName());
	            table.addCell(String.valueOf(user.getUserAge()));
	            table.addCell(user.getUserAddress());
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLACK);
	         
	        Paragraph p = new Paragraph("List of Users", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(4);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
	        table.setSpacingBefore(10);
	         
	        pdfHeader(table);
	        pdfBody(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
}
