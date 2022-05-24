package com.example.viewmodellivedata.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.viewmodellivedata.R
import com.example.viewmodellivedata.model.Fragment1ViewModel
import com.example.viewmodellivedata.model.Fragment2ViewModel

class Fragment2 : Fragment() {

    companion object{
        fun newInstance() = Fragment2()
    }

    lateinit var viewModel1: Fragment1ViewModel
    lateinit var view2 : View
    lateinit var txtFragment2: TextView
    lateinit var editText2: EditText
    lateinit var btnfrag2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        view2 = inflater.inflate(R.layout.fragment_2, container, false)
        txtFragment2 = view2.findViewById(R.id.textView2)
        editText2 = view2.findViewById(R.id.inputchange)
        btnfrag2 = view2.findViewById(R.id.btnchange)
        return view2
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel1 = ViewModelProvider(requireActivity()).get(Fragment1ViewModel::class.java)
        requireActivity().title = viewModel1.name.value.toString()
        editText2.setText(viewModel1.name.value.toString())
    }

    override fun onStart() {
        super.onStart()
        btnfrag2.setOnClickListener {
            viewModel1.name.value = editText2.text.toString()
            val action2 = Fragment2Directions.actionFragment2ToFragment1()
            view2.findNavController().navigate(action2)
        }
    }
}