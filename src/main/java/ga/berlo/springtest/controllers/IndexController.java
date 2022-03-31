package ga.berlo.springtest.controllers;

import ga.berlo.springtest.models.Visit;
import ga.berlo.springtest.models.VisitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    final VisitRepository visitRepository;

    public IndexController(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @GetMapping("/")
    public ModelAndView index() {
        Map<String,String> model = new HashMap<>();
        model.put("name","Sergei");
        Visit visit = new Visit();
        visit.description = String.format("Visited at %s", LocalDateTime.now());
        visitRepository.save(visit);

        return new ModelAndView("index",model);
    }
}
