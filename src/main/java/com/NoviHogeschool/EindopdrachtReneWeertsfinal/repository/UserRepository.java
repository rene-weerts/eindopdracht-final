package com.NoviHogeschool.EindopdrachtReneWeertsfinal.repository;

import com.NoviHogeschool.EindopdrachtReneWeertsfinal.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
