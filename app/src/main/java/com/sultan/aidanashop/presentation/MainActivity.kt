package com.sultan.aidanashop.presentation


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.sultan.aidanashop.databinding.ActivityMainBinding
import com.sultan.aidanashop.presentation.adapter.ShopItemAdapter
import com.sultan.aidanashop.presentation.adapter.SliderAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var shopListAdapter: ShopItemAdapter

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

        }
        sliderView()

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
            Log.d("test", "test " + it)
        }
    }

    private fun sliderView() {

        lateinit var sliderAdapter: SliderAdapter
        lateinit var imageUrl: ArrayList<String>
        imageUrl = ArrayList()

        imageUrl =
            (imageUrl +
                    "https://biznesprost.com/wp-content/uploads/2018/12/franshiza-burger-king.jpg") as ArrayList<String>
        imageUrl =
            (imageUrl + "https://restolife.kz/upload/information_system_6/3/8/1/item_3812/information_items_property_2966.jpg") as ArrayList<String>
        imageUrl =
            (imageUrl + "https://www.iphones.ru/wp-content/uploads/2018/08/BurgerN.jpg") as ArrayList<String>



        sliderAdapter = SliderAdapter(imageUrl)
        with(binding.sliderView) {

            setSliderAdapter(sliderAdapter)
            setIndicatorAnimation(IndicatorAnimationType.WORM)
            setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
            startAutoCycle()
        }


    }


}

