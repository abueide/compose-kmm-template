//
// Created by Andrea Bueide on 6/29/22.
// Copyright (c) 2022 orgName. All rights reserved.
//

import Combine
import Foundation
import shared
import UIKit

class TestViewModel: ObservableObject {
    let descriptionString = MR.strings.shared.appName.description()
    let resourceIdString = MR.strings.shared.appName.resourceId
    let localizedString = MR.strings.shared.appName.desc().localized()
    let otherString = MR.strings.shared.formatTest.format(args_: ["This is from iOS project"]).localized()
    
    let valueColor = MR.colors.shared.valueColor
    let themedColor = MR.colors.shared.themedColor
    
    let font = MR.fontsUrbane.shared.bold.uiFont(withSize: 20)
}
