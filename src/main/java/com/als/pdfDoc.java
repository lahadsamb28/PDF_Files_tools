package com.als;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pdfDoc {
    // get size file 
    private static double getSizeFile(File file){
        return (double) file.length() / (1024);
    }
    
    // load ressource file
    public String loadPdfRessource() {

            System.out.println("write the absolute name of pdf file");
            Scanner inp = new Scanner(System.in);
            String pdfName;
            String ext = "pdf";
            while(true){
                String pdfSrc = inp.nextLine();
                File source = new File(pdfSrc);
                // File[] filesSrc;
                if(source.exists() && source.isFile() && !source.isDirectory()){
                    pdfName = source.getAbsolutePath();
                    if(pdfName.substring(pdfName.lastIndexOf(".")+1).equalsIgnoreCase(ext) ){
                        System.out.println("file found");
                        break;
                    }
                }
                System.out.println("write the absolute name of pdf file");
            }
            inp.close();
            return pdfName;

    }

    public List<String> getFolderFiles(){
        System.out.println("write the absolute name of folder");
        Scanner inp = new Scanner(System.in);
        String ext = "pdf";
        List<String> pdfNames = new ArrayList<String>();
        String folderPath = inp.nextLine();
        File folderSrc = new File(folderPath);
        File[] folderFiles = folderSrc.listFiles();
        for(int i = 0 ; i < folderFiles.length; i++){
            if(folderFiles[i].isFile()){
                pdfNames.add(folderFiles[i].getAbsolutePath());
                if(pdfNames.get(i).substring(pdfNames.get(i).lastIndexOf(".")+1).equalsIgnoreCase(ext) && getSizeFile(folderFiles[i]) >= 490){
                    System.out.println(pdfNames.get(i)+" found");
                }
            }
        }
        inp.close();
        return pdfNames;
    }

}
