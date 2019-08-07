package br.com.escola.exame.security;

import static br.com.escola.exame.security.Constants.HEADER_STRING;
import static br.com.escola.exame.security.Constants.SECRET;
import static br.com.escola.exame.security.Constants.TOKEN_PREFIX;
import br.com.escola.exame.service.ImplementsUserDetailsService;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private final ImplementsUserDetailsService userDetailsService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, ImplementsUserDetailsService userDetailsService) {
        super(authenticationManager);
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(HEADER_STRING);

        //se o header estiver nulo ou nao começar com "Bearer " ele returna
        if (header == null || !header.startsWith(TOKEN_PREFIX)) {   //importados estaticamentes
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(request);
        //adiciona no SecurityContext a sua autenticação
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        String username = Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        //se a string username for diferente de nulo, retorna username senão retorna nulo
        return username != null ? new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities()) : null;
    }

}
