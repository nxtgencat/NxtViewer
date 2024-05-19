package cat.nxtviewer.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cat.nxtviewer.R
import cat.nxtviewer.chat.ChatScreenUI
import cat.nxtviewer.ui.theme.BottomSelected
import cat.nxtviewer.ui.theme.DividerColor
import cat.nxtviewer.ui.theme.FABColor
import cat.nxtviewer.ui.theme.TabSelected
import cat.nxtviewer.ui.theme.TabSelectedText
import cat.nxtviewer.ui.theme.TabUnSelected
import cat.nxtviewer.ui.theme.TabUnSelectedText
import cat.nxtviewer.ui.theme.WhatsBG

class HomeScreenUI : Screen {
    @Composable
    override fun Content() {

        HomeScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val navigator = LocalNavigator.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = WhatsBG,
        topBar = {
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
                            modifier = Modifier
                                .size(30.dp),
                            painter = painterResource(id = R.drawable.camera),
                            contentDescription = "Chats"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = ""
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            modifier = Modifier
                                .size(30.dp),
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = "Chats"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
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
        },
        bottomBar = {
            BottomAppBar(
                containerColor = WhatsBG,
                contentColor = Color.White,
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        BottomBarTab(R.drawable.chats, "Chats", BottomSelected)
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        BottomBarTab(R.drawable.updates, "Updates")
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        BottomBarTab(R.drawable.communties, "Communities")
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        BottomBarTab(R.drawable.call, "Calls")
                    }
                }
            }
        }
    ) { innerPaddingValues ->
        Column(
            modifier = Modifier
                .padding(innerPaddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Divider(thickness = 0.2.dp, color = DividerColor)
            Spacer(modifier = Modifier.height(20.dp))
            FilterTabRow()
            Spacer(modifier = Modifier.height(10.dp))
            repeat(10) {
                ChatRow(navigator)
            }
        }
    }
}

@Composable
fun BottomBarTab(icon: Int, name: String, color: Color = Color.Transparent) {
    Column(
        modifier = Modifier
            .width(70.dp)
            .height(35.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(color = color)
            .clickable { },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(25.dp),
            painter = painterResource(id = icon),
            contentDescription = name
        )
    }
    Spacer(modifier = Modifier.height(5.dp))
    Text(
        text = name,
        fontSize = 12.sp
    )
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
                .background(color = TabSelected)
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp),
                text = "All",
                color = TabSelectedText
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(color = TabUnSelected)
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp),
                text = "Unread",
                color = TabUnSelectedText
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(color = TabUnSelected)
                .clickable { },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp),
                text = "Groups",
                color = TabUnSelectedText
            )
        }
    }
}

@Composable
fun ChatRow(navigator: Navigator?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navigator?.push(ChatScreenUI()) }
            .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp)
    ) {
        Icon(
            modifier = Modifier
                .size(50.dp)
                .weight(1f),
            painter = painterResource(id = R.drawable.user),
            contentDescription = "Chats",
            tint = Color.LightGray
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier
                .height(50.dp)
                .weight(6f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(8f),
                    maxLines = 1,
                    text = "+919014396580 (You)",
                    fontSize = 16.sp,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis
                )
                Box(
                    modifier = Modifier
                        .height(20.dp)
                        .weight(2f),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        maxLines = 1,
                        text = "Yesterday",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }
            Row {
                Text(
                    modifier = Modifier.weight(8f),
                    maxLines = 1,
                    text = "You reacted to the post sent by sushanth reddy",
                    color = Color.Gray,
                    overflow = TextOverflow.Ellipsis
                )
                Box(modifier = Modifier.weight(2f))
            }

        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}