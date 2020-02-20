import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
public class ListOfthem{

   public static void main(String[] args){ 
      Scanner num = new Scanner(System.in);//this one is for number
      Scanner num2 = new Scanner(System.in);//this is anotehr one for number
      Scanner string = new Scanner(System.in);//this one is fro string
      boolean menu = true;
      
      while(menu){
         ArrayList<Student> stu = new ArrayList<Student>();
         ArrayList<Course> cour = new ArrayList<Course>();
         ArrayList<Registration> res = new ArrayList<Registration>();         
         Course newcour = new Course();
         Student newstu = new Student();
         Registration newres = new Registration();
         
         //print the menu
         System.out.println("Enter 1 for adding student");
         System.out.println("Enter 2 for adding course");
         System.out.println("Enter 3 for adding registration");
         System.out.println("Enter 4 for printing all Students that are registered for a Course");
         System.out.println("Enter 5 for printing all the Courses a Student is registered for");
         System.out.println("Enter 6 for deleted registration");
         System.out.println("Enter 7 for exiting");
         
         int a = num.nextInt();
         
         switch(a){
         
         case 1: //option 1 adding students
            System.out.println("Please enter student name");
            String enterStuName = string.nextLine();      
            System.out.println("Please enter student ID");
            String enterStuID = num.nextLine();
           
            for(int i = 0; i < stu.size();i++){
               if((enterStuName == stu.get(i).getStuName())&&(enterStuID == stu.get(i).getStuID())){
               System.out.println("Error");}
               else{
               newstu.setStuName(enterStuName);
               newstu.setStuID(enterStuID);
               stu.add(newstu);
               System.out.println("Success");}
            } 
            break;
         
         case 2://option 2 adding courses, same logic with option 1
            System.out.println("Please enter course name");
            String enterCourName = string.nextLine();      
            System.out.println("Please enter course ID");
            String enterCourID = num.nextLine(); 
            
            
            for(int y = 0; y < cour.size();y++){
               if((enterCourName == cour.get(y).getCourName())&&(enterCourID == cour.get(y).getCourID())){
               System.out.println("Error");}
               else{
               newcour.setCourName(enterCourName);
               newcour.setCourID(enterCourID);
               cour.add(newcour);
               System.out.println("Success");}
            } 
            break;
         
         case 3://option 3 adding resgistration
            System.out.println("Please enter student ID");
            String enterResSID = num.nextLine();      
            System.out.println("Please enter course ID");
            String enterResCID = num2.nextLine();
 
            for(int x = 0; x < res.size(); x++){
               if((enterResSID == stu.get(x).getStuName())&&(enterResCID == cour.get(x).getCourID())){// exam whether they exist in their respective lists
               String enterResName = stu.get(x).getStuName();//using student list to convert student ID to student name
               newres.setResName(enterResName);
               newres.setResID(enterResCID);
               res.add(newres);
               System.out.println("Success");}
            }   
            break;
            
         case 4://option 4  printing all students for a course  
            System.out.println("Please enter course ID");
            String enterCID = num.nextLine();
            
            for(int o = 0; o < cour.size(); o++){
                  if(enterCID == cour.get(o).getCourID()){//exam whether it exist in course list
                     enterCID = cour.get(o).getCourID();
                     for(int u = 0; u < res.size(); u++){
                           if(enterCID == res.get(u).getResID()){//exam whether it exist in registration list
                           String allstuName = res.get(u).getResName();//using registration list to find student name
                           System.out.print(allstuName);}
                     }
                  }
                  else{System.out.println("Error");}// if it is not in the course list, the error message shows
             }
             break;
             
         case 5://option 5 printing all courses that a student register for
            System.out.println("Please enter student ID");
            String enterSID = num2.nextLine();
            
            for(int p = 0; p < stu.size(); p++){
               if(enterSID == stu.get(p).getStuID()){//exam whether it exist in respective list
                  String enterSName = stu.get(p).getStuName();
                  for(int v = 0; v < res.size(); v++){
                     if(enterSName == res.get(v).getResName()){//using registration list to find course ID
                        enterCID = res.get(v).getResID(); 
                        for(int b = 0; b < res.size(); b++){
                           if(enterCID == cour.get(b).getCourID()){
                           String allcourName = cour.get(b).getCourName();//using course list to find course name
                           System.out.print(allcourName);}
                        }
                     }
                  }
                }
               else{System.out.println("Error");}//if it is not in the student list, the error message shows
             }
             break;
          
          case 6://option 6 deleting registration
            System.out.println("Please enter student ID");
            enterSID = num.nextLine();      
            System.out.println("Please enter course ID");
            enterResCID = num2.nextLine();
            
            for(int d = 0; d < res.size(); d++){
               if(stu.get(d).getStuID() == enterSID){
                  String resStuName = stu.get(d).getStuName();// using7 student list to find the student name
                     for(int f = 0; f < res.size(); f++){
                        if((res.get(f).getResName() == resStuName)&&(res.get(f).getResID() == enterResCID)){//exam whether it matches in the registration list
                           res.remove(d);
                           System.out.println("Success");}
                         else{System.out.println("Error");}//if it is not in the registration list, the error message shows
                     }
                }
             } 
            break;   
             
          case 7://option 7 exiting
          System.exit(0);
          break;
         default:} 
      }
   }
}
      
      
         
   
                      

   
   




