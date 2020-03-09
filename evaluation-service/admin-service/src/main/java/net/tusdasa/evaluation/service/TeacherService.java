package net.tusdasa.evaluation.service;

import net.tusdasa.evaluation.client.TeacherClient;
import net.tusdasa.evaluation.commons.CommonResponse;
import net.tusdasa.evaluation.entity.Teacher;
import net.tusdasa.evaluation.vo.TeacherRequest;
import org.springframework.stereotype.Service;

/**
 * @Author: tusdasa
 * @Date: 2020-03-09 8:35 AM
 */

@Service
public class TeacherService {

    private TeacherClient teacherClient;

    public TeacherService(TeacherClient teacherClient) {
        this.teacherClient = teacherClient;
    }

    public CommonResponse<Teacher> findById(Integer id) {
        return teacherClient.getTeacherById(id);
    }

    public CommonResponse<String> update(TeacherRequest request) {
        return this.teacherClient.updateTeacher(request);
    }
}
