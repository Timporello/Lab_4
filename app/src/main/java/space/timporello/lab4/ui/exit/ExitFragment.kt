package space.timporello.lab4.ui.exit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import space.timporello.lab4.databinding.FragmentExitBinding
import space.timporello.lab4.ui.messages.MessagesViewModel

class ExitFragment : Fragment() {

    private var _binding: FragmentExitBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val exitViewModel =
            ViewModelProvider(this).get(ExitViewModel::class.java)

        _binding = FragmentExitBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textExit
        exitViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}