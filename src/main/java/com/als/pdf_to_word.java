package com.als;

import com.aspose.pdf.DocSaveOptions;
import com.aspose.pdf.Document;

public class pdf_to_word {

    public void ConvertPDFtoWORD() {
        pdfDoc pdfSrc = new pdfDoc();
        String pdfFile = pdfSrc.loadPdfRessource();
        Document pdfDocument = new Document(pdfFile);

        DocSaveOptions saveOptions = new DocSaveOptions();

        // specify output format as DOC
        saveOptions.setFormat(DocSaveOptions.DocFormat.DocX);
        // set the recognition mode as flow can allow to easily edit the doc
        saveOptions.setMode(DocSaveOptions.RecognitionMode.Textbox);
        // set the horizontal proximity: this property control the caractere and font size in resume
        saveOptions.setRelativeHorizontalProximity(2.5f);
        // enable the value to recognize bullets during conversion process
        saveOptions.setRecognizeBullets(true);
        //name of new file
        String newDoc = pdfFile.replace(pdfFile.substring(pdfFile.lastIndexOf(".")+1), "docx");

        pdfDocument.save(newDoc, saveOptions);
        System.out.println(pdfFile);
        System.out.println("to");
        System.out.println(newDoc);
        System.out.println("document converted successfully !");
        pdfDocument.close();

    }
}