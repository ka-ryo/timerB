package com.timer.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.realm.OrderedRealmCollection
import io.realm.RealmBaseAdapter

class timerBAdapter(data: OrderedRealmCollection<TimerdbModel>?) : RealmBaseAdapter<TimerdbModel>(data) {
    inner class ViewHolder(cell: View){
        val title = cell.findViewById<TextView>(R.id.text1)
        val timer = cell.findViewById<TextView>(R.id.text2)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View
        val viewHolder:ViewHolder

        when(convertView){
            null->{
                val inflater =LayoutInflater.from(parent?.context)
                view=inflater.inflate(R.layout.main_listview_cusutom,parent,false)
                viewHolder = ViewHolder(view)
                view.tag = viewHolder
            }
            else ->{
                view = convertView
                viewHolder = view.tag as ViewHolder
            }
        }

        adapterData?.run {
            val savedata = get(position)
            viewHolder.title.text=savedata.title
            viewHolder.timer.text=savedata.timer.toString()
        }
        return  view
    }

}