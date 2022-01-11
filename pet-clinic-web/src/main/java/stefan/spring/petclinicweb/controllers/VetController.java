package stefan.spring.petclinicweb.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import stefan.spring.petclinicdata.model.Vet;
import stefan.spring.petclinicdata.service.VetService;

/**
 * 
 * @author stefan
 *
 */
@Controller
public class VetController {
    
    private final VetService vetService;
    
    
    
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }


    @RequestMapping({"/vets/"})
    public String listVets(Model model) {
        
        model.addAttribute("vets", this.vetService.findAll());

        return "vets/index";
    }
    
    @GetMapping("/api/vets/")
    public @ResponseBody Set<Vet> getVetsJson(){

        return vetService.findAll();
    }

}
