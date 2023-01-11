package com.example.mynotes.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.mynotes.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private val viewModel = AddViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.notesLiveData.observe(viewLifecycleOwner){
            if(it.isEmpty()){
                binding.apply {
                    goneView(noteRecycler)
                    goneView(filterNotes)
                    goneView(searchNoteWrapper)
                    visibleView(emptyState)
                }
            }else{
                binding.apply {
                    visibleView(noteRecycler)
                    visibleView(filterNotes)
                    visibleView(searchNoteWrapper)
                    goneView(emptyState)
                }
            }
        }
    }

    private fun goneView(view : View){
        view.isGone = true
    }

    private fun visibleView(view : View){
        view.isVisible = true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}