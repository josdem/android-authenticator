package com.josdem.authenticator.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.josdem.authenticator.R
import com.josdem.authenticator.data.model.Message

class MessageAdapter(private val dataSet: Array<Message>) : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.text_chat_indicator)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MessageAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        holder: MessageAdapter.ViewHolder,
        position: Int,
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
