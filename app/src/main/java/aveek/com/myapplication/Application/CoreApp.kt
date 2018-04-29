package aveek.com.myapplication.Application

import android.app.Application
import aveek.com.myapplication.Model.GithubRepo

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