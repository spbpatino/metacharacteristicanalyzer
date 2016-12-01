

package metacharacteristicanalyzer;
import entities.Metacharacteristic;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import utilities.*;
import wekautil.Analyzer;
public class Metacharacteristicanalyzer {
    public static void main(String[] args) {
        File[] pathsList = null;
        //String path = JOptionPane.showInputDialog("Ingrese el directorio de archivos a analizar");
        String path = "C:\\Users\\LinaMarcelaGarcia\\Desktop\\eliminar\\Laboratorio metacaracteristicas\\datasets";
        pathsList = Utilities.getFilesPath(path);
        if(pathsList != null){
            ArrayList<Metacharacteristic> metacharacteristicList = new ArrayList<Metacharacteristic>();
            for(int i=0; i<pathsList.length; i++){
                if(Utilities.checkArffFile(pathsList[i].getName())){
                    Analyzer objAnalyzer = new Analyzer(pathsList[i].getAbsolutePath());
                    Metacharacteristic metacharacteristic = new Metacharacteristic();
                    metacharacteristic.setFilename(pathsList[i].getName());
                    metacharacteristic.setNumAtrib(objAnalyzer.getNumAtrib());
                    metacharacteristic.setNumInstancias(objAnalyzer.getNumInstancias());
                    metacharacteristic.setCantAtrbNom(objAnalyzer.getCantAtrbSpec(1));
                    metacharacteristic.setCantAtrbNum(objAnalyzer.getCantAtrbSpec(2));
                    metacharacteristic.setCantAtbrStr(objAnalyzer.getCantAtrbSpec(3));
                    //numClasses estoy inseguro
                    //metacharacteristic.setNumClasses(objAnalyzer.getNumClasses());
                    metacharacteristic.setCantValoresNullNom(objAnalyzer.getCantValoresNullSpec(1));
                    metacharacteristic.setCantValoresNullNum(objAnalyzer.getCantValoresNullSpec(2));
                    metacharacteristic.setPercentageNominals(objAnalyzer.getAttributesTypePercentage(1));
                    metacharacteristic.setPercentageNumerics(objAnalyzer.getAttributesTypePercentage(2));
                    metacharacteristic.setCharacterization(objAnalyzer.caracterizeFont(metacharacteristic.getPercentageNominals(), 
                                                                                        metacharacteristic.getPercentageNumerics()));
                    metacharacteristicList.add(metacharacteristic);                    
                }                 
            }            
            for(Metacharacteristic objList : metacharacteristicList){
                System.out.println("----------------");
                System.out.println("Nombre: " + objList.getFilename());
                System.out.println("Numero atributos: " + objList.getNumAtrib());
                System.out.println("Numero instancias: " + objList.getNumInstancias());
                System.out.println("Cantidad nominales: " + objList.getCantAtrbNom());
                System.out.println("Cantidad numericos: " + objList.getCantAtrbNum());
                System.out.println("Cantidad de Strings: " + objList.getCantAtbrStr());
                System.out.println("Numero de Clases: " + objList.getNumClasses());
                System.out.println("Cantidad null nominales: " + objList.getCantValoresNullNom());
                System.out.println("Cantidad null numericos: " + objList.getCantValoresNullNum());
                System.out.println("Porcentaje nominal: " + objList.getPercentageNominals());
                System.out.println("Porcentaje numerico: " + objList.getPercentageNumerics());
                System.out.println("Fuente de datos: " + objList.getCharacterization());
                System.out.println("----------------");
            }            
        }else{
            JOptionPane.showMessageDialog(null, "No se logró cargar el directorio");
        }
    }    
}
