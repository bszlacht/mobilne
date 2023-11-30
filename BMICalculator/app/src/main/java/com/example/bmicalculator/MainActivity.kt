package com.example.bmicalculator


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.bmicalculator.bmihistoryview.BmiHistory
import com.example.bmicalculator.bmihistoryview.BmiHistoryAdapter
import com.example.bmicalculator.bmihistoryview.BmiHistoryDao
import com.example.bmicalculator.bmihistoryview.BmiHistoryDatabase
import com.example.bmicalculator.databinding.MainLayoutBinding
import java.time.LocalDate

class MainActivity : Fragment() {

    private lateinit var binding: MainLayoutBinding
    private lateinit var bmiUtils: BmiUtils
    private lateinit var bmiHistoryDao: BmiHistoryDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainLayoutBinding.inflate(inflater, container, false)

        bmiUtils = ViewModelProvider(this)[BmiUtils::class.java]
        bmiUtils.weight = MutableLiveData("100")
        bmiUtils.height = MutableLiveData("1.80")
        binding.bmiUtils = bmiUtils
        binding.lifecycleOwner = this

        val db = Room.databaseBuilder(
            requireContext().applicationContext,
            BmiHistoryDatabase::class.java, "bmihistorydatabase"
        ).allowMainThreadQueries().enableMultiInstanceInvalidation()
            .fallbackToDestructiveMigration().build()
        bmiHistoryDao = db.bmiHistoryDao()

        val bmiHistories: List<BmiHistory> = bmiHistoryDao.getAll()
        for (bmiHistory in bmiHistories) {
            Log.i("BmiApp", bmiHistory.toString())
        }

        val bmiHistoryAdapter = BmiHistoryAdapter(bmiHistoryDao.getAll())
        val recycleView: RecyclerView = binding.ryBmiHistory
        recycleView.layoutManager = LinearLayoutManager(requireContext().applicationContext)
        recycleView.adapter = bmiHistoryAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            calcBmiBtn.setOnClickListener() {
                binding.bmiUtils = bmiUtils
                val height = bmiUtils?.height?.value
                val weight = bmiUtils?.weight?.value
                val res = calcBmi()
                insertRowToDb(weight, height, res.toString(), LocalDate.now())
                Log.i("myApp", "msg from listener $res")
                if (res < 18.5) findNavController().navigate(R.id.action_mainActivity_to_underweight)
                if (res >= 18.5 && res < 24.9) findNavController().navigate(R.id.action_mainActivity_to_healthy)
                if (res >= 24.9 && res < 29.9) findNavController().navigate(R.id.action_mainActivity_to_overweight)
                if (res >= 29.9 && res < 34.9) findNavController().navigate(R.id.action_mainActivity_to_obesity)
            }
        }
    }

    private fun calcBmi(): Double {
        val heightNum = bmiUtils.height.value?.toDoubleOrNull()
        val weightNum = bmiUtils.weight.value?.toDoubleOrNull()

        if (weightNum != null && heightNum != null) {
            return weightNum / (heightNum * heightNum)
        }
        return 1.0
    }

    private fun insertRowToDb(
        weight: String?,
        height: String?,
        bmi: String,
        date: LocalDate
    ) {
        bmiHistoryDao.insertAll(BmiHistory(weight, height, bmi, date.toString()))
    }
}
