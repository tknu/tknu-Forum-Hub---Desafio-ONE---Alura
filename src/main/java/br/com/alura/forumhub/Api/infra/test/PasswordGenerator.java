package br.com.alura.forumhub.Api.infra.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {
        // Cria uma instância do codificador de senhas BCrypt
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // A senha que queremos modificar
        String rawPassword = "123456";

        // Gerar o hash da senha
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // Imprime o resultado no console
        System.out.println("Senha Original: " + rawPassword);
        System.out.println("Senha Criptografada (Hash BCypt) "  + encodedPassword);
    }
}
