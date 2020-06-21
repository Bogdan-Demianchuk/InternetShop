package bogdan.internetshop.service.security;

import bogdan.internetshop.exeptions.AuthenticationException;
import bogdan.internetshop.lib.Inject;
import bogdan.internetshop.lib.Service;
import bogdan.internetshop.model.User;
import bogdan.internetshop.service.UserService;
import bogdan.internetshop.util.HashUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Override
    public User login(String login, String password) throws AuthenticationException {
        User userFromDb = userService.findeByLogin(login)
                .orElseThrow(() -> new AuthenticationException("Incorrect user login"));
        if (HashUtil.hashPassword(password, userFromDb.getSalt())
                .equals(userFromDb.getPassword())) {
            return userFromDb;
        }
        throw new AuthenticationException("Incorrect password");
    }
}
