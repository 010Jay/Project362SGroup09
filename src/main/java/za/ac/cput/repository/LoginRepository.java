package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
}
