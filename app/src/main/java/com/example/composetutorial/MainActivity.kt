package com.example.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme() {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(Message("Son", "Football Player"))
                }
            }
        }
    }

    data class Message(val author: String, val body: String)

    @Composable
    fun MessageCard(msg: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.ic_image_foreground),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = msg.author,
                     color = MaterialTheme.colorScheme.secondary,
                     style = MaterialTheme.typography.titleSmall)

                Spacer(modifier = Modifier.height(4.dp))

                Surface(shadowElevation = 1.dp) {
                    Text(text = msg.body,
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }

    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )

    @Preview
    @Composable
    fun PreviewMessageCard() {
        ComposeTutorialTheme() {
            androidx.compose.material3.Surface() {
                MessageCard(
                    msg = Message("Ahn", "안녕하세요")
                )
            }
        }
    }

    @Composable
    fun Conversation(message: List<Message>) {
        LazyColumn {
            
        }
    }
}
