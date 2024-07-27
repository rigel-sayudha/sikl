@file:Suppress("UNREACHABLE_CODE")

package com.example.sikl.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sikl.*
import com.example.sikl.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: PopularAdapter
    private lateinit var adapter2: NewestAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var popularArrayList: ArrayList<Popular>
    private lateinit var newestArrayList: ArrayList<Newest>

    lateinit var imgPopular: Array<Int>
    lateinit var titlePopular:Array<String>
    lateinit var descPopular:Array<String>

    lateinit var imgNew: Array<Int>
    lateinit var titleNew:Array<String>
    lateinit var descNew:Array<String>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Popular
        dataInitialize()
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recyclerView = view.findViewById(R.id.rv_pop)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = PopularAdapter(popularArrayList, context)
        recyclerView.adapter = adapter

        //Newest
        dataInitialize2()
        val layoutManager2 = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recyclerView = view.findViewById(R.id.rv_new)
        recyclerView.layoutManager = layoutManager2
        recyclerView.setHasFixedSize(true)
        adapter2 = NewestAdapter(newestArrayList,context)
        recyclerView.adapter = adapter2
    }
    //Popular
    private fun dataInitialize(){
        popularArrayList = arrayListOf()
        imgPopular = arrayOf(
            R.drawable.nike,
            R.drawable.nike2,
            R.drawable.nike3,
            R.drawable.nike4
        )

        titlePopular = arrayOf(
            getString(R.string.title_rv),
            getString(R.string.title_rv2),
            getString(R.string.title_rv3),
            getString(R.string.title_rv4)

        )

        descPopular = arrayOf(
            getString(R.string.desc_rv),
            getString(R.string.desc_rv2),
            getString(R.string.desc_rv3),
            getString(R.string.desc_rv4)
        )

        for (i in imgPopular.indices){
            val popular = Popular(imgPopular[i],titlePopular[i],descPopular[i])
            popularArrayList.add(popular)
        }
    }

    //Newest
    private fun dataInitialize2(){
        newestArrayList = arrayListOf()
        imgNew = arrayOf(
            R.drawable.nike,
            R.drawable.nike2,
            R.drawable.nike3,
            R.drawable.nike4
        )

        titleNew = arrayOf(
            getString(R.string.title_rv),
            getString(R.string.title_rv2),
            getString(R.string.title_rv3),
            getString(R.string.title_rv4)

        )

        descNew = arrayOf(
            getString(R.string.desc_rv),
            getString(R.string.desc_rv2),
            getString(R.string.desc_rv3),
            getString(R.string.desc_rv4)
        )

        for (i in imgNew.indices){
            val newest = Newest(imgNew[i],titleNew[i],descNew[i])
            newestArrayList.add(newest)
        }
    }
}

