package kraft.book.code.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kraft.book.code.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final TokenRepository tokenRepository;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        var header = request.getHeader("Authorization");
        var jwt = header.substring(7);

        if(!header.startsWith("Bearer ")){
            return;
        }

        var token = tokenRepository.findByToken(jwt).orElseThrow(()->new RuntimeException("token not found"));

        if(token != null){
            token.setExpired(true);
            token.setRevoked(true);
            tokenRepository.save(token);
            SecurityContextHolder.clearContext();
        }
    }
}
