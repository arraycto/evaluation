package net.tusdasa.evaluation.vo;

import lombok.*;
import net.tusdasa.evaluation.entity.FirstKpi;
import net.tusdasa.evaluation.utils.CheckUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
@Builder
@ToString
public class FirstKpiRequest implements CommonRequest<FirstKpi> {

    private Integer firstKpiId;

    private String firsKpiContent;


    public FirstKpi build() {
        return FirstKpi.builder().build().withFirstKpiId(this.getFirstKpiId())
                .withFirsKpiContent(this.getFirsKpiContent());
    }

    @Override
    public boolean isUpdateRequest() {
        return CheckUtils.isIntegerNumber(this.getFirstKpiId()) && CheckUtils.isString(this.getFirsKpiContent());
    }

    @Override
    public boolean isCreateRequest() {
        return CheckUtils.isString(this.getFirsKpiContent());
    }

}
