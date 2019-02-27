package com.timer.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.realm.OrderedRealmCollection
import io.realm.RealmBaseAdapter

class timerBAdapter(data: OrderedRealmCollection<TimerdbModel>?) : RealmBaseAdapter<TimerdbModel>(data) {
    inner class ViewHolder(cell: View){
        val title = cell.findViewById<TextView>(R.id.text1)
        val minute = cell.findViewById<TextView>(R.id.text2)
        val second = cell.findViewById<TextView>(R.id.text3)
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
            viewHolder.minute.text=savedata.stringMinute
            viewHolder.second.text=savedata.stringSecond
        }
        return  view
    }

}