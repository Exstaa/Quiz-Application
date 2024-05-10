let questions = []
let questionNumber = 0;
async function getQuestionsData() {
    questions = await fetch("http://localhost:8080/api/questions/").then(response => {
        return response.json();
    })

    loadQuestion(questionNumber)
}

function loadQuestion(questionNumber) {
    if (questions[questionNumber] != null) {
        let answers = questions[questionNumber].answers.split(" , ")

        let trueAnswer = questions[questionNumber].trueAnswer;
        document.getElementById("question-title").innerText = questions[questionNumber].question
        document.getElementById("answer1").innerText = answers[0]
        document.getElementById("answer2").innerText = answers[1]
        document.getElementById("answer3").innerText = answers[2]
        document.getElementById("answer4").innerText = answers[3]


        document.getElementById("answer1").addEventListener(("click"), () => {
            if (answer1.innerText.trim() == trueAnswer.trim()) {
                questionNumber = questionNumber + 1;
                loadQuestion(questionNumber)
            } else {
                alert("You lost, your score: " + questionNumber)
                window.location.reload();
            }
        })
        document.getElementById("answer2").addEventListener(("click"), () => {
            if (answer2.innerText.trim() == trueAnswer.trim()) {
                questionNumber = questionNumber + 1;
                loadQuestion(questionNumber)
            } else {
                alert("You lost, your score: " + questionNumber)
                window.location.reload();
            }
        })
        document.getElementById("answer3").addEventListener(("click"), () => {
            if (answer3.innerText.trim() == trueAnswer.trim()) {
                questionNumber = questionNumber + 1;
                loadQuestion(questionNumber)
            } else {
                alert("You lost, your score: " + questionNumber)
                window.location.reload();
            }
        })
        document.getElementById("answer4").addEventListener(("click"), () => {
            if (answer4.innerText.trim() == trueAnswer.trim()) {
                questionNumber = questionNumber + 1;
                loadQuestion(questionNumber)
            } else {
                alert("You lost, your score: " + questionNumber)
                window.location.reload();
            }
        })
    } else {
        alert("you won! your score: " + questionNumber)
    }
}
setTimeout(() => {
    console.log(questions)
}, 2000)

getQuestionsData()
