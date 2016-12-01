/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekautil;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
public final class Analyzer {
    
    DataSource objDataSource;
    Instances objInstance;
    /*private double valorEsperado;
    private double[] FunctDistribChiCuad005;*/
    
    public Analyzer(String path){
        this.objDataSource = null;
        this.objInstance = null;
        DataSourceObj(path);
        InstanceObj(this.objDataSource);
    }
    
    
    private void DataSourceObj(String path){
        try{
            this.objDataSource = new DataSource(path);
        }catch(Exception e){
            System.out.println("Error en: wekautil.Analyzer.DataSourceObj()");
        }        
    }
    
    private void InstanceObj(DataSource dataSource){        
        try {
            this.objInstance = (Instances) dataSource.getDataSet();
        } catch (Exception ex) {
            System.out.println("Error en: wekautil.Analyzer.InstanceObj()");
        }
    }
    
    public int getNumAtrib(){
        return this.objInstance.numAttributes();
    }
    
    public int getNumInstancias(){
        return this.objInstance.numInstances();
    }
    
    /*cases:
    1.Nominal
    2.Numerico
    3.String
    */
    public int getCantAtrbSpec(int caseVal){
        int result = 0;
        for (int i=0;i<this.objInstance.numAttributes();i++)
            switch(caseVal){
                case 1:
                    if(this.objInstance.attribute(i).isNominal())
                        result ++;
                    break;
                case 2:
                    if(this.objInstance.attribute(i).isNumeric())
                        result ++;
                    break;
                case 3:
                    if(this.objInstance.attribute(i).isString())
                        result ++;
                    break;
                default:
                    break;
            }                    
        return result;
    }
    
    public int getNumClasses(){
        return this.objInstance.numClasses();
    }
    
    /*cases:
    1.Nominal
    2.Numerico
    */
    public int getCantValoresNullSpec(int caseVal){
        int result = 0;
        for (int i=0;i<this.objInstance.numAttributes();i++)
            for(int j=0;j<this.objInstance.numInstances();j++){
                if(this.objInstance.instance(j).isMissing(i))
                switch(caseVal){
                    case 1:
                        if(this.objInstance.attribute(i).isNominal())
                            result ++;
                        break;
                    case 2:
                        if(this.objInstance.attribute(i).isNumeric())
                            result ++;
                        break;
                    default:
                        break;
                }
            }                    
        return result;
    }
    
    /*cases:
    1.Nominal
    2.Numerico
    */
    public double getAttributesTypePercentage(int caseVal){
        double percentage = 0;
        int numAttributes = this.objInstance.numAttributes();
        switch(caseVal){
            case 1:
                percentage = (getCantAtrbSpec(1)/(double)numAttributes)*100;
                break;
            case 2:
                percentage = (getCantAtrbSpec(2)/(double)numAttributes)*100;
                break;
            default:
                break;
        }    
        return percentage;
    }
    
    public String caracterizeFont(double nominal,double numeric){
        String response = "Nominal-Numeric";
        if(nominal<numeric){
            response = "Numeric";
        }else if(nominal>numeric)
        {
            response = "Nominal";
        }
        return response;
    }
    

    /*private Map<Double, Integer> getFrequencies(double[] nums) {
        double cantidadtotal = 0;
        Map<Double, Integer> freqs = new HashMap<Double, Integer>();
        for (double x : nums) {
            cantidadtotal = cantidadtotal + x;
            if (freqs.containsKey(x)) {
                freqs.put(x, freqs.get(x) + 1);
            } else {
                freqs.put(x, 1);
            }
        }
        valorEsperado = cantidadtotal / nums.length;
        return freqs;
    }

    private boolean Balanced(double[] randomNums) {
        Map<Double, Integer> ht = getFrequencies(randomNums);
        double chiSquare1 = 0;
        for (double v : ht.values()) {
            double f1 = v - valorEsperado;
            chiSquare1 += f1 * f1;
        }
        chiSquare1 /= valorEsperado;
        int GradosLibertad = randomNums.length - 1;
        if (chiSquare1 < FunctDistribChiCuad005[GradosLibertad + 1]) {
            return true;
        } else {
            return false;
        }
    }*/
    
}
