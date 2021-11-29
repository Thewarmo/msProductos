package com.edu.supermarket.supermarkms.repositories;

import com.edu.supermarket.supermarkms.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository <Account, String> {

}
