package com.example.fsmsystemvender.Constant;

public interface Url
{
    String JSONURL = "https://dev.gocabish.com/";

    String  BaseUrl=JSONURL +"api/";
    String OTP = BaseUrl + "loginwithotp";
    String Registration = BaseUrl + "registration";
    String LOGINWITHPASS = BaseUrl + "loginwithpass";
    String VERIFY = BaseUrl + "verifyotp";

    String UPDATEPROFILE = BaseUrl + "updateprofile";
    String GETPROFILE = BaseUrl + "getprofile";

    String ONEWAY_FROM_TO = BaseUrl + "getlocation";

    String DASHBOARD = BaseUrl + "getdashboard";

    String SEARCHBOOKING = BaseUrl + "searchbooking";

    String CouponList = BaseUrl + "getPromoCode";

    String Packages = BaseUrl + "getlocalpackage";

    String ApplyCode = BaseUrl + "applypromocode";

    String CABISHPOINT = BaseUrl + "getcabishpoint";



    String PopularCities = BaseUrl + "MasterAddress";

    String MAsterCities = BaseUrl + "MasterAddress";



    String AdditionalInfo = BaseUrl + "BookingMasterData/1";






    String OfferList = "";
}
