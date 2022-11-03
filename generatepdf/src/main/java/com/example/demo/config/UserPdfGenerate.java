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
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

public class UserPdfGenerate {
	
	private List<User> listUsers;
	
	

	public UserPdfGenerate(List<User> listUsers) {
		super();
		this.listUsers = listUsers;
	}

	private void pdfHeader(PdfPTable pdftable) {
		PdfPCell cell=new PdfPCell();
		cell.setBackgroundColor(Color.black);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(Color.GRAY);
		
		cell.setPhrase(new Phrase("userId",font));
		pdftable.addCell(cell);
		
		cell.setPhrase(new Phrase("userName", font));
		pdftable.addCell(cell);
		
		cell.setPhrase(new Phrase("userAdd", font));
		pdftable.addCell(cell);
		
		cell.setPhrase(new Phrase("userAge", font));
		pdftable.addCell(cell);
		
		cell.setPhrase(new Phrase("userCity", font));
		pdftable.addCell(cell);
		
	}
	
	private void pdfBody(PdfPTable table) {
		for(User user:listUsers) {
			table.addCell(String.valueOf(user.getUserId()));
			table.addCell(user.getUserName());
			table.addCell(user.getUserCity());
			table.addCell(String.valueOf(user.getUserAge()));
			table.addCell(user.getUserAdd());
			
		}
	}
    public void export(HttpServletResponse response)throws DocumentException,IOException{
    Document document=new Document(PageSize.A4);
    PdfWriter.getInstance(document, response.getOutputStream());
    document.open();
    Font font=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
    font.setSize(18);
    font.setColor(Color.black);
    
    Paragraph p= new Paragraph("list of users",font);
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