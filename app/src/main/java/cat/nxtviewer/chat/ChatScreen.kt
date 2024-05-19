package cat.nxtviewer.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cat.nxtviewer.R
import cat.nxtviewer.ui.theme.SecuritymessageBG
import cat.nxtviewer.ui.theme.SecuritymessageText
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
            Column {
                SecurityMessage()
            }
        }
    }
}

@Composable
fun ChatTopBar(navigator: Navigator?) {
    Row(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxWidth()
            .height(75.dp)
            .padding(start = 5.dp, end = 5.dp, bottom = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            modifier = Modifier.weight(1f),
            onClick = {
                navigator?.pop()
            }
        ) {
            Icon(
                modifier = Modifier.size(25.dp),
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White
            )
        }
        Icon(
            modifier = Modifier
                .weight(2f)
                .size(50.dp),
            painter = painterResource(id = R.drawable.user),
            contentDescription = "Chats",
            tint = Color.LightGray
        )
        Spacer(modifier = Modifier.width(5.dp))
        Column(
            modifier = Modifier
                .height(50.dp)
                .weight(8f),
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
        IconButton(
            modifier = Modifier.weight(1.5f),
            onClick = { /*TODO*/ }
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = R.drawable.call),
                contentDescription = "Chats",
                tint = Color.LightGray
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        IconButton(
            modifier = Modifier.weight(1.5f),
            onClick = { /*TODO*/ }
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Chats",
                tint = Color.LightGray
            )
        }
    }
}

@Composable
fun SecurityMessage() {
    Column(
        modifier = Modifier
            .padding(start = 45.dp, end = 45.dp, top = 5.dp, bottom = 5.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = SecuritymessageBG)
            .padding(start = 7.5.dp, end = 7.5.dp, top = 5.dp, bottom = 5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val annotatedString = buildAnnotatedString {
            appendInlineContent(id = "imageId")
            append(" Messages and calls are end-to-end encrypted. No one outside of this chat, not even WhatsApp, can read or listen to them. Tap to learn more.")
        }
        val inlineContentMap = mapOf(
            "imageId" to InlineTextContent(
                Placeholder(10.sp, 10.sp, PlaceholderVerticalAlign.TextCenter)
            ) {
                Icon(
                    modifier = Modifier.size(10.dp),
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    tint = SecuritymessageText
                )
            }
        )
        Text(
            annotatedString,
            inlineContent = inlineContentMap,
            color = SecuritymessageText,
            lineHeight = 16.sp,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}