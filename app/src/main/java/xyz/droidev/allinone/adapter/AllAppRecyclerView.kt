package xyz.droidev.allinone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import xyz.droidev.allinone.R
import xyz.droidev.allinone.databinding.AppItemViewBinding
import xyz.droidev.allinone.model.AppData

/**
 * Project : All in one.
 * @author PANDEY ANURAG.
 */
class AllAppRecyclerView(
    private val data : List<AppData>,
    private val onClick: (AppData) -> Unit
): RecyclerView.Adapter<AllAppRecyclerView.AllAppViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllAppViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.app_item_view, parent, false)
        return AllAppViewHolder(itemView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: AllAppViewHolder, position: Int) {
        holder.binding.apply {
            Glide.with(root.context)
                .load(data[position].icon)
                .into(appIcon)

            appName.text = data[position].name

            root.setOnClickListener {
                onClick(data[position])
            }
        }
    }

    inner class AllAppViewHolder(itemView: View) : ViewHolder(itemView) {
        val binding = AppItemViewBinding.bind(itemView)
    }
}