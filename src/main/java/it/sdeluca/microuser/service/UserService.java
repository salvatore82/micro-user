/**
 * 
 */
package it.sdeluca.microuser.service;

import java.io.IOException;

import it.sdeluca.microuser.dto.MicroUser;

/**
 * @author S.DeLuca
 *
 */
public interface UserService {

	public MicroUser saveUser(MicroUser microUser) throws IOException;
}
