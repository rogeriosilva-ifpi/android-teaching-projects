package codes.wise.retrofitdemo.infra;

import java.io.IOException;
import java.util.Calendar;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rogermac on 30/03/17.
 */

public class InterceptorMuralAPI implements Interceptor{


    public static final String AUTHORIZATION = "Authorization";
    public static final String TOKEN = "token b65ecc64073fca22100123d591145ea7ee2994cf";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request().newBuilder()
                .addHeader(AUTHORIZATION, TOKEN)
                .build();

        return chain.proceed(request);
    }
}

