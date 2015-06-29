package com.dreamteam.model;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by Wojtek on 2015-06-28.
 */

public class PDFGenerator {

    private OutputStream file;
    private Document document;

    public PDFGenerator(Recipe recipe) {

            try {
                this.file = new FileOutputStream(new File("Test.pdf"));
                this.document = new Document();
                PdfWriter.getInstance(this.document, this.file);

                this.document.open();
                this.document.add(new Paragraph("Hello World, iText"));
                this.document.close();
                this.file.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}