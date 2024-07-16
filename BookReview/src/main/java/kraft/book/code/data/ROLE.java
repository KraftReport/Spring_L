package kraft.book.code.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum ROLE {
    ADMIN(
            Set.of(
                    PERMISSION.ADMIN_READ,
                    PERMISSION.ADMIN_ACTION,
                    PERMISSION.ADMIN_DELETE
            )
    ),
    MEMBER(
            Set.of(
                    PERMISSION.MEMBER_READ,
                    PERMISSION.ADMIN_ACTION,
                    PERMISSION.ADMIN_DELETE
            )
    ),
    VISITOR(
            Set.of(
                    PERMISSION.VISITOR_READ
            )
    );

    private final Set<PERMISSION> permissions;
    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
