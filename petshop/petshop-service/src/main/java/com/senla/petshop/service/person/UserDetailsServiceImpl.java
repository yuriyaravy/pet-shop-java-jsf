package com.senla.petshop.service.person;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.senla.petshop.api.dao.person.PersonDao;
import com.senla.petshop.model.person.Person;

@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PersonDao personDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetail = null;

		Person person = personDao.findPersonByName(username);

		if (person != null) {
			Set<GrantedAuthority> roles = new HashSet<>();
			roles.add(new SimpleGrantedAuthority(person.getRole().name()));
			userDetail = new User(person.getAunthenticator().getLogin(), person.getAunthenticator().getPassword(),
					roles);
		}
		return userDetail;
	}
}
