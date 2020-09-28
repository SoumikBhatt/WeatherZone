package com.soumik.weatherzone.utils


/**
 * Created by Soumik Bhattacharjee on 9/11/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */

const val LOCATION_REQUEST = 100
const val GPS_REQUEST = 101
const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
const val APP_ID="c1fac2c531c4c592942693d386edc753"
const val PREF_NAME = "WeatherZone"
const val KEY_UNITS = "Units"
const val DB_NAME = "cityList.db"
const val TABLE_CITY = "city_bd"





//class NotificationFragment : Fragment(), RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {
//
//
//            notificationAdapter = NotificationAdapter(context!!, notificationDBHelpers)
//            notificationRecyclerView?.adapter = notificationAdapter
////            val helper = ItemTouchHelper(SwipeToDeleteCallback(notificationAdapter))
////            helper.attachToRecyclerView(notificationRecyclerView)
//
//            val helper = RecyclerItemTouchHelper(this)
//            ItemTouchHelper(helper).attachToRecyclerView(notificationRecyclerView)
//
//
//    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {
//        if (viewHolder is NotificationAdapter.Holder) {
//
//            notificationAdapter?.deleteItem(viewHolder.adapterPosition)
//        }
//    }
//}

//    fun deleteItem(position: Int){
//        val recentlyDeletedItem = list[position]
//        val recentlyDeletedItemPosition = position
//        val dataAdapter = DataAdapter(context)
//        dataAdapter.open()
//        dataAdapter.deleteNotificationByID(list[position].serial_id + "")
//        dataAdapter.close()
//        list.removeAt(position)
//        notifyItemRemoved(position)
//    }
//}