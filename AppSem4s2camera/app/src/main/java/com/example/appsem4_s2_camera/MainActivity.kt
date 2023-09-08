package com.example.appsem4_s2_camera

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private val CAMERA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCamara = findViewById<Button>(R.id.btCamara)

        btCamara.setOnClickListener {
            checkCameraPermission()
        }
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED){
            //si no se dio permiso
            requestCameraPermission()
        }
        else{
            //si se dio permiso
            Toast.makeText(this,"¡Ya se tiene permiso de la cámara!", Toast.LENGTH_LONG).show()
        }
    }

    private fun requestCameraPermission() {
        //vamos a solicitar el permiso
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
            //si es V
            //El usuario ya rechazó el permiso, debe habilitarlo manualmente
            Toast.makeText(this,"¡Rechazó el permiso!, debe habilitarlo manualmente", Toast.LENGTH_LONG).show()
        }
        else{
            //El usuario NUNCA aceptó ni rechazó el permiso. Se le pide el permiso
            Toast.makeText(this,"¡Debe aceptar el permiso", Toast.LENGTH_LONG).show()
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),CAMERA_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode){
            CAMERA_REQUEST_CODE ->{
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //se aceptó el permiso
                    Toast.makeText(this,"¡Permiso ACEPTADO!", Toast.LENGTH_LONG).show()
                    //Aqui se pondrían las funcionalidades de la camara
                }
                else{
                    Toast.makeText(this,"¡Permiso NEGADO!", Toast.LENGTH_LONG).show()
                }
                return
            }
        }
    }
}