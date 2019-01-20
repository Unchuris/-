package omstu.com.osh.ui.main.training.regulations


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.regulation_item.view.*
import omstu.com.osh.R

class RegulationsAdapter(
    private val list: List<String> = listOf(),
    private val itemOnClick: (position: Int) -> Unit
) : RecyclerView.Adapter<RegulationsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.regulation_item, parent, false)
        val viewHolder = ViewHolder(view)
        view.setOnClickListener {
            val position = viewHolder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                itemOnClick.invoke(position)
            }
        }
        return viewHolder
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: String) {
            itemView.regulationTextView.text = item
        }
    }
}
