package com.example.fsmsystemvender;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fsmsystemvender.UI.AddNewVendor;
import com.example.fsmsystemvender.UI.MyOrdersActivity;
import com.example.fsmsystemvender.UI.ProductCategroyPage;
import com.example.fsmsystemvender.UI.ProductDetailsActivity;
import com.example.fsmsystemvender.UI.ProfileActivity;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     TableRow tr_add_vendor, tr_userprofile, tr_home, tr_myOrders, tr_Settings, tr_update_profile, tr_change_pass, tr_report, tr_Logout, tr_request_delivery_center, tr_center_delivery, tr_request_for_centerto_user, tr_deliverd_user_to_center;
    private LinearLayout linear_report, linear_sett;
    private DrawerLayout drawer;

    private String version;
    private String versionName;
    private TextView tv_version, tv_thank;
    private RelativeLayout noRecordLayout, no_internet;
    private Dialog dialog;
    private Button btn_yes, btn_no;
    private TextView notification_text_count;
    private LinearLayout li_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//         tv_thank = (TextView) findViewById(R.id.tv_thank);
        setSupportActionBar(toolbar);

        try {
            versionName = MainActivity.this.getPackageManager().getPackageInfo(MainActivity.this.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        version = versionName;
        Log.d("abc", "onCreate: " + version);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        tv_version = navigationView.findViewById(R.id.tv_version);
//        tv_version.setText("V" + version);
        View header = navigationView.getHeaderView(0);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        SetonClick();
    }

    private void SetonClick() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        li_product = (LinearLayout) findViewById(R.id.li_product);
        linear_report = (LinearLayout) navigationView.findViewById(R.id.linear_report);
        tr_home = (TableRow) navigationView.findViewById(R.id.tr_home);
        tr_userprofile = (TableRow) navigationView.findViewById(R.id.tr_userprofile);
        tr_report = (TableRow) navigationView.findViewById(R.id.tr_report);
        tr_add_vendor = (TableRow) navigationView.findViewById(R.id.tr_add_vendor);
        tr_Logout = (TableRow) navigationView.findViewById(R.id.tr_Logout);
        tr_request_delivery_center = (TableRow) navigationView.findViewById(R.id.tr_request_delivery_center);
        tr_center_delivery = (TableRow) navigationView.findViewById(R.id.tr_center_delivery);
        tr_request_for_centerto_user = (TableRow) navigationView.findViewById(R.id.tr_request_for_centerto_user);
        tr_deliverd_user_to_center = (TableRow) navigationView.findViewById(R.id.tr_deliverd_user_to_center);
        tr_myOrders = (TableRow) navigationView.findViewById(R.id.tr_myOrders);
        tr_Settings = (TableRow) navigationView.findViewById(R.id.tr_Settings);
        linear_sett = (LinearLayout) navigationView.findViewById(R.id.linear_sett);
        tr_update_profile = (TableRow) navigationView.findViewById(R.id.tr_update_profile);
        tr_change_pass = (TableRow) navigationView.findViewById(R.id.tr_change_pass);

        tr_home.setOnClickListener(this);
        tr_userprofile.setOnClickListener(this);
        tr_report.setOnClickListener(this);
        tr_add_vendor.setOnClickListener(this);
        tr_Logout.setOnClickListener(this);
        tr_request_delivery_center.setOnClickListener(this);
        tr_center_delivery.setOnClickListener(this);
        tr_request_for_centerto_user.setOnClickListener(this);
        tr_deliverd_user_to_center.setOnClickListener(this);
        tr_myOrders.setOnClickListener(this);
        tr_Settings.setOnClickListener(this);
        tr_update_profile.setOnClickListener(this);
        tr_change_pass.setOnClickListener(this);
        li_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ProductDetailsActivity.class));

            }
        });


    }


    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        int id = view.getId();
        if (id == R.id.tr_home) {
            startActivity(new Intent(MainActivity.this, MainActivity.class));
            finish();
            drawer.closeDrawers();
        } else if (id == R.id.tr_report) {
             startActivity(new Intent(MainActivity.this, ProductCategroyPage.class));
            drawer.closeDrawers();
//                if (!linear_report.isShown()) {
//                    linear_report.setVisibility(View.VISIBLE);
//                    drawer.openDrawer(GravityCompat.START);
//                } else {
//                    linear_report.setVisibility(View.GONE);
//                }
        } else if (id == R.id.tr_Settings) {
            if (!linear_sett.isShown()) {
                linear_sett.setVisibility(View.VISIBLE);
                drawer.openDrawer(GravityCompat.START);
            } else {
                linear_sett.setVisibility(View.GONE);
            }
        } else if (id == R.id.tr_update_profile) {
            //  startActivity(new Intent(MainActivity.this, UpdateVenderProfile.class));
            linear_sett.setVisibility(View.GONE);
            drawer.closeDrawers();
            //            case R.id.tr_change_pass:
//                startActivity(new Intent(MainActivity.this, ChangePasswordActivity.class));
//                linear_sett.setVisibility(View.GONE);
//                drawer.closeDrawers();
//                break;
        } else if (id == R.id.tr_request_delivery_center) {
            //                startActivity(new Intent(MainActivity.this, ReportDeliveryToCenter.class));
            linear_report.setVisibility(View.GONE);
            drawer.closeDrawers();
        } else if (id == R.id.tr_center_delivery) {
            //                startActivity(new Intent(MainActivity.this, ReportCenterToDelivery.class));
            linear_report.setVisibility(View.GONE);
            drawer.closeDrawers();
        } else if (id == R.id.tr_request_for_centerto_user) {
            //                startActivity(new Intent(MainActivity.this, ReportCenterToUser.class));
            linear_report.setVisibility(View.GONE);
            drawer.closeDrawers();
        } else if (id == R.id.tr_myOrders) {
             startActivity(new Intent(MainActivity.this, MyOrdersActivity.class));
            drawer.closeDrawers();
        } else if (id == R.id.tr_userprofile) {
              startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            drawer.closeDrawers();
        } else if (id == R.id.tr_add_vendor) {
             startActivity(new Intent(MainActivity.this, AddNewVendor.class));
            drawer.closeDrawers();
        } else if (id == R.id.tr_Logout) {
            showDialog();
            drawer.closeDrawers();
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container1, fragment);
            ft.commit();

        }

    }


    private void showDialog() {
        dialog = new Dialog(MainActivity.this);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.alert_dialog);
        btn_yes = dialog.findViewById(R.id.btn_logout_yes);
        btn_no = dialog.findViewById(R.id.btn_logout_no);
        btn_yes.setText("Logout");
        btn_no.setText("Cancel");
        TextView text_msg = (TextView) dialog.findViewById(R.id.text_msg);
        ImageView iv_image = (ImageView) dialog.findViewById(R.id.iv_image);
        iv_image.setImageDrawable(getResources().getDrawable(R.drawable.logout));
        TextView text = (TextView) dialog.findViewById(R.id.text);
        text_msg.setText("Are you sure you want to Logout");
        text.setText("Logout...!");
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                // Shared_Preferences.clearPref(MainActivity.this);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Logout Successfully...", Toast.LENGTH_SHORT).show();

            }
        });

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (Integer.parseInt(Build.VERSION.SDK) > 5 && keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                finishAffinity();
                // tv_thank.setVisibility(View.VISIBLE);
            } else {
                System.exit(0);
            }
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press back again to exit.", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}