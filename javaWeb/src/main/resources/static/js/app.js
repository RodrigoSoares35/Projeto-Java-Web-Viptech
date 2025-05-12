
// Validação de Usuário e senha
const USUARIO_CORRETO = "Admin";
const SENHA_CORRETA = "Admin";

function validarLogin() {
    let usuarioDigitado = document.getElementById("usuario").value.trim();
    let senhaDigitada = document.getElementById("senha").value.trim();
   
    // Verifica se os campos estão preenchidos
    if (usuarioDigitado === "" || senhaDigitada === "") {
        alert("Preencha todos os campos!");
        return false;
    }

    // Verifica se o usuário e a senha estão corretos 
    if (usuarioDigitado === USUARIO_CORRETO && senhaDigitada === SENHA_CORRETA) {
        alert("Login efetuado com sucesso!");
         
         setTimeout(() => {
            window.location.href = "/menu";
        }, 100);
        return false;
        
        
        
    } else {
        alert("Usuário ou senha incorretos!");;
        return false;
    }
}

 
    window.confirmarExclusao = function () {
    return confirm("Tem certeza que deseja excluir este livro?");
};