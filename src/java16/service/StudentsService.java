package java16.service;

import java16.models.Student;

public interface StudentsService extends GeneralService {
    void addStudentByGroupName(String groupName, Student newStudent);
    Student[] findByStudentName(String firstName);
    Student[] getAllStudent();
}
