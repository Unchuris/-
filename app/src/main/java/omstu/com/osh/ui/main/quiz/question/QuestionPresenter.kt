package omstu.com.osh.ui.main.quiz.question

import android.graphics.Color
import com.arellomobile.mvp.InjectViewState
import com.google.firebase.database.*
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import omstu.com.osh.data.entities.Question
import omstu.com.osh.data.entities.ResultTest
import omstu.com.osh.ui.Screens
import omstu.com.osh.ui.common.BasePresenter
import ru.terrakok.cicerone.Router
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class QuestionPresenter @Inject constructor(
    private val router: Router
) : BasePresenter<QuestionView>() {

    private val colorCorrectAnswer = Color.GREEN
    private val colorIncorrectAnswer = Color.RED
    private var question: Question? = null
    private val timeDelay = 400L
    private var total = 1
    private var currentAnswerCount = 0

    override fun onFirstViewAttach() {
        total = 0
        updateQuestion()
        super.onFirstViewAttach()
    }

    fun back() = router.exit()

    fun option1onClick() = question?.let { checkAnswer(it.option1, 1) }

    fun option2onClick() = question?.let { checkAnswer(it.option2, 2) }

    fun option3onClick() = question?.let { checkAnswer(it.option3, 3) }

    fun option4onClick() = question?.let { checkAnswer(it.option4, 4) }

    private fun checkAnswer(userAnswer: String, position: Int) {
        question?.let {
            if (userAnswer == it.answer) {
                correctAnswer(position)
            } else {
                incorrectAnswer(position)
            }
        }
        disposable += Completable.timer(
            timeDelay,
            TimeUnit.MILLISECONDS,
            AndroidSchedulers.mainThread()
        ).subscribe(this::updateQuestion)
    }

    private fun updateQuestion() {
        total++
        val reference = FirebaseDatabase.getInstance().reference.child("Questions").child(total.toString())
        reference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                question = dataSnapshot.getValue(Question::class.java)
                showQuestion(question)
            }
        })
    }

    private fun showRez() {
        router.replaceScreen(Screens.RESULT_SCREEN, ResultTest(currentAnswerCount, total - currentAnswerCount - 1))
    }

    private fun showQuestion(question: Question?) {
        question?.let { viewState.showQuestion(it) } ?: showRez()
    }

    private fun correctAnswer(position: Int) {
        currentAnswerCount++
        viewState.changeColor(position, colorCorrectAnswer)
    }

    private fun incorrectAnswer(position: Int) {
        with(viewState) {
            changeColor(position, colorIncorrectAnswer)
            val positionCurrent = getCorrectAnswerPositionInOption()
            if (positionCurrent != null) {
                changeColor(positionCurrent, colorCorrectAnswer)
            }
        }
    }

    private fun getCorrectAnswerPositionInOption(): Int? {
        return question?.let {
            when (it.answer) {
                it.option1 -> 1
                it.option2 -> 2
                it.option3 -> 3
                it.option4 -> 4
                else -> null
            }
        }
    }
}
