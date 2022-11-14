package com.redeyesncode.gitkid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.redeyesncode.gitkid.databinding.ActivityMainBinding
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast
import android.widget.AutoCompleteTextView





class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setupMajorCommandsForGit()


        setContentView(binding.root)
    }

    private fun setupMajorCommandsForGit() {
        val majorGitCommands = resources.getStringArray(R.array.major_git_commands)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item_commands, majorGitCommands)
        binding.autoCompleteMajorGitCommands.setAdapter(arrayAdapter)

        binding.autoCompleteMajorGitCommands.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity,position,Toast.LENGTH_LONG).show()

                when(position){
                    0->{
                        val subCommands = resources.getStringArray(R.array.add_subcommands)
                        val arrayAdapter = ArrayAdapter(this@MainActivity,R.layout.dropdown_item_commands,subCommands)
                        binding.subCommandOne.setAdapter(arrayAdapter)
                    }


                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {


            }
        }
        binding.spinnerMajorGitCommands.setOnClickListener {
            binding.subCommandOne.clearListSelection()
        }
        binding.autoCompleteMajorGitCommands.setOnClickListener {
            binding.subCommandOne.clearListSelection()
        }
        binding.autoCompleteMajorGitCommands.onItemClickListener =
            OnItemClickListener { adapterView, view, position, id ->
                when(id.toInt()){
                    0->{
                        val subCommands = resources.getStringArray(R.array.add_subcommands)
                        val arrayAdapter = ArrayAdapter(this@MainActivity,R.layout.dropdown_item_commands,subCommands)
                        binding.subCommandOne.setAdapter(arrayAdapter)
                    }


                }
            }

    }
}