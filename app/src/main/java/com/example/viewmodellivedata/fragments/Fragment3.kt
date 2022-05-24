package com.example.viewmodellivedata.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.viewmodellivedata.R
import com.example.viewmodellivedata.model.Fragment3ViewModel

class Fragment3 : Fragment() {

    lateinit var viewModel3 : Fragment3ViewModel
    lateinit var view3 : View
    lateinit var txtfrag3 : TextView
    lateinit var btn3 : Button

    companion object {
        fun newInstance() = Fragment3()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view3 = inflater.inflate(R.layout.fragment_3, container, false)
        txtfrag3 = view3.findViewById(R.id.textView3)
        btn3 = view3.findViewById(R.id.btn3)
        return view3
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel3 = ViewModelProvider(requireActivity()).get(Fragment3ViewModel::class.java)
        viewModel3.name.observe(viewLifecycleOwner, Observer{ result ->
            txtfrag3.text = result.toString()
        })
    }

    override fun onStart() {
        super.onStart()

        btn3.setOnClickListener {
            val action3 = Fragment3Directions.actionFragment3ToFragment1()
            view3.findNavController().navigate(action3)
        }
    }

}