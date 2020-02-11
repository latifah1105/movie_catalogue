package io.github.latifah1105.movie3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import io.github.latifah1105.movie3.model.Result
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DETAIL = "EXTRA_DETAIL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val film = intent.getParcelableExtra(EXTRA_DETAIL) as Result
        txt_title.text = film.title
        txt_score_percent.text = film.popularity.toString()
        txt_overview.text = film.overview
        Glide.with(applicationContext).load(film.getPosterUrl()).into(image_view)
    }
}
