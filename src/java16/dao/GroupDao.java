package java16.dao;

import java16.models.Group;
import java16.models.Student;

public interface GroupDao {

    void addGroup(Group newGroup);

    Group[] getAllGroup();

    void addStudentByGroupName(String groupName, Student newStudent);

    Student[] findByStudentName(String firstName);

    void deleteGroupOrStudent(Long id, String type);

    Object[] findById(Long id, String type);

    Group[] findByGroupName(String groupName);

    Student[] getAllStudent();
}
