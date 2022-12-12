package com.sultan.aidanashop.presentation


import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.sultan.aidanashop.R
import com.sultan.aidanashop.databinding.ActivityMainBinding
import com.sultan.aidanashop.presentation.adapter.ShopItemAdapter
import com.sultan.aidanashop.presentation.adapter.SliderAdapter


lateinit var toggle : ActionBarDrawerToggle

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
        navView()

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




//            var shopItem = it.image
//            ContextCompat.getDrawable(this, shopItem)?.setColorFilter(
//                ContextCompat.getColor(this, R.color.purple_500),
//                PorterDuff.Mode.SRC_IN
//            )
            //changeDrawableColor(col, ContextCompat.getColor(this, R.color.purple_500))
        }
    }

//    fun changeDrawableColor(drawable: Drawable?, color: Int): Drawable {
//        var drawable = drawable
//        drawable = DrawableCompat.wrap(drawable!!)
//        DrawableCompat.setTint(drawable, color)
//        return drawable
//    }


    private fun sliderView() {

        lateinit var sliderAdapter: SliderAdapter
        var imageUrl: ArrayList<String> = ArrayList()

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
    private fun navView(){
        val drawerLayout : DrawerLayout = binding.drawerLayout
        val navView : NavigationView =binding.navView
        toggle = ActionBarDrawerToggle(this,drawerLayout, R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        getSupportActionBar()?.setHomeButtonEnabled(true);
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);

        getSupportActionBar()?.setHomeAsUpIndicator(R.drawable.ic_baseline_sort_24);


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.navHome -> Toast.makeText(applicationContext,"Clicked Home",Toast.LENGTH_SHORT).show()
                R.id.navLike -> Toast.makeText(applicationContext,"Clicked Like",Toast.LENGTH_SHORT).show()
                R.id.navShop -> Toast.makeText(applicationContext,"Clicked Shop",Toast.LENGTH_SHORT).show()
                R.id.navLogin -> Toast.makeText(applicationContext,"Clicked Login",Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }



}

