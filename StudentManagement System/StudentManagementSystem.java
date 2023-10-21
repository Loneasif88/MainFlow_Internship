import java.util.*;

class Student{
    public int stdId;
    private String name;
    private String course;
    private double grades;
    private int attendance;

    // constructor
    Student(int stdId,String name, String course, double grades, int attendance){
        this.stdId = stdId;
        this.name = name;
        this.course = course;
        this.grades = grades;
        this.attendance = attendance;
    }
    // getter Methods
    public int getStdId(){
        return stdId;
    }
    public String getName(){
        return name;
    }
     public String getCourse() {
        return course;
    }

    public double getGrades() {
        return grades;
    }

    public int getAttendance() {
        return attendance;
    }

    // setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGrades(double grades) {
        this.grades = grades;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

}
class StudentManagementSystem{
    public static void main(String[] args){
        ArrayList<Student> std = new ArrayList<>();
        Set<Integer> studentId = new HashSet<>();  // storing Unique id's
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter Your choice \n 1. Add Student \n 2. Update Student \n 3. Delete Student \n 4. Show Students Details \n 5. Exit \n");
            int choice = sc.nextInt();
            // use swith Cases
            switch(choice){
                case 1: addStudent(std,studentId,sc);
                        break;
                case 2: updateStudent(std,sc);
                        break;
                case 3: deleteStudent(std,sc);
                        break;
                case 4: showStudentDetails(std);
                        break;
                case 5: System.out.println("|-------------------------------------|"); 
                        System.out.println("|           You have Exited...        |");
                        System.out.println("|-------------------------------------|");
                        System.exit(0);
                        break;
                default: 
                        System.out.println("|-------------------------------------|"); 
                        System.out.println("|    Oops! You Entered wrong input..  |");
                        System.out.println("|-------------------------------------|");
                        break;
            }
        }
        
    }

    public static void addStudent(ArrayList<Student> std, Set<Integer> studentId, Scanner sc){
        System.out.println("Enter Student ID");
        int id = sc.nextInt();
        sc.nextLine();
        // check for studentId if its already present or not
        if(studentId.contains(id)){
            System.out.println("|---------------------------------------------------|"); 
            System.out.println("| Studend Id = "+id+" already Present, try different ID |");
            System.out.println("|---------------------------------------------------|");
            return;
        }

        System.out.println("Enter Name");
        String name = sc.nextLine();

        System.out.println("Enter Course");
        String course = sc.nextLine();

        System.out.println("Enter Grades");
        double grades = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter attendence percentage(%)");
        int attd = sc.nextInt();
        sc.nextLine();

        Student st = new Student(id, name, course, grades, attd);
        std.add(st);
        studentId.add(id);
        System.out.println("|-------------------------------------|"); 
        System.out.println("|     Student Added Successfully..!   |");
        System.out.println("|-------------------------------------|");

    }
    public static void updateStudent(ArrayList<Student> std, Scanner sc){
        System.out.println("|Enter Student ID for Updation |");
        System.out.println("|------------------------------|");
        int id = sc.nextInt();
        sc.nextLine();

        boolean studentFound = false;
        for(Student st: std){
            if(st.stdId == id){
                System.out.println("Enter new Name");
                String name = sc.nextLine();

                System.out.println("Enter new course");
                String course = sc.nextLine();

                System.out.println("Enter new Grades");
                double grades = sc.nextDouble();

                System.out.println("Enter new Attendance(%)");
                int attendance = sc.nextInt();

                st.setName(name);
                st.setCourse(course);
                st.setGrades(grades);
                st.setAttendance(attendance);
                
                studentFound = true;
                System.out.println("|-------------------------------------|"); 
                System.out.println("|    Student Updated Successfully..!  |");
                System.out.println("|-------------------------------------|");
                break;
            }
        }
        if(!studentFound){
            System.out.println("|-------------------------------------|"); 
            System.out.println("| Student not found with ID : "+id+"  |");
            System.out.println("|-------------------------------------|");
        }

    }
    public static void deleteStudent(ArrayList<Student> std, Scanner sc){
        System.out.println("| Enter Student ID for Deletion  |");
        System.out.println("|--------------------------------|");
        int id = sc.nextInt();
        Iterator<Student> it = std.iterator();
        while(it.hasNext()){
            Student st = it.next();
            if(st.stdId == id){
                it.remove();
                System.out.println("|-------------------------------------|"); 
                System.out.println("|    Student Removed Successfully..!  |");
                System.out.println("|-------------------------------------|");
                return;
            }
        }
        System.out.println("|-------------------------------------|"); 
        System.out.println("| Student not found with ID : "+id+"  |");
        System.out.println("|-------------------------------------|");
    }
    public static void showStudentDetails(ArrayList<Student> std){
        if(std.isEmpty()){
        System.out.println("|-------------------------------------|"); 
        System.out.println("|           No Data Found            |");
        System.out.println("|-------------------------------------|");
        }
        else{
            System.out.println("Students Details...");
            System.out.println("|-------------------------------------|"); 
            System.out.println("|           Students Details          |");
            System.out.println("|-------------------------------------|");
            for(Student st: std){
                System.out.println("| Student ID :  " +  st.getStdId());
                System.out.println("|-------------------------------------|");
                System.out.println("| Name       :  " + st.getName());
                System.out.println("|-------------------------------------|");
                System.out.println("| Course:    :  " + st.getCourse());
                System.out.println("|-------------------------------------|");
                System.out.println("| Grades:    :  " + st.getGrades());
                System.out.println("|-------------------------------------|");
                System.out.println("| Attendance :  " + st.getAttendance() + "%");
                System.out.println("|-------------------------------------|");
                System.out.println("|=====================================|");
                System.out.println();
            }
        }
        
    }
}