package com.resume.maker.ui.fragments.resume

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.resume.maker.R
import com.resume.maker.models.PersonalDetailsModel
import com.resume.maker.utils.generateUniqueId
import com.resume.maker.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_personal_details.*

class PersonalDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_next_personal_details.setOnClickListener {
            if (validateEditTexts()) {
                val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
                val personalDetailsModel = PersonalDetailsModel(
                    generateUniqueId(),
                    full_name_et.text.toString(),
                    phone_et.text.toString(),
                    email_et.text.toString(),
                    address_et.text.toString(),
                    job_title_et.text.toString(),
                )
                viewModel.login().observe(viewLifecycleOwner, {
                    Toast.makeText(requireContext(), "id: " + it.isAnonymous, Toast.LENGTH_SHORT)
                        .show()
                })
                viewModel.addResumeWithPersonalDetails(personalDetailsModel)
                findNavController().navigate(PersonalDetailsFragmentDirections.fromPersonalDetailsSecondaryDetails(personalDetailsModel.id))
            } else {
                Toast.makeText(requireContext(), "Please enter all fields", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun validateEditTexts(): Boolean {
        return !(full_name_et.text.isEmpty() ||
                phone_et.text.isEmpty() ||
                email_et.text.isEmpty() ||
                address_et.text.isEmpty() ||
                job_title_et.text.isEmpty())
    }
}