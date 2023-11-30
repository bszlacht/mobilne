package com.example.bartoszszlachtaandroidlab1

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.bartoszszlachtaandroidlab1.databinding.ActivityActionsBinding

class ActionsActivity : Fragment() {

    private lateinit var binding: ActivityActionsBinding
    private lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityActionsBinding.inflate(inflater, container, false)

        user = ViewModelProvider(this)[User::class.java]
        user.firstName = MutableLiveData("Bartosz")
        user.lastName = MutableLiveData("Szlachta")
        binding.user = user
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvSampleMessage: TextView = binding.SampleMessage

        binding.apply {
            btn1.setOnClickListener() {
                Log.i("myApp", "msg from listener")
            }
            btn2.setOnClickListener() {
                Log.i("myApp", "msg from listener")
                //Toast.makeText(this@ActionsActivity, "msg from my app btn2", Toast.LENGTH_LONG).show()
            }
            btn3.setOnClickListener() {
                tvSampleMessage.text = "aaa"
            }
            btn4.setOnClickListener() {
                user?.firstName = MutableLiveData("AAAA")
                user?.lastName = MutableLiveData("AAAA")
                binding.user = user
            }
        }
    }
}