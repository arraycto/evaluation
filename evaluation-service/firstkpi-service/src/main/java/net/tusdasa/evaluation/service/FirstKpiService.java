package net.tusdasa.evaluation.service;

import net.tusdasa.evaluation.entity.FirstKpi;
import net.tusdasa.evaluation.vo.FirstKpiRequest;

import java.util.List;

public interface FirstKpiService {
    List<FirstKpi> findAllFirstKpiByAcademicYear(Integer academicYearId);
    List<FirstKpi> findAll();
    FirstKpi findById(Integer firstKpiId);
    void updateFirstKpi(FirstKpiRequest request);
    void addFirstKpi(FirstKpiRequest request);
    void deleteFirstKpi(Integer firstKpiId);
}
