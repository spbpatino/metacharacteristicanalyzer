/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;
import java.io.File;
public class Utilities {
    
    public static File[] getFilesPath(String path){
        File[] listFiles = null;
        File folder = new File(path);
        if(folder.isDirectory()){
            listFiles = folder.listFiles();
        }
        return listFiles;
    }
    
    public static boolean checkArffFile(String file){
        String extension = file.substring(file.lastIndexOf(".")+1);
        return extension.equals("arff") ? true : false;
    }
    
}
