package kakei.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kakei.entity.ErrorMessage;

public interface ErrorMessageRepository extends JpaRepository<ErrorMessage, String> {

}
