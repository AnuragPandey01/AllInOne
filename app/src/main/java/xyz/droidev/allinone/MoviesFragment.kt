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
import xyz.droidev.allinone.databinding.FragmentMoviesBinding
import xyz.droidev.allinone.databinding.FragmentSocialBinding
import xyz.droidev.allinone.model.AppData

class MoviesFragment : Fragment(R.layout.fragment_movies) {

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMoviesBinding.bind(view)

        setupRecyclerView(movies)
    }

    private fun setupRecyclerView(data: List<AppData>) {
        val adapter = AllAppRecyclerView(data) {
            findNavController().navigate(
                MoviesFragmentDirections.actionMoviesFragmentToWebViewFragment(it.url)
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

val movies = listOf(
    AppData(
        "Prime Video",
        url = "https://www.primevideo.com/",
        icon = R.drawable.ic_amazon_prime_video
    ),
    AppData(
        "Netflix",
        url = "https://www.netflix.com/",
        icon = R.drawable.ic_netflix
    ),
)