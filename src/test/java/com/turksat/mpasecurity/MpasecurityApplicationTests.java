package com.turksat.mpasecurity;

import com.turksat.mpasecurity.config.HibernateConfig;
import com.turksat.mpasecurity.domain.Authority;
import com.turksat.mpasecurity.domain.MPAUser;
import com.turksat.mpasecurity.domain.User;
import com.turksat.mpasecurity.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Slf4j
@SpringBootTest
class MpasecurityApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void getUserByUsername(){
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		User person = userRepository.findByUsername("ibrahim");
		MPAUser user = new MPAUser(person.getUsername(), person.getPassword(),
				true,
				true,
				true,
				true,
				getAuthorities(person.getAuthorities()),
				person.getId());
		tx.commit();
		session.close();
		log.info(person.getUsername()+" " + person.getAuthorities().size());
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
