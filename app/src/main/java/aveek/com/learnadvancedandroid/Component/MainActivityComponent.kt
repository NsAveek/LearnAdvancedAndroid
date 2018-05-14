package aveek.com.learnadvancedandroid.Component

import aveek.com.learnadvancedandroid.MainActivity
import aveek.com.learnadvancedandroid.Module.MainActivityModule
import dagger.Component

@Component(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent {
    fun injectOrInsert (mainActivity: MainActivity)
}