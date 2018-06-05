package aveek.com.learnadvancedandroid

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import aveek.com.learnadvancedandroid.Adapter.ListAdapter
import aveek.com.learnadvancedandroid.Component.DaggerMainActivityComponent
import aveek.com.learnadvancedandroid.Module.MainActivityModule
import aveek.com.learnadvancedandroid.VM.ActivityProfileViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.*
import javax.inject.Inject
import io.reactivex.internal.util.NotificationLite.disposable
import io.reactivex.observers.DisposableObserver
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getRecyclerViewLayoutManager: RecyclerView.LayoutManager

    @Inject
    lateinit var getRecyclerViewAdapter: ListAdapter

    @Inject
    lateinit var provideProfileViewModel: ActivityProfileViewModel

    @Inject
    lateinit var binding: ViewDataBinding

    lateinit var disposable: Disposable

    val TAG = "aveek"

    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        DaggerMainActivityComponent.builder()
                .mainActivityModule(MainActivityModule(this))
                .build()
                .injectOrInsert(this)

        binding.setVariable(BR.viewModel, provideProfileViewModel)

        initRecyclerViews()

        binding.root.mainActivity_progress_bar.visibility=View.GONE

        lambdaTest()
        initObservable()

//        mGithubRepo = CoreApp.getGithubRepo()
//        initViews()
//        loadData()

    }

    private fun lambdaTest(){
        binding.root.mainActivity_test_button?.setOnClickListener({ view -> Toast.makeText(this,
        "I was written in Java 8! 1", Toast.LENGTH_LONG).show()} )

        binding.root.mainActivity_test_button?.setOnClickListener({ Toast.makeText(this,
                "I was written in Java 8! 2 ", Toast.LENGTH_LONG).show()} )

        binding.root.mainActivity_test_button?.setOnClickListener() {Toast.makeText(this,
                "I was written in Java 8! 3", Toast.LENGTH_LONG).show()}

    }

    private fun initObservable() {
        var res : String
        /*disposable = provideProfileViewModel.animalObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it -> res = it
                    Toast.makeText(this,
                            it, Toast.LENGTH_LONG).show()
                })*/
        disposable = provideProfileViewModel.animalObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    object : Subscriber <String> {
                        override fun onSubscribe(s: Subscription?) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            Toast.makeText(this@MainActivity,
                                    s.toString(), Toast.LENGTH_LONG).show()
                        }

                        override fun onComplete() {
                            Toast.makeText(this@MainActivity,
                                    "Complete", Toast.LENGTH_LONG).show()

                        }

                        override fun onNext(t: String?) {
                            Toast.makeText(this@MainActivity,
                                    t, Toast.LENGTH_LONG).show()
                        }

                        override fun onError(t: Throwable?) {
                            Toast.makeText(this@MainActivity,
                                    t!!.message, Toast.LENGTH_LONG).show()
                        }
                    }
                })

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
        mainActivity_recycler_view.layoutManager=getRecyclerViewLayoutManager  // This is another approach to declare xml variables into the kotlin code
//       mRecyclerView.setLayoutManager(getRecyclerViewLayoutManager)
        mainActivity_recycler_view.adapter=getRecyclerViewAdapter
//       mRecyclerView.setAdapter(getRecyclerViewAdapter)
    }


}
