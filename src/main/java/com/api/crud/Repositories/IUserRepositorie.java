package com.api.crud.Repositories;

import com.api.crud.Models.UsersModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepositorie extends JpaRepository<UsersModels,Long> {
}
