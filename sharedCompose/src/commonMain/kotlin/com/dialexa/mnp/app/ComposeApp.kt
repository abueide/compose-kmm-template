package com.dialexa.mnp.app

import LandingComponent
import com.dialexa.mnp.compose.navigation.NavigationService
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ComposeApp {
    val navigationService = NavigationService().also { it.navigate(LandingComponent()) }

    val platformModule = module {
        single { navigationService }
    }

    init {
        startKoin {
            modules(MnpApp.appModule, platformModule)
        }
    }
}
