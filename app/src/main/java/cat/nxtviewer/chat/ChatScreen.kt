package cat.nxtviewer.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cat.nxtviewer.R
import cat.nxtviewer.ui.theme.WhatsBG

class ChatScreenUI : Screen {
    @Composable
    override fun Content() {
        ChatScreen()
    }
}

@Composable
fun ChatScreen() {

    val navigator = LocalNavigator.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = WhatsBG,
        topBar = {
            ChatTopBar(navigator)
        },
    ) { innerPaddingValues ->
        Box(
            modifier = Modifier
                .padding(innerPaddingValues)
                .fillMaxSize()
        ) {
            Image(
                modifier = Modifier.matchParentSize(),
                painter = painterResource(id = R.drawable.chatbg),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun ChatTopBar(navigator: Navigator?) {
    Row(
        modifier = Modifier
            .safeDrawingPadding()
            .padding(start = 5.dp, end = 5.dp, bottom = 10.dp)
            .fillMaxWidth()
            .height(75.dp),
        verticalAlignment = Alignment.Bottom,
    ) {
        IconButton(
            onClick = {
                navigator?.pop()
            }
        ) {
            Icon(
                modifier = Modifier
                    .size(25.dp)
                    .weight(1f),
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White
            )
        }
        Icon(
            modifier = Modifier
                .size(50.dp)
                .weight(5f),
            painter = painterResource(id = R.drawable.user),
            contentDescription = "Chats",
            tint = Color.LightGray
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier
                .height(50.dp)
                .weight(20f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    maxLines = 1,
                    text = "+919014396580 (You)",
                    fontSize = 18.sp,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(12.dp),
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    maxLines = 1,
                    text = "End-to-end encrypted",
                    color = Color.Gray,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 14.sp
                )
            }
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .weight(1f),
                painter = painterResource(id = R.drawable.call),
                contentDescription = "Chats",
                tint = Color.LightGray
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .weight(1f),
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Chats",
                tint = Color.LightGray
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}