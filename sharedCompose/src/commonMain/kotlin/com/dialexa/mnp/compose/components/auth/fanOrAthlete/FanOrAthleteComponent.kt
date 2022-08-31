package com.dialexa.mnp.compose.components.auth.fanOrAthlete

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dialexa.mnp.compose.components.Component
import com.dialexa.mnp.compose.components.auth.register.RegisterComponent

class FanOrAthleteComponent : Component() {
    @Composable
    override fun view() {
        FanOrAthleteScreen()
    }

    @Composable
    fun FanOrAthleteScreen() {
        Column(
            modifier = Modifier.padding(70.dp)
        ) {
            Text("How will you use myNILpay?", style = MaterialTheme.typography.h5, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.size(50.dp))
            SelectionCard(
                "I'm a Fan",
                "Send money & sponsorship requests to any current NCAA athlete"
            ) {
                navigationService.navigate(RegisterComponent())
            }
            Spacer(modifier = Modifier.size(25.dp))
            SelectionCard(
                "I'm a NCAA Athlete",
                "Legally receive money and sponsorship offers from your fans and supporters"
            ) {
                // TODO: Not implemented
            }
        }
    }

    companion object {
        @Composable
        fun SelectionCard(title: String, description: String, onClick: () -> Unit) {
            Card(
                border = BorderStroke(1.dp, MaterialTheme.colors.surface),
                backgroundColor = MaterialTheme.colors.background,
                modifier = Modifier.padding().width(250.dp).height(200.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.clickable(onClick = onClick).padding(horizontal = 50.dp)
                ) {
                    Box(modifier = Modifier.size(16.dp).clip(CircleShape).background(MaterialTheme.colors.onBackground))
                    Text(
                        title,
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onBackground,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        description,
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onBackground,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
