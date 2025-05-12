
package com.viptech.javaWeb.Login;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuthController {
     private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/trocar-senha")
    public String trocarSenha() {
        return "trocar-senha";
    }

    @PostMapping("/trocar-senha")
    public String atualizarSenha(@RequestParam String username, @RequestParam String novaSenha, Model model) {
        var usuarioOpt = usuarioRepository.findByUsername(username);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setPassword(passwordEncoder.encode(novaSenha));
            usuarioRepository.save(usuario);
            model.addAttribute("mensagem", "Senha atualizada com sucesso!");
        } else {
            model.addAttribute("mensagem", "Usuário não encontrado.");
        }
        return "login";
    }
}
