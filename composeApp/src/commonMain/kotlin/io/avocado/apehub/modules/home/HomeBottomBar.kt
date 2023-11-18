package com.avocado.apehub.modules.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab

@Composable
fun HomeBottomBar(
    tabOptions: List<Tab>,
) {
    NavigationBar(
        windowInsets = WindowInsets.safeContent.only(
            WindowInsetsSides.Bottom + WindowInsetsSides.Horizontal,
        ),
    ) {
        val tabNavigator = LocalTabNavigator.current
        tabOptions.forEachIndexed { _, item ->
            NavigationBarItem(
                modifier = Modifier.navigationBarsPadding(),
                icon = { Icon(item.options.icon!!, contentDescription = item.options.title) },
                label = { Text(item.options.title) },
                selected = tabNavigator.current == item,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xff0f7cae),
                    selectedTextColor = Color(0xff0f7cae),
                ),
                onClick = { tabNavigator.current = item },
            )
        }
    }
}
