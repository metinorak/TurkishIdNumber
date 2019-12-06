public class TurkishIdNumber {
    private final static int length = 11;
    private String value;
    
    public TurkishIdNumber(String value) throws IllegalArgumentException{
        this.setValue(value);
    }

    public String toString(){
        return this.value;
    }
    
    public static void main(String[] args) {
        TurkishIdNumber tid = null;
        try{
            tid = new TurkishIdNumber("10000000146");
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        
        try{
            tid.setValue("10000000140");
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    
    public void setValue(String value) throws IllegalArgumentException{
        if(!isValid(value)){
            throw new IllegalArgumentException("Invalid Turkish Id Number");
        }
        else{
            this.value = value;
        }
    }
    
    public static boolean isValid(String value){
        if(!isNumeric(value)){
            return false;
        }
        if(value.charAt(0) == '0'){
            return false;
        }
        
        int first_sum = 0;
        int second_sum = 0;

        for(int i = 0; i < 4; i++){
            first_sum += getDigit(value, i * 2);
            second_sum += getDigit(value, i * 2 + 1);
        }
        first_sum += getDigit(value, 8);
        
        int n = 7 * first_sum - second_sum;
        
        if(n < 0){
            n += 10;
        }

        if(n % 10 != getDigit(value, 9)){
            return false;
        }

        int first_ten_sum = first_sum + second_sum + getDigit(value, 9);

        return first_ten_sum % 10 == getDigit(value, 10);
    }
    
    private static short getDigit(String value, int index){
        return Short.parseShort(new String(new char[]{value.charAt(index)}));
    }
    
    private static boolean isNumeric(String value){
        if(value == null || value.length() != length){
            return false;
        }
        for(char c: value.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
    
}
