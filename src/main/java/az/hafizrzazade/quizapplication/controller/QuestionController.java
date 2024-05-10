package az.hafizrzazade.quizapplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.hafizrzazade.quizapplication.model.Question;
import az.hafizrzazade.quizapplication.repository.QuestionRepository;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api/questions")
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepo;

	@PostMapping("/addQuestion")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		question.setId(0);
		Question resultquestion = questionRepo.save(question);
		return new ResponseEntity<Question>(resultquestion, HttpStatus.CREATED);
	}

	@GetMapping({ "", "/" })
	public ResponseEntity<List<Question>> getAllQuestions() {
		return new ResponseEntity<List<Question>>(questionRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable Integer id) {
		Optional<Question> resultQuestion = questionRepo.findById(id);
		return new ResponseEntity<Question>(resultQuestion.get(), HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Question> deleteQuestionById(@PathVariable Integer id) {
		Optional<Question> resultQuestion = questionRepo.findById(id);
		if (!resultQuestion.isEmpty()) {
			questionRepo.deleteById(id);
		}
		return new ResponseEntity<Question>(resultQuestion.get(), HttpStatus.ACCEPTED);
	}

	@PutMapping("/edit")
	public ResponseEntity<HashMap<String, String>> editQuestion(@RequestBody Question question) {
		HashMap<String, String> responseMap = new HashMap<>();
		responseMap.put("message", "question id " + question.getId() + " has been edited");
		Integer id = question.getId();
		if (id != null) {
			questionRepo.save(question);
		}

		return new ResponseEntity<>(responseMap, HttpStatus.ACCEPTED);
	}
}
