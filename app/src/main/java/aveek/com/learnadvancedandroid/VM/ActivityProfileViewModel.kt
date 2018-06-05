package aveek.com.learnadvancedandroid.VM

import android.arch.lifecycle.ViewModel
import aveek.com.learnadvancedandroid.Model.GithubRepo
import io.reactivex.Observable
import java.util.*

class ActivityProfileViewModel : ViewModel(){

    val someText : String = "Aveek is testing"

    val animalObservable : Observable <String> = Observable.just("Ant", "Bee", "Source", "Ravi")

}