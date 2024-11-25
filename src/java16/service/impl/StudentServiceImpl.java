package java16.service.impl;
import java16.dao.impl.GroupDaoImpl;
import java16.models.Student;
import java16.service.StudentsService;

public class StudentServiceImpl implements StudentsService {
    private final GroupDaoImpl groupDao;

    public StudentServiceImpl(GroupDaoImpl groupDao) {
        this.groupDao = groupDao;
    }

    public GroupDaoImpl getGroupDao() {
        return groupDao;
    }

    @Override
    public void addStudentByGroupName(String groupName, Student newStudent) {
        groupDao.addStudentByGroupName(groupName, newStudent);
    }



    @Override
    public Student[] findByStudentName(String firstName) {
        return groupDao.findByStudentName(firstName);
    }

    @Override
    public Student[] getAllStudent() {
        return groupDao.getAllStudent();
    }

    @Override
    public void deleteGroupOrStudent(Long studentId, String type) {
        groupDao.deleteGroupOrStudent(studentId,type);
    }

    @Override
    public Object[] findById(Long id, String type) {
        return groupDao.findById(id, type);
    }


}
