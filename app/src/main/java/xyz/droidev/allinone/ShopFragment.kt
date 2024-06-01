package xyz.droidev.allinone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import xyz.droidev.allinone.adapter.AllAppRecyclerView
import xyz.droidev.allinone.adapter.SpacedItemDecorator
import xyz.droidev.allinone.databinding.FragmentShopBinding
import xyz.droidev.allinone.model.AppData

/**
 * Project : All in one.
 * @author PANDEY ANURAG.
 */
class ShopFragment : Fragment(R.layout.fragment_shop) {

    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentShopBinding.bind(view)

        setupRecyclerView(shops)
    }

    private fun setupRecyclerView(data: List<AppData>) {
        val adapter = AllAppRecyclerView(data) {
            findNavController().navigate(
                ShopFragmentDirections.actionShopFragmentToWebViewFragment(it.url)
            )
        }
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),3)
        binding.recyclerView.addItemDecoration(SpacedItemDecorator(3, 16f, 16f, 16f, 16f))
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}

val shops = listOf(
    AppData(
        "Amazon",
        url = "https://www.amazon.com/",
        icon = R.drawable.ic_amazon
    ),
    AppData(
        "Flipkart",
        url = "https://www.flipkart.com/",
        icon = R.drawable.ic_flipkart
    ),
    AppData(
        "Ebay",
        url = "https://www.ebay.com/",
        icon = R.drawable.ic_ebay
    ),
    AppData(
        "Wallmart",
        url = "https://www.walmart.com/",
        icon = R.drawable.ic_walmart
    ),
    AppData(
        "Wish",
        url = "https://www.wish.com/",
        icon = R.drawable.ic_wish
    ),
)