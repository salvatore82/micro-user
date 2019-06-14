/**
 * 
 */
package it.sdeluca.microuser.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sdeluca.microuser.dto.MicroUser;
import it.sdeluca.microuser.model.User;
import it.sdeluca.microuser.repository.UserRepository;

/**
 * @author S.DeLuca
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public MicroUser saveUser(MicroUser microUser) {
		User user = new User();
		BeanUtils.copyProperties(microUser, user);
		userRepository.save(user);
		BeanUtils.copyProperties(user, microUser);
		return microUser;
	}

}
