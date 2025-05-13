
package com.viptech.javaWeb.Controller;

import com.viptech.javaWeb.Data.ThomasGraham;
import com.viptech.javaWeb.Service.ThomasGrahamService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/thomasgraham")
public class ThomasGrahamController {
    
     @Autowired
    ThomasGrahamService tgService;

    @GetMapping("/listar-tg")
    public ResponseEntity<List> getAllUsuario() {

        List<ThomasGraham> tg = tgService.listarTodosThomasGraham();

        return new ResponseEntity<>(tg, HttpStatus.OK);

    }
    /*
    @GetMapping("/pesquisarUsuario/{id}")

    public ResponseEntity<ThomasGraham> getThomasGrahamById(@PathVariable Integer id) {

        ThomasGraham tg = tgService.getThomasGrahamId(id);

        return new ResponseEntity<>(tg, HttpStatus.OK);

    }
    */
    @GetMapping("/pesquisarTg/{contrato}")
    
    public ResponseEntity<ThomasGraham> getThomasGrahamByContrato(@PathVariable String contrato) {
        
    ThomasGraham tg = tgService.getThomasGrahamByContrato(contrato);
    
    return new ResponseEntity<>(tg, HttpStatus.OK);
}
  
    @PostMapping("/adicionarTg")

    public ResponseEntity<ThomasGraham> addThomasGraham(@Valid @RequestBody ThomasGraham tg) {

        var novoThomasGraham = tgService.criarThomasGraham(tg);

        return new ResponseEntity<>(novoThomasGraham, HttpStatus.CREATED);

    }
    /*
    @DeleteMapping("/deletar/{id}")

    public ResponseEntity deletarThomasGraham(@PathVariable Integer id) {

        tgService.deletarThomasGraham(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
   */
}
