package com.example.viewmodellivedata.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.viewmodellivedata.R
import com.example.viewmodellivedata.model.Fragment1ViewModel

class Fragment1 : Fragment() {

    companion object{
        fun newInstance() = Fragment1()
    }

    lateinit var view1 : View
    lateinit var textFragment : TextView
    lateinit var btngo2 : Button
    lateinit var btngo3 : Button
    lateinit var editText : EditText
    lateinit var viewmodel : Fragment1ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view1 = inflater.inflate(R.layout.fragment_1, container, false)
        textFragment = view1.findViewById(R.id.textid)
        btngo2 = view1.findViewById(R.id.btngo2)
        btngo3 = view1.findViewById(R.id.btngo3)
        editText = view1.findViewById(R.id.edittextid)

        editText.setText("ViewModel Test")

        return view1
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewmodel = ViewModelProvider(requireActivity()).get(Fragment1ViewModel::class.java)
        viewmodel.name.observe(viewLifecycleOwner, Observer{result ->
            textFragment.text = result.toString() //push
        })
        editText.setText(viewmodel.name.value)
    }

    override fun onStart() {
        super.onStart()

        btngo2.setOnClickListener {
            val  action2 = Fragment1Directions.actionFragment1ToFragment2()
            view1.findNavController().navigate(action2)
            viewmodel.changeName()
        }

        btngo3.setOnClickListener {
            val action = Fragment1Directions.actionFragment1ToFragment3()
            view1.findNavController().navigate(action)
            viewmodel.changeName()
        }
    }

}