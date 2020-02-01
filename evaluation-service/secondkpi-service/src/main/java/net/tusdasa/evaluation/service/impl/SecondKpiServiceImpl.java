package net.tusdasa.evaluation.service.impl;

import net.tusdasa.evaluation.dao.SecondKpiMapper;
import net.tusdasa.evaluation.entity.SecondKpi;
import net.tusdasa.evaluation.service.SecondKpiService;
import net.tusdasa.evaluation.vo.SecondKpiRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SecondKpiServiceImpl implements SecondKpiService {

    private SecondKpiMapper secondKpiMapper;

    public SecondKpiServiceImpl(SecondKpiMapper secondKpiMapper){
        this.secondKpiMapper = secondKpiMapper;
    }

    @Override
    public void addSecondKpi(SecondKpiRequest request) {
        this.secondKpiMapper.insert(request.build());
    }

    @Transactional
    @Override
    public void updateSecondKpi(SecondKpiRequest request) {
        SecondKpi secondKpi = this.secondKpiMapper.selectByPrimaryKey(request.getFirstKpiId());
        if (secondKpi.compareTo(request) != 0) {
            this.secondKpiMapper.updateByPrimaryKeySelective(request.build());
        }
    }

    @Transactional
    @Override
    public void deleteSecondKpi(Integer secondKpiId) {
        this.secondKpiMapper.deleteByPrimaryKey(secondKpiId);
    }

    @Override
    public SecondKpi findSecondKpiById(Integer secondKpiId) {
        return this.secondKpiMapper.selectByPrimaryKey(secondKpiId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SecondKpi> findAll() {
        return this.secondKpiMapper.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<SecondKpi> findAllByFirstKpi(Integer firstKpiId) {
        return this.secondKpiMapper.findAllByFirstKpiId(firstKpiId);
    }
}
