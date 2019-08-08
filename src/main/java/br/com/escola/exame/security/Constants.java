package br.com.escola.exame.security;

public class Constants {

    public static final String SECRET = "secret";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 86400000L;  //1 dia
    static final String SIGN_UP_URL = "/usuarios/sign-up";
}
