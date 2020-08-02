package com.internshala.bookhub.fragment


import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.internshala.bookhub.R

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {
    private lateinit var imgfb:ImageView
    private lateinit var imgwhatsapp:ImageView
    private lateinit var imginsta:ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view=inflater.inflate(R.layout.fragment_profile, container, false)

        imgfb=view.findViewById(R.id.imgfb)
        imgwhatsapp=view.findViewById(R.id.imgwhatsapp)
        imginsta=view.findViewById(R.id.imginsta)

        imgfb.setOnClickListener{
         goToFbPage("576120919732517")

        }
        imgwhatsapp.setOnClickListener{

         goToWhatsappPage()

        }
        imginsta.setOnClickListener{
            goToInstaPage()

        }

        return view
    }



    private fun goToInstaPage() {
        val uri = Uri.parse("https://instagram.com/_u/anja.likumari601")
        val intent = Intent(Intent.ACTION_VIEW,uri)
        intent.setPackage("com.instagram.android")//straight reach to instagram unless it will oen intent chooser

        try{

            startActivity(intent)

        }catch (e: ActivityNotFoundException){

            startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("https://instagram.com/_u/anja.likumari601")))

        }
    }

    private fun goToFbPage(id:String) {
        try{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/"+id))
            startActivity(intent)
        }
        catch (e : ActivityNotFoundException){
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"+id))
            startActivity(intent)

        }
    }

    private fun goToWhatsappPage(){
        val intent = Intent(Intent.ACTION_VIEW)//implicit intent
        //universal resource identifier exist for all things whict is listed on web or  internet which is taken care of by the Uri class provided by android
        intent.setData(Uri.parse("https://api.whatsapp.com/send?phone="+"+91"+"7256028138"+"&text="+""))
        startActivity(intent)

    }


}
