package com.narsha.sundolls_ep_android.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.FragmentFriendBinding
import com.narsha.sundolls_ep_android.ui.adapter.RecyclerViewFriendAdapter
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.FriendViewModel


class FriendFragment : Fragment() {

    private val viewModel: FriendViewModel by lazy {
        ViewModelProvider(this)[FriendViewModel::class.java]
    }

    lateinit var binding: FragmentFriendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFriendBinding.inflate(inflater, container, false)
        binding.ranking = viewModel
        binding.lifecycleOwner = this
        binding.friendRecycler.layoutManager = LinearLayoutManager(context)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.recyclerView.observe(viewLifecycleOwner, Observer {
            var newAdapter = RecyclerViewFriendAdapter(it)
            binding.friendRecycler.adapter = newAdapter
        })
    }

}