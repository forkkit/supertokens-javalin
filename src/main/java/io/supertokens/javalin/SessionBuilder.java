package io.supertokens.javalin;

import com.google.gson.JsonObject;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class SessionBuilder {

    @NotNull
    private final Context ctx;

    @NotNull
    private final String userId;

    @Nullable
    private JsonObject jwtPayload = null;

    @Nullable
    private JsonObject sessionData = null;

    SessionBuilder(@NotNull Context ctx, @NotNull String userId) {
        this.ctx = ctx;
        this.userId = userId;
    }

    public void withJWTPayload(@NotNull JsonObject jwtPayload) {
        this.jwtPayload = jwtPayload;
    }

    public void withSessionData(@NotNull JsonObject sessionData) {
        this.sessionData = sessionData;
    }

    public void withJWTPayload(@NotNull Map<String, Object> jwtPayload) {
        // TODO: a problem is what are we going to return to the user? Map or JsonObject?
    }

    public void withSessionData(@NotNull Map<String, Object> sessionData) {
        // TODO: See above..
    }

    public Session create() {
        return SuperTokens.createNewSession(this.ctx, this.userId, this.jwtPayload, this.sessionData);
    }
}