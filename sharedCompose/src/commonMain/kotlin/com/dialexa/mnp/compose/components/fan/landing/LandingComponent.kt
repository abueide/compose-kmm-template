import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dialexa.mnp.compose.components.Component
import com.dialexa.mnp.compose.components.auth.fanOrAthlete.FanOrAthleteComponent
import com.dialexa.mnp.compose.components.auth.login.LoginComponent
import com.dialexa.mnp.compose.components.auth.register.RegisterComponent
import com.dialexa.mnp.compose.shared.PrimaryTextButton
import com.dialexa.mnp.compose.shared.RoundedPrimaryButton
import com.dialexa.mnp.compose.theme.Typography

class LandingComponent : Component() {
    @Composable
    override fun view() {
        LandingScreen()
    }

    @Composable
    fun LandingScreen() {
        Box(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp)
                .padding(top = 120.dp).padding(bottom = 40.dp),
        ) {
            Column {
                title()
                description()
            }
            RoundedPrimaryButton(
                text = "Register",
                modifier = Modifier.align(Alignment.Center).fillMaxWidth(),
                onClick = { navigationService.navigate(FanOrAthleteComponent()) }
            )
            PrimaryTextButton(
                text = "Login",
                modifier = Modifier.align(Alignment.BottomCenter),
                onClick = { navigationService.navigate(LoginComponent()) }
            )
        }
    }

    companion object {
        @Composable
        private fun title() {
            Text(
                text = "myNILpay",
                style = Typography.h3,
            )
        }

        @Composable
        private fun description() {
            Text(
                text = "Purchase memorabilia at any time from any athlete at a price the fans " +
                    "determine",
                style = Typography.body1,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}
