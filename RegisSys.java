import java.util.*;
class Student {
    
    //
    private String fname;
    private String lname;
    private int id;
    private String address;
    private String program;
    private char gender;

    Student(){}
    Student(int id, String fname, String lname, char gender, String program, String address) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.program = program;
        this.address= address;
    }

    public void setName(String fname) {
        this.fname = fname;
    }
    public String getFName() {
        return fname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getLname() {
        return lname;
    }
    public void setAddress(String address) {
        this.address= address;
    }
    public String getAddress() {
        return address;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public char getGender() {
        return gender;
    }
    public void setProgram(String program) {
        this.program = program;
    }
    public String getProgram() {
        return program;
    }

    @Override
    public String toString() {
  
        return String.format("%12d%16s%15s%12c%12s%20s",id, fname, lname, gender, program, address);
    }
    public void addStudent(int id, String fname, String lname, char gender, String address, String program) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.address= address;
        this.program = program;
    }

}

public class RegisSys {

    public static void main(String[] args) {

        List<Student> c = new ArrayList<Student>();
        int choice;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        

        do {
            System.out.println();
            System.out.println(" UNIVERSITY MALAYSIA SABAH ");
            System.out.println("STUDENT REGISTRATION SYSTEM");
            System.out.println("----------------------------");
            System.out.println("Choose Your Operataion (1-6)");
            System.out.println("1. ADD STUDENT"); 
            System.out.println("2. DELETE STUDENT"); //enter student id and then use delete method in Student class to delete
            System.out.println("3. UPDATE STUDENT"); //enter student id and then use edit method in Student class to edit
            System.out.println("4. SEARCH STUDENT"); //enter student id and then use print method in Student class to print
            System.out.println("5. DISPLAY ALL STUDENTS");
            System.out.println("6. EXIT\n");
            System.out.print("OPERATION CHOSEN: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Matric Id : ");
                    int matricId = scanner.nextInt();
                    System.out.print("Enter Student First Name : ");
                    String fname = scanner.next();
                    System.out.print("Enter Student Last Name : ");
                    String lname = scanner.next();
                    System.out.print("Enter Student Gender (F) or (M) : ");
                    char gender = scanner.next().charAt(0);
                    System.out.print("Enter Student Program : ");
                    String program = scanner.next();
                    scanner.nextLine();
                    System.out.print("Enter Student Address : ");
                    String address = scanner.nextLine();

                    c.add(new Student(matricId, fname, lname, gender, program, address));
                    break;
                case 2:
                    boolean found = false;
                    System.out.print("Enter Student Matric Id to Delete: ");
                    matricId = scanner.nextInt();
                    System.out.println("------------------------------------------------------------");
                    Iterator<Student> i = c.iterator();
                    while(i.hasNext()) {
                        Student s = i.next();
                        if(s.getId() == matricId) {
                            i.remove();
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("Record Not Found");
                    }
                    else {
                        System.out.println("Record is Deleted Successfully");
                    }
                    System.out.println("------------------------------------------------------------");
                    break;
                case 3:
                    found = false;
                    System.out.println("Enter Student Matric Id to Update : ");
                    matricId = scanner.nextInt();
                    System.out.println("--------------------------------------------------------------------------------");
                    ListIterator<Student> li = c.listIterator();
                    while(li.hasNext()) {
                        Student s = li.next();
                        if(s.getId() == matricId) {
                            System.out.print("Enter New Student First Name : ");
                            fname = scanner1.next();
                            System.out.print("Enter Student Last Name : ");
                            lname = scanner.next();
                            System.out.print("Enter Student Gender (F) or (M): ");
                            gender = scanner2.next().charAt(0);
                            System.out.print("Enter New Program : ");
                            program = scanner3.next();
                            scanner.nextLine();
                            System.out.print("Enter New Address : ");
                            address = scanner.nextLine();
                            li.set(new Student(matricId, fname, lname, gender, program, address));
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("Record Not Found");
                    }
                    else {
                        System.out.println("Record is Updated Successfully");
                    }
                    System.out.println("----------------------------------------------------------------------");
                    break;
                case 4:
                    found = false;
                    System.out.println("Enter Student Matric Id to Search : ");
                    matricId = scanner.nextInt();
                    System.out.println();
                    i = c.iterator();
                    while(i.hasNext()) {
                        Student s = i.next();
                        if(s.getId() == matricId) {
                            found = true;
                            System.out.println("--------------------------------------------------------------------------------");
                            System.out.printf("%12s%16s%15s%12s%12s%12s","MatricId", "First Name", "Last Name", "Gender", "Program", "Address");
                            System.out.println("\n--------------------------------------------------------------------------------");
                            System.out.println(s);
                        }
                    }

                    if(!found){
                        System.out.println("Record Not Found");
                    }
                    System.out.println("----------------------------------------------------------------------");
                    break;
                case 5:
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("Student Registration System - Display All Students");
                System.out.println("----------------------------------------------------------------------\n");
                System.out.printf("%12s%16s%15s%12s%12s%12s","MatricId", "First Name", "Last Name", "Gender", "Course", "Address");
                System.out.println("\n--------------------------------------------------------------------------------\n");
                    i = c.iterator();
                    while(i.hasNext()) {
                        Student s = i.next();
                        System.out.println(s);
                    }
                    System.out.println("---------------------------------------------------------------------------------");
                
                default:
                    break;
            }
        }while(choice!=6);
        
        scanner.close();
        scanner1.close();
        scanner2.close();
        scanner3.close();
    }
}
