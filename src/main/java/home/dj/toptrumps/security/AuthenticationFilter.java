package home.dj.toptrumps.security;

import home.dj.toptrumps.user.UserEntity;
import home.dj.toptrumps.user.UserService;
import home.dj.toptrumps.user.UserStorage;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {

    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwt = (Jwt) authentication.getCredentials();
        String email = jwt.getClaimAsString("email");
        Optional<UserEntity> byEmail = userService.findByEmail(email);
        UserEntity userEntity = byEmail.orElseGet(() -> userService.save(UserEntity.builder().email(email).build()));
        UserStorage.setUser(userEntity);
        filterChain.doFilter(request, response);
        UserStorage.clear();
    }
}
