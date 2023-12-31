package vn.com.dsk.demo.base.repository;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.dsk.demo.base.model.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);

    Optional<Account> findByEmail(String email);

    @EntityGraph(attributePaths = "authorities")
    Optional<Account> findOneWithAuthoritiesByEmail(String email);

    @EntityGraph(attributePaths = "authorities")
    Optional<Account> findOneWithAuthoritiesByUsername(String username);

    Boolean existsByUsernameOrEmail(String username, String email);
}
