package com.nirwashh.android.livedatasimpleexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nirwashh.android.livedatasimpleexample.adapter.MyAdapter
import com.nirwashh.android.livedatasimpleexample.databinding.ActivityMainBinding
import com.nirwashh.android.livedatasimpleexample.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userViewModel by lazy { ViewModelProvider(this)[UserViewModel::class.java] }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAdapter = MyAdapter()
        with(binding) {
            with(rcView) {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = myAdapter
            }
        }

        userViewModel.getListUsers().observe(this, Observer {
            it?.let {
                myAdapter.refreshUsers(it)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.menuItem -> {
                userViewModel.updateUserList()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}