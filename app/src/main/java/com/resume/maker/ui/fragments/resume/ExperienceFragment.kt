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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.resume.maker.R
import com.resume.maker.adapters.ExperienceAdapter
import com.resume.maker.adapters.TemplatesAdapter
import com.resume.maker.models.ExperienceModel
import com.resume.maker.utils.generateUniqueId
import com.resume.maker.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_experience.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_personal_details.*
import kotlinx.android.synthetic.main.fragment_secondary_details.*
import java.util.*

class ExperienceFragment : Fragment() {

    private var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getString("id")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_experience, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list: MutableLiveData<ArrayList<ExperienceModel>> = MutableLiveData()
        val arrayList: ArrayList<ExperienceModel> = ArrayList<ExperienceModel>()

        add_experience_iv.setOnClickListener {
            if (add_experience_layout.visibility == View.VISIBLE) {
                add_experience_layout.visibility = View.GONE
                add_experience_iv.setImageResource(R.drawable.ic_baseline_add_24)
            } else {
                add_experience_layout.visibility = View.VISIBLE
                add_experience_iv.setImageResource(R.drawable.ic_baseline_arrow_down_24)
            }
        }

        btn_add_experience.setOnClickListener {
            if (validateEditTexts()) {
                arrayList.add(addExperience())
                arrayList.reverse()
                list.value = arrayList

                emptyEditTexts()
                add_experience_layout.visibility = View.GONE
                add_experience_iv.setImageResource(R.drawable.ic_baseline_add_24)
            } else {
                Toast.makeText(requireContext(), "Please enter all fields", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        rv_experience.layoutManager = LinearLayoutManager(context)
        list.observe(viewLifecycleOwner, {
            rv_experience.adapter = ExperienceAdapter(it)
        })

        btn_next_experience.setOnClickListener {
            val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
            viewModel.addExperience("d5506da8-baef-4fbd-ae4f-6432dc8de095", arrayList)
        }

        back_arrow_im_fragment_experience.setOnClickListener {
            findNavController().navigate(ExperienceFragmentDirections.fromExperienceToSecondaryDetails(id.toString()))
        }
    }

    private fun addExperience(): ExperienceModel {
        return ExperienceModel(
            generateUniqueId(),
            job_title_et_experience.text.toString(),
            company_et.text.toString(),
            start_job_et.text.toString(),
            end_job_et.text.toString(),
            job_description_et.text.toString()
        )
    }

    private fun validateEditTexts(): Boolean {
        return !(job_title_et_experience.text.isEmpty() ||
                company_et.text.isEmpty() ||
                start_job_et.text.isEmpty() ||
                end_job_et.text.isEmpty() ||
                job_description_et.text.isEmpty())
    }

    private fun emptyEditTexts() {
        job_title_et_experience.setText("")
        company_et.setText("")
        start_job_et.setText("")
        end_job_et.setText("")
        job_description_et.setText("")

    }
}