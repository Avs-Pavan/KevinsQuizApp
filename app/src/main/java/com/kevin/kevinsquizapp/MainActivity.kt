package com.kevin.kevinsquizapp

import android.content.AbstractThreadedSyncAdapter
import android.os.Bundle
import com.kevin.kevinsquizapp.adapter.QNAAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    lateinit var adapter: QNAAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val questions = mutableListOf<QAModel>()
        questions.add(
            QAModel(
                R.drawable.iron_man,
                "Guess the Hero",
                mutableListOf(
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                ),
                1
            )
        )
        questions.add(
            QAModel(
                R.drawable.shield,
                "Guess the Hero",
                mutableListOf(
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                ),
                1
            )
        )
        questions.add(
            QAModel(
                R.drawable.shield,
                "Guess the Hero",
                mutableListOf(
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                ),
                1
            )
        )
        questions.add(
            QAModel(
                R.drawable.shield,
                "Guess the Hero",
                mutableListOf(
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                ),
                1
            )
        )
        questions.add(
            QAModel(
                R.drawable.shield,
                "Guess the Hero",
                mutableListOf(
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                ),
                1
            )
        )
        questions.add(
            QAModel(
                R.drawable.shield,
                "Guess the Hero",
                mutableListOf(
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                ),
                1
            )
        )
        questions.add(
            QAModel(
                R.drawable.shield,
                "Guess the Hero",
                mutableListOf(
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                ),
                1
            )
        )
        questions.add(
            QAModel(
                R.drawable.shield,
                "Guess the Hero",
                mutableListOf(
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                    Answer(1, "Iron man"),
                ),
                1
            )
        )
        adapter = QNAAdapter(this)
        qa_list.adapter = adapter
        adapter.setMenuOptionList(questions)
    }
}