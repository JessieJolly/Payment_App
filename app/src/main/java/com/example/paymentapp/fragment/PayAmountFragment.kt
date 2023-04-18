package com.example.paymentapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.paymentapp.PaymentViewModel
import com.example.paymentapp.R
import com.example.paymentapp.databinding.PayAmountFragmentBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PayAmountFragment : Fragment() {

    private var _binding: PayAmountFragmentBinding? = null
    private val sharedViewModel: PaymentViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PayAmountFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextButton.setOnClickListener{
            val toPayAmount = try {
                Integer.parseInt(binding.editText.text.toString())
            } catch (e: NumberFormatException) {
                0
            }
            if (toPayAmount>sharedViewModel.getData().balance_amount) {
                binding.editText.error = "Not enough balance"
            }
            else {
                sharedViewModel.setAmount(toPayAmount)
                findNavController().navigate(R.id.action_PayAmountFragment_to_ConfirmFragment)
            }
        }
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_PayAmountFragment_to_TransferToFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}