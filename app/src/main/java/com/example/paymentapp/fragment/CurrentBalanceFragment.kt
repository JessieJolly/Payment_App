package com.example.paymentapp.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.paymentapp.MainActivity
import com.example.paymentapp.PaymentViewModel
import com.example.paymentapp.R
import com.example.paymentapp.databinding.CurrentBalanceFragmentBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CurrentBalanceFragment : Fragment() {

    private var _binding: CurrentBalanceFragmentBinding? = null
    private val sharedViewModel: PaymentViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = CurrentBalanceFragmentBinding.inflate(inflater, container, false)
        binding.balanceDataModel = sharedViewModel.getData()
        binding.BalanceText.text = "₹"+binding.balanceDataModel!!.balance_amount.toString()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_CurrentBalanceFragment_to_HomeScreenFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}