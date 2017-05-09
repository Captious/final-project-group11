package ua.goit.java.hotelbooking.ui.common;

import ua.goit.java.hotelbooking.services.UserManageService;
import ua.goit.java.hotelbooking.services.impl.UserManageServiceImpl;

public abstract class AbstractUserAction extends ActionWithScanner {
    protected final UserManageService userManageService;

    public AbstractUserAction() {
        userManageService = new UserManageServiceImpl();
    }
}
