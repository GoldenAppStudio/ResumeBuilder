package com.resume.maker.ui.fragments.resume

import android.app.Activity.RESULT_OK
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.resume.maker.R
import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.resume.maker.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_take_pic.*
import kotlinx.coroutines.delay
import java.io.IOException


class TakePicFragment : Fragment() {

    private var id: String? = null

    // Uri indicates, where the image will be picked from
    private var filePath: Uri? = null

    // request code
    private val PICK_IMAGE_REQUEST = 22

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
        return inflater.inflate(R.layout.fragment_take_pic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add_pic_iv.setOnClickListener {
            selectImage()
        }

        btn_next_pic.setOnClickListener {
            if (filePath != null) {
                val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
                viewModel.uploadImage("d5506da8-baef-4fbd-ae4f-6432dc8de095", filePath)

                findNavController().navigate(TakePicFragmentDirections.fromPicToPreview(id.toString()))
            }
        }
    }

    // Select Image method
    private fun selectImage() {
        // Defining Implicit Intent to mobile gallery
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(
            Intent.createChooser(
                intent,
                "Select Image from here..."
            ),
            PICK_IMAGE_REQUEST
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PICK_IMAGE_REQUEST
            && data != null
            && resultCode == RESULT_OK
            && data.data != null
        ) {
            try {
                // Setting image on image view using Bitmap
                val b = data.data
                filePath = b
                val bitmap = MediaStore.Images.Media
                    .getBitmap(
                        requireActivity().contentResolver,
                        b
                    )
                add_pic_iv.setImageBitmap(bitmap)
                Log.d("__img", "" + b)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

}