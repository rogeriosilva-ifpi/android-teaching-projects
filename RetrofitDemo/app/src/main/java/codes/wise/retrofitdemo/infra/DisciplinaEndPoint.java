package codes.wise.retrofitdemo.infra;

import codes.wise.retrofitdemo.models.Disciplina;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by rogermac on 30/03/17.
 */

public interface DisciplinaEndPoint {

    @GET("disciplinas/")
    Call<ListaDisciplinaAPIModel> disciplinas();

    @POST("disciplinas/")
    Call<Disciplina> postDisciplina(@Body Disciplina disciplina);

    @PUT("disciplinas/{id}/")
    Call<Disciplina> putDisciplina(@Path("id") long id, @Body Disciplina disciplina);

    @DELETE("disciplinas/{id}/")
    Call<ResponseBody> deleteDisciplina(@Path("id") long id);

}

