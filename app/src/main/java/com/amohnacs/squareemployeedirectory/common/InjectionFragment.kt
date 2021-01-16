package com.amohnacs.squareemployeedirectory.common

import android.content.Context
import androidx.fragment.app.Fragment
import com.amohnacs.squareemployeedirectory.SquareApp
import com.amohnacs.squareemployeedirectory.ui.MainActivity
import com.amohnacs.squareemployeedirectory.dagger.MainComponent

open class InjectionFragment : Fragment() {

    lateinit var mainDaggerComponent: MainComponent

    override fun onAttach(context: Context) {
        val mainActivity = activity as MainActivity
        val application = mainActivity.applicationContext as SquareApp
        mainDaggerComponent = application.appComponent.mainComponent().create()
        super.onAttach(context)
    }
}