package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.C0163d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import java.util.List;

public final class RealTimeMultiplayerImpl implements RealTimeMultiplayer {
    /* renamed from: a */
    private static <L> C0163d<L> m3022a(GoogleApiClient googleApiClient, L l) {
        return l == null ? null : googleApiClient.mo933d(l);
    }

    public void create(GoogleApiClient apiClient, RoomConfig config) {
        Games.m659d(apiClient).m4158a(apiClient.mo933d(config.getRoomUpdateListener()), m3022a(apiClient, config.getRoomStatusUpdateListener()), m3022a(apiClient, config.getMessageReceivedListener()), config);
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m659d(apiClient).m4231q(invitationId, 0);
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m659d(apiClient).m4230p(invitationId, 0);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.m659d(apiClient).m4162b(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.m659d(apiClient).m4162b(minPlayers, maxPlayers, allowAutomatch);
    }

    public RealTimeSocket getSocketForParticipant(GoogleApiClient apiClient, String roomId, String participantId) {
        return Games.m659d(apiClient).m4232s(roomId, participantId);
    }

    public Intent getWaitingRoomIntent(GoogleApiClient apiClient, Room room, int minParticipantsToStart) {
        return Games.m659d(apiClient).m4119a(room, minParticipantsToStart);
    }

    public void join(GoogleApiClient apiClient, RoomConfig config) {
        Games.m659d(apiClient).m4179b(apiClient.mo933d(config.getRoomUpdateListener()), m3022a(apiClient, config.getRoomStatusUpdateListener()), m3022a(apiClient, config.getMessageReceivedListener()), config);
    }

    public void leave(GoogleApiClient apiClient, RoomUpdateListener listener, String roomId) {
        Games.m659d(apiClient).m4159a(apiClient.mo933d(listener), roomId);
    }

    public int sendReliableMessage(GoogleApiClient apiClient, ReliableMessageSentCallback callback, byte[] messageData, String roomId, String recipientParticipantId) {
        return Games.m659d(apiClient).m4115a(m3022a(apiClient, callback), messageData, roomId, recipientParticipantId);
    }

    public int sendUnreliableMessage(GoogleApiClient apiClient, byte[] messageData, String roomId, String recipientParticipantId) {
        return Games.m659d(apiClient).m4116a(messageData, roomId, new String[]{recipientParticipantId});
    }

    public int sendUnreliableMessage(GoogleApiClient apiClient, byte[] messageData, String roomId, List<String> recipientParticipantIds) {
        return Games.m659d(apiClient).m4116a(messageData, roomId, (String[]) recipientParticipantIds.toArray(new String[recipientParticipantIds.size()]));
    }

    public int sendUnreliableMessageToOthers(GoogleApiClient apiClient, byte[] messageData, String roomId) {
        return Games.m659d(apiClient).m4192d(messageData, roomId);
    }
}
