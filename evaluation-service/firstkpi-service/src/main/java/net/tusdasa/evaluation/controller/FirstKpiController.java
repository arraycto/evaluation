package net.tusdasa.evaluation.controller;

import net.tusdasa.evaluation.commons.CommonResponse;
import net.tusdasa.evaluation.entity.FirstKpi;
import net.tusdasa.evaluation.service.FirstKpiService;
import net.tusdasa.evaluation.vo.FirstKpiRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstKpiController {

    private FirstKpiService firstKpiService;

    public FirstKpiController(FirstKpiService firstKpiService) {
        this.firstKpiService = firstKpiService;
    }

    /**
     * @GetMapping("/year/{yearId}") public CommonResponse<FirstKpi> findAllFirstKpiByAcademicYear(@PathVariable("yearId") Integer yearId) {
     * return new CommonResponse<FirstKpi>().ok().table(this.firstKpiService.findAllFirstKpiByAcademicYear(yearId));
     * }
     * @GetMapping("/year/{yearId}/{firstKpiId}") public CommonResponse<FirstKpi> findAllByAcademicYearAndId(@PathVariable("yearId") Integer yearId, @PathVariable("firstKpiId") Integer firstKpiId) {
     * return new CommonResponse<FirstKpi>().ok().table(this.firstKpiService.findAllByAcademicYearAndId(yearId, firstKpiId));
     * }
     * @PostMapping("/ids/{yearId}") public CommonResponse<FirstKpi> findAllByAcademicYearAndIds(@PathVariable("yearId") Integer yearId, @RequestBody IdsRequest idsRequest) {
     * return new CommonResponse<FirstKpi>().ok().table(this.firstKpiService.findAllByAcademicYearAndIds(yearId, idsRequest));
     * }
     */
    @GetMapping("/")
    public CommonResponse<FirstKpi> findAll() {
        return new CommonResponse<FirstKpi>().ok().table(this.firstKpiService.findAll());
    }

    @GetMapping("/{firstKpiId}")
    public CommonResponse<FirstKpi> findById(@PathVariable("firstKpiId") Integer firstKpiId) {
        FirstKpi firstKpi = this.firstKpiService.findById(firstKpiId);
        if (firstKpi != null) {
            return new CommonResponse<FirstKpi>().ok().data(this.firstKpiService.findById(firstKpiId));
        } else {
            return new CommonResponse<FirstKpi>().error("未找到");
        }
    }

    @PutMapping("/")
    public CommonResponse<String> updateFirstKpi(@RequestBody FirstKpiRequest request) {
        if (request.isUpdateRequest()) {
            this.firstKpiService.updateFirstKpi(request);
            return new CommonResponse<String>().ok();
        }
        return new CommonResponse<String>().error();
    }

    @PostMapping("/")
    public CommonResponse<String> createFirstKpi(@RequestBody FirstKpiRequest request) {
        if (request.isCreateRequest()) {
            this.firstKpiService.addFirstKpi(request);
            return new CommonResponse<String>().ok();
        }
        return new CommonResponse<String>().error();
    }

    @DeleteMapping("/{firstKpiId}")
    public CommonResponse<String> deleteFirstKpi(@PathVariable("firstKpiId") Integer firstKpiId) {
        this.firstKpiService.deleteFirstKpi(firstKpiId);
        return new CommonResponse<String>().ok();
    }

}
