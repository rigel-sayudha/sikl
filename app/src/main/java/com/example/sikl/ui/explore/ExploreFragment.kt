package com.example.sikl.ui.explore

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sikl.R
import com.example.sikl.databinding.FragmentExploreBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_explore.*
import java.util.*
import kotlin.collections.ArrayList

@Suppress("CAST_NEVER_SUCCEEDS")
class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.

    private lateinit var adapter3: ExploreAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var exploreArrayList: ArrayList<Explore>
    private  lateinit var tempArrayList : ArrayList<Explore>

    lateinit var imgExp: Array<Int>
    lateinit var titleExp:Array<String>

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentExploreBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Explore
        dataInitialize3()
        val layoutManager = GridLayoutManager(context,2)
        recyclerView = view.findViewById(R.id.rv_explore)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter3 = ExploreAdapter(tempArrayList)
        recyclerView.adapter = adapter3


//        val search = view.findViewById<TextInputEditText>(R.id.et_search)
//        val searchView = search as SearchView
        et_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }


            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(newText: String?): Boolean {

                tempArrayList.clear()
                val searchText = newText!!.lowercase(Locale.getDefault())
                if (searchText.isNotEmpty()) {
                    exploreArrayList.forEach {
                        if (it.titleExp.lowercase(Locale.getDefault()).contains(searchText)) {
                            tempArrayList.add(it)
                        }
                    }
                    recyclerView.adapter!!.notifyDataSetChanged()
                } else {
                    tempArrayList.clear()
                    tempArrayList.addAll(exploreArrayList)
                    recyclerView.adapter!!.notifyDataSetChanged()
                }

                return false
            }

        })
    }

    private fun dataInitialize3(){
        exploreArrayList = arrayListOf()
        tempArrayList = arrayListOf()
        imgExp = arrayOf(
            R.drawable.nike,
            R.drawable.nike2,
            R.drawable.nike3,
            R.drawable.nike4,
            R.drawable.nike3,
            R.drawable.nike,
            R.drawable.nike4,
            R.drawable.nike2,
            R.drawable.nike,
            R.drawable.nike3,
            R.drawable.nike,
            R.drawable.nike4,
            R.drawable.nike,
            R.drawable.nike2,
            R.drawable.nike3,
            R.drawable.nike4,
            R.drawable.nike3,
            R.drawable.nike,
            R.drawable.nike4,
            R.drawable.nike2,
            R.drawable.nike,
            R.drawable.nike3,
            R.drawable.nike,
            R.drawable.nike4
        )

        titleExp = arrayOf(
            getString(R.string.title_rv),
            getString(R.string.title_rv2),
            getString(R.string.title_rv3),
            getString(R.string.title_rv4),
            getString(R.string.title_rv3),
            getString(R.string.title_rv),
            getString(R.string.title_rv4),
            getString(R.string.title_rv2),
            getString(R.string.title_rv),
            getString(R.string.title_rv3),
            getString(R.string.title_rv),
            getString(R.string.title_rv4),
            getString(R.string.title_rv),
            getString(R.string.title_rv2),
            getString(R.string.title_rv3),
            getString(R.string.title_rv4),
            getString(R.string.title_rv3),
            getString(R.string.title_rv),
            getString(R.string.title_rv4),
            getString(R.string.title_rv2),
            getString(R.string.title_rv),
            getString(R.string.title_rv3),
            getString(R.string.title_rv),
            getString(R.string.title_rv4),

        )

        for (i in imgExp.indices){
            val explore = Explore(imgExp[i],titleExp[i])
            exploreArrayList.add(explore)
        }
        tempArrayList.addAll(exploreArrayList)
    }
}