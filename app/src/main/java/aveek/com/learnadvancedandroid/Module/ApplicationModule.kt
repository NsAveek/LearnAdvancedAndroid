package aveek.com.learnadvancedandroid.Module

import android.content.Context
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration

@Module
class ApplicationModule(var context: Context) {

    @Provides
    fun provideRealm () = Realm.getDefaultInstance()

    @Provides
    fun getRealmConfiguration() : RealmConfiguration {

        return RealmConfiguration.Builder()
                .name("learnadvancedandroid.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build()
    }
}