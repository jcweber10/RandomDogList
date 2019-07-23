package com.example.doglist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.doglist.databinding.FragmentDogListBinding
import javax.inject.Inject

class DogListFragment : Fragment() {

    companion object {
        fun newInstance(): DogListFragment = DogListFragment()
    }

    private lateinit var binding: FragmentDogListBinding
    private lateinit var viewModel:DogListViewModel

    @Inject
    lateinit var factory: DogListViewModel.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This injects and instantiates factory
        (activity?.application as? DogListApplication)?.appComponent?.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dog_list, container, false)
        viewModel = ViewModelProviders.of(this, factory).get(DogListViewModel::class.java)
        viewModel.getDogs()
        return binding.root
    }
}