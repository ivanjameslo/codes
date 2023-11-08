package Lo;

public class Subject {
    
    private final String subjectCode;
    private final int creditUnits;
        
    public Subject(String subjectCode, int creditUnits){
            this.subjectCode = subjectCode;
            this.creditUnits = creditUnits;
    }
        
    public String getSubjectCode(){
        return subjectCode;
    }
    
    public int getCreditUnits(){
        return creditUnits;
    }
   
}
