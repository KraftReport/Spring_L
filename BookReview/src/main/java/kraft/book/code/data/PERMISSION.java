package kraft.book.code.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PERMISSION {

    ADMIN_READ("admin:read"),
    ADMIN_ACTION("admin:action"),
    ADMIN_DELETE("admin:delete"),
    MEMBER_READ("member:read"),
    MEMBER_ACTION("member:action"),
    MEMBER_DELETE("member:delete"),
    VISITOR_READ("visitor:read");

    private final String permission;
}
