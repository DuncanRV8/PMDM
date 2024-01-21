package com.duncanrua.duncanfinal.viewModel.mainViewModels

import android.app.Application
import com.duncanrua.duncanfinal.viewModel.AnimeViewModel
import com.duncanrua.duncanfinal.viewModel.UserNameViewModel

class MainViewModels (application: Application) {
    val userNameViewModel = UserNameViewModel(application)
    val animeViewModel = AnimeViewModel(application)
}