package codes.wise.retrofitdemo.infra;

import java.util.List;

/**
 * Created by rogermac on 30/03/17.
 */

public interface Retrofitable {

    public void onRetrofitResponse(int status, List dados);

    public void onRetrofitFailure(Throwable t);
}
