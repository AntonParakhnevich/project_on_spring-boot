package com.test.handler;

import com.test.model.RoleName;
import java.io.IOException;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException {
    Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

    if (roles.contains(RoleName.ADMIN.getAuthority()) || roles.contains(RoleName.SUPER_ADMIN.getAuthority())) {
      response.sendRedirect("/admin");
    } else {
      response.sendRedirect("/private-area");
    }
  }
}