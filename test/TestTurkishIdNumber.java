public class TestTurkishIdNumber {
    public static void main(String[] args) {
        
        // Create a new instance
        try{
            TurkishIdNumber tid = new TurkishIdNumber("10000000146");
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        
        // Change the value of existing instance
        try{
            TurkishIdNumber tid = new TurkishIdNumber("10000000146");
            tid.setValue("10000000140");
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        
        // Validate a value using isValid method
        if(TurkishIdNumber.isValid("10000000146")){
            System.out.println("The number is valid.");
        }
        
        // Generate random numbers
        for(int i = 0; i < 100; i++){
            System.out.println(TurkishIdNumber.generate());
        }
  
    }
}
