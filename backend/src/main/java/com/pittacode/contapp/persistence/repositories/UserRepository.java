package com.pittacode.contapp.persistence.repositories;

import com.pittacode.contapp.persistence.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
