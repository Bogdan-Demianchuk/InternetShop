package bogdan.internetshop.service.security;

import bogdan.internetshop.exeptions.AuthenticationException;
import bogdan.internetshop.model.User;

public interface AuthenticationService {
    User login(String login, String password) throws AuthenticationException;
}
