import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Task{
    String name;
    String description;
    LocalDate dueDate;

    Task(String name, String desc, LocalDate dueDate){
        this.name = name;
        this.description = desc;
        this.dueDate = dueDate;
    }

}
class TaskManagementSystem{
    public static void main(String args[]){
        ArrayList<Task> task = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // while loop to continue untill you want to exit
        while(true){
        System.out.println("Enter Your choice \n 1. Add Task \n 2. Delete Task \n 3. List Tasks \n 4. Exit");
        int choice = sc.nextInt();
        sc.nextLine();
            // use switch case for displaying multiplr options
            switch(choice){
                case 1: addTask(sc,task);
                break;
                case 2: removeTask(sc,task);
                break;
                case 3: listTasks(task);
                break;
                case 4: System.exit(0);
                break;
                default:
                    System.out.println("|-------------------------------------"); 
                    System.out.println("|      You Entered Wrong choice       |");
                    System.out.println("|-------------------------------------");
                break;
            }
        }
        
    }
    public static void addTask(Scanner sc, ArrayList<Task> task){
            System.out.print("Enter Name of the Task\n");
            String name = sc.nextLine();
            System.out.print("Enter Description \n");
            String desc = sc.nextLine();
            //sc.nextLine();
            System.out.print("Enter Due Date YYYY-MM-DD\n");
                String dueDateStr = sc.nextLine();
            try{
                
                LocalDate dueDate = LocalDate.parse(dueDateStr, DateTimeFormatter.ISO_DATE);  
                 
                Task t1 = new Task(name, desc, dueDate);
                task.add(t1);  
                System.out.println("|-------------------------------------"); 
                System.out.println("|      Task Added Successfully...     |");
                System.out.println("|-------------------------------------"); 
            }
            catch(DateTimeException e){
                System.out.println("Invalid Date Format -> Use [YYYY-MM-DD] this format");
                System.out.println(e.getMessage());

            }
            
           
           
    }
    public static void removeTask( Scanner sc, ArrayList<Task> task){
        System.out.println("Enter Task Name to Remove :");
        String removeName = sc.nextLine();
        Iterator<Task> t = task.iterator();
        while(t.hasNext()){
            Task t1= t.next();
            if(t1.name.equals(removeName)){
                t.remove();
                System.out.println("|-------------------------------------");
                System.out.println("|    Task Removed Successfully...     |");
                System.out.println("|-------------------------------------");
                return;
            } 
        }
        System.out.println("|-------------------------------------");
        System.out.println("|   No Task found of this name...     |");
        System.out.println("|-------------------------------------");
    }
    public static void listTasks(ArrayList<Task> task){
        //int len = task.size();
        System.out.println("============Your Task List===========");
        int taskcount = 1;
        for(Task t : task){
            System.out.println("|       Task : "+taskcount);
            System.out.println("|-------------------------------------");
            System.out.println("|    Name    : "+t.name+"\n|Description : "+t.description+"\n|  Due Date  : "+t.dueDate);
            System.out.println("|____________________________________");  
            taskcount++;                                      
        }
        if(taskcount == 1){
            System.out.println("|-------------------------------------");
            System.out.println("|     Your Task List is Empty..!      |");
            System.out.println("|-------------------------------------");
        }
    }
}