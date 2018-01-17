package codes.wise.retrofitdemo.infra;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import codes.wise.retrofitdemo.models.Disciplina;
import codes.wise.retrofitdemo.models.Usuario;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rogermac on 30/03/17.
 */

public class APIService {

    public static String TAG = APIService.class.getSimpleName();

    public static final String BASE_URL = "http://mural-api.herokuapp.com/api/v1/";

    private Retrofit retrofit;

    private Interceptor interceptor;

    //Endpoint
    private DisciplinaEndPoint disciplinaEndPoint;
    private UsuarioEndPoint usuarioEndPoint;

    public APIService(){

        this.interceptor = new InterceptorMuralAPI();

        OkHttpClient.Builder builderCliente = new OkHttpClient.Builder();
        builderCliente.interceptors().add(this.interceptor);

        OkHttpClient cliente = builderCliente.build();

        Retrofit.Builder builder = new Retrofit.Builder();

        retrofit = builder.baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(cliente)
                .build();

        disciplinaEndPoint = retrofit.create(DisciplinaEndPoint.class);
        usuarioEndPoint = retrofit.create(UsuarioEndPoint.class);

    }

    public void getDisciplinas(final Retrofitable retrofitable){

        Call<ListaDisciplinaAPIModel> call = disciplinaEndPoint.disciplinas();

        call.enqueue(new Callback<ListaDisciplinaAPIModel>() {
            @Override
            public void onResponse(Call<ListaDisciplinaAPIModel> call, Response<ListaDisciplinaAPIModel> response) {
                Log.i(TAG, "Status Code: " + response.code());
                retrofitable.onRetrofitResponse(response.code(), response.body().getResults());
            }

            @Override
            public void onFailure(Call<ListaDisciplinaAPIModel> call, Throwable t) {
                retrofitable.onRetrofitFailure(t);
            }
        });

    }

    public void postDisciplina(final Retrofitable retrofitable, Disciplina disciplina){

        Call<Disciplina> call = disciplinaEndPoint.postDisciplina(disciplina);

        call.enqueue(new Callback<Disciplina>() {
            @Override
            public void onResponse(Call<Disciplina> call, Response<Disciplina> response) {
                if (response.code() == 201){
                    getDisciplinas(retrofitable);
                    Toast.makeText((Context) retrofitable, "Disciplina Adicionada na API",
                            Toast.LENGTH_SHORT).show();
                }

                if (response.code() == 400) {
                    Gson gson = new GsonBuilder().create();
                    try {

                        DisciplinaPostError disciplinaPostError = gson.fromJson(response.errorBody().string(), DisciplinaPostError.class);
                        Toast.makeText((Context) retrofitable, "Error: " + disciplinaPostError.getNome(), Toast.LENGTH_LONG).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<Disciplina> call, Throwable t) {
                retrofitable.onRetrofitFailure(t);
            }
        });

    }

    public void putDisciplina(final Retrofitable retrofitable, Disciplina disciplina){

        Call<Disciplina> call = disciplinaEndPoint.putDisciplina(disciplina.getId(), disciplina);

        call.enqueue(new Callback<Disciplina>() {
            @Override
            public void onResponse(Call<Disciplina> call, Response<Disciplina> response) {
                if (response.code() == 200){
                    getDisciplinas(retrofitable);
                    Toast.makeText((Context) retrofitable, "Disciplina Alterada na API",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Disciplina> call, Throwable t) {
                retrofitable.onRetrofitFailure(t);
            }
        });

    }

    public void deleteDisciplina(final Retrofitable retrofitable, Disciplina disciplina){

        Call<ResponseBody> call = disciplinaEndPoint.deleteDisciplina(disciplina.getId());

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 204){
                    getDisciplinas(retrofitable);
                    Toast.makeText((Context) retrofitable, "Disciplina Removida da API",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                retrofitable.onRetrofitFailure(t);
            }
        });

    }

    public void obterUsuariosDaAPI(final Retrofitable retrofitable){

        Call<ListaUsuarioAPIModel> call = usuarioEndPoint.getUsarios();

        call.enqueue(new Callback<ListaUsuarioAPIModel>() {
            @Override
            public void onResponse(Call<ListaUsuarioAPIModel> call, Response<ListaUsuarioAPIModel> response) {
               int codigo = response.code();

                if (codigo >= 500){
                    //TODO: Servidor esta com problema.
                }

                if (response.isSuccessful()){
                    ListaUsuarioAPIModel corpo = response.body();
                    List<Usuario> usuarios = corpo.getResults();

                    retrofitable.onRetrofitResponse(codigo, usuarios);
                }

            }

            @Override
            public void onFailure(Call<ListaUsuarioAPIModel> call, Throwable t) {

            }
        });

    }

}













