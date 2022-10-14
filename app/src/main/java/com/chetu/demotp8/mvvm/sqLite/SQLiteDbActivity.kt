package com.chetu.demotp8.mvvm.sqLite

import android.app.ActionBar.LayoutParams
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import androidx.compose.ui.window.Dialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivitySqliteDbBinding
import com.chetu.demotp8.databinding.LayoutUserDataBinding

class SQLiteDbActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySqliteDbBinding
    private lateinit var factory : SQLiteFactory
    private lateinit var viewModel: SQLiteViewModel
    private lateinit var adapter : MyRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sqlite_db)

        factory = SQLiteFactory(this)
        viewModel = ViewModelProvider(this, factory)[SQLiteViewModel::class.java]

        val detailList = viewModel.getDataList()
        adapter = MyRecyclerViewAdapter(detailList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
//        registerForContextMenu(adapter)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.sq_options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.create_data-> {
                val createDataBiding : LayoutUserDataBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.layout_user_data,  null, false)
                val dialog = Dialog(this)
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.setContentView(createDataBiding.root)
                dialog.setCancelable(false)
                dialog.show()

                val window = dialog.window
                window!!.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

                createDataBiding.submitBtn.setOnClickListener {
                    viewModel.createData(createDataBiding.firstName.text.toString(), createDataBiding.lastName.text.toString(), createDataBiding.mobileNo.text.toString())
                    binding.recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()
                    dialog.dismiss()
                }

                createDataBiding.cancelBtn.setOnClickListener {
                    dialog.dismiss()
                }
            }
            R.id.delete_all-> {
                viewModel.deleteAllData()
            }

            R.id.delete_single_data-> {
                val personalData = viewModel.getDataList().get(1)
                viewModel.deleteSingleData(personalData.srNo)
            }
            R.id.update_data-> {
                val personalData = viewModel.getDataList().get(0)
                val upBinding : LayoutUserDataBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.layout_user_data,  null, false)
                upBinding.submitBtn.text = "UPDATE"
                val dialog = Dialog(this)
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.setContentView(upBinding.root)
                dialog.setCancelable(false)
                dialog.show()

                val window = dialog.window
                window!!.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

                upBinding.firstName.setText(personalData.fName)
                upBinding.lastName.setText(personalData.lName)
                upBinding.mobileNo.setText(personalData.mobileNo)
                upBinding.submitBtn.setOnClickListener {
                    viewModel.updateDataList(personalData.srNo, upBinding.firstName.text.toString(), upBinding.lastName.text.toString(), upBinding.mobileNo.text.toString())

                    binding.recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()
                    dialog.dismiss()
                }

                upBinding.cancelBtn.setOnClickListener {
                    dialog.dismiss()
                }
            }
        }
            return super.onOptionsItemSelected(item)
    }
}