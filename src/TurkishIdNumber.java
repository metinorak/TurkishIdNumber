public class TurkishIdNumber {
    private final static int length = 11;
    private String value;
    
    public TurkishIdNumber(String value) throws IllegalArgumentException{
        this.setValue(value);
    }

    public String toString(){
        return this.value;
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
        
        int firstSum = 0;
        int secondSum = 0;

        for(int i = 0; i < 4; i++){
            firstSum += getDigit(value, i * 2);
            secondSum += getDigit(value, i * 2 + 1);
        }
        firstSum += getDigit(value, 8);
        
        int checkSum = (7 * firstSum - secondSum) % 10;
        
        if(checkSum < 0){
            checkSum += 10;
        }

        if(checkSum != getDigit(value, 9)){
            return false;
        }

        int firstTenSum = firstSum + secondSum + getDigit(value, 9);

        return firstTenSum % 10 == getDigit(value, 10);
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
