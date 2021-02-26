
package searchtutor;
public class Student {
    private String name = "";
    private String address= "";
    private Integer cls = 0;
    private String searchrequriment="";

    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setCls(Integer cls){
        this.cls = cls;
    }
    public void setSearchrequriment(String searchrequriment){
        this.searchrequriment = searchrequriment;
    }

    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public Integer getCls(){
        return this.cls;
    }
    public String  getSearchRequriment(){
        return this.searchrequriment;
    }
}
