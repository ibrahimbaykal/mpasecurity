package com.turksat.mpasecurity.config;

import com.turksat.mpasecurity.domain.Authority;
import com.turksat.mpasecurity.domain.MPAUser;
import com.turksat.mpasecurity.domain.User;
import com.turksat.mpasecurity.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
class MPAUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.isEmpty()) {
            throw new UsernameNotFoundException("Username cannot be empty");
        } else {
            User person = userRepository.findByUsername(username);
            if (person == null) {
                throw new UsernameNotFoundException("User not found");
            } else {
                MPAUser user = new MPAUser(person.getUsername(), person.getPassword(),
                        true,
                        true,
                        true,
                        true,
                        getAuthorities(person.getAuthorities()),
                        person.getId());
                log.info(person.getUsername()+" " + person.getAuthorities().toString());
                return user;
            }
        }
    }

    public List<String> getRolesAsList(Set<Authority> roles) {
        List<String> rolesAsList = new ArrayList<String>();
        for (Authority role : roles) {
            rolesAsList.add(role.getName());
        }
        return rolesAsList;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Set<Authority> roles) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRolesAsList(roles));
        return authList;
    }
}
