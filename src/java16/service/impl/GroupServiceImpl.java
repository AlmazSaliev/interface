package java16.service.impl;

import java16.dao.impl.GroupDaoImpl;
import java16.models.Group;
import java16.service.GroupService;

public class GroupServiceImpl implements GroupService {
    private final GroupDaoImpl groupDao;

    public GroupServiceImpl(GroupDaoImpl groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public void addGroup(Group newGroup) {
        groupDao.addGroup(newGroup);
    }

    @Override
    public Group[] getAllGroup() {
        return groupDao.getAllGroup();
    }

    @Override
    public Group[] findByGroupName(String groupName) {
        return groupDao.findByGroupName(groupName);
    }


    @Override
    public void deleteGroupOrStudent(Long groupId, String type) {
        groupDao.deleteGroupOrStudent(groupId, type);
    }

    @Override
    public Object[] findById(Long id, String type) {
        return groupDao.findById(id, type);
    }


}
