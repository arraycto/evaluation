package net.tusdasa.evaluation.client.impl;

import net.tusdasa.evaluation.client.FirstKpiClient;
import net.tusdasa.evaluation.commons.CommonResponse;
import net.tusdasa.evaluation.entity.FirstKpi;
import net.tusdasa.evaluation.vo.IdsRequest;
import org.springframework.stereotype.Component;

@Component
public class FirstKpiClientImpl implements FirstKpiClient {
    @Override
    public CommonResponse<FirstKpi> findAllByAcademicYearAndIds(Integer yearId, IdsRequest idsRequest) {
        return new CommonResponse<FirstKpi>().busy();
    }
}
