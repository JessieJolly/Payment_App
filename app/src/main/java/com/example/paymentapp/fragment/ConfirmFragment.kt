package com.example.paymentapp.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.paymentapp.MainActivity
import com.example.paymentapp.PaymentViewModel
import com.example.paymentapp.R
import com.example.paymentapp.databinding.ConfirmFragmentBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ConfirmFragment : Fragment() {

    private var _binding: ConfirmFragmentBinding? = null
    private val sharedViewModel: PaymentViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ConfirmFragmentBinding.inflate(inflater, container, false)
        binding.confirmMessage.text = "Are you sure you want to pay ₹${sharedViewModel.getAmount()} to ${sharedViewModel.getName()} ?"
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.payButton.setOnClickListener {
            sharedViewModel.setData()
            findNavController().navigate(R.id.action_ConfirmFragment_to_PaymentSuccessfulFragment)
        }
        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_ConfirmFragment_to_PayAmountFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}