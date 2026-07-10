import java.util.Scanner; 
public class Main { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        StudentManager manager = new StudentManager(); 
        while (true) { 
            System.out.println("\n===== Student Management System ====="); 
            System.out.println("1. Add Student"); 
            System.out.println("2. Display Students"); 
            System.out.println("3. Search Student"); 
            System.out.println("4. Update Student"); 
            System.out.println("5. Delete Student"); 
            System.out.println("6. Exit"); 
            System.out.print("Enter Choice: "); 
            int choice = sc.nextInt(); 
            switch (choice) { 
                case 1: 
                    System.out.print("ID: "); 
                    int id = sc.nextInt(); sc.nextLine(); 
                    System.out.print("Name: "); 
                    String name = sc.nextLine(); 
                    System.out.print("Age: "); 
                    int age = sc.nextInt(); 
                    sc.nextLine(); System.out.print("Department: "); 
                    String dept = sc.nextLine(); 
                    manager.addStudent( new Student(id, name, age, dept) ); 
                break; 
                case 2:
                    manager.displayStudents(); 
                break; 
                case 3: 
                    System.out.print("Enter ID: "); 
                    manager.searchStudent(sc.nextInt()); 
                break; 
                case 4: 
                    System.out.print("Enter ID: "); 
                    int uid = sc.nextInt(); sc.nextLine(); 
                    System.out.print("New Name: "); 
                    String uname = sc.nextLine(); 
                    System.out.print("New Age: "); 
                    int uage = sc.nextInt(); 
                    sc.nextLine(); 
                    System.out.print("New Department: "); 
                    String udept = sc.nextLine(); 
                    manager.updateStudent(uid, uname, uage, udept); 
                break; 
                case 5: 
                    System.out.print("Enter ID: "); 
                    manager.deleteStudent(sc.nextInt()); 
                    break; 
                case 6: 
                    System.out.println("Exiting..."); 
                    return; 
                default: System.out.println("Invalid Choice"); 
            } 
        } 
    } 
}