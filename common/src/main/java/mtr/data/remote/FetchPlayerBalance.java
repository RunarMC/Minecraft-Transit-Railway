package mtr.data.remote;

import com.runarmc.annotations.Route;
import com.runarmc.models.AbstractModel;

@Route(
        route = "/api/mtr/players/by-id/:uuid",
        arguments = true,
        method = "GET",
        result = FetchPlayerBalance.class
)
public class FetchPlayerBalance extends AbstractModel {
    private Integer balance;

    public Integer getBalance() {
        return balance;
    }
}
