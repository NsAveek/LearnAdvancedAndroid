package aveek.com.learnadvancedandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ProgressBar
import android.widget.Toast
import aveek.com.learnadvancedandroid.Application.CoreApp
import aveek.com.learnadvancedandroid.Model.GithubRepo
import io.reactivex.disposables.Disposable

class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView : RecyclerView
    lateinit var mProgressBar : ProgressBar
    lateinit var mGithubRepo: GithubRepo
    lateinit var mAdapter : HomeAdapter
    lateinit var mLayoutManager: RecyclerView.LayoutManager
    lateinit var mDisposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, CoreApp.getRealm(),Toast.LENGTH_LONG).show()
        Toast.makeText(this, CoreApp.getGithubRepo().testVal,Toast.LENGTH_LONG).show()
        mGithubRepo = CoreApp.getGithubRepo()
        initViews()
        initRecyclerViews()
        loadData()

    }

    private fun initViews() {
        mRecyclerView = findViewById(R.id.MainActivity_recycler_view);
        mProgressBar =  findViewById(R.id.MainActivity_progress_bar);
    }

    private fun loadData() {

    }

    private fun initRecyclerViews() {
        mLayoutManager = LinearLayoutManager(this)
        mAdapter = HomeAdapter(ArrayList<String>())
        mRecyclerView.setLayoutManager(mLayoutManager)
        mRecyclerView.setAdapter(mAdapter)
    }

}
