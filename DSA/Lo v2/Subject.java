public class Subject{

    private String subjectCode;
    private int creditUnits;

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