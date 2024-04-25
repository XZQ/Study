/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xzq.composestudy.rally

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.xzq.composestudy.rally.ui.accounts.AccountsScreen
import com.xzq.composestudy.rally.ui.accounts.SingleAccountScreen
import com.xzq.composestudy.rally.ui.bills.BillsScreen
import com.xzq.composestudy.rally.ui.overview.OverviewScreen

/**
 * Contract for information needed on every Rally navigation destination
 */
interface RallyDestination {
    val icon: ImageVector
    val route: String
    val screen: @Composable () -> Unit
}

/**
 * Rally app navigation destinations
 */
object Overview : RallyDestination {
    override val icon = Icons.Filled.Home
    override val route = "overview"
    override val screen: @Composable () -> Unit = { OverviewScreen() }
}

object Accounts : RallyDestination {
    override val icon = Icons.Filled.AccountCircle
    override val route = "accounts"
    override val screen: @Composable () -> Unit = { AccountsScreen() }
}

object Bills : RallyDestination {
    override val icon = Icons.Filled.List
    override val route = "bills"
    override val screen: @Composable () -> Unit = { BillsScreen() }
}

object SingleAccount : RallyDestination {
    // Added for simplicity, this icon will not in fact be used, as SingleAccount isn't
    // part of the RallyTabRow selection
    override val icon = Icons.Filled.AccountBox
    override val route = "single_account"
    override val screen: @Composable () -> Unit = { SingleAccountScreen() }
    const val accountTypeArg = "account_type"
}

// Screens to be displayed in the top RallyTabRow
val rallyTabRowScreens = listOf(Overview, Accounts, Bills)
