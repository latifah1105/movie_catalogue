package io.github.latifah1105.movie3.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.latifah1105.movie3.DataAdapter
import io.github.latifah1105.movie3.DetailActivity
import io.github.latifah1105.movie3.R
import io.github.latifah1105.movie3.model.Result
import io.github.latifah1105.movie3.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_movie, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieAdapter = DataAdapter()
        movieAdapter.notifyDataSetChanged()

        rv_movie.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = movieAdapter
        }

        movieViewModel = ViewModelProviders.of(this, ViewModelProvider.NewInstanceFactory()).get(MovieViewModel::class.java)
        progress_circular_movie.visibility = View.VISIBLE
        movieViewModel.setMovies()
        movieViewModel.getMovies().observe(this, Observer {
            if(it != null){
                movieAdapter.setData(it)
                movieAdapter.notifyDataSetChanged()
                progress_circular_movie.visibility = View.GONE
            }
        })

        movieAdapter.setOnItemClickCallback(object : DataAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Result) {
                Intent(context, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_DETAIL, data)
                    startActivity(this)
                }
            }

        })

    }

}