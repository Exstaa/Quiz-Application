package az.hafizrzazade.quizapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.hafizrzazade.quizapplication.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{

}
