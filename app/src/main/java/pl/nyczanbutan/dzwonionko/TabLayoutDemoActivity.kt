package pl.nyczanbutan.dzwonionko
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_tab_layout_demo.*

class TabLayoutDemoActivity : AppCompatActivity() {

    companion object {
        var currentUser = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentUser = intent.getStringExtra("currentUser")
        setContentView(R.layout.activity_tab_layout_demo)
        setSupportActionBar(toolbar)
        configureTabLayout()
    }

    private fun configureTabLayout() {
        tab_layout.addTab(tab_layout.newTab().setText("Telefon"))
        tab_layout.addTab(tab_layout.newTab().setText("Kontakty"))
        tab_layout.addTab(tab_layout.newTab().setText("Konto"))

        val adapter = TabPagerAdapter(supportFragmentManager, tab_layout.tabCount)
        pager.adapter = adapter


        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })
    }
}
