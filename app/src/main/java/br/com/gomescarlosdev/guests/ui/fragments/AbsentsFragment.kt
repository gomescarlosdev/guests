package br.com.gomescarlosdev.guests.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.gomescarlosdev.guests.databinding.FragmentAbsentsBinding

class AbsentsFragment : Fragment() {

    private var _binding: FragmentAbsentsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel = ViewModelProvider(this)[AbsentsViewModel::class.java]

        _binding = FragmentAbsentsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textAbsents
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}