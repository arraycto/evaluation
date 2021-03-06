package net.tusdasa.evaluation.client;

import net.tusdasa.evaluation.client.impl.StudentAuthClientImpl;
import net.tusdasa.evaluation.commons.CommonResponse;
import net.tusdasa.evaluation.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "evaluation-student-service", path = "/student", fallback = StudentAuthClientImpl.class)
public interface StudentAuthClient {
    @PostMapping("/auth")
    CommonResponse<Student> getStudent(@RequestParam("studentId") Long studentId, @RequestParam("password") String password);

    @PutMapping("/rest/{studentId}")
    CommonResponse<String> restPassword(@PathVariable("studentId") Long studentId, @RequestParam("new") String newPassword, @RequestParam("old") String oldPassword);
}
