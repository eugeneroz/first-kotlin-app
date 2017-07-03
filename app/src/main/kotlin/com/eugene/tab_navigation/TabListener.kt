package com.eugene.tab_navigation

/**
 * Created by eugene on 21/06/2017.
 */
interface TabListener {
    val TAG: String
    fun onTabClicked(position: Int)
    fun onContainerSelected(position: Int)
}