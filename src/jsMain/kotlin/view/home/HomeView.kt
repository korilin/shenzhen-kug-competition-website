package view.home

import androidx.compose.runtime.Composable
import global.KUGInfo
import view.home.component.InfoCard

@Composable
fun HomeView() {

    InfoCard(KUGInfo)
}