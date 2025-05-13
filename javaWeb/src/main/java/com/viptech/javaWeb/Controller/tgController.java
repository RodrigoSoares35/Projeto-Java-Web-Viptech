
package com.viptech.javaWeb.Controller;

import com.viptech.javaWeb.Service.ThomasGrahamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class tgController {
    
     @Autowired
    ThomasGrahamService tgService;
     
    @GetMapping("/")
    public String login(Model model) {
        return "index";
    }
    @GetMapping("menu")
    public String menu(Model model) {
        return "menu";
    }
     @GetMapping("/listaUsuario")
    public String listaUsuario(Model model) {
        model.addAttribute("listarUsuario", tgService.listarTodosThomasGraham());
        return "listaUsuario";
    }
}
