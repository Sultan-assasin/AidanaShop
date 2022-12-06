package com.sultan.aidanashop.presentation


import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.google.android.material.navigation.NavigationView
import com.sultan.aidanashop.R
import com.sultan.aidanashop.databinding.ActivityMainBinding
import com.sultan.aidanashop.domain.ShopItem
import com.sultan.aidanashop.presentation.adapter.ShopItemAdapter
import com.sultan.aidanashop.presentation.adapter.SliderAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var shopListAdapter: ShopItemAdapter
    private lateinit var  appBarConfiguration: AppBarConfiguration
    private lateinit var navController : NavController


    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            shopListAdapter.submitList(it)
            clickListener()


            val imageList = ArrayList<ShopItem>()

            imageList.add(ShopItem("pizza", 1, R.drawable.img1, "title", 0))
            imageList.add(ShopItem("pizza", 1, R.drawable.img1, "title", 0))
            imageList.add(ShopItem("pizza", 1, R.drawable.img1, "title", 0))
            imageList.add(ShopItem("pizza", 1, R.drawable.img1, "title", 0))
            imageList.add(ShopItem("pizza", 1, R.drawable.img1, "title", 0))
            imageList.add(ShopItem("pizza", 1, R.drawable.img1, "title", 0))


        }

    }


    private fun setupRecyclerView() {
        with(binding.rvShop) {
            shopListAdapter = ShopItemAdapter()
            adapter = shopListAdapter
            val linear =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            layoutManager = linear
//app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
        }
    }

    private fun clickListener() {
        shopListAdapter.onShopItemClickListener = {

        }
    }

//    private fun adapter() {
//        val imageList = ArrayList<ShopItem>()
//
//        imageList.add(ShopItem("pizza", 1, R.drawable.img1, "title", 0))
//        imageList.add(ShopItem("pizza", 1, R.drawable.img1, "title", 0))
//        imageList.add(ShopItem("pizza", 1, R.drawable.img1, "title", 0))
//        imageList.add(ShopItem("pizza", 1, R.drawable.img1, "title", 0))
//        imageList.add(ShopItem("pizza", 1, R.drawable.img1, "title", 0))
//        imageList.add(ShopItem("pizza", 1, R.drawable.img1, "title", 0))
//
//        binding.carousel.adapter = SliderAdapter(imageList, binding.carousel)
//
//
//    }

//    private fun adapterAnimation() {
//        with(binding) {
//            carousel.clipToPadding = false
//            carousel.clipChildren = false
//            carousel.offscreenPageLimit = 3
//            carousel.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
//
//            val compositePageTransformer = CompositePageTransformer()
//
//            compositePageTransformer.addTransformer(MarginPageTransformer(40))
//            compositePageTransformer.addTransformer { page, position ->
//                val r = 1 - kotlin.math.abs(position)
//                page.scaleY = (0.80f + r*0.20f)
//                Log.d("start", "start")
//            }
//            carousel.setPageTransformer(compositePageTransformer)
//        }
//    }

}

