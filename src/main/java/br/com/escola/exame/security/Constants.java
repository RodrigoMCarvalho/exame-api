package br.com.escola.exame.security;

public class Constants {

    public static final String SECRET = "secret";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 86400000L;  //1 dia
    public static final String SIGN_UP_URL = "/usuarios/sign-up";

//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("123"));
//        senha com criptografia: $2a$10$hzQzxe2d6TgHfC/uX1Z6sO8/PLoJMzN.4j51GGRgvg3N/f.A/Sss.
//    }
}
