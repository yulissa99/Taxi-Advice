package hernandez.perez.uca.com.taximetrodos.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private final static  String URL = "https://driversnic.herokuapp.com/api";

    public static String getBase() {
        return URL + "/";
    }

    public static ApiInterface instance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.getBase())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        System.out.println("MESSAGE API: "+ URL);
        return retrofit.create(ApiInterface.class);
    }

}
