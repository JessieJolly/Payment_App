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
import com.example.paymentapp.PaymentViewModel
import com.example.paymentapp.R
import com.example.paymentapp.databinding.PayAmountFragmentBinding
import com.example.paymentapp.databinding.PaymentSuccessfulFragmentBinding
import kotlin.properties.Delegates


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PaymentSuccessfulFragment : Fragment() {

    private var _binding: PaymentSuccessfulFragmentBinding? = null
    private val sharedViewModel: PaymentViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PaymentSuccessfulFragmentBinding.inflate(inflater, container, false)
        binding.textView.text = "Successfully transferred ₹${sharedViewModel.getAmount()} to ${sharedViewModel.getName()}"
        binding.balanceTextView.text = "Balance amount: ₹${sharedViewModel.getData().balance_amount}"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeButton.setOnClickListener{
            findNavController().navigate(R.id.action_PaymentSuccessfulFragment_to_HomeScreenFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}