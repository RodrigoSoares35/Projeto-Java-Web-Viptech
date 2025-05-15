
package com.viptech.javaWeb.Controller;

import com.viptech.javaWeb.Data.ThomasGraham;
import com.viptech.javaWeb.Service.ThomasGrahamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class tgController {
    
     @Autowired
    ThomasGrahamService tgService;
     
     @GetMapping("/lista-cliente-tg")
    public String listaClienteTg(Model model) {
        model.addAttribute("clienteTg", tgService.listarTodosThomasGraham());
        return "lista-cliente-tg";
    }
    @GetMapping("/cadastrarClienteTg")
    public String mostrarFormularioTg(Model model) {
        model.addAttribute("tg", new ThomasGraham());
        return "cadastrar-cliente-tg";
    }
    
    @PostMapping("/salvarClienteTg")
    public String salvarSalvar(@Valid @ModelAttribute("tg") ThomasGraham tg, BindingResult result) {
        System.out.println("Recebido: " + tg);

        if (result.hasErrors()) {
            return "cadastrar-cliente-tg";
        }

        if (tg.getId() == null) {
            tgService.criarThomasGraham(tg);
        } else {
            tgService.atualizarThomasGraham(tg.getId(), tg);
        }
        return "redirect:/lista-cliente-tg";

    }
     @GetMapping("/criarThomasGrahamForm")
    public String criarThomasGrahamForm(Model model) {
        ThomasGraham tg = new ThomasGraham ();
        model.addAttribute("tg", tg);
        return "cadastrar-cliente-tg";
    }

    @GetMapping("/atualizarThomasGrahamForm/{id}")
    public String atualizarThomasGrahamForm(@PathVariable(value = "id") Integer id, Model model) {
        ThomasGraham tg  = tgService.getThomasGrahamId(id);
        model.addAttribute("tg", tg);
        return "atualizar-cliente-tg";
    }
    @GetMapping("/detalheThomasGrahamForm/{id}")
    public String DetalheThomasGrahamForm(@PathVariable(value = "id") Integer id, Model model) {
        ThomasGraham tg  = tgService.getThomasGrahamId(id);
        model.addAttribute("tg", tg);
        return "detalhe-cliente-tg";
    }
   
    /*
   @GetMapping("/pesquisarUsuario")
    public String pesquisarUsuario(@RequestParam("id") Integer id, Model model) {
    Usuario usuario = usuarioService.getUsuarioId(id);
    model.addAttribute("usuario", usuario);
    return "/listaUsuario"; 
}
*/
}
