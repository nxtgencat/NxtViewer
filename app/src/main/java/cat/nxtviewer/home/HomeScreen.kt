@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package cat.nxtviewer.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.PushPin
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cat.nxtviewer.R
import cat.nxtviewer.chat.ChatScreenUI
import cat.nxtviewer.ui.theme.BottomTabSelected
import cat.nxtviewer.ui.theme.BottomTabSelectedIcon
import cat.nxtviewer.ui.theme.ChatRowSelected
import cat.nxtviewer.ui.theme.DividerColor
import cat.nxtviewer.ui.theme.FABColor
import cat.nxtviewer.ui.theme.FilterTabSelected
import cat.nxtviewer.ui.theme.FilterTabSelectedText
import cat.nxtviewer.ui.theme.FilterTabUnSelected
import cat.nxtviewer.ui.theme.FilterTabUnSelectedText
import cat.nxtviewer.ui.theme.GreyText
import cat.nxtviewer.ui.theme.WhatsBG

class HomeScreenUI : Screen {
    @Composable
    override fun Content() {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {

    val navigator = LocalNavigator.current
    val viewModel: HomeViewModel = viewModel()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = WhatsBG,
        topBar = {
            Column {
                if (viewModel.isSelected.value) {
                    MenuTopBar(viewModel)
                } else {
                    TopAppBar()
                }
                Divider(thickness = 0.2.dp, color = DividerColor)
            }
        },
        floatingActionButton = {
            FloatingActionButton()
        },
        bottomBar = {
            BottomBar()
        }
    ) { innerPaddingValues ->
        Column(
            modifier = Modifier
                .padding(innerPaddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            FilterTabRow()
            Spacer(modifier = Modifier.height(10.dp))
            ChatRow(navigator, viewModel)
        }
    }
}

@Composable
fun TopAppBar() {
    TopAppBar(
        colors = topAppBarColors(
            containerColor = WhatsBG,
            titleContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        title = {
            Text(
                text = "WhatsApp",
                fontWeight = FontWeight.W700
            )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = "Chats"
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = Icons.Default.Search,
                    contentDescription = ""
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Chats"
                )
            }
        }
    )
}

@Composable
fun MenuTopBar(
    viewModel: HomeViewModel
) {
    Row(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .height(64.dp)
            .padding(start = 5.dp, end = 5.dp, top = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { viewModel.isSelected.value = false }
        ) {
            Icon(
                modifier = Modifier.size(25.dp),
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = Color.White
            )
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = Icons.Outlined.PushPin,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            IconButton(
                onClick = { }
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            IconButton(
                onClick = { }
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = Icons.Outlined.Archive,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            IconButton(
                onClick = { }
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun FilterTabRow() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(color = FilterTabSelected)
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp),
                text = "All",
                color = FilterTabSelectedText
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(color = FilterTabUnSelected)
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp),
                text = "Unread",
                color = FilterTabUnSelectedText
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(color = FilterTabUnSelected)
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp),
                text = "Groups",
                color = FilterTabUnSelectedText
            )
        }
    }
}

@Composable
fun ChatRow(
    navigator: Navigator?,
    viewModel: HomeViewModel
) {

    val haptics = LocalHapticFeedback.current
    val chatColor = if (viewModel.isSelected.value) ChatRowSelected else Color.Unspecified

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(chatColor)
            .combinedClickable(
                onClick = {
                    when (viewModel.isSelected.value) {
                        true -> viewModel.toggleSelection()
                        false -> navigator?.push(ChatScreenUI())
                    }
                },
                onLongClick = {
                    viewModel.toggleSelection()
                    haptics.performHapticFeedback(HapticFeedbackType.LongPress)
                }
            )
            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
            .height(50.dp),
    ) {
        Icon(
            modifier = Modifier
                .size(45.dp)
                .align(Alignment.CenterVertically),
            painter = painterResource(id = R.drawable.user),
            contentDescription = "Chats",
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier
                .weight(8f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                maxLines = 1,
                text = "+919014396580 (You)",
                fontSize = 16.sp,
                color = Color.White,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                maxLines = 1,
                text = "You reacted to the post sent by sushanth reddy",
                color = GreyText,
                overflow = TextOverflow.Ellipsis
            )
        }
        Column(
            modifier = Modifier
                .weight(2f)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.End
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                maxLines = 1,
                text = "Yesterday",
                color = GreyText,
                fontSize = 12.sp
            )
        }

    }
}

@Composable
fun FloatingActionButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = FABColor,
    ) {
        Icon(
            modifier = Modifier.size(30.dp),
            painter = painterResource(id = R.drawable.fab),
            contentDescription = "Chats",
            tint = Color.Black
        )
    }
}

@Composable
fun BottomBarTabItem(
    icon: Int,
    name: String,
    iconColor: Color = LocalContentColor.current,
    tabColor: Color = Color.Transparent
) {
    Column(
        modifier = Modifier
            .width(70.dp)
            .height(35.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(color = tabColor)
            .clickable { },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(25.dp),
            painter = painterResource(id = icon),
            contentDescription = name,
            tint = iconColor
        )
    }
    Spacer(modifier = Modifier.height(5.dp))
    Text(
        text = name,
        fontSize = 12.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun BottomBar() {
    Column {
        Divider(thickness = 0.2.dp, color = DividerColor)
        BottomAppBar(
            containerColor = WhatsBG,
            contentColor = Color.White,
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BottomBarTabItem(
                        R.drawable.chats,
                        "Chats",
                        BottomTabSelectedIcon,
                        BottomTabSelected
                    )
                }
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BottomBarTabItem(R.drawable.updates, "Updates")
                }
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BottomBarTabItem(R.drawable.communties, "Communities")
                }
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BottomBarTabItem(R.drawable.call, "Calls")
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}