package com.example.fsmsystemvender.Constant;

import android.content.Context;
import android.widget.Toast;

public interface Constant {


    String RESPONSE_MESSAGE = "ResponseMessage";
    String ID = "ID";

    String RESPONSE_CODE = "ResponseCode";
    int STATUS_CODE200 = 200;
    String STATUS_CODE400 = "400";
    String Status = "status";
    String APP_VERSION="APP_VERSION";
    String USER_TYPE="USER_TYPE";
    String ACTIVE_USER="ACTIVE_USER";
    String RESPONSE_SUCCESS = "0";
    String ResponseMessage = "ResponseMessage";
    String ERROR_CHECK_INTERNET="Please check your internet connection";

    String MCAT_ID = "MCAT_ID";
    String MCAT_NAME = "MCAT_NAME";
    String CITY_NAME = "CITY_NAME";

    String DATA = "DATA";
    String DATA1 = "DATA1";
    String START = "START";
    String END = "END";
    String WORD = "WORD";



    String GET_DATA = "GET_DATA";
    String ID1 = "ID1";
    String ID2 = "ID2";
    String ID3 = "ID3";

    String TOTAL_RATING = "TOTAL_RATING";
    String OUT_OFF_RATING = "OUT_OFF_RATING";
    String ONE_RATING = "ONE_RATING";
    String TWO_RATING = "TWO_RATING";
    String THREE_RATING = "THREE_RATING";
    String FOUR_RATING = "FOUR_RATING";
    String FIVE_RATING = "FIVE_RATING";

    String Pickup_way ="Pickup_way";
    String Drop_way ="Drop_way";

    String Pickup_Drop ="Pickup_Drop";
    String RoundTripDropAddress ="addressroundtrip";


    String STATUS = "STATUS";

    String START_DATE = "START_DATE";

    String END_DATE = "END_DATE";

    String LOGIN_TYPE ="LOGIN_TYPE";

    String Registration ="Registration";

    String Login ="Login";

    String SearchCabType= "SearchCabType";

    String Oneway_Trip="One Way";
    String Local_Trip="Local";
    String Round_Trip="Round Trip";
    String Airport_Trip="Airport Transfer";

    String MOBILE_NO ="mobileno";
    String USER_ID ="custid";
    String USER_UNIQUEID ="custuniqueid";
    String FULL_NAME ="fullname";
    String EMAIL ="emailid";
    String ADDRESS ="ADDRESS";
    String ADHARCARD_NUMBER ="ADHARCARD_NUMBER";
    String TOKEN ="jwttoken";
    String NATIONALITY ="nationality";
    String GENDER ="gender";
    String PASSWORD ="PASSWORD";
    String ROLEID ="roleid";
    String PROFILE_PHOTO ="customerpic";
    String TASK ="TASK";
    String EXTRA1 ="EXTRA1";
    String EXTRA2 ="EXTRA2";
    String EXTRA3 ="EXTRA3";
    String LANG_ID ="LANG_ID";
    String User_Otp ="User_Otp";
    String Master_Otp ="Master_Otp";

    String VCAT_ID ="VCAT_ID";

    String OneWay_Id ="OneWay_Id";
    String RoundTip_Id ="RoundTip_Id";
    String LocalTrip_Id ="LocalTrip_Id";
    String AirportTransferId ="AirportTransferId";

    String PICKUP_LOCATION ="PICKUP_LOCATION";
    String DROP_LOCATION ="DROP_LOCATION";
    String DRIP_DATE ="DRIP_DATE";

    public static void showToast(Context context, String msg, String type) {

        if (type.equals("1")) {

            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        }
    }


}
