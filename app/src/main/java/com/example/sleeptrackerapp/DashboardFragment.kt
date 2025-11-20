package com.example.sleeptrackerapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DashboardFragment : Fragment() {

    private var sleepChart: BarChart? = null
    private var fabAddSleep: FloatingActionButton? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        initializeViews(view)
        setupSleepChart()
        setupClickListeners()
        updateSleepData()

        return view
    }

    private fun initializeViews(view: View) {
        sleepChart = view.findViewById(R.id.sleep_chart)
        fabAddSleep = view.findViewById(R.id.fab_add_sleep)
    }

    private fun setupSleepChart() {
        sleepChart?.let { chart ->
            // Configuration du graphique
            chart.setDrawBarShadow(false)
            chart.setDrawValueAboveBar(true)
            chart.description.isEnabled = false
            chart.setMaxVisibleValueCount(7)
            chart.setPinchZoom(false)
            chart.setDrawGridBackground(false)

            // Configuration de l'axe X
            val xAxis = chart.xAxis
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.setDrawGridLines(false)
            xAxis.granularity = 1f
            xAxis.labelCount = 7
            xAxis.valueFormatter = object : ValueFormatter() {
                override fun getFormattedValue(value: Float): String {
                    val days = arrayOf("Lun", "Mar", "Mer", "Jeu", "Ven", "Sam", "Dim")
                    return days.getOrNull(value.toInt()) ?: ""
                }
            }
            xAxis.textColor = 0xFFFFFFFF.toInt()

            // Configuration de l'axe Y gauche
            val leftAxis = chart.axisLeft
            leftAxis.setDrawGridLines(true)
            leftAxis.axisMinimum = 0f
            leftAxis.textColor = 0xFFFFFFFF.toInt()
            leftAxis.gridColor = 0x5A5A5A6B.toInt()

            // Masquer l'axe Y droit
            chart.axisRight.isEnabled = false
            chart.legend.isEnabled = false
        }
    }

    private fun updateSleepData() {
        sleepChart?.let { chart ->
            // Données d'exemple pour la semaine
            val sleepEntries = ArrayList<BarEntry>()
            sleepEntries.add(BarEntry(0f, 7.25f))  // Lundi: 7h15
            sleepEntries.add(BarEntry(1f, 6.75f))  // Mardi: 6h45
            sleepEntries.add(BarEntry(2f, 8.0f))   // Mercredi: 8h00
            sleepEntries.add(BarEntry(3f, 7.5f))   // Jeudi: 7h30
            sleepEntries.add(BarEntry(4f, 6.5f))   // Vendredi: 6h30
            sleepEntries.add(BarEntry(5f, 8.5f))   // Samedi: 8h30
            sleepEntries.add(BarEntry(6f, 7.25f))  // Dimanche: 7h15

            val dataSet = BarDataSet(sleepEntries, "Durée de sommeil")
            dataSet.color = 0xFFB4B0FF.toInt()
            dataSet.valueTextColor = 0xFFFFFFFF.toInt()
            dataSet.valueFormatter = object : ValueFormatter() {
                override fun getFormattedValue(value: Float): String {
                    val hours = value.toInt()
                    val minutes = ((value - hours) * 60).toInt()
                    return "${hours}h${minutes}m"
                }
            }

            val barData = BarData(dataSet)
            barData.barWidth = 0.6f

            chart.data = barData
            chart.invalidate()
        }
    }

    private fun setupClickListeners() {
        fabAddSleep?.setOnClickListener {
            showAddSleepDialog()
        }
    }

    private fun showAddSleepDialog() {
        // Implémentation de la boîte de dialogue pour ajouter une session de sommeil
        val dialog = SleepTrackingDialogFragment()
        dialog.show(parentFragmentManager, "SleepTrackingDialog")
    }

    companion object {
        fun newInstance() = DashboardFragment()
    }
}

