package com.resume.maker.ui.fragments.resume

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.resume.maker.R
import com.resume.maker.adapters.EducationAdapter
import com.resume.maker.adapters.ProjectAdapter
import com.resume.maker.models.EducationModel
import com.resume.maker.models.ProjectModel
import com.resume.maker.utils.generateUniqueId
import com.resume.maker.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_education.*
import kotlinx.android.synthetic.main.fragment_project.*
import java.util.ArrayList

class EducationFragment : Fragment() {

    private var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getString(id)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_education, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list: MutableLiveData<ArrayList<EducationModel>> = MutableLiveData()
        val arrayList: ArrayList<EducationModel> = ArrayList<EducationModel>()

        add_edu_iv.setOnClickListener {
            if (add_edu_layout.visibility == View.VISIBLE) {
                add_edu_layout.visibility = View.GONE
                add_edu_iv.setImageResource(R.drawable.ic_baseline_add_24)
            } else {
                add_edu_layout.visibility = View.VISIBLE
                add_edu_iv.setImageResource(R.drawable.ic_baseline_arrow_down_24)
            }
        }

        btn_add_edu.setOnClickListener {
            if (validateEditTexts()) {
                arrayList.add(addEducation())
                arrayList.reverse()
                list.value = arrayList

                emptyEditTexts()
                add_edu_layout.visibility = View.GONE
                add_edu_iv.setImageResource(R.drawable.ic_baseline_add_24)
            } else {
                Toast.makeText(requireContext(), "Please enter all fields", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        rv_edu.layoutManager = LinearLayoutManager(context)
        list.observe(viewLifecycleOwner, {
            rv_edu.adapter = EducationAdapter(it)
        })

        btn_next_edu.setOnClickListener {
            val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
            viewModel.addEducation("d5506da8-baef-4fbd-ae4f-6432dc8de095", arrayList)
        }

        back_arrow_im_fragment_edu.setOnClickListener {
            findNavController().navigate(EducationFragmentDirections.fromEducationToProject(id.toString()))
        }
    }

    private fun addEducation(): EducationModel {
        return EducationModel(
            generateUniqueId(),
            class_name_et.text.toString(),
            passing_year_et.text.toString(),
            percentage_et.text.toString(),
        )
    }

    private fun validateEditTexts(): Boolean {
        return !(class_name_et.text.isEmpty() ||
                passing_year_et.text.isEmpty() ||
                percentage_et.text.isEmpty())
    }

    private fun emptyEditTexts() {
        class_name_et.setText("")
        passing_year_et.setText("")
        percentage_et.setText("")
    }
}