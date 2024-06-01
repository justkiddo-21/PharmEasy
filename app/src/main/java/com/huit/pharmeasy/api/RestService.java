package com.huit.pharmeasy.api;


import com.huit.pharmeasy.model.BannerResult;
import com.huit.pharmeasy.model.Bill;
import com.huit.pharmeasy.model.BillResult;
import com.huit.pharmeasy.model.Category;
import com.huit.pharmeasy.model.CategoryResult;
import com.huit.pharmeasy.model.OfferResult;
import com.huit.pharmeasy.model.OrderItem;
import com.huit.pharmeasy.model.OrdersResult;
import com.huit.pharmeasy.model.PlaceOrder;
import com.huit.pharmeasy.model.Prescription;
import com.huit.pharmeasy.model.PrescriptionResult;
import com.huit.pharmeasy.model.ProductResult;
import com.huit.pharmeasy.model.Token;
import com.huit.pharmeasy.model.User;
import com.huit.pharmeasy.model.UserResult;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit RestAPI
 */

public interface RestService {

    @POST("api/v1/register")
    Call<UserResult> register(@Body User user);

    @POST("api/v1/login")
    Call<UserResult> login(@Body User user);

    @POST("api/v1/forgot_password")
    Call<UserResult> forgotPassword(@Body User user);

    @POST("api/v1/reset_password")
    Call<UserResult> resetPassword(@Body User user);

    @POST("api/v1/resend_otp")
    Call<UserResult> resendVerification(@Body User user);

    @POST("api/v1/verify_otp")
    Call<UserResult> userActivate(@Body User user);

    @GET("api/v1/banners")
    Call<BannerResult> banners();

    @GET("api/v1/offers")
    Call<OfferResult> offers();

    @POST("api/v1/categories")
    Call<CategoryResult> allCategory(@Body Token token);

    @POST("api/v1/newProducts")
    Call<ProductResult> newProducts(@Body Token token);

    @POST("api/v1/homepage")
    Call<ProductResult> popularProducts(@Body Token token);

    @POST("api/v1/category/products")
    Call<ProductResult> getCategoryProduct(@Body Category category);

    @POST("api/v1/sub-category/products")
    Call<ProductResult> getSubCategoryProduct(@Body Category category);

    @POST("api/v1/placeOrder")
    Call<OrdersResult> confirmPlaceOrder(@Body PlaceOrder placeOrder);

    @Multipart
    @POST("api/v1/uploadprescription/{id}")
    Call<OrdersResult> uploadPrescription(@Path("id") String id , @Part MultipartBody.Part prescription);


    @POST("api/v1//orderDetails")
    Call<OrdersResult> orderDetails(@Body Token token);

    @POST("api/v1/update_user")
    Call<UserResult> updateUser(@Body User user);

    @GET("api/v1/product/search")
    Call<ProductResult> searchProduct(@Query("s") String search);

    @POST("api/v1/singleOrderDetails")
    Call<OrdersResult> getOrderItems(@Body OrderItem orderItem);

    @POST("api/v1/prescriptions")
    Call<PrescriptionResult> getPrescription(@Body Token token);

    @Multipart
    @POST("api/v1/upload_prescription")
    Call<Prescription> uploadPrescription(
            @Part("name") RequestBody name,
            @Part("email") RequestBody email,
            @Part("mobile") RequestBody mobile,
            @Part("remark") RequestBody remark,
            @Part("title") RequestBody title,
            @Part MultipartBody.Part image,
            @Part("token") RequestBody token
    );

    @POST("api/v1/bills")
    Call<BillResult> getBills(@Body Token token);

    @Multipart
    @POST("api/v1/upload_bills")
    Call<Bill> uploadBill(
            @Part("name") RequestBody name,
            @Part("email") RequestBody email,
            @Part("mobile") RequestBody mobile,
            @Part("amount") RequestBody amount,
            @Part("title") RequestBody title,
            @Part MultipartBody.Part bill,
            @Part("token") RequestBody token
    );


}
