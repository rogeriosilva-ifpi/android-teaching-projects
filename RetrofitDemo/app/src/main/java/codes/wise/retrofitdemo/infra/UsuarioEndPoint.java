package codes.wise.retrofitdemo.infra;

import codes.wise.retrofitdemo.models.Usuario;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rogermac on 04/04/17.
 */

public interface UsuarioEndPoint {

    @GET("users/")
    Call<ListaUsuarioAPIModel> getUsarios();

    @GET("users/{username}")
    Call<Usuario> getUsario(@Path("username") String username);

}
