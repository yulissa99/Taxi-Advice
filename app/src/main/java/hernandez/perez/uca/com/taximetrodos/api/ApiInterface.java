package hernandez.perez.uca.com.taximetrodos.api;

import java.util.List;

import hernandez.perez.uca.com.taximetrodos.entity.AccessToken;
import hernandez.perez.uca.com.taximetrodos.entity.Conductor;
import hernandez.perez.uca.com.taximetrodos.entity.Lugar;
import hernandez.perez.uca.com.taximetrodos.entity.User;
import hernandez.perez.uca.com.taximetrodos.entity.UserCreate;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("conductores")
    Call<List<Conductor>> getConductores();

    @POST("conductores")
    Call<Conductor> postBus(@Path("id") Conductor conductor);

    @POST("Users")
    Call<User> signUp(@Body UserCreate user);

    @POST("Users/login")
    Call<AccessToken> login(@Body User user);
}
