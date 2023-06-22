package com.healteion.HealthionApp.Repository;

import com.healteion.HealthionApp.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface MemberRepo extends JpaRepository<Member, Integer> {

    Member findByEmail(String email);

    Optional<Member> findOneByEmailAndPassword(String email, String password);

}
