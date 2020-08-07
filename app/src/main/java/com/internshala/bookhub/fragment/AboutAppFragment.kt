package com.internshala.bookhub.fragment


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.Toast
import com.internshala.bookhub.BuildConfig
import com.internshala.bookhub.R
import java.lang.Exception
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class AboutAppFragment : Fragment() {
    private lateinit var imggithub: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_about_app, container, false)

        imggithub=view.findViewById(R.id.imggithub)

        this.setHasOptionsMenu(true)

        imggithub.setOnClickListener{
            
               viewCode()
        }
        return view
    }
    
     private fun viewCode() {
        val uri =  "https://github.com/anjali1361/BookHub.git"

        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(uri))
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.share, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

     try {

        val id = item.itemId
        if (id == R.id.share){
            val intent= Intent(Intent.ACTION_SEND)
           intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT,"SHARE DEMO")
            val message ="https://play.google.com/store/apps/details?="+BuildConfig.APPLICATION_ID+"\n\n"
            intent.putExtra(Intent.EXTRA_TEXT,"Hey ,there is my first app check it out and respond me with some feedback "+ message)
            startActivity(Intent.createChooser(intent,"share using"))
        }

        }catch (e: Exception){
         Toast.makeText(activity as Context,"some error occured",Toast.LENGTH_SHORT).show()
     }

        return super.onOptionsItemSelected(item)
    }


}
