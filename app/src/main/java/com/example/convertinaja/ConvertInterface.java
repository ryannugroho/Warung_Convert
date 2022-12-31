package com.example.convertinaja;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ConvertInterface {

    @GET("index.php")
    Call<List<Convert>> getConvert();

    @FormUrlEncoded
    @POST("index.php")
    Call<Convert> postConvert(
            @Field("nama") String nama,
            @Field("noPengirim") String noPengirim,
            @Field("jumlah") String jumlah,
            @Field("noTujuan") String noTujuan,
            @Field("eWallet")String eWallet
    );

}
