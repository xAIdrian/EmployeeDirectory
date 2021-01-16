package com.amohnacs.squareemployeedirectory.dagger

import com.amohnacs.squareemployeedirectory.ui.main.MainFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface MainComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }
    fun inject(mainFragment: MainFragment)
}