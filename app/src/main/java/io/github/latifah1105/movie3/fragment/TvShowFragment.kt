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
import io.github.latifah1105.movie3.viewmodel.TvViewModel
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment() {

    private lateinit var tvShowViewModel: TvViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvShowAdapter = DataAdapter()
        tvShowAdapter.notifyDataSetChanged()

        rv_tv_show.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = tvShowAdapter
        }

        tvShowViewModel= ViewModelProviders.of(this, ViewModelProvider.NewInstanceFactory()).get(TvViewModel::class.java)
        progress_circular_tv.visibility = View.VISIBLE
        tvShowViewModel.setTvShow()
        tvShowViewModel.getTvShow().observe(this, Observer {
            if (it != null) {
                tvShowAdapter.setData(it)
                tvShowAdapter.notifyDataSetChanged()
                progress_circular_tv.visibility = View.GONE
            }
        })

        tvShowAdapter.setOnItemClickCallback(object : DataAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Result) {
                Intent(context, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_DETAIL, data)
                    startActivity(this)
                }
            }

        })

    }

}