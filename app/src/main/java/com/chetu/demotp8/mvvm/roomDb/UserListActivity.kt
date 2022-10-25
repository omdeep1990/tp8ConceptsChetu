package com.chetu.demotp8.mvvm.roomDb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityUserListBinding

class UserListActivity : AppCompatActivity() {
    private lateinit var viewModel : UserListActivityViewModel
    private lateinit var binding : ActivityUserListBinding
    private lateinit var factory : UserListViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list)

        val dao = AppDatabase.getInstance(this).userDao

        factory = UserListViewModelFactory(UserRepository(dao))
        viewModel = ViewModelProvider(this, factory)[UserListActivityViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initRecyclerview()

        viewModel.message.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun displayUserList(){
        viewModel.userList.observe(this, Observer {
            binding.recyclerView.adapter = MyRecyclerViewAdapter(it) { selectedItem: User ->
                listItemclicked(
                    selectedItem
                )
            }
        })
    }

    private fun initRecyclerview(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        displayUserList()

    }


    private fun listItemclicked(user: User){
//        Toast.makeText(this@UserListActivity, "${user.fistName} ${user.lastName}", Toast.LENGTH_SHORT).show()
        viewModel.initUpdateOrDelete(user)
    }

}