package com.als;
import java.util.ArrayList;
import java.util.List;


import com.aspose.pdf.Document;
import com.aspose.pdf.optimization.OptimizationOptions;

public class compress_pdf_files {
    public void compressPDF() throws Exception{
        pdfDoc pdfLoader = new pdfDoc();
        String src = pdfLoader.loadPdfRessource();
        
        Document CompressPdfDoc = new Document(src);

        OptimizationOptions PdfoptOpt = new OptimizationOptions();

        PdfoptOpt.getImageCompressionOptions().setCompressImages(true);

        PdfoptOpt.getImageCompressionOptions().setImageQuality(50);

        CompressPdfDoc.optimizeResources(PdfoptOpt);

        CompressPdfDoc.save(src+"compressed.pdf");
        System.out.println(src+"compressed.pdf");
        CompressPdfDoc.close();
    }

    public void compressFolderPdfFiles() throws Exception{
        

        pdfDoc folderLoader = new pdfDoc();
        
        List<String> src = folderLoader.getFolderFiles();
        List<Document> CompressFolderPdf = new ArrayList<>();
        for (int i = 0; i < src.size(); i++) {
            CompressFolderPdf.add(new Document(src.get(i)));

            OptimizationOptions PdfoptOpt = new OptimizationOptions();

            PdfoptOpt.getImageCompressionOptions().setCompressImages(true);

            PdfoptOpt.getImageCompressionOptions().setImageQuality(75);

            CompressFolderPdf.get(i).optimizeResources(PdfoptOpt);

            CompressFolderPdf.get(i).save(src.get(i)+"compressed.pdf");
            System.out.println(src.get(i)+"compressed.pdf");

        }
    }
    
}
