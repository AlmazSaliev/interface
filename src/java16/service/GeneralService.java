package java16.service;

import java16.models.Group;

public interface GeneralService {
    void deleteGroupOrStudent(Long id, String type);
    Object[] findById(Long id, String type);
}
