package com.chiachat.app.web

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
  console.log("Test")
  onWasmReady {
    val app = CanvasDebugApp()
    Window("ChiaChat") {
      var counter by remember { mutableStateOf(0) }
      Box() {
        app.View()
        Button(onClick = { counter++ }, modifier = Modifier.align(Alignment.CenterStart)) {
          Text(counter.toString(), color = Color.Red)
        }
      }
    }
  }
}
