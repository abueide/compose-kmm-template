package com.dialexa.mnp.app

import org.koin.core.context.startKoin

class IosApp {
    init {
        startKoin {
            modules(MnpApp.appModule)
        }
    }
}