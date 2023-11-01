package com.als;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println("========================PDF TOOLS===========================");
        System.out.println("please choose a tool and enter the number");
        System.out.println("1. Compress single pdf file");
        System.out.println("2. Compress multiple pdf files(folder)");
        System.out.println("3. convert pdf file to docx");
        Scanner inputChoice  = new Scanner(System.in); 
        int choice = inputChoice.nextInt();
        compress_pdf_files pdfCompressed = new compress_pdf_files();
        pdf_to_word convertPDFtoWORD = new pdf_to_word();
        switch (choice) {
            case 1:
                pdfCompressed.compressPDF();
                break;
            case 2:
                pdfCompressed.compressFolderPdfFiles();
                break;
            case 3:
                convertPDFtoWORD.ConvertPDFtoWORD();
                break;
            default:
                System.out.println("please restart application and choose a right choice !");
                break;
        }
        inputChoice.close();

    }

}
