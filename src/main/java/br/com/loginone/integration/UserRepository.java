package br.com.loginone.integration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.loginone.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    @Query("SELECT u FROM User u WHERE u.loginUser= :login AND u.passwordUser= :password")
    public User getUserByLoginAndPassword(@Param("login") String login, @Param("password") String password);
}
