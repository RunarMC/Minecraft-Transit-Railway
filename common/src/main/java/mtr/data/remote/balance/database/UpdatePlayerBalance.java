package mtr.data.remote.balance.database;

import com.google.gson.JsonObject;
import com.runarmc.annotations.Route;
import com.runarmc.models.AbstractPostModel;

import java.util.UUID;


@Route(
        route = "/api/mtr/players/update",
        method = "POST",
        result = UpdatePlayerBalance.class
)
public class UpdatePlayerBalance extends AbstractPostModel {

    private final String uuid;
    private final Operation operation;
    private final Integer amount;

    private String kingdomId;

    public UpdatePlayerBalance(UUID uuid, Operation operation, Integer amount) {
        this.uuid = uuid.toString();
        this.operation = operation;
        this.amount = amount;
    }

    public void setKingdomId(String kingdomId) {
        this.kingdomId = kingdomId;
    }

    @Override
    public JsonObject body() {
        JsonObject body = new JsonObject();

        body.addProperty("uuid", this.uuid);
        body.addProperty("operation", this.operation.name());
        body.addProperty("amount", this.amount);
        body.addProperty("kingdomId", this.kingdomId);

        return body;
    }

    public enum Operation {
        DEBIT,
        CREDIT
    }
}
