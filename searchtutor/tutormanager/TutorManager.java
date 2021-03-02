package searchtutor.tutormanager;
import java.io.*;
import java.util.*;
import searchtutor.Student;
public class TutorManager {
        private String fileName = "C:\\Users\\abhiboss\\Desktop\\tutorDb.txt";
        private List<Tutor> TutorList;
    
        public TutorManager(){
            this.TutorList = new ArrayList<Tutor>();
        }
    
        public List<Tutor> getTutors() {
            List<Tutor> result = null;
            result = Collections.unmodifiableList(this.TutorList);
            return result;
        }
    
        public boolean init(String fileName) {
            boolean result = false;
            BufferedReader bufReader = null;
            try {
                bufReader = new BufferedReader(new FileReader(fileName));
                StringTokenizer st = null;
                String oneLine = bufReader.readLine();
                oneLine = bufReader.readLine();
                Tutor myTutor = null;
                while(oneLine != null){
                    // System.out.println(oneLine);
                    st = new StringTokenizer(oneLine, "|");
                    myTutor = new Tutor();
                    if (st.countTokens() == 0){
                        break;
                    }
                    myTutor.setName(st.nextToken());
                    myTutor.setAddress(st.nextToken());
                    myTutor.setQualification(st.nextToken());
                    myTutor.setSubjectPrefer(st.nextToken());
                    myTutor.setFees(Integer.parseInt(st.nextToken()));
                    this.TutorList.add(myTutor);
                    oneLine = bufReader.readLine();
                    
                }
                bufReader.close();
                result = true;
                
            } catch (FileNotFoundException e) {
                    //do something clever with the exception
                    System.out.println("File Not Found");
            } catch (IOException e) {
                    //do something clever with the exception
                    System.out.println("IO Exception");              
            }
            return result;
        }
        
        boolean write(String fileName){
            boolean flag = false;
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(fileName));
                bw.write("name|address|qualification|subjectPrefer|fees\n");
                for(int i=0;i<this.TutorList.size();i++){
                    // System.out.println(this.TutorList.get(i).toString());
                    // bw.write(this.TutorList.get(i).toString());
                    bw.write(this.TutorList.get(i).toString());
                }
                flag = true;
                bw.close();
            } catch (IOException e) {
                System.out.println("Error Occurred." + e);
            }
            return flag;
        }
    
        public boolean addTutor(Tutor td){
            boolean flag = false;
            try{
                this.TutorList.add(td);
                write(this.fileName);
            }
            finally{
                flag = true;
            }
            return flag;
        }    
        
        public String displayTutor(Tutor td){
            for (int i=0;i<this.TutorList.size();i++){
                
                if (this.TutorList.get(i).getName().equals(td.getName())){
                    return this.TutorList.get(i).displayString();
                }
            }
            return "There is no Tutor data yet.";
        }
    
        public boolean updateTutor(Tutor td){
            boolean flag = false;
            for (int i=0;i<this.TutorList.size();i++){
                
                if (this.TutorList.get(i).getName().equals(td.getName())){
    
                    this.TutorList.get(i).setAddress(td.getAddress());
                    this.TutorList.get(i).setQualification(td.getQualification());
                    this.TutorList.get(i).setSubjectPrefer(td.getSubjectPrefer());
                    this.TutorList.get(i).setFees(td.getFees());
                    write(this.fileName);
                    flag = true;
                    break;
                }
            }
    
            return flag;
        }
    
        public boolean deleteTutor(Tutor td){
            boolean flag = false;
            for (int i=0;i<this.TutorList.size();i++){
                if (this.TutorList.get(i).getName().equals(td.getName())){
                    this.TutorList.remove(i);
                    write(this.fileName);
                    flag = true;
                    break;
                }
            }
            return flag;
        }
        
    
        
        public List<Tutor> matchTutor(Student s)
        {
            List<Tutor> result = new ArrayList<Tutor>();
            for(int i=0;i<this.TutorList.size();i++){
                if(this.TutorList.get(i).getSubjectPrefer().equals(s.getSearchRequriment()) && this.TutorList.get(i).getAddress().equals(s.getAddress())){
                    result.add(this.TutorList.get(i));
                }
            }

            System.out.println(result);
            return result;
        }

        public static void main(String[] args) throws IOException {
    
            // Instantiation of Tutor Manager
            TutorManager TM = new TutorManager();
    
            // Initialization of Tutor Manager ,i.e load data to the arrayList of tutor
            TM.init(TM.fileName);
    
            // Unit Testing
            assert(TM.getTutors().size()==13);
            assert(TM.TutorList.get(0).getName().equals("Tutor1"));
              

            //  Filter tutor for Student
            // Student s = new Student();
            // s.setName("Abhishek");
            // s.setAddress("Mumbai");
            // s.setCls(10);
            // s.setSearchrequriment("Chemistry");
            // TM.matchTutor(s);

            
            // Add Tutor of a user
            // Tutor td = new Tutor();
            // td.setName("Tutor14");
            // td.setAddress("Kolkata");
            // td.setQualification("BTech");
            // td.setSubjectPrefer("Math");
            // td.setFees(10000);
            // TM.addTutor(td);
    
            // Display Tutor of a user
            // Tutor td = new Tutor();
            // td.setName("Tutor11");
            // System.out.println(TM.displayTutor(td));
    
            // // Update Tutor of a user
            // Tutor td = new Tutor();
            // td.setName("Tutor10");
            // td.setAddress("Kolkata");
            // td.setQualification("MTech");
            // td.setSubjectPrefer("computerscience");
            // td.setFees(2000);
            // TM.updateTutor(td);
    
            // Delete Tutor of a user
            // Tutor td = new Tutor();
            // td.setName("Tutor13");
            // TM.deleteTutor(td);
            
            
             
        }
    }
