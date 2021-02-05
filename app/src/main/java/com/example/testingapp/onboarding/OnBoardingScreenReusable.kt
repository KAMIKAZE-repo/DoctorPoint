package com.example.testingapp.onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.testingapp.R

class OnBoardingScreenReusable : Fragment(), View.OnClickListener {
    interface FragmentListener{
        fun onNextButtonClickedCallBack()
        fun onDotClicked(position: Int)
    }
    private lateinit var activityCallBack : FragmentListener
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(
            R.layout.fragment_on_boarding_screen_reusable,
            container,
            false
        )
        val dot1 = view.findViewById<TextView>(R.id.Dot1)
        val dot2 = view.findViewById<TextView>(R.id.Dot2)
        val dot3 = view.findViewById<TextView>(R.id.Dot3)
        val title = view.findViewById<TextView>(R.id.title)
        val button = view.findViewById<TextView>(R.id.nextButton)
        val description = view.findViewById<TextView>(R.id.description)
        val image = view.findViewById<ImageView>(R.id.imageView)
        title.text = arguments?.getString("TITLE")
        description.text = arguments?.getString("DESCRIPTION")
        image.setImageResource(arguments?.getInt("IMAGE") ?: R.drawable.img_placeholder1)//if null found then place placeholder1
        when(arguments?.getInt("DOT"))
        {
            0 -> dot1.setBackgroundResource(R.drawable.dot_active)
            1 -> dot2.setBackgroundResource(R.drawable.dot_active)
            2 -> dot3.setBackgroundResource(R.drawable.dot_active)
            else -> dot1.setBackgroundResource(R.drawable.dot_active)
        }
        button.setOnClickListener {
            onButtonClicked()
        }

        dot1.setOnClickListener(this)
        dot2.setOnClickListener(this)
        dot3.setOnClickListener(this)

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            activityCallBack = activity as FragmentListener
        }catch (e: ClassCastException){
            throw ClassCastException(activity.toString() + " must implement ToolbarListener")
        }
    }

    private fun onButtonClicked(){
        activityCallBack.onNextButtonClickedCallBack()
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.Dot1 -> activityCallBack.onDotClicked(0)
            R.id.Dot2 -> activityCallBack.onDotClicked(1)
            R.id.Dot3 -> activityCallBack.onDotClicked(2)
        }
    }
}

