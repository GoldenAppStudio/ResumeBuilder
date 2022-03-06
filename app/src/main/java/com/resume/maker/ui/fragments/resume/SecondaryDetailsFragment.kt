package com.resume.maker.ui.fragments.resume

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.resume.maker.R
import com.resume.maker.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_secondary_details.*

class SecondaryDetailsFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_secondary_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add_language_iv.setOnClickListener {
            add_language_iv.setImageResource(R.drawable.ic_baseline_arrow_down_24)
            add_language_layout.visibility = View.VISIBLE
        }

        add_skills_iv.setOnClickListener {
            add_skills_iv.setImageResource(R.drawable.ic_baseline_arrow_down_24)
            add_skill_layout.visibility = View.VISIBLE
        }

        val langList: ArrayList<String> = ArrayList()
        val skillList: ArrayList<String> = ArrayList()

        btn_add_language.setOnClickListener {
            if (language_et.text.isEmpty()) {
                language_et.error = "Please add language"
            } else {
                langList.add(language_et.text.toString())
                addLangChip()
            }
        }
        btn_add_skill.setOnClickListener {
            if (skill_et.text.isEmpty()) {
                skill_et.error = "Please add Skill"
            } else {
                skillList.add(skill_et.text.toString())
                addSkillChip()
            }
        }

        btn_next_secondary_details.setOnClickListener {
            val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
            viewModel.addSecondaryDetails(id, langList, skillList)

            findNavController().navigate(SecondaryDetailsFragmentDirections.fromSecondaryDetailsToExperience(id.toString()))
        }

        back_arrow_im_fragment_secondary_details.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun addLangChip() {
        language_chip_group.visibility = View.VISIBLE
        val chip = Chip(language_chip_group.context)
        chip.text = language_et.text.toString()
        chip.setChipBackgroundColorResource(R.color.white_50)
        chip.isCloseIconVisible = true
        chip.isClickable = true
        chip.setOnClickListener(langChipClickListener)
        chip.setTextColor(resources.getColor(R.color.primary_blue))
        language_chip_group.addView(chip)

        language_et.setText("")
        add_language_iv.setImageResource(R.drawable.ic_baseline_add_24)
        add_language_layout.visibility = View.GONE
    }

    private fun addSkillChip() {
        skill_chip_group.visibility = View.VISIBLE
        val chip = Chip(skill_chip_group.context)
        chip.text = skill_et.text.toString()
        chip.setChipBackgroundColorResource(R.color.white_50)
        chip.isCloseIconVisible = true
        chip.isClickable = true
        chip.setOnClickListener(skillChipClickListener)
        chip.setTextColor(resources.getColor(R.color.primary_blue))
        skill_chip_group.addView(chip)

        skill_et.setText("")
        add_skills_iv.setImageResource(R.drawable.ic_baseline_add_24)
        add_skill_layout.visibility = View.GONE
    }

    private val langChipClickListener = View.OnClickListener {

        val anim = AlphaAnimation(1f, 0f)
        anim.duration = 250
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                language_chip_group.removeView(it)
            }

            override fun onAnimationStart(animation: Animation?) {}
        })

        it.startAnimation(anim)
    }

    private val skillChipClickListener = View.OnClickListener {

        val anim = AlphaAnimation(1f, 0f)
        anim.duration = 250
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                skill_chip_group.removeView(it)
            }

            override fun onAnimationStart(animation: Animation?) {}
        })

        it.startAnimation(anim)
    }
}

