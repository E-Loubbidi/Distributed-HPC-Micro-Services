package org.sid.servicesec.secservice;

import org.sid.servicesec.entities.AppRole;
import org.sid.servicesec.entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username, String AppRole);
    AppUser loasUserByUsername(String username);
    List<AppUser> listUsers();
}
