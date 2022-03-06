package com.resume.maker.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.resume.maker.R
import com.resume.maker.adapters.TemplatesAdapter
import com.resume.maker.callbacks.NavigateToPersonalDetailsFragmentCallback
import com.resume.maker.models.TemplatesModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), NavigateToPersonalDetailsFragmentCallback {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayList = arrayListOf<TemplatesModel>()

        arrayList.add( TemplatesModel(0, R.drawable.logo_main))
        arrayList.add( TemplatesModel(1, R.drawable.logo_main))
        arrayList.add( TemplatesModel(2, R.drawable.logo_main))
        arrayList.add( TemplatesModel(3, R.drawable.logo_main))

        templates_rv_fragment_home.apply {
            this.layoutManager = GridLayoutManager(context, 2)
            this.adapter = TemplatesAdapter(arrayList, this@HomeFragment)
        }
    }

    override fun navigate() {
        findNavController().navigate(HomeFragmentDirections.fromHomeToPersonalDetails())
    }
}