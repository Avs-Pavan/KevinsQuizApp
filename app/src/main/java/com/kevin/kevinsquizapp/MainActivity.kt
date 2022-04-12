package com.kevin.kevinsquizapp

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import android.os.Bundle
import com.kevin.kevinsquizapp.adapter.QNAAdapter
import com.kevin.kevinsquizapp.adapter.QnASelectionListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    lateinit var adapter: QNAAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val questions = mutableListOf<QAModel>()

        soundPool = SoundPool(1, AudioManager.STREAM_MUSIC, 0)
        soundPool.load(baseContext, R.raw.success, 1)

        failSoundPool = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        failSoundPool.load(baseContext, R.raw.fail, 1)

        questions.add(
            QAModel(
                "https://i.pinimg.com/originals/bb/8a/bf/bb8abf1a043b398b3501c00f1a54427e.jpg",
                "Guess the Hero",
                mutableListOf(
                    Answer(1, "Iron man", false),
                    Answer(1, "Hulk", false),
                    Answer(1, "Black widow", false),
                    Answer(1, "Black panther", false),
                ),
                0
            )
        )
        questions.add(
            QAModel(
                "https://raw.githubusercontent.com/kevinOcconer/msd_vertical_submission/main/113761.webp",
                "Guess the Hero",
                mutableListOf(
                    Answer(1, "Iron man", false),
                    Answer(1, "Hulk", false),
                    Answer(1, "Vision", false),
                    Answer(1, "Shuri", false),
                ),
                1
            )
        )
//        questions.add(
//            QAModel(
//                "https://i.pinimg.com/originals/e4/41/ec/e441eca30f4b27a6f0acd3bbacc86349.jpg",
//                "Guess the Hero",
//                mutableListOf(
//                    Answer(1, "Iron man", false),
//                    Answer(1, "Hulk", false),
//                    Answer(1, "Black Panther", false),
//                    Answer(1, "Vision", false),
//                ),
//                2
//            )
//        )
//        questions.add(
//            QAModel(
//                "https://i.pinimg.com/736x/7a/d2/da/7ad2da34eaab49324701253e4f7ebb49.jpg",
//                "Guess the Hero",
//                mutableListOf(
//                    Answer(1, "Black widow", false),
//                    Answer(1, "Iron man", false),
//                    Answer(1, "Hulk", false),
//                    Answer(1, "Wanda", false),
//                ),
//                0
//            )
//        )
//
//        questions.add(
//            QAModel(
//                "https://www.psu.com/wp/wp-content/uploads/2020/10/marvels-spider-man-miles-morales-ps4-ps5-wallpapers-08.jpg",
//                "Guess the Hero",
//                mutableListOf(
//                    Answer(1, "Captain America", false),
//                    Answer(1, "Spider man", false),
//                    Answer(1, "Vision", false),
//                    Answer(1, "Iron man", false),
//                ),
//                1
//            )
//        )
//        questions.add(
//            QAModel(
//                "https://imgix.bustle.com/uploads/image/2022/2/14/3dddbfb7-4f3f-418c-a346-33f958f0baee-wanda-2.jpg?w=350&h=298&fit=crop&crop=focalpoint&auto=format%2Ccompress&fp-x=0.492&fp-y=0.2176",
//                "Guess the Hero",
//                mutableListOf(
//                    Answer(1, "Iron man", false),
//                    Answer(1, "Spider man", false),
//                    Answer(1, "Wanda", false),
//                    Answer(1, "War machine", false),
//                ),
//                2
//            )
//        )
//        questions.add(
//            QAModel(
//                "https://static.wikia.nocookie.net/ironman/images/1/10/Phil-saunders-warmachinemk4-b3-web.jpg/revision/latest?cb=20190617163805",
//                "Guess the Hero",
//                mutableListOf(
//                    Answer(1, "War machine ", false),
//                    Answer(1, "Iron man", false),
//                    Answer(1, "Hulk", false),
//                    Answer(1, "Vision", false),
//                ),
//                0
//            )
//        )
//        questions.add(
//            QAModel(
//                "https://media.wired.com/photos/5926a2d67034dc5f91bec227/master/w_2560%2Cc_limit/DoctorStrangeTA.jpg",
//                "Guess the Hero",
//                mutableListOf(
//                    Answer(1, "Iron man", false),
//                    Answer(1, "Doctor strange", false),
//                    Answer(1, "War machine", false),
//                    Answer(1, "Spider man", false),
//                ),
//                1
//            )
//        )
//        questions.add(
//            QAModel(
//                "https://i.pinimg.com/originals/2c/3f/d7/2c3fd77862947349f29dc9a08d66ce7f.jpg",
//                "Guess the Hero",
//                mutableListOf(
//                    Answer(1, "Iron man", false),
//                    Answer(1, "Thor", false),
//                    Answer(1, "Vision", false),
//                    Answer(1, "Spider man", false),
//                ),
//                1
//            )
//        )
//        questions.add(
//            QAModel(
//                "https://nepal24hours.com/wp-content/uploads/2018/11/gettyimages-627159562.jpg",
//                "Guess the Hero",
//                mutableListOf(
//                    Answer(1, "Iron man", false),
//                    Answer(1, "Doctor strange", false),
//                    Answer(1, "Stan lee", false),
//                    Answer(1, "Spider man", false),
//                ),
//                2
//            )
//        )
        adapter = QNAAdapter()
        qa_list.adapter = adapter
        adapter.setMenuOptionList(questions)

        adapter.setRecyclerClickListener(object : QnASelectionListener {
            override fun onCorrectAnswerClicked(position: Int) {
                shout("You are correct..")
                playSound()
                qa_list.currentItem = position + 1
                if (position == questions.size - 1) {
                    startActivity(Intent(this@MainActivity, ResultScreen::class.java))
                    finish()
                }
            }

            override fun onWrongAnswerClicked(position: Int) {
                shout("You are wrong...")
                playFailSound()
            }

        })
    }

    private lateinit var soundPool: SoundPool
    private val soundId = 1
    private lateinit var failSoundPool: SoundPool

    fun playSound() {
        soundPool.play(soundId, 1F, 1F, 0, 0, 1F)
    }

    fun playFailSound() {
        failSoundPool.play(soundId, 1F, 1F, 0, 0, 1F)
    }
}