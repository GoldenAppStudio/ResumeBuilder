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
import com.resume.maker.adapters.ExperienceAdapter
import com.resume.maker.adapters.ProjectAdapter
import com.resume.maker.models.ExperienceModel
import com.resume.maker.models.ProjectModel
import com.resume.maker.utils.generateUniqueId
import com.resume.maker.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_experience.*
import kotlinx.android.synthetic.main.fragment_experience.add_experience_layout
import kotlinx.android.synthetic.main.fragment_project.*
import java.util.ArrayList

class ProjectFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_project, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list: MutableLiveData<ArrayList<ProjectModel>> = MutableLiveData()
        val arrayList: ArrayList<ProjectModel> = ArrayList<ProjectModel>()

        add_project_iv.setOnClickListener {
            if (add_project_layout.visibility == View.VISIBLE) {
                add_project_layout.visibility = View.GONE
                add_project_iv.setImageResource(R.drawable.ic_baseline_add_24)
            } else {
                add_project_layout.visibility = View.VISIBLE
                add_project_iv.setImageResource(R.drawable.ic_baseline_arrow_down_24)
            }
        }

        btn_add_project.setOnClickListener {
            if (validateEditTexts()) {
                arrayList.add(addProject())
                arrayList.reverse()
                list.value = arrayList

                emptyEditTexts()
                add_project_layout.visibility = View.GONE
                add_project_iv.setImageResource(R.drawable.ic_baseline_add_24)
            } else {
                Toast.makeText(requireContext(), "Please enter all fields", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        rv_project.layoutManager = LinearLayoutManager(context)
        list.observe(viewLifecycleOwner, {
            rv_project.adapter = ProjectAdapter(it)
        })

        btn_next_project.setOnClickListener {
            val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
            viewModel.addProject("d5506da8-baef-4fbd-ae4f-6432dc8de095", arrayList)

            findNavController().navigate(ProjectFragmentDirections.fromProjectToEdu(id.toString()))
        }

        back_arrow_im_fragment_project.setOnClickListener {
            findNavController().navigate(ProjectFragmentDirections.fromProjectToExperience(id.toString()))
        }
    }

    private fun addProject(): ProjectModel {
        return ProjectModel(
            generateUniqueId(),
            project_title_et.text.toString(),
            your_role_et.text.toString(),
            team_size_et.text.toString(),
            tech_used_et.text.toString(),
            summary_et.text.toString()
        )
    }

    private fun validateEditTexts(): Boolean {
        return !(project_title_et.text.isEmpty() ||
                team_size_et.text.isEmpty() ||
                summary_et.text.isEmpty() ||
                tech_used_et.text.isEmpty() ||
                your_role_et.text.isEmpty())
    }

    private fun emptyEditTexts() {
        project_title_et.setText("")
        team_size_et.setText("")
        your_role_et.setText("")
        tech_used_et.setText("")
        summary_et.setText("")
    }
}