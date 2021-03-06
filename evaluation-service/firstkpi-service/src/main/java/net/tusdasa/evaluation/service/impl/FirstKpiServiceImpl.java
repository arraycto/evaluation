package net.tusdasa.evaluation.service.impl;

import net.tusdasa.evaluation.dao.FirstKpiMapper;
import net.tusdasa.evaluation.entity.FirstKpi;
import net.tusdasa.evaluation.service.FirstKpiService;
import net.tusdasa.evaluation.vo.FirstKpiRequest;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FirstKpiServiceImpl implements FirstKpiService {

    private FirstKpiMapper firstKpiMapper;

    public FirstKpiServiceImpl(FirstKpiMapper firstKpiMapper) {
        this.firstKpiMapper = firstKpiMapper;
    }
/*
    @Cacheable(value = "findAllByAcademicYearAndId", key = "methodName + #academicYearId + #firstKpiId")
    @Transactional(readOnly = true)
    @Override
    public List<FirstKpi> findAllByAcademicYearAndId(Integer academicYearId, Integer firstKpiId) {
        HashMap<String, Integer> parameter = new HashMap<>();
        parameter.put("academicYearId", academicYearId);
        parameter.put("firstKpiId", firstKpiId);
        return this.firstKpiMapper.findAllByAcademicYearAndId(parameter);
    }

    @Cacheable(value = "findAllFirstKpiByAcademicYear", key = "methodName + #academicYearId")
    @Transactional(readOnly = true)
    @Override
    public List<FirstKpi> findAllFirstKpiByAcademicYear(Integer academicYearId) {
        return this.firstKpiMapper.findAllByAcademicYear(academicYearId);
    }
    @Cacheable(value = "findAllByAcademicYearAndIds", key = "methodName + #firstKpiIds")
    @Transactional(readOnly = true)
    @Override
    public List<FirstKpi> findAllByAcademicYearAndIds(Integer academicYearId, IdsRequest firstKpiIds) {
        HashMap<String, Object> parameter = new HashMap<>();
        parameter.put("academicYearId", academicYearId);
        parameter.put("firstKpiIds", firstKpiIds.getFirstArray());
        return this.firstKpiMapper.findAllByAcademicYearAndIds(parameter);
    }
*/
    @Cacheable(value = "findAll", key = "methodName")
    @Transactional(readOnly = true)
    @Override
    public List<FirstKpi> findAll() {
        return this.firstKpiMapper.findAll();
    }


    @Cacheable(value = "findById", key = "methodName + #firstKpiId")
    @Transactional(readOnly = true)
    @Override
    public FirstKpi findById(Integer firstKpiId) {
        return this.firstKpiMapper.selectByPrimaryKey(firstKpiId);
    }

    @Caching(
            evict = {
                    @CacheEvict(value = "findAllByAcademicYearAndIds", allEntries = true),
                    @CacheEvict(value = "findById", allEntries = true),
                    @CacheEvict(value = "findAll", allEntries = true),
                    @CacheEvict(value = "findAllFirstKpiByAcademicYear", allEntries = true),
                    @CacheEvict(value = "findAllByAcademicYearAndId", allEntries = true)
            }
    )
    @Transactional
    @Override
    public void updateFirstKpi(FirstKpiRequest request) {
        FirstKpi firstKpi = this.firstKpiMapper.selectByPrimaryKey(request.getFirstKpiId());
        if (firstKpi != null && firstKpi.compareTo(request) != 0) {
            this.firstKpiMapper.updateByPrimaryKeySelective(request.build());
        }
    }

    @Caching(
            evict = {
                    @CacheEvict(value = "findAllByAcademicYearAndIds", allEntries = true),
                    @CacheEvict(value = "findById", allEntries = true),
                    @CacheEvict(value = "findAll", allEntries = true),
                    @CacheEvict(value = "findAllFirstKpiByAcademicYear", allEntries = true),
                    @CacheEvict(value = "findAllByAcademicYearAndId", allEntries = true)
            }
    )
    @Transactional
    @Override
    public void addFirstKpi(FirstKpiRequest request) {
        this.firstKpiMapper.insert(request.build());
    }

    @Caching(
            evict = {
                    @CacheEvict(value = "findAllByAcademicYearAndIds", allEntries = true),
                    @CacheEvict(value = "findById", allEntries = true),
                    @CacheEvict(value = "findAll", allEntries = true),
                    @CacheEvict(value = "findAllFirstKpiByAcademicYear", allEntries = true),
                    @CacheEvict(value = "findAllByAcademicYearAndId", allEntries = true)
            }
    )
    @Transactional
    @Override
    public void deleteFirstKpi(Integer firstKpiId) {
        this.firstKpiMapper.deleteByPrimaryKey(firstKpiId);
    }
}
