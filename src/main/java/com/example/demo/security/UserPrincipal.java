package com.example.demo.security;


import com.example.demo.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserPrincipal implements UserDetails {
    private User user;
    public UserPrincipal(User user) {
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        this.user.getPermissionList().forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission)));

        this.user.getRoleList().forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
        return authorities;
    }
   @Override
    public String getPassword() {
        return this.user.getPassword();
   }
   @Override
    public String getUsername() {
        return this.user.getUsername();
   }
   @Override
    public boolean isAccountNonExpired() {
        return true;
   }
   @Override
    public boolean isAccountNonLocked() {
        return true;
   }
   @Override
    public boolean isCredentialsNonExpired() {
        return true;
   }
   @Override
    public boolean isEnabled() {
        return this.user.getActive() == 1;
   }




}
