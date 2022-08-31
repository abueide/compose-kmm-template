//
//  Font+Extension.swift
//  iosApp
//
//  Created by Wilson Scott on 7/15/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI

public extension Font {
    init(_ uiFont: UIFont) {
        self = Font(uiFont as CTFont)
    }
}
