package com.example.kar_o_bar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class CarHostActivity : AppCompatActivity(), CarListFragment.ItemSelected {

    private lateinit var carDescription : TextView
    private lateinit var carDetails : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        carDescription = findViewById(R.id.carDescription)
        carDetails = ArrayList()

        carDetails.add(
            """Bayerische Motoren Werke AG, commonly referred to as BMW is a German multinational corporation which produces luxury vehicles and motorcycles. The company was founded in 1916 as a manufacturer of aircraft engines, which it produced from 1917 until 1918 and again from 1933 to 1945.
Automobiles are marketed under the brands BMW, Mini and Rolls-Royce, and motorcycles are marketed under the brand BMW Motorrad. """
        )
        carDetails.add(
            """Mercedes-Benz commonly referred to as Mercedes, is both a German automotive brand and, from late 2019 onwards, a subsidiary – as Mercedes-Benz AG – of Daimler AG.[1] Mercedes-Benz is known for producing luxury vehicles and commercial vehicles.
"""
        )
        carDetails.add("""Alfa Romeo Automobiles S.p.A. is an Italian premium car manufacturer and a subsidiary of Stellantis. The company was founded on June 24, 1910, in Milan, Italy. "Alfa" is an acronym of its founding name, "Anonima Lombarda Fabbrica Automobili." "Anonima" means "anonymous", which was a legal form of company at the time, as it was founded by anonymous investors.""")
        carDetails.add("""Volkswagen, shortened to VW, is a German motor vehicle manufacturer founded in 1937 by the German Labour Front, known for the iconic Beetle and headquartered in Wolfsburg. It is the flagship brand of the Volkswagen Group, the largest car maker by worldwide sales in 2016 and 2017.[2] The group's biggest market is in China, which delivers 40% of its sales and profits.""")
        carDetails.add("""Audi AG is a German automobile manufacturer that designs, engineers, produces, markets and distributes luxury vehicles. Audi is a subsidiary of Volkswagen Group and has its roots at Ingolstadt, Bavaria, Germany. Audi vehicles are produced in nine production facilities worldwide.""")


        if (findViewById<View>(R.id.layout_default) != null) {
            val manager = this.supportFragmentManager
            manager.beginTransaction()
                .hide(manager.findFragmentById(R.id.detailFrag)!!)
                .show(manager.findFragmentById(R.id.listFrag)!!)
                .commit()
        }

        if (findViewById<View>(R.id.layout_land) != null) {
            val manager = this.supportFragmentManager
            manager.beginTransaction()
                .show(manager.findFragmentById(R.id.detailFrag)!!)
                .show(manager.findFragmentById(R.id.listFrag)!!)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onItemSelected(index: Int) {

        if (findViewById<View>(R.id.layout_default) != null) {
            val manager = this.supportFragmentManager
            manager.beginTransaction()
                .show(manager.findFragmentById(R.id.detailFrag)!!)
                .hide(manager.findFragmentById(R.id.listFrag)!!)
                .addToBackStack(null)
                .commit()
        }
        carDescription.text = carDetails[index]
    }
}