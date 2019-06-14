/**
 * 
 */
package it.sdeluca.microuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.sdeluca.microuser.model.User;

/**
 * @author S.DeLuca
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
