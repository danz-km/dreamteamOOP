import java.util.*;

class Student{
    
    private int id;
    private String name;
    private String address;
    private String course;
    private char gender;

    //Constructor
    Student(int id, String name, String address, String course, char gender) {
        this.id = id;
        this.name = name;
        this.address= address;
        this.course = course;
        this.gender = gender;
    }
    //Creating getters
  
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
   
    public int getId() {
        return id;
    }
    
    public char getGender() {
        return gender;
    }
    
    public String getCourse() {
        return course;
    }

    //override
    public String toString(){
        return id+" "+name+" "+address+" "+" "+course+" "+gender;
    }
}

class RegisSys{
        public static void main(String[] args){

            //List
            List<Student> c = new ArrayList<Student>();
    
            Scanner s = new Scanner(System.in);
            Scanner s1 = new Scanner(System.in);
            Scanner s2 = new Scanner(System.in);
            Scanner s3 = new Scanner(System.in);
    
            int ch;
    
            // do while loop
            do{
                System.out.println("1. INSERT");
                System.out.println("2. DISPLAY");
                System.out.println("3. SEARCH");
                System.out.println("4. DELETE");
                System.out.println("5. UPDATE");
                System.out.println("Enter Your Choice: ");
                ch = s.nextInt();
    
                switch(ch){
                    case 1:
    
                    System.out.print("Enter Student ID: ");
                    int sId = s.nextInt();
    
                    System.out.print("Enter Student Name: ");
                    String name = s1.nextLine();
    
                    System.out.print("Enter Student Address: ");
                    String address = s2.nextLine();

                    System.out.print("Enter Student Course: ");
                    String course = s3.nextLine();

                    System.out.print("Enter Student Gender: ");
                    char gender = s.next().charAt(0);
    
                    c.add(new Student(sId, name, address, course, gender));
    
                    break;
    
                    case 2:
    
                    System.out.println("---------------------------------");
    
                    Iterator<Student> i = c.iterator();
                    
                    while(i.hasNext()){
                        Student p = i.next();
                        System.out.println(p);
                    }
                    System.out.println("---------------------------------");
    
                    break;
    
                    case 3:
                    
                    boolean found = false;
    
                    System.out.println("Enter Student Number to Search: ");
                    
                    int id = s.nextInt();
    
                    System.out.println("---------------------------------");
                    i = c.iterator();
                    
                    while(i.hasNext()){
                        Student p = i.next();
                        if(p.getId()==id){
                            System.out.println(p);
                            found = true;
                        }
                        
                    }
                    
                    if(!found){
                        System.out.println("Record Not Found");
                    }
    
                    System.out.println("---------------------------------");
                    break;
    
                    case 4:
    
                    found = false;
    
                    System.out.println("Enter Student Number to Delete: ");
                    id = s.nextInt();
    
                    System.out.println("---------------------------------");
                    i = c.iterator();
                    
                    while(i.hasNext()){
                        Student p = i.next();
                        if(p.getId()==id){
                            i.remove();
                            found = true;
                        }
                        
                    }
                    
                    if(!found){
                        System.out.println("Record Not Found");
                    }else{
                        System.out.println("Record is Deleted Successfully...!");
                    }
    
                    System.out.println("---------------------------------");
    
    
                    break;
    
                    case 5:
    
                    found = false;
    
                    System.out.println("Enter Student Number to Update: ");
                    id = s.nextInt();
    
                    System.out.println("---------------------------------");
                    ListIterator<Student> li = c.listIterator();
                    
    
                    while(li.hasNext()){
                        Student p = li.next();
                        if(p.getId()==id){
    
                            System.out.print("Enter New Student Name: ");
                            name = s1.nextLine();
    
                            System.out.print("Enter New Student Address: ");
                            address = s2.nextLine();

                            System.out.print("Enter New Student Course: ");
                            course = s3.nextLine();

                            System.out.print("Enter New Gender: ");
                            gender = s.next().charAt(0);
    
                            li.set(new Student(id, name, address, course, gender));
                            
                            found = true;
                        }
                        
                    }
                    
                    if(!found){
                        System.out.println("Record Not Found");
                    }else{
                        System.out.println("Record is Updated Successfully...!");
                    }
    
                    System.out.println("---------------------------------");
    
                    
                    break;
                }
    
            }while(ch!=0);
    }
}
