package net.tusdasa.evaluation.controller;

import net.tusdasa.evaluation.commons.CommonResponse;
import net.tusdasa.evaluation.entity.Term;
import net.tusdasa.evaluation.service.TermService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TermController {

    private TermService termService;

    public TermController(TermService termService) {
        this.termService = termService;
    }

    @GetMapping("/")
    public CommonResponse<Term> findAllTerm() {
       return new CommonResponse<Term>().ok().table(this.termService.findAll());
    }

    @GetMapping("/{id}")
    public CommonResponse<Term> findById(@PathVariable("id") Integer id) {
        Term term = this.termService.findById(id);
        if (term != null) {
            return new CommonResponse<Term>().ok().data(term);
        }
        return new CommonResponse<Term>().error("未找到");
    }
}