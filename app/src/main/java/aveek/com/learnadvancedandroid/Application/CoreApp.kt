package aveek.com.learnadvancedandroid.Application

import android.app.Application
import aveek.com.learnadvancedandroid.Model.GithubRepo
import io.realm.Realm
import io.realm.RealmConfiguration

object CoreApp : Application() {

    var gitHubRepo: GithubRepo

    init {
        gitHubRepo = GithubRepo()
        initRealm()
    }

    fun getRealm(): String {
        return "Test"
    }

    fun getGithubRepo(): GithubRepo {
        return gitHubRepo
    }
    fun initRealm(){
        Realm.init(this)
        val realmConfig : RealmConfiguration = RealmConfiguration.Builder().name("learnadvancedandroid.realm").schemaVersion(0).build()
        Realm.setDefaultConfiguration(realmConfig)
        // We will integrate the realm to the module later
    }
}