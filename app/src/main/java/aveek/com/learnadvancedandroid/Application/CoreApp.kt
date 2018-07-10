package aveek.com.learnadvancedandroid.Application

import android.app.Application
import aveek.com.learnadvancedandroid.Component.DaggerApplicationComponent
import aveek.com.learnadvancedandroid.Model.GithubRepo
import aveek.com.learnadvancedandroid.Module.ApplicationModule
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject

class CoreApp : Application() {

    @Inject
    lateinit var provideRealm : Realm

    @Inject
    lateinit var getRealmConfiguration: RealmConfiguration

    var gitHubRepo: GithubRepo

    init {

        gitHubRepo = GithubRepo()
        initDagger()
        initRealm()
    }

    private fun initDagger() {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
                .injectApplication(this)

    }


    fun getRealm(): String {
        return "Test"
    }

    fun getGithubRepo(): GithubRepo {
        return gitHubRepo
    }
    fun initRealm(){
        Realm.init(this)
        Realm.setDefaultConfiguration(getRealmConfiguration)
    }
}