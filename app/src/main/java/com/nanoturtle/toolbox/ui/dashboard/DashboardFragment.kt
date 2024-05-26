package com.nanoturtle.toolbox.ui.dashboard

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nanoturtle.toolbox.databinding.FragmentDashboardBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        // 监听器不知道干啥的，反正新建按钮要加
        //例子：
        //val 类名: Button = binding.类名
        val buttonGallery: Button = binding.buttonGallery
        val buttonSelfTest: Button = binding.buttonSelftest
        val buttonadb: Button = binding.buttonadb
        // 监听DashBoard按下按钮的代码
        //例子：
        /*
        buttonGallery.setOnClickListener {
    // 目标应用的包名和Activity类名
    val packageName = "com.example.targetapp" // 替换为目标应用的真实包名
    val activityClassName = "com.example.targetapp.TargetActivity" // 替换为目标Activity的真实类名

    // 创建Intent并设置目标应用的包名和Activity类名
    val intent = Intent().apply {
        setClassName(packageName, activityClassName)
    }

    // 检查Intent是否有效
    if (intent.resolveActivity(requireContext().packageManager) != null) {
        try {
            // 启动目标应用的Activity
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            // 处理ActivityNotFoundException异常，例如显示Toast消息
            Toast.makeText(requireContext(), "找不到指定的Activity", Toast.LENGTH_SHORT).show()
        }
    } else {
        // 处理Intent解析失败的情况，例如显示Toast消息
        Toast.makeText(requireContext(), "无法解析Intent", Toast.LENGTH_SHORT).show()
    }
}
         */
        buttonGallery.setOnClickListener {
            // 目标应用的包名和Activity类名
            val packageName = "com.xtc.setting" // 替换为目标应用的真实包名
            val activityClassName = "com.xtc.setting.module.dev.activity.DevMainActivity" // 替换为目标Activity的真实类名

            // 创建Intent并设置目标应用的包名和Activity类名
            val intent = Intent().apply {
                setClassName(packageName, activityClassName)
            }

            // 检查Intent是否有效
            if (intent.resolveActivity(requireContext().packageManager) != null) {
                try {
                    // 启动目标应用的Activity
                    startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    // 处理ActivityNotFoundException异常，例如显示Toast消息
                    Toast.makeText(requireContext(), "找不到指定的Activity", Toast.LENGTH_SHORT).show()
                }
            } else {
                // 处理Intent解析失败的情况，例如显示Toast消息
                Toast.makeText(requireContext(), "无法解析Intent", Toast.LENGTH_SHORT).show()
            }
        }


        buttonSelfTest.setOnClickListener {
            // 目标应用的包名和Activity类名
            val packageName = "com.xtc.selftest" // 替换为目标应用的真实包名
            val activityClassName = "com.xtc.selftest.MainActivity" // 替换为目标Activity的真实类名

            // 创建Intent并设置目标应用的包名和Activity类名
            val intent = Intent().apply {
                setClassName(packageName, activityClassName)
            }

            // 检查Intent是否有效
            if (intent.resolveActivity(requireContext().packageManager) != null) {
                try {
                    // 启动目标应用的Activity
                    startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    // 处理ActivityNotFoundException异常，例如显示Toast消息
                    Toast.makeText(requireContext(), "找不到指定的Activity", Toast.LENGTH_SHORT).show()
                }
            } else {
                // 处理Intent解析失败的情况，例如显示Toast消息
                Toast.makeText(requireContext(), "无法解析Intent", Toast.LENGTH_SHORT).show()
            }
        }


        buttonadb.setOnClickListener {
            // Shell命令来启动Activity，但通常不会工作，因为需要root权限
            val command = "am start -n com.xtc.selftest/com.xtc.selftest.settings.DebugSettingsActivity"
            try {
                val process = Runtime.getRuntime().exec("su -c $command") // 'su' 通常用于root权限
                val inputStream = process.inputStream
                val reader = BufferedReader(InputStreamReader(inputStream))
                var line: String?
                //while ((line = reader.readLine()) != null) {
                    // 输出命令执行的结果，通常用于调试
                    //Log.d("ShellCommand", line)
                //}
                reader.close()
            } catch (e: IOException) {
                // 处理IO异常
                e.printStackTrace()
                Toast.makeText(requireContext(), "执行Shell命令出错", Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }

    // Helper function to check if an activity is available to be launched
    private fun isActivityAvailable(packageName: String, activityName: String): Boolean {
        try {
            val intent = Intent().setClassName(packageName, activityName)
            val packageManager = requireContext().packageManager
            packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)
            return true
        } catch (e: Exception) {
            return false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}