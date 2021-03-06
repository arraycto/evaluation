package net.tusdasa.evaluation.controller;

import net.tusdasa.evaluation.commons.CommonResponse;
import net.tusdasa.evaluation.entity.SecondKpi;
import net.tusdasa.evaluation.service.SecondKPIService;
import net.tusdasa.evaluation.vo.SecondKpiRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 第二指标
 *
 * @Author: tusdasa
 * @Date: 2020-03-08 1:54 PM
 */

@RestController
public class SecondKPIController {

    private SecondKPIService secondKPIService;

    public SecondKPIController(SecondKPIService secondKPIService) {
        this.secondKPIService = secondKPIService;
    }

    @GetMapping("/second")
    public CommonResponse<SecondKpi> findAll() {
        return this.secondKPIService.findAll();
    }

    @GetMapping("/second/{id}")
    public CommonResponse<SecondKpi> findById(@PathVariable("id") Integer id) {
        return this.secondKPIService.findById(id);
    }

    @PutMapping("/second")
    public CommonResponse<String> update(@RequestBody SecondKpiRequest request) {
        return this.secondKPIService.update(request);
    }

    @PostMapping("/second")
    public CommonResponse<String> create(@RequestBody SecondKpiRequest request) {
        return this.secondKPIService.create(request);
    }

    @DeleteMapping("/second/{id}")
    public CommonResponse<String> delete(@PathVariable("id") Integer id) {
        return this.secondKPIService.delete(id);
    }

}
