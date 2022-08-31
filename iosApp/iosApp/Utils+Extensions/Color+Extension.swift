//
//  Color+Extension.swift
//  iosApp
//
//  Created by Wilson Scott on 7/15/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI

public extension Color {
    init(_ graphicsColor: GraphicsColor) {
        self = Color(
            UIColor(
                red: (CGFloat(graphicsColor.red) / 255.0),
                green: (CGFloat(graphicsColor.green) / 255.0),
                blue: (CGFloat(graphicsColor.blue) / 255.0),
                alpha: (CGFloat(graphicsColor.alpha) / 255.0)
            )
        )
    }
    
    init(_ colorResourceSingle: ColorResource.Single) {
        self = Color(colorResourceSingle.color)
    }
    
    init(_ colorResourceTheme: ColorResource.Themed) {
        self = Color(colorResourceTheme.light) // TODO: Handle light and dark mode here
    }
}
