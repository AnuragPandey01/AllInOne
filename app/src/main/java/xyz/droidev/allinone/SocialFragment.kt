package xyz.droidev.allinone

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import xyz.droidev.allinone.adapter.AllAppRecyclerView
import xyz.droidev.allinone.adapter.SpacedItemDecorator
import xyz.droidev.allinone.databinding.FragmentSocialBinding
import xyz.droidev.allinone.model.AppData


/**
 * Project : All in one.
 * @author PANDEY ANURAG.
 */
class SocialFragment : Fragment(R.layout.fragment_social) {

    private var _binding: FragmentSocialBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSocialBinding.bind(view)

        setupRecyclerView(socials)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView(data: List<AppData>) {
        val adapter = AllAppRecyclerView(data) {
            findNavController().navigate(
                SocialFragmentDirections.actionSocialFragmentToWebViewFragment(it.url)
            )
        }
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),3)
        binding.recyclerView.addItemDecoration(SpacedItemDecorator(3, 16f, 16f, 16f, 16f))
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)
    }

    companion object {
        private const val TAG = "SocialFragment"
    }

}

val socials = listOf<AppData>(
    AppData(
        "Facebook",
        url = "https://www.facebook.com/",
        icon = R.drawable.ic_facebook
    ),
    AppData(
        "Instagram",
        url = "https://www.instagram.com/",
        icon = R.drawable.ic_insta
    ),
    AppData(
        "Twitter",
        url = "https://x.com/",
        icon = R.drawable.ic_twitter
    ),
    AppData(
        "LinkedIn",
        url = "https://www.linkedin.com/",
        icon = R.drawable.ic_linkedin
    ),
    AppData(
        "Snapchat",
        url = "https://www.snapchat.com/",
        icon = R.drawable.ic_snapchat
    ),
    AppData(
        "Pinterest",
        url = "https://www.pinterest.com/",
        icon = R.drawable.ic_pinterest
    ),
    AppData(
        "Reddit",
        url = "https://www.reddit.com/",
        icon = R.drawable.ic_reddit
    ),
    AppData(
        "Tumblr",
        url = "https://www.tumblr.com/",
        icon = R.drawable.ic_tumblr
    ),
    AppData(
        "Quora",
        url = "https://www.quora.com/",
        icon = R.drawable.ic_quora
    ),
    AppData(
        "Medium",
        url = "https://medium.com/",
        icon = R.drawable.ic_medium
    )
)