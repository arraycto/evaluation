package net.tusdasa.evaluation.client;

import net.tusdasa.evaluation.client.impl.CourseClientImpl;
import net.tusdasa.evaluation.commons.CommonResponse;
import net.tusdasa.evaluation.entity.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "evaluation-course-service", path = "/course", fallback = CourseClientImpl.class)
public interface CourseClient {
    @GetMapping("/class/{classId}/term/{termId}")
    CommonResponse<Course> findCourseByClassIdAndTermId(@PathVariable("classId") Integer classId, @PathVariable("termId") Integer termId);
}
