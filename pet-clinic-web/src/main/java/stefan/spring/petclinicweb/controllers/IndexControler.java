package stefan.spring.petclinicweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author stefan
 *
 */
@Controller
public class IndexControler {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        
        return "Index";
    }
}

