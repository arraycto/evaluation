package net.tusdasa.evaluation.controller;

import net.tusdasa.evaluation.commons.CommonResponse;
import net.tusdasa.evaluation.entity.ThirdKpi;
import net.tusdasa.evaluation.service.ThirdKpiService;
import net.tusdasa.evaluation.vo.IdsRequest;
import net.tusdasa.evaluation.vo.ThirdKpiRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class ThirdKpiController {

    private ThirdKpiService thirdKpiService;

    public ThirdKpiController(ThirdKpiService thirdKpiService) {
        this.thirdKpiService = thirdKpiService;

    }

    @GetMapping("/")
    public CommonResponse<ThirdKpi> findAll() {
        return new CommonResponse<ThirdKpi>().ok().table(this.thirdKpiService.findAll());
    }

    @GetMapping("/{thirdKpiId}")
    public CommonResponse<ThirdKpi> findById(@PathVariable("thirdKpiId") Integer thirdKpiId) {
        ThirdKpi thirdKpi = this.thirdKpiService.findThirdKpiById(thirdKpiId);

        if (thirdKpi != null) {
            return new CommonResponse<ThirdKpi>().ok().data(thirdKpi);
        }
        return new CommonResponse<ThirdKpi>().error("未找到");
    }

    @GetMapping("/second/{secondKpiId}")
    public CommonResponse<ThirdKpi> findSecondKpiId(@PathVariable("secondKpiId") Integer secondKpiId) {
        return new CommonResponse<ThirdKpi>().ok().table(this.thirdKpiService.findBySecondKpiId(secondKpiId));
    }

    @PostMapping("/second")
    public CommonResponse<ThirdKpi> findThirdBySecondKpiIds(@RequestBody IdsRequest idsRequest) {
        return new CommonResponse<ThirdKpi>().ok().table(this.thirdKpiService.findBySecondKpiIdAll(idsRequest.getFirstArray()));
    }

    @PostMapping("/ids/{secondKpiId}")
    public CommonResponse<ThirdKpi> findByIds(@PathVariable("secondKpiId") Integer secondKpiId, @RequestBody IdsRequest idsRequest) {
        return new CommonResponse<ThirdKpi>().ok().table(this.thirdKpiService.findBySecondKpiIds(secondKpiId, idsRequest.getFirstArray()));
    }

    @PostMapping("/ids/ids")
    public CommonResponse<ThirdKpi> findByIdsAndIds(@RequestBody IdsRequest idsRequest) {
        return new CommonResponse<ThirdKpi>().ok().table(this.thirdKpiService.findBySecondKpiIdsAndIds(idsRequest.getFirstArray(), idsRequest.getSecondIdsArray()));
    }

    @PostMapping("/")
    public CommonResponse<String> createThirdKpi(@RequestBody ThirdKpiRequest request) {
        if (request.isCreateRequest()) {
            this.thirdKpiService.addThirdKpi(request);
            return new CommonResponse<String>().ok();
        }
        return new CommonResponse<String>().error();
    }

    @PutMapping("/")
    public CommonResponse<String> updateThirdKpi(@RequestBody ThirdKpiRequest request) {
        if (request.isUpdateRequest()) {
            this.thirdKpiService.updateThirdKpi(request);
            return new CommonResponse<String>().ok();
        }
        return new CommonResponse<String>().error();
    }


}
