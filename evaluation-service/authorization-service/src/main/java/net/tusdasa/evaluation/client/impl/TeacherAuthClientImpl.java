package net.tusdasa.evaluation.client.impl;

import net.tusdasa.evaluation.client.TeacherAuthClient;
import net.tusdasa.evaluation.commons.CommonResponse;
import net.tusdasa.evaluation.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherAuthClientImpl implements TeacherAuthClient {
    @Override
    public CommonResponse<Teacher> getTeacher(Integer workId, String password) {
        return new CommonResponse<Teacher>().busy();
    }

    @Override
    public CommonResponse<String> restPassword(Integer workId, String newPassword, String oldPassword) {
        return new CommonResponse<String>().busy();
    }
}
