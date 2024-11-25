package java16.service;

import java16.models.Group;

public interface GroupService extends GeneralService {
    void addGroup(Group newGroup);
    Group[] getAllGroup();
    Group[] findByGroupName(String groupName);
}
