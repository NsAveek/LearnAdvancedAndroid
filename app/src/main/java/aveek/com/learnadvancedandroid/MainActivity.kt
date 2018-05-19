package aveek.com.learnadvancedandroid

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import aveek.com.learnadvancedandroid.Adapter.ListAdapter
import aveek.com.learnadvancedandroid.Component.DaggerMainActivityComponent
import aveek.com.learnadvancedandroid.Module.MainActivityModule
import aveek.com.learnadvancedandroid.VM.ActivityProfileViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getRecyclerViewLayoutManager : RecyclerView.LayoutManager

    @Inject
    lateinit var getRecyclerViewAdapter : ListAdapter

    @Inject
    lateinit var provideProfileViewModel : ActivityProfileViewModel

    @Inject
    lateinit var binding : ViewDataBinding


    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        DaggerMainActivityComponent.builder()
                .mainActivityModule(MainActivityModule(this))
                .build()
                .injectOrInsert(this)

        binding.setVariable(BR.viewModel, provideProfileViewModel)

        initRecyclerViews()

        binding.root.mainActivity_progress_bar.visibility = View.GONE

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
