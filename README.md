## Quiz Application
This is a simple quiz application built using Java Spring framework. It allows users to create, edit, delete questions, and also provides an API to retrieve questions.

## Features
Add Question: Users can add new questions to the quiz database.
Edit Question: Modify existing questions in the database.
Delete Question: Remove questions from the database.
Get Questions API: Provides an API endpoint to retrieve questions.

## Technologies Used
Java
Spring Framework
Hibernate
JpaRepository
Lombok

## API Endpoints
GET "/": Retrieve all questions.
POST "/addQuestion": Add a new question.
PUT "/{id}": Update an existing question.
DELETE "/{id}": Delete a question by its ID.
