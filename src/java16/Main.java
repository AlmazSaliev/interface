package java16;
import java16.dao.impl.GroupDaoImpl;
import java16.models.Group;
import java16.models.Student;
import java16.service.impl.GroupServiceImpl;
import java16.service.impl.StudentServiceImpl;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String studentStr = "STUDENT", groupStr = "GROUP";
        GroupDaoImpl groupDao = new GroupDaoImpl();
        GroupServiceImpl groupService = new GroupServiceImpl(groupDao);
        StudentServiceImpl studentService = new StudentServiceImpl(groupDao);
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        while (true) {
            System.out.printf("""
                    ________Group_________
                    1. Create new group.
                    2. Get all group.
                    3. Find by group name.
                    4. Find by group id.
                    5. Delete group by id.
                    _______Student_________
                    6. Create new student.
                    7. Get all student.
                    8. Find by student name.
                    9. Find by student id.
                    10. Delete student by id.
                    ____Exit on process____
                    0. Exit.
                    """);
            int choiceNum = scanner.nextInt();
            switch (choiceNum) {
                case 1->{
                    System.out.print("Write the group name : ");
                    String name = scanner2.nextLine();
                    groupService.addGroup(new Group(random.nextLong(1,100), name)); // add new group
                }
                case 2->{
                    System.out.println("All groups: \n"+Arrays.toString(groupService.getAllGroup()));
                }
                case 3->{
                    System.out.print("Write the group name : ");
                    String name = scanner2.nextLine();
                    System.out.println("Find by group name: \n"+Arrays.toString(groupService.findByGroupName(name)));
                }
                case 4->{
                    System.out.print("Write the group ID : ");
                    Long num = scanner.nextLong();
                    System.out.println("Find by group id: \n"+Arrays.toString(groupService.findById(num, groupStr)));
                }
                case 5->{
                    System.out.print("Write the group ID : ");
                    Long num = scanner.nextLong();
                    groupService.deleteGroupOrStudent(num, groupStr);
                }
                case 6->{
                    System.out.print("Choice group name: ");
                    Group[] getGroup = groupService.getAllGroup();
                    for (int i = 0; i < getGroup.length; i++) {
                        System.out.println((i+1) +" "+ getGroup[i].getGroupName());
                    }
                    int index = scanner.nextInt();
                    System.out.print("Write firstname: ");
                    String firstname = scanner2.nextLine();
                    System.out.print("Write lastname: ");
                    String lastname = scanner2.nextLine();
                    System.out.println("Write birthday: ");
                    System.out.print("Write the year: ");
                    int year = scanner.nextInt();
                    System.out.print("Write the month: ");
                    int month = scanner.nextInt();
                    System.out.print("Write the day: ");
                    int day = scanner.nextInt();
                    System.out.println("Choice gender: ");
                    System.out.println("1. Male.");
                    System.out.println("2. Female.");
                    int genderNum = scanner.nextInt();
                    String gender = "";
                    switch (genderNum) {
                        case 1->{
                            gender = "Male";
                            break;
                        }
                        case 2->{
                            gender = "Female";
                            break;
                        }
                        default -> {
                            System.out.println("Incorrect choice!");
                        }
                    }
                    System.out.print("Write the phone number: ");
                    int phoneNumber = scanner.nextInt();
                    studentService.addStudentByGroupName(getGroup[index - 1].getGroupName(),
                    new Student(random.nextLong(1,100), firstname,lastname,
                    LocalDate.of(year,month,day),gender,phoneNumber));
                }
                case 7->{
                    System.out.println("All students: \n"+Arrays.toString(studentService.getAllStudent()));
                }
                case 8->{
                    System.out.print("Write the student name : ");
                    String name = scanner2.nextLine();
                    System.out.println("Find by student name: \n"+Arrays.toString(studentService.findByStudentName(name)));
                }
                case 9->{
                    System.out.print("Write the student ID : ");
                    Long num = scanner.nextLong();
                    System.out.println("Find by student id: \n"+Arrays.toString(studentService.findById(num, studentStr)));
                }
                case 10->{
                    System.out.print("Write the student ID : ");
                    Long num = scanner.nextLong();
                    studentService.deleteGroupOrStudent(num, studentStr);
                }
                case 0->{
                    return;
                }
                default -> {
                    System.out.println("Incorrect value!");
                }
            }

        }
    }
}