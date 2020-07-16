package com.projecttraining.repositories;

import com.projecttraining.data.objects.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserDO, Integer> {

    UserDO findByName(String name);
}
