
package org.sitcon.ccip.network;

import org.sitcon.ccip.model.Submission;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class SITCONClient {

    public static final String API_BASE_URL = "http://sitcon.org/2017/";

    private static Retrofit retrofit;
    private static SITCONService sCOSCUPService;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static SITCONService get() {
        if (sCOSCUPService == null) {
            sCOSCUPService = getRetrofit().create(SITCONService.class);
        }

        return sCOSCUPService;
    }

    public interface SITCONService {
        @GET("submissions.json")
        Call<List<Submission>> submission();
    }
}
