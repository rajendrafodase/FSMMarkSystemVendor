package com.example.fsmsystemvender;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.example.fsmsystemvender.UI.OtpActivity;
import com.example.fsmsystemvender.my_library.CheckNetwork;
import com.example.fsmsystemvender.my_library.UtilityRuntimePermission;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class AddNewAddressActivity extends UtilityRuntimePermission implements OnMapReadyCallback,
        LocationListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, GoogleMap.OnCameraIdleListener, GoogleMap.OnCameraMoveStartedListener, GoogleMap.OnCameraMoveListener, GoogleMap.OnCameraMoveCanceledListener {
    private EditText edt_area;
    private TextView tv_address;
    private Spinner edt_state, edt_location;
    private Button btn_add_address;
    private String getcity = "", getstate = "";
    private boolean statusOfGPS;
    private ImageView imageMarker,imgMyLocation;
    private Boolean userTouch = false;
    private boolean flag1 = true;
    Geocoder geocoder;
    List<Address> addresses;
    private GoogleMap mMap;
    private String address = "", city1 = "", state1 = "", country = "", postalCode = "", district = "", CurrentAddName = "", marker = "";
    private double lat, lon, latitude, longitude;
    private Location myLocation;
    private ProgressDialog progressDialog;
    private double current_lat = 0.0, current_lon = 0.0;
    private static final String LOG_TAG = "PlaceSelectionListener";
    private static LatLngBounds BOUNDS_MOUNTAIN_VIEW;
    private static final int REQUEST_SELECT_PLACE = 1000;
    protected GoogleApiClient mGoogleApiClient;
    private final static int REQUEST_LOCATION = 199;
    LocationManager manager;
    private boolean flag;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;
    CountDownTimer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_address);

        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Fetching Location");
        progressDialog.setCancelable(false);
        inti();


        timer = new CountDownTimer(5000, 2) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish()
            {

                Log.d("TAG", "onFinish: "+statusOfGPS);

                      flag = true;
                      CurrentLocation();
                     tv_address.setText("Fetching Address...");

            }
        }.start();

    }

    @Override
    public void processFinish(String result, int img_no) {

    }


    private void inti() {


        SupportMapFragment frag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map1);
        frag.getMapAsync(AddNewAddressActivity.this);
        tv_address = findViewById(R.id.address);
        edt_area = findViewById(R.id.edt_area);
        imgMyLocation = findViewById(R.id.imgMyLocation);

        btn_add_address = findViewById(R.id.btn_add_address);
        geocoder = new Geocoder(AddNewAddressActivity.this, Locale.getDefault());
        manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        statusOfGPS = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        imgMyLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = true;
                CurrentLocation();

            }
        });
        edt_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = true;
                CurrentLocation();

            }
        });
        btn_add_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddNewAddressActivity.this, MainActivity.class));
                finish();
//                if (validatefield()) {
//                    AddnewAddrss();
//                }
//                else {
//                    Toast.makeText(AddNewAddressActivity.this, "Address Not Getting...!", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(AddNewAddressActivity.this)
                    .addApi(LocationServices.API)
                    .addConnectionCallbacks(AddNewAddressActivity.this)
                    .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                        @Override
                        public void onConnectionFailed(ConnectionResult connectionResult) {

                            //Timber.v("Location error " + connectionResult.getErrorCode());
                        }
                    }).build();
            mGoogleApiClient.connect();
        }
        geocoder = new Geocoder(AddNewAddressActivity.this, Locale.getDefault());
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        statusOfGPS = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        imageMarker = (ImageView) findViewById(R.id.imageMarker);
        check_connection();

    }

    private void check_connection() {
        if (CheckNetwork.isInternetAvailable(this))  //if connection available
        {
            if (statusOfGPS) {
                getLocation();
            } else {
                enableLoc();
            }
        }
    }




    private void enableLoc() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(2 * 1000);
        locationRequest.setFastestInterval(5 * 1000);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);

        builder.setAlwaysShow(true);

        PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult result) {
                final Status status = result.getStatus();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:

                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        try {
                            status.startResolutionForResult(AddNewAddressActivity.this, REQUEST_LOCATION);
                        } catch (IntentSender.SendIntentException e) {

                            // Ignore the error.
                        }
                        break;
                }
            }
        });
    }

   /* private boolean validatefield() {
        boolean result = true;
        if (!MyValidator.isValidField(edt_area)) {
            result = false;
        }  if (!MyValidator.isValidField(edt_actual_address)) {
            result = false;
        }
        return result;
    }*/





    private void getLocation() {
        BOUNDS_MOUNTAIN_VIEW = new LatLngBounds(new LatLng(current_lat, current_lon), new LatLng(current_lat, current_lon));
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Searching Location");
        progressDialog.setCancelable(true);
        progressDialog.dismiss();

        if (mMap == null) {
            SupportMapFragment frag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map1);
            frag.getMapAsync(AddNewAddressActivity.this);

        }



    }


    private double distance(double lat1, double lon1, double lat2, double lon2) {

        Location locationA = new Location("point A");
        locationA.setLatitude(lat1);
        locationA.setLongitude(lon1);
        Location locationB = new Location("point B");
        locationB.setLatitude(lat2);
        locationB.setLongitude(lon2);
        double distance = locationA.distanceTo(locationB);
        return (distance) / 1000;

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (AddNewAddressActivity.super.requestAppPermissions(this)) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);


        }
        try {
            mMap.setMyLocationEnabled(true);
            myLocation = mMap.getMyLocation();
        } catch (Exception e) {
            e.getMessage();
        }
        /*else flag1 = true;
        try {
            myLocation = mMap.getMyLocation();
        } catch (Exception e) {
            e.getMessage();
        }*/


        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {
                flag = true;
                CurrentLocation();

                return false;
            }
        });

        mMap.setOnCameraIdleListener(this);
        mMap.setOnCameraMoveStartedListener(this);
        mMap.setOnCameraMoveListener(this);
        mMap.setOnCameraMoveCanceledListener(this);

        CurrentLocation();
    }


    @Override
    public void onPermissionsGranted(boolean result) {
        if (result && flag1)
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                return;
            }
        mMap.setMyLocationEnabled(true);
    }

    private void getAddress(double lat, double lon) {
        try {
            addresses = geocoder.getFromLocation(lat, lon, 5); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            if (addresses != null && addresses.size() > 0) {
                String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                city1 = addresses.get(0).getLocality();
                state1 = addresses.get(0).getAdminArea();
                country = addresses.get(0).getCountryName();
                postalCode = addresses.get(0).getPostalCode();
                district = addresses.get(0).getSubAdminArea();
                CurrentAddName = addresses.get(0).getFeatureName(); // Only if available else return NULL

                latitude = lat;
                longitude = lon;
                this.address = address;
                edt_area.setText(address);
                tv_address.setText(address);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void CurrentLocation() {

        mMap.clear();
        GoogleMap.OnMyLocationChangeListener myLocationChangeListener = new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
                current_lat = location.getLatitude();
                current_lon = location.getLongitude();
                //mMap.addMarker(new MarkerOptions().position(loc));
                if (mMap != null && flag) {

                    flag = false;
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, 16.0f));
                    //mMap.addMarker(new MarkerOptions().position(loc));
                    getAddress(location.getLatitude(), location.getLongitude());
                    //get_data(location.getLatitude(),location.getLongitude(),10);
                }
            }
        };

        mMap.setOnMyLocationChangeListener(myLocationChangeListener);

    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SELECT_PLACE) {
        }
        if (requestCode == REQUEST_LOCATION) {
            if (resultCode == RESULT_OK) {
                getLocation();
            } else {
                finish();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {
    }


    @Override
    public void onCameraMoveStarted(int reason) {

        //if (reason == GoogleMap.OnCameraMoveStartedListener.REASON_GESTURE) {
            if (!userTouch) {
                markerUp();
                userTouch = true;
            }
//        } else if (reason == GoogleMap.OnCameraMoveStartedListener.REASON_API_ANIMATION) {
//        } else if (reason == GoogleMap.OnCameraMoveStartedListener.REASON_DEVELOPER_ANIMATION) {
//        }
    }

    @Override
    public void onCameraMove() {
    }

    @Override
    public void onCameraMoveCanceled() {
    }

    @Override
    public void onCameraIdle() {
        if (userTouch) {
            markerDown();
            userTouch = true;
        }
    }

    public void markerUp() {
        edt_area.setText("Getting Address...");
        tv_address.setText("Getting Address...");
        imageMarker.clearAnimation();
        imageMarker.animate().translationY(-10f).setInterpolator(new AccelerateInterpolator()).setDuration(300);
    }

    public void markerDown() {
        imageMarker.clearAnimation();
        imageMarker.animate().translationY(10f).setInterpolator(new DecelerateInterpolator()).setDuration(300);
        LatLng cl = mMap.getCameraPosition().target;
        getAddress(cl.latitude, cl.longitude);
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }
        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    public void searchLocation(View view) {
        EditText locationSearch = (EditText) findViewById(R.id.editText);
        String location = locationSearch.getText().toString();
        List<Address> addressList = null;

        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Address address = addressList.get(0);
                LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(16.0f));
                getAddress(address.getLatitude(), address.getLongitude());

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}