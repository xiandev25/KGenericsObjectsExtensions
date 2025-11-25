//class FillInTheBlankQuestion(
//    val questionText: String,
//    val answer: String,
//    val difficulty: String
//)
//
//class TrueOrFalseQuestion(
//    val questionText: String,
//    val answer: Boolean,
//    val difficulty: String
//)
//
//class NumericQuestion(
//    val questionText: String,
//    val answer: Int,
//    val difficulty: String
//)

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}

interface ProgressPrintable {
    val progressText: String

    fun printProgressBar()
}

class Quiz : ProgressPrintable {
    override val progressText: String
        get() = "${Quiz.answered} of ${Quiz.total} answered."

    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓")}
        repeat(Quiz.total - Quiz.answered) { print("▒")}
        println()
        println(Quiz.progressText)
    }

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(question3.questionText)
            println(question3.answer)
            println(question3.difficulty)
        }
        println()
    }
}

val Quiz.StudentProgress.progressText: String
    get() = "${Quiz.answered} of ${Quiz.total} answered."



fun main() {
    Quiz().apply {
        printQuiz()
        printProgressBar()
    }
}