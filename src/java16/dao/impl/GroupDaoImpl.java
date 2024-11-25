package java16.dao.impl;
import java16.dao.GroupDao;
import java16.models.Group;
import java16.models.Student;
import java.util.Arrays;

public class GroupDaoImpl implements GroupDao {
    Group[] dataGroup= new Group[0];
    public String studentStr = "STUDENT", groupStr = "GROUP";

    @Override
    public void addGroup(Group newGroup) {
        dataGroup = Arrays.copyOf(dataGroup,dataGroup.length + 1);
        dataGroup[dataGroup.length - 1] = newGroup;
    }

    @Override
    public Group[] getAllGroup() {
        return dataGroup;
    }

    @Override
    public void addStudentByGroupName(String groupName, Student newStudent) {
        boolean isblock = false;
        for (int i = 0; i < dataGroup.length; i++) {
            if (dataGroup[i].getGroupName().equals(groupName)){
                isblock = true;
                if(dataGroup[i].getStudents() != null) {
                    Student[] students = new Student[0];
                    for (int j = 0; j < dataGroup[i].getStudents().length; j++) {
                        students = Arrays.copyOf(students, students.length +1);
                        students[students.length - 1] = dataGroup[i].getStudents()[j];
                    }
                    students = Arrays.copyOf(students, students.length +1);
                    students[students.length - 1] = newStudent;
                    dataGroup[i].setStudents(students);
                }else {
                    Student[] students = {newStudent};
                    dataGroup[i].setStudents(students);
                }
            }
        }
        if (!isblock){
            System.out.println(" not find by group name: " + groupName + "!");
        }
    }

    @Override
    public Group[] findByGroupName(String groupName) {
        Object[] findGroup = returnValue(null,groupName,groupStr);
        if (findGroup!= null && findGroup.length > 0){
            return new Group[]{(Group) findGroup[0]};
        }
        System.out.println("Group by name " + groupName + " is not found!");
        return null;
    }

    @Override
    public Student[] getAllStudent() {
        Student[] students = new Student[0];
        for (int i = 0; i < dataGroup.length; i++) {
            if (dataGroup[i].getStudents() != null) {
                for (int j = 0; j < dataGroup[i].getStudents().length; j++) {
                    students = Arrays.copyOf(students, students.length + 1);
                    students[students.length -1] = dataGroup[i].getStudents()[j];
                }
            }
        }
        return students;
    }

    @Override
    public Object[] findById(Long id, String type) {
        Object[] findValue = returnValue(id,null,type);
        if (findValue != null){
            return findValue;
        }
        System.out.println(type + " by ID " + id + " is not found!");
        return null;
    }
    @Override
    public Student[] findByStudentName(String firstName) {
        Object[] findStudent = returnValue(null,firstName,studentStr);
       if (findStudent != null && findStudent.length > 0){
           return new Student[]{(Student) findStudent[0]};
       }
       System.out.println("Student by name " + firstName+" is not found!");
       return null;
    }
    public Object[] returnValue(Long id, String text, String type) {
        Object[] findValue = new Object[0];
        for (int i = 0; i < dataGroup.length; i++) {
            if (type == groupStr){
                if(dataGroup[i].getId() == id || dataGroup[i].getGroupName() == text){
                    findValue = Arrays.copyOf(findValue, findValue.length + 1);
                    findValue[findValue.length -1] = dataGroup[i];
                }
            }else if (type == studentStr){
                if (dataGroup[i].getStudents() != null) {
                    for (int j = 0; j < dataGroup[i].getStudents().length; j++) {
                        if(dataGroup[i].getStudents()[j].getId() == id || dataGroup[i].getStudents()[j].getFirstName() == text){
                            findValue = Arrays.copyOf(findValue, findValue.length+1);
                            findValue[findValue.length -1] = dataGroup[i].getStudents()[j];
                        }
                    }
                }
            }
        }
        return findValue;
    }

    @Override
    public void deleteGroupOrStudent(Long id, String type) {
        if (type == groupStr) {
            Group[] newData = new Group[0];
            for (int i = 0; i < dataGroup.length; i++) {
                if (dataGroup[i].getId() != id){
                    newData = Arrays.copyOf(newData, newData.length +1);
                    newData[newData.length -1] = dataGroup[i];
                }else if (dataGroup[i].getId() == id){
                    System.out.println("Group with ID "+ id + " was remove!");
                }
            }
            dataGroup = newData;
        }else if (type == studentStr){
            for (int i = 0; i < dataGroup.length; i++) {
                Student[] newStudent = new Student[0];
                if (dataGroup[i].getStudents() != null){
                    for (int j = 0; j < dataGroup[i].getStudents().length; j++) {
                        if(dataGroup[i].getStudents()[j].getId() != id){
                            newStudent = Arrays.copyOf(newStudent, newStudent.length + 1);
                            newStudent[newStudent.length - 1] = dataGroup[i].getStudents()[j];
                        } else if (dataGroup[i].getStudents()[j].getId() == id) {
                            System.out.println("Student with ID "+ id + " was remove!");
                        }
                    }
                    dataGroup[i].setStudents(newStudent);
                }
            }
        }
    }

}
