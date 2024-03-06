package com.josdem.authenticator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.josdem.authenticator.data.MessageDataSource
import com.josdem.authenticator.databinding.ActivityMessageBinding

class MessageActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMessageBinding
    private var messageDataSource = MessageDataSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_message)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        val button = findViewById<Button>(R.id.button_chat_send)
        val chatContent = findViewById<TextView>(R.id.text_chat_indicator)
        val message = findViewById<TextView>(R.id.edit_chat_message)
        button.setOnClickListener {
            Log.d("message:", message.text.toString())
            messageDataSource.sendMessage(message.text.toString())
            chatContent.text = messageDataSource.getMessage()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_message)
        return navController.navigateUp(appBarConfiguration) ||
            super.onSupportNavigateUp()
    }
}
