package aveek.com.learnadvancedandroid

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import aveek.com.learnadvancedandroid.Adapter.ListAdapter
import aveek.com.learnadvancedandroid.Model.GithubRepo
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

}