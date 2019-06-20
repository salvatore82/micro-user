/**
 * 
 */
package it.sdeluca.microuser.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
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
	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	@Transactional
	public MicroUser saveUser(MicroUser microUser) throws IOException {
		User user = new User();
		BeanUtils.copyProperties(microUser, user);
		userRepository.save(user);
		BeanUtils.copyProperties(user, microUser);
		BeanUtils.copyProperties(user, microUser);
		Map<String, Object> map = new HashMap<String, Object>();
	    map.put("id", microUser.getId());
	    map.put("name", microUser.getName());
	    map.put("lastName", microUser.getLastName());
	    map.put("document", microUser.getMultipartFile().getBytes());
	    map.put("documentFileName", microUser.getMultipartFile().getOriginalFilename());
	    map.put("documentMimeType", microUser.getMultipartFile().getContentType());
		jmsTemplate.convertAndSend("microuser.topic", map);
		
		return microUser;
	}

}
