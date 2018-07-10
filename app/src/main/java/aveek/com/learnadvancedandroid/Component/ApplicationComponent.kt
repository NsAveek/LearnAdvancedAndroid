package aveek.com.learnadvancedandroid.Component

import aveek.com.learnadvancedandroid.Application.CoreApp
import aveek.com.learnadvancedandroid.Module.ApplicationModule
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun injectApplication(coreApp : CoreApp)
}