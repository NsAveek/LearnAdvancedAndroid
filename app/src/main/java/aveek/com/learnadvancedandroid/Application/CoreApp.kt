package aveek.com.learnadvancedandroid.Application

import android.app.Application
import aveek.com.learnadvancedandroid.Model.GithubRepo

object CoreApp : Application() {

    var gitHubRepo: GithubRepo

    init {
        gitHubRepo = GithubRepo()
    }

    fun getRealm(): String {
        return "Test"
    }

    fun getGithubRepo(): GithubRepo {
        return gitHubRepo
    }
}