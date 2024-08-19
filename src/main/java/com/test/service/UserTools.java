package com.test.service;

import com.test.model.RoleName;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public class UserTools {

  public static boolean isAdmin(Collection<? extends GrantedAuthority> authorityList) {
    return authorityList.contains(RoleName.ADMIN) || authorityList.contains(RoleName.SUPER_ADMIN);
  }
}
