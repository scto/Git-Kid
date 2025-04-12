package com.redeyesncode.gitkid

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.redeyesncode.gitkid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // MAJOR TASK IS TO REMOVE THE BOLIER PLATE CODE AND MANAGE WITHOUT USING SWTICH CASE OR IF ELSE
    // STATEMENT.

    private var subCommandPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setupMajorCommandsForGit()
        setupSubCommandsLogic()

        setContentView(binding.root)
    }

    private fun setupMajorCommandsForGit() {
        val majorGitCommands = resources.getStringArray(R.array.major_git_commands)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item_commands, majorGitCommands)
        binding.autoCompleteMajorGitCommands.setAdapter(arrayAdapter)

        binding.autoCompleteMajorGitCommands.onItemSelectedListener =
            object : OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long,
                ) {
                    Toast.makeText(this@MainActivity, position, Toast.LENGTH_LONG).show()

                    when (position) {
                        0 -> {
                            val subCommands = resources.getStringArray(R.array.add_subcommands)
                            val arrayAdapter =
                                ArrayAdapter(
                                    this@MainActivity,
                                    R.layout.dropdown_item_commands,
                                    subCommands,
                                )
                            binding.subCommandOne.setAdapter(arrayAdapter)
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        binding.spinnerMajorGitCommands.setOnClickListener {
            binding.subCommandOne.clearListSelection()
        }
        binding.autoCompleteMajorGitCommands.setOnClickListener {
            binding.subCommandOne.clearListSelection()
        }

        binding.subCommandOne.onItemClickListener =
            OnItemClickListener { adapterView, view, position, id ->
                subCommandPosition = position
            }

        // Also we can use method to shorten up the boiler plate code.
        binding.autoCompleteMajorGitCommands.onItemClickListener =
            OnItemClickListener { adapterView, view, position, id ->
                when (id.toInt()) {
                    0 -> {

                        // For git add command
                        val subCommands = resources.getStringArray(R.array.add_subcommands)
                        val arrayAdapter =
                            ArrayAdapter(
                                this@MainActivity,
                                R.layout.dropdown_item_commands,
                                subCommands,
                            )
                        binding.subCommandOne.setAdapter(arrayAdapter)
                    }
                    1 -> {
                        // For git cherry pick command
                        val subCommands = resources.getStringArray(R.array.cherry_pick_subcommands)
                        val arrayAdapter =
                            ArrayAdapter(
                                this@MainActivity,
                                R.layout.dropdown_item_commands,
                                subCommands,
                            )
                        binding.subCommandOne.setAdapter(arrayAdapter)
                    }
                    2 -> {
                        // For clone git command
                        val subCommands = resources.getStringArray(R.array.clone_subcommands)
                        val arrayAdapter =
                            ArrayAdapter(
                                this@MainActivity,
                                R.layout.dropdown_item_commands,
                                subCommands,
                            )
                        binding.subCommandOne.setAdapter(arrayAdapter)
                    }
                    3 -> {
                        // For commit git commands
                        val subCommands = resources.getStringArray(R.array.commit_subcommands)
                        val arrayAdapter =
                            ArrayAdapter(
                                this@MainActivity,
                                R.layout.dropdown_item_commands,
                                subCommands,
                            )
                        binding.subCommandOne.setAdapter(arrayAdapter)
                    }
                    4 -> {

                        // For comparing two commits

                        val subCommands =
                            resources.getStringArray(R.array.compare_two_commits_subcommands)
                        val arrayAdapter =
                            ArrayAdapter(
                                this@MainActivity,
                                R.layout.dropdown_item_commands,
                                subCommands,
                            )
                        binding.subCommandOne.setAdapter(arrayAdapter)
                    }
                    5 -> {

                        val subCommands = resources.getStringArray(R.array.configure_subcommands)
                        val arrayAdapter =
                            ArrayAdapter(
                                this@MainActivity,
                                R.layout.dropdown_item_commands,
                                subCommands,
                            )
                        binding.subCommandOne.setAdapter(arrayAdapter)
                    }
                    6 -> {
                        // Git debug commands
                        val subCommands = resources.getStringArray(R.array.debug_commands)
                        val arrayAdapter =
                            ArrayAdapter(
                                this@MainActivity,
                                R.layout.dropdown_item_commands,
                                subCommands,
                            )
                        binding.subCommandOne.setAdapter(arrayAdapter)
                    }
                    7 -> {
                        // Remember string-array in kotlin does not take ' symbol in the strings

                        // Git delete/remove commands
                        val subCommands = resources.getStringArray(R.array.del_subcommands)
                        val arrayAdapter =
                            ArrayAdapter(
                                this@MainActivity,
                                R.layout.dropdown_item_commands,
                                subCommands,
                            )
                        binding.subCommandOne.setAdapter(arrayAdapter)
                    }
                    8 -> {
                        // Git ignore commands
                        val subCommands = resources.getStringArray(R.array.ignore_subcommands)
                        val arrayAdapter =
                            ArrayAdapter(
                                this@MainActivity,
                                R.layout.dropdown_item_commands,
                                subCommands,
                            )
                        binding.subCommandOne.setAdapter(arrayAdapter)
                    }
                    9 -> {
                        // Git initialize commands
                        val subCommands = resources.getStringArray(R.array.initialize_subcommands)
                        val arrayAdapter =
                            ArrayAdapter(
                                this@MainActivity,
                                R.layout.dropdown_item_commands,
                                subCommands,
                            )
                        binding.subCommandOne.setAdapter(arrayAdapter)
                    }
                    10 -> {
                        // Git merge commands
                        val subCommands = resources.getStringArray(R.array.merge_subcommands)
                        val arrayAdapter =
                            ArrayAdapter(
                                this@MainActivity,
                                R.layout.dropdown_item_commands,
                                subCommands,
                            )
                        binding.subCommandOne.setAdapter(arrayAdapter)
                    }
                    11 -> {
                        // Git modify commands

                        val subCommands = resources.getStringArray(R.array.modify_subcommands)
                        val arrayAdapter =
                            ArrayAdapter(
                                this@MainActivity,
                                R.layout.dropdown_item_commands,
                                subCommands,
                            )
                        binding.subCommandOne.setAdapter(arrayAdapter)
                    }
                    12 -> {
                        // Git rebase commands
                        val subCommands = resources.getStringArray(R.array.rebase_subcommands)
                        val arrayAdapter =
                            ArrayAdapter(
                                this@MainActivity,
                                R.layout.dropdown_item_commands,
                                subCommands,
                            )
                        binding.subCommandOne.setAdapter(arrayAdapter)
                    }
                }
            }
    }

    // IF ELSE Statements over switch case hahahahahaa XD XD.
    // ~RedEyesNCode. You still reviewing my code. is it ??

    fun setupSubCommandsLogic() {
        //        <!-- MORE GIT COMMANDS WILL BE  ADD IN NEXT COMMIT RELEASE. :) -->

        // We will now get the current selection for First Exposed Dropdown.

        binding.btnSubmit.setOnClickListener {
            if (
                binding.autoCompleteMajorGitCommands.editableText
                    .toString()
                    .equals("Major Git Commands")
            ) {

                // For the default use case when no command is selected.

                showSelectCommandToast()
            } else if (binding.autoCompleteMajorGitCommands.editableText.toString().equals("add")) {

                // For git add commands

                if (subCommandPosition == 0) {
                    binding.tvCommandUsage.text = "git add <file.ext>"
                } else if (subCommandPosition == 1) {
                    binding.tvCommandUsage.text = "git branch <new name>"
                } else if (subCommandPosition == 2) {
                    binding.tvCommandUsage.text = "git remote add <shortname> <url>"
                } else if (subCommandPosition == 3) {
                    binding.tvCommandUsage.text = "git config --global alias.<alias> <command>"
                } else if (subCommandPosition == 4) {
                    binding.tvCommandUsage.text =
                        "git tag -a v1.4 -m my version 1.4 and git push --tags"
                } else if (subCommandPosition == 5) {
                    binding.tvCommandUsage.text =
                        "git tag -a v1.2 -m 'version 1.2' <commit-hash> and git push --tags"
                } else if (subCommandPosition == -1) {
                    showSelectCommandToast()
                }
            } else if (
                binding.autoCompleteMajorGitCommands.editableText.toString().equals("cherry-pick")
            ) {
                if (subCommandPosition == 0) {
                    binding.tvCommandUsage.text = "git cherry-pick <commit-hash> <commit-hash>"
                } else {}
            } else if (
                binding.autoCompleteMajorGitCommands.editableText.toString().equals("clone")
            ) {
                if (subCommandPosition == 0) {
                    binding.tvCommandUsage.text = "git clone <repo-url> <directory>"
                } else if (subCommandPosition == 1) {
                    binding.tvCommandUsage.text = "git clone <repo-url>."
                } else if (subCommandPosition == 2) {
                    binding.tvCommandUsage.text = "git clone --recurse-submodules <repo-url> ."
                } else if (subCommandPosition == 3) {
                    binding.tvCommandUsage.text = "git submodule update --init --recursive"
                } else {
                    showSelectCommandToast()
                }
            } else if (
                binding.autoCompleteMajorGitCommands.editableText.toString().equals("commit")
            ) {
                if (subCommandPosition == 0) {
                    binding.tvCommandUsage.text = "git commit -a"
                } else if (subCommandPosition == 1) {
                    binding.tvCommandUsage.text = "git commit -m <message>"
                } else {
                    showSelectCommandToast()
                }
            } else if (
                binding.autoCompleteMajorGitCommands.editableText
                    .toString()
                    .equals("compare two commits")
            ) {
                if (subCommandPosition == 0) {
                    binding.tvCommandUsage.text = "git diff <sha1> <sha2>"
                } else if (subCommandPosition == 1) {
                    binding.tvCommandUsage.text = "git diff <sha1> <sha2> > diff.txt"
                } else {
                    showSelectCommandToast()
                }
            } else if (
                binding.autoCompleteMajorGitCommands.editableText.toString().equals("configure")
            ) {
                if (subCommandPosition == 0) {
                    binding.tvCommandUsage.text =
                        "git config --global user.name username" +
                            "\n" +
                            "git config --global user.email email address"
                } else if (subCommandPosition == 1) {
                    binding.tvCommandUsage.text = "git config --global core.editor vim"
                } else if (subCommandPosition == 2) {
                    binding.tvCommandUsage.text = "git config --global diff.external \"meld\""
                } else if (subCommandPosition == 3) {
                    binding.tvCommandUsage.text = "git config --global merge.tool \"meld\""
                } else if (subCommandPosition == 4) {
                    binding.tvCommandUsage.text = "git config --global color.ui auto"
                } else if (subCommandPosition == 5) {
                    binding.tvCommandUsage.text =
                        "git config --global user.signingkey <your-secret-gpg-key>"
                } else if (subCommandPosition == -1) {
                    showSelectCommandToast()
                }
            } else if (
                binding.autoCompleteMajorGitCommands.editableText.toString().equals("debug")
            ) {
                if (subCommandPosition == 0) {
                    binding.tvCommandUsage.text = "git bisect start"
                } else if (subCommandPosition == 1) {
                    binding.tvCommandUsage.text =
                        "git blame -L <number-line-start>,<number-line-end> <filename>"
                } else if (subCommandPosition == 2) {
                    binding.tvCommandUsage.text = "git grep -n <your_text_or_expression>"
                } else {
                    showSelectCommandToast()
                }
            } else if (
                binding.autoCompleteMajorGitCommands.editableText.toString().equals("delete/remove")
            ) {
                if (subCommandPosition == 0) {
                    binding.tvCommandUsage.text = "git branch -D <branch name>"
                } else if (subCommandPosition == 1) {
                    binding.tvCommandUsage.text =
                        "git branch -D <branch name> <branch name> <branch name>"
                } else if (subCommandPosition == 2) {
                    binding.tvCommandUsage.text = "git tag -d v<tag version>"
                } else if (subCommandPosition == 3) {
                    binding.tvCommandUsage.text = "git remote rm <remote>"
                } else if (subCommandPosition == 4) {
                    binding.tvCommandUsage.text = "git clean -<flag>"
                } else if (subCommandPosition == 5) {
                    binding.tvCommandUsage.text = "git rm --cached <file or dir>"
                } else if (subCommandPosition == 6) {
                    binding.tvCommandUsage.text = "git remote prune <remote-name>"
                } else {
                    showSelectCommandToast()
                }
            } else if (
                binding.autoCompleteMajorGitCommands.editableText.toString().equals("ignore")
            ) {
                if (subCommandPosition == 0) {
                    binding.tvCommandUsage.text = "<dir name>/*"
                } else if (subCommandPosition == 1) {
                    binding.tvCommandUsage.text = "*.<filename extension>"
                } else {
                    showSelectCommandToast()
                }
            } else if (
                binding.autoCompleteMajorGitCommands.editableText.toString().equals("initialize")
            ) {
                if (subCommandPosition == 0) {
                    binding.tvCommandUsage.text = "git init"
                } else {
                    showSelectCommandToast()
                }
            } else if (
                binding.autoCompleteMajorGitCommands.editableText.toString().equals("merge")
            ) {
                if (subCommandPosition == 0) {
                    binding.tvCommandUsage.text = "git merge <branch-name>"
                } else if (subCommandPosition == 1) {
                    binding.tvCommandUsage.text =
                        "git checkout <branch name> <path to file> --patch"
                } else {
                    showSelectCommandToast()
                }
            } else if (
                binding.autoCompleteMajorGitCommands.editableText.toString().equals("modify")
            ) {
                if (subCommandPosition == 0) {
                    binding.tvCommandUsage.text = "git commit --amend"
                } else if (subCommandPosition == 1) {
                    binding.tvCommandUsage.text = "git add . \n" + "git commit --amend --no-edit"
                } else if (subCommandPosition == 2) {
                    binding.tvCommandUsage.text = "git remote set-url <alias> <url>"
                } else {
                    showSelectCommandToast()
                }
            } else if (
                binding.autoCompleteMajorGitCommands.editableText.toString().equals("rebase")
            ) {
                if (subCommandPosition == 0) {
                    binding.tvCommandUsage.text = "git pull --rebase origin <branch name>"
                } else if (subCommandPosition == 1) {
                    binding.tvCommandUsage.text = "git rebase <branch name>"
                } else if (subCommandPosition == 2) {
                    binding.tvCommandUsage.text = "git rebase --skip"
                } else if (subCommandPosition == 3) {
                    binding.tvCommandUsage.text = "git rebase --continue"
                } else {
                    showSelectCommandToast()
                }
            }
        }
    }

    fun showSelectCommandToast() {

        Toast.makeText(this, "Please select a command to proceed.", Toast.LENGTH_LONG).show()
    }
}
