package aveek.com.learnadvancedandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import aveek.com.learnadvancedandroid.Adapter.ListAdapter
import aveek.com.learnadvancedandroid.Application.CoreApp
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getRecyclerViewLayoutManager : RecyclerView.LayoutManager

    @Inject
    lateinit var getAveek : String


    lateinit var mRecyclerView : RecyclerView
    /*
    lateinit var mProgressBar : ProgressBar
    lateinit var mGithubRepo: GithubRepo
    lateinit var mAdapter : ListAdapter
    lateinit var mLayoutManager: RecyclerView.LayoutManager
    lateinit var mDisposable: Disposable*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, CoreApp.getRealm(),Toast.LENGTH_LONG).show()
        Toast.makeText(this, CoreApp.getGithubRepo().testVal,Toast.LENGTH_LONG).show()
        initRecyclerViews()
        DaggerMainActivityComponent.builder()
                .mainActivityModule(MainActivityModule(this))
                .build()
                .injectOrInsert(this)

//        mGithubRepo = CoreApp.getGithubRepo()
//        initViews()
//        loadData()

    }
   /* private fun initViews() {
        mRecyclerView = findViewById(R.id.MainActivity_recycler_view);
        mProgressBar =  findViewById(R.id.MainActivity_progress_bar);
    }

    private fun loadData() {

    }

    */
   private fun initRecyclerViews() {
       Toast.makeText(this, getAveek, Toast.LENGTH_LONG).show()
//       mLayoutManager = LinearLayoutManager(this)
//       mAdapter = ListAdapter(ArrayList<String>())
//       mRecyclerView = findViewById(R.id.mainActivity_recycler_view) as RecyclerView
//       mRecyclerView = findViewById <RecyclerView> (R.id.mainActivity_recycler_view)
       mainActivity_recycler_view.layoutManager = getRecyclerViewLayoutManager
//       mainActivity_recycler_view.adapter
//       mainActivity_recycler_view.adapter
//       mRecyclerView.setLayoutManager(mLayoutManager)
//       mRecyclerView.setAdapter(mAdapter)
   }


}
