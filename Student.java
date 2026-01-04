import java.util.*;

class Stud{
    int rollNo;
    String name;
    int[] marks = new int[5];

    //to calculate total
    int calculateTotal(){
        int sum = 0;
        for(int i =0 ;i <5;i++){
            sum +=marks[i];
        }
        return sum;
    }
    //to find average
    double calculateAverage(){
        return calculateTotal() / 5.0;
    }
    //to find grade
    String calculateGrade(){
        double average = calculateAverage();

        if (average  >=90)
            return "Grade A";
        else if(average  >=75)
            return "Grade B";
        else if(average  >=60)
            return "Grade C";
        
        else if(average  >=45)
            return "Grade D";
        
        else
            return "Fail";
          
    }
    //To display
    void display(){
        System.out.println("\n -----Student Report-----");
        System.out.println(" Roll number " + rollNo);
        System.out.println(" Name " + name);
        System.out.println(" Total " + calculateTotal());
        System.out.println(" Average " + calculateAverage());
        System.out.println(" Grade " + calculateGrade());
    }
}
public class Student{
    static Stud[] students = new Stud[10];
    static int count = 0;
    public static void main(String[]  args)
    {
        Scanner std = new Scanner(System.in);
        
        //Main add display  part
        while(true){
            System.out.println("-\n---Student Management System-----");
            System.out.println("1.Add Student");
            System.out.println("2.Display Student");
            System.out.println("3.Exit");
            System.out.println("Enter Choice");

            int choice = std.nextInt();

            switch(choice){
                case 1:
                    addStudent(std);
                    break;
                case 2:
                    displayStudent(std);
                    break;
                case 3:
                    System.out.println("Exiting Program.....");
                    std.close();
                    return;
                default:
                    System.out.println("Invalid choice!..");
            }
        }
    }
    //adding student information
    static void addStudent(Scanner std){
        students[count] = new Stud(); 
        System.out.println("Enter Roll Number:");
        students[count].rollNo = std.nextInt();
    
        System.out.println("Enter Name:");
        students[count].name = std.next();
        System.out.println("Enter Marks of 5 subjects:");
        for (int i=0;i<5;i++){
            students[count].marks[i]= std.nextInt();
        }
    
        count++;
        System.out.println("Student added Successfully!....");
    }
        
    static void displayStudent(Scanner std){
        System.out.println("Enter Roll number to search: ");
        int r = std.nextInt();
        boolean found = false;

        for (int i =0 ;i< count; i++){
            if(students[i].rollNo == r){
                
                students[i].display();
                found = true;
                break;
                
            }
            
        }
        if(!found){
            System.out.println(" Student Not Found... " );
        }
        
    }
        
}