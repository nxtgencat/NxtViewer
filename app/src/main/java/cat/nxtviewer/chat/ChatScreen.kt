package cat.nxtviewer.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cat.nxtviewer.R
import cat.nxtviewer.ui.theme.DividerColor
import cat.nxtviewer.ui.theme.GreyText
import cat.nxtviewer.ui.theme.ReceiverBubbleBG
import cat.nxtviewer.ui.theme.SecurityMessageBG
import cat.nxtviewer.ui.theme.SecurityMessageText
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
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SecurityMessage()
                }
                ReceiverBubble()
            }
        }
    }
}

@Composable
fun ChatTopBar(navigator: Navigator?) {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp, top = 5.dp, bottom = 5.dp)
            .height(50.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    navigator?.pop()
                }
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Icon(
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = R.drawable.user),
                contentDescription = "Chats",
                tint = Color.LightGray
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(7f),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    maxLines = 1,
                    text = "+919014396580 (You)",
                    fontSize = 16.sp,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis
                )
                TextWithIcon(
                    imageVector = Icons.Default.Lock,
                    vectorWidth = 10.sp,
                    vectorHeight = 10.sp,
                    color = GreyText,
                    text = " End-to-end encrypted",
                    textSize = 14.sp,
                    maxLines = 1
                )
            }
            Box(
                modifier = Modifier.weight(3f),
                contentAlignment = Alignment.CenterEnd
            ){
                Row(
                    modifier = Modifier.width(100.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(
                    modifier = Modifier.weight(1f),
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.call),
                            contentDescription = "Chats",
                            tint = Color.White
                        )
                    }
                    IconButton(
                    modifier = Modifier.weight(1f),
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = "Chats",
                            tint = Color.White
                        )
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(5.dp))
        Divider(thickness = 0.2.dp, color = DividerColor)
    }
}

@Composable
fun SecurityMessage() {
    Column(
        modifier = Modifier
            .padding(start = 40.dp, end = 40.dp, top = 10.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = SecurityMessageBG)
            .padding(start = 8.dp, end = 8.dp, top = 6.dp, bottom = 6.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextWithIcon(
            imageVector = Icons.Outlined.Lock,
            vectorWidth = 10.sp,
            vectorHeight = 10.sp,
            color = SecurityMessageText,
            text = " Messages and calls are end-to-end encrypted. No one outside of this chat, not even WhatsApp, can read or listen to them. Tap to learn more.",
            textSize = 13.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TextWithIcon(
    imageVector: ImageVector,
    vectorWidth: TextUnit,
    vectorHeight: TextUnit,
    color: Color,
    text: String,
    textSize: TextUnit,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null
) {
    val annotatedString = buildAnnotatedString {
        appendInlineContent(id = "imageId")
        append(text)
    }
    val inlineContentMap = mapOf(
        "imageId" to InlineTextContent(
            Placeholder(vectorWidth, vectorHeight, PlaceholderVerticalAlign.TextCenter)
        ) {
            Icon(
                modifier = Modifier.size(10.dp),
                imageVector = imageVector,
                contentDescription = null,
                tint = color
            )
        }
    )
    Text(
        annotatedString,
        inlineContent = inlineContentMap,
        color = color,
        lineHeight = 16.sp,
        fontSize = textSize,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Composable
fun ReceiverBubble() {
    Box(
        modifier = Modifier
            .padding(start = 15.dp, top = 5.dp, end = 15.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = ReceiverBubbleBG)
            .padding(start = 10.dp, top = 5.dp, bottom = 5.dp, end = 10.dp)
            .widthIn(min = 60.dp, max = 300.dp)
    ) {
        Text(
            text = "Hi",
            color = Color.White
        )
        Text(
            modifier = Modifier
                .align(Alignment.BottomEnd),
            text = "9:45 PM",
            color = Color.Gray,
            fontSize = 10.sp,

            )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}