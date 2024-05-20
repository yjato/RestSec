package ru.itmentor.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    List<User> findAll();

    Optional<User> findById(long id);

    Optional<User> findByUsername(String username);

    List<User> findByDepartment(String department);

    List<User> findBySalaryGreaterThan(int salary);

    void deleteById(long id);

    void delete(User user);
}
