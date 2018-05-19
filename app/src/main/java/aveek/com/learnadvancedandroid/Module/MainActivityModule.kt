package aveek.com.learnadvancedandroid.Module

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import aveek.com.learnadvancedandroid.Adapter.ListAdapter
import aveek.com.learnadvancedandroid.MainActivity
import aveek.com.learnadvancedandroid.Model.GithubRepo
import aveek.com.learnadvancedandroid.R
import aveek.com.learnadvancedandroid.VM.ActivityProfileViewModel
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule (var context : Context){

    @Provides
    fun getGitHubRepo(): GithubRepo {
        return GithubRepo()
    }

    @Provides
    fun getRecyclerViewLayoutManager () : RecyclerView.LayoutManager{
        return LinearLayoutManager(context)
    }

    @Provides
    fun getRecyclerViewAdapter () : ListAdapter{
        return ListAdapter(context, listOf("a","b","c"))
    }

    @Provides
    fun provideProfileViewModel () : ActivityProfileViewModel{
        return ViewModelProviders.of(context as AppCompatActivity).get(ActivityProfileViewModel::class.java) // context must be FragmentActivity or AppCompatActivity
    }

    @Provides
    fun binding () : ViewDataBinding {
        return DataBindingUtil.setContentView(context as AppCompatActivity, R.layout.activity_main)
    }


}