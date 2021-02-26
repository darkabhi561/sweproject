package searchtutor.tutormanager;
public class Tutor {
    private String name = "";
    private String address= "";
    private String qualification = "";
    private String subjectprefer="";
    private Integer fees=0;

    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setQualification(String qualification){
        this.qualification = qualification;
    }
    public void setSubjectPrefer(String subjectprefer){
        this.subjectprefer = subjectprefer;
    }
    public void setFees(Integer fees){
        this.fees = fees;
    }

    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public String getQualification(){
        return this.qualification;
    }
    public String getSubjectPrefer(){
        return this.subjectprefer;
    }
    public Integer getFees(){
        return this.fees;
    }

    public String displayString(){
        String res = "Name: " + name +  "\nAddress:" + address + "\nQualification:" + qualification +"\nSubjectPrefer:"+ subjectprefer+"\nfees:"+  String.valueOf(fees);
         return res;
    }

    public String toString(){
        String res = name + "|" + address + "|" + qualification + "|" + subjectprefer + "|"+ String.valueOf(fees)+ "\n";
        return res;
    }
}
