package aveek.com.learnadvancedandroid

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import aveek.com.learnadvancedandroid.Adapter.ListAdapter
import aveek.com.learnadvancedandroid.Application.CoreApp
import aveek.com.learnadvancedandroid.Module.MainActivityModule
import aveek.com.learnadvancedandroid.VM.ProfileViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getRecyclerViewLayoutManager : RecyclerView.LayoutManager

    @Inject
    lateinit var getRecyclerViewAdapter : ListAdapter

    @Inject
    lateinit var provideProfileViewModel: ProfileViewModel

//    lateinit var mRecyclerView : RecyclerView
    /*
    lateinit var mRecyclerView : RecyclerView
    lateinit var mProgressBar : ProgressBar
    lateinit var mGithubRepo: GithubRepo
    lateinit var mAdapter : ListAdapter
    lateinit var mLayoutManager: RecyclerView.LayoutManager
    lateinit var mDisposable: Disposable*/

    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, CoreApp.getRealm(),Toast.LENGTH_LONG).show()
        Toast.makeText(this, CoreApp.getGithubRepo().testVal,Toast.LENGTH_LONG).show()
        var prfvm = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        DaggerMainActivityComponent.builder()
                .mainActivityModule(MainActivityModule(this))
                .build()
                .injectOrInsert(this)
        initRecyclerViews()

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
//       mLayoutManager = LinearLayoutManager(this)
//       mAdapter = ListAdapter(ArrayList<String>())
//       mRecyclerView = findViewById(R.id.mainActivity_recycler_view) as RecyclerView // This is one approach to declare xml variables into the kotlin code
//       mRecyclerView = findViewById <RecyclerView> (R.id.mainActivity_recycler_view) // This is another approach to declare xml variables into the kotlin code
       mainActivity_recycler_view.layoutManager = getRecyclerViewLayoutManager  // This is another approach to declare xml variables into the kotlin code
//       mRecyclerView.setLayoutManager(getRecyclerViewLayoutManager)
       mainActivity_recycler_view.adapter = getRecyclerViewAdapter
//       mRecyclerView.setAdapter(getRecyclerViewAdapter)
   }


}
