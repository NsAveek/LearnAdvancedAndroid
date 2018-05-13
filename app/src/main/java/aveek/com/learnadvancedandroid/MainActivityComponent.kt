package aveek.com.learnadvancedandroid

import dagger.Component

@Component(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent {
    fun injectOrInsert (mainActivity: MainActivity)
}