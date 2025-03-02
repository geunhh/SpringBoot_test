package jpabook.jpashop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jpabook.jpashop.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
