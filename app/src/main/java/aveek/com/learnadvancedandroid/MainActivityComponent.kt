package aveek.com.learnadvancedandroid

import dagger.Component
import javax.inject.Inject

@Component(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent {
    fun injectOrInsert (mainActivity: MainActivity)
}