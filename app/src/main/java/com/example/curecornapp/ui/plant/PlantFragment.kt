package com.example.curecornapp.ui.plant

<<<<<<< HEAD
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.curecornapp.R
import com.example.curecornapp.databinding.FragmentPlantBinding

class PlantFragment : Fragment() {

    private var _binding: FragmentPlantBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
=======
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import coil.load
import coil.transform.CircleCropTransformation
import com.example.curecornapp.databinding.FragmentPlantBinding
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.single.PermissionListener

class PlantFragment : Fragment() {

    private lateinit var binding: FragmentPlantBinding
    private val CAMERA_REQUEST_CODE = 1
    private val GALLERY_REQUEST_CODE = 2
>>>>>>> 0d40f4b (First Commit)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
<<<<<<< HEAD
    ): View {
        return inflater.inflate(R.layout.fragment_plant, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
=======
    ): View? {
        binding = FragmentPlantBinding.inflate(layoutInflater)

        binding.btnCamera.setOnClickListener {
            cameraCheckPermission()
        }

        binding.btnGallery.setOnClickListener {
            galleryCheckPermission()
        }

        //when you click on the image
        binding.imageView.setOnClickListener {
            val pictureDialog = context?.let { it1 -> AlertDialog.Builder(it1) }
            pictureDialog?.setTitle("Select Action")
            val pictureDialogItem = arrayOf("Select photo from Gallery",
                "Capture photo from Camera")
            pictureDialog?.setItems(pictureDialogItem) { dialog, which ->

                when (which) {
                    0 -> gallery()
                    1 -> camera()
                }
            }
            pictureDialog?.show()
        }
        return binding.root
    }

    private fun galleryCheckPermission() {

        Dexter.withContext(context).withPermission(
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        ).withListener(object : PermissionListener {
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                gallery()
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText(
                    context,
                    "You have denied the storage permission to select image",
                    Toast.LENGTH_SHORT
                ).show()
                showRotationalDialogForPermission()
            }

            override fun onPermissionRationaleShouldBeShown(
                p0: PermissionRequest?, p1: PermissionToken?) {
                showRotationalDialogForPermission()
            }
        }).onSameThread().check()
    }

    private fun gallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }

    private fun cameraCheckPermission() {
        Dexter.withContext(context)
            .withPermissions(
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.CAMERA).withListener(

                object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                        report?.let {
                            if (report.areAllPermissionsGranted()) {
                                camera()
                            }

                        }
                    }

                    override fun onPermissionRationaleShouldBeShown(
                        p0: MutableList<PermissionRequest>?,
                        p1: PermissionToken?) {
                        showRotationalDialogForPermission()
                    }

                }
            ).onSameThread().check()
    }

    private fun camera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {

            when (requestCode) {

                CAMERA_REQUEST_CODE -> {

                    val bitmap = data?.extras?.get("data") as Bitmap

                    //we are using coroutine image loader (coil)
                    binding.imageView.load(bitmap) {
                        crossfade(true)
                    }
                }

                GALLERY_REQUEST_CODE -> {

                    binding.imageView.load(data?.data) {
                        crossfade(true)
                        crossfade(1000)
                    }
                }
            }
        }
    }

    private fun showRotationalDialogForPermission() {
        context?.let {
            AlertDialog.Builder(it)
                .setMessage("It looks like you have turned off permissions"
                        + "required for this feature. It can be enable under App settings!!!")

                .setPositiveButton("Go TO SETTINGS") { _, _ ->

                    try {
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                        val packageName = "CureCorn"
                        val uri = Uri.fromParts("package", packageName, null)
                        intent.data = uri
                        startActivity(intent)

                    } catch (e: ActivityNotFoundException) {
                        e.printStackTrace()
                    }
                }

                .setNegativeButton("CANCEL") { dialog, _ ->
                    dialog.dismiss()
                }.show()
        }
    }
}

>>>>>>> 0d40f4b (First Commit)
