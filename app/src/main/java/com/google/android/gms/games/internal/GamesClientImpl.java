package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.C0163d;
import com.google.android.gms.common.api.C0163d.C0162b;
import com.google.android.gms.common.api.C0800a;
import com.google.android.gms.common.api.C0801b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C0810a;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.IGamesService.Stub;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jl.C1399e;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ll;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl extends jl<IGamesService> implements ConnectionCallbacks, OnConnectionFailedListener {
    private final String DZ;
    EventIncrementManager Yk = new C08941(this);
    private final String Yl;
    private final Map<String, RealTimeSocket> Ym;
    private PlayerEntity Yn;
    private GameEntity Yo;
    private final PopupManager Yp;
    private boolean Yq = false;
    private final Binder Yr;
    private final long Ys;
    private final GamesOptions Yt;

    /* renamed from: com.google.android.gms.games.internal.GamesClientImpl$1 */
    class C08941 extends EventIncrementManager {
        final /* synthetic */ GamesClientImpl Yu;

        C08941(GamesClientImpl gamesClientImpl) {
            this.Yu = gamesClientImpl;
        }

        public EventIncrementCache lF() {
            return new GameClientEventIncrementCache(this.Yu);
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        final /* synthetic */ GamesClientImpl Yu;

        public GameClientEventIncrementCache(GamesClientImpl gamesClientImpl) {
            this.Yu = gamesClientImpl;
            super(gamesClientImpl.getContext().getMainLooper(), 1000);
        }

        /* renamed from: r */
        protected void mo1171r(String str, int i) {
            try {
                if (this.Yu.isConnected()) {
                    ((IGamesService) this.Yu.hw()).mo1420o(str, i);
                } else {
                    GamesLog.m685p("GamesClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
                }
            } catch (RemoteException e) {
                GamesLog.m684o("GamesClientImpl", "service died");
            }
        }
    }

    private static final class InvitationReceivedNotifier implements C0162b<OnInvitationReceivedListener> {
        private final Invitation YF;

        InvitationReceivedNotifier(Invitation invitation) {
            this.YF = invitation;
        }

        /* renamed from: a */
        public void m2736a(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.YF);
        }

        /* renamed from: c */
        public /* synthetic */ void mo916c(Object obj) {
            m2736a((OnInvitationReceivedListener) obj);
        }

        public void gG() {
        }
    }

    private static final class InvitationRemovedNotifier implements C0162b<OnInvitationReceivedListener> {
        private final String YG;

        InvitationRemovedNotifier(String invitationId) {
            this.YG = invitationId;
        }

        /* renamed from: a */
        public void m2738a(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.YG);
        }

        /* renamed from: c */
        public /* synthetic */ void mo916c(Object obj) {
            m2738a((OnInvitationReceivedListener) obj);
        }

        public void gG() {
        }
    }

    private static final class LeftRoomNotifier implements C0162b<RoomUpdateListener> {
        private final int Iv;
        private final String YI;

        LeftRoomNotifier(int statusCode, String roomId) {
            this.Iv = statusCode;
            this.YI = roomId;
        }

        /* renamed from: a */
        public void m2740a(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.Iv, this.YI);
        }

        /* renamed from: c */
        public /* synthetic */ void mo916c(Object obj) {
            m2740a((RoomUpdateListener) obj);
        }

        public void gG() {
        }
    }

    private static final class MatchRemovedNotifier implements C0162b<OnTurnBasedMatchUpdateReceivedListener> {
        private final String Zb;

        MatchRemovedNotifier(String matchId) {
            this.Zb = matchId;
        }

        /* renamed from: a */
        public void m2742a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.Zb);
        }

        /* renamed from: c */
        public /* synthetic */ void mo916c(Object obj) {
            m2742a((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        public void gG() {
        }
    }

    private static final class MatchUpdateReceivedNotifier implements C0162b<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch Zc;

        MatchUpdateReceivedNotifier(TurnBasedMatch match) {
            this.Zc = match;
        }

        /* renamed from: a */
        public void m2744a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.Zc);
        }

        /* renamed from: c */
        public /* synthetic */ void mo916c(Object obj) {
            m2744a((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        public void gG() {
        }
    }

    private static final class MessageReceivedNotifier implements C0162b<RealTimeMessageReceivedListener> {
        private final RealTimeMessage Zd;

        MessageReceivedNotifier(RealTimeMessage message) {
            this.Zd = message;
        }

        /* renamed from: a */
        public void m2746a(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.Zd);
        }

        /* renamed from: c */
        public /* synthetic */ void mo916c(Object obj) {
            m2746a((RealTimeMessageReceivedListener) obj);
        }

        public void gG() {
        }
    }

    private static final class NearbyPlayerDetectedNotifier implements C0162b<OnNearbyPlayerDetectedListener> {
        private final Player Ze;

        /* renamed from: a */
        public void m2748a(OnNearbyPlayerDetectedListener onNearbyPlayerDetectedListener) {
            onNearbyPlayerDetectedListener.m661a(this.Ze);
        }

        /* renamed from: c */
        public /* synthetic */ void mo916c(Object obj) {
            m2748a((OnNearbyPlayerDetectedListener) obj);
        }

        public void gG() {
        }
    }

    private static final class P2PConnectedNotifier implements C0162b<RoomStatusUpdateListener> {
        private final String Zk;

        P2PConnectedNotifier(String participantId) {
            this.Zk = participantId;
        }

        /* renamed from: a */
        public void m2750a(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PConnected(this.Zk);
        }

        /* renamed from: c */
        public /* synthetic */ void mo916c(Object obj) {
            m2750a((RoomStatusUpdateListener) obj);
        }

        public void gG() {
        }
    }

    private static final class P2PDisconnectedNotifier implements C0162b<RoomStatusUpdateListener> {
        private final String Zk;

        P2PDisconnectedNotifier(String participantId) {
            this.Zk = participantId;
        }

        /* renamed from: a */
        public void m2752a(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PDisconnected(this.Zk);
        }

        /* renamed from: c */
        public /* synthetic */ void mo916c(Object obj) {
            m2752a((RoomStatusUpdateListener) obj);
        }

        public void gG() {
        }
    }

    private static final class QuestCompletedNotifier implements C0162b<QuestUpdateListener> {
        private final Quest Yw;

        QuestCompletedNotifier(Quest quest) {
            this.Yw = quest;
        }

        /* renamed from: a */
        public void m2754a(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.Yw);
        }

        /* renamed from: c */
        public /* synthetic */ void mo916c(Object obj) {
            m2754a((QuestUpdateListener) obj);
        }

        public void gG() {
        }
    }

    private static final class RealTimeMessageSentNotifier implements C0162b<ReliableMessageSentCallback> {
        private final int Iv;
        private final String Zp;
        private final int Zq;

        RealTimeMessageSentNotifier(int statusCode, int token, String recipientParticipantId) {
            this.Iv = statusCode;
            this.Zq = token;
            this.Zp = recipientParticipantId;
        }

        /* renamed from: a */
        public void m2756a(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.Iv, this.Zq, this.Zp);
            }
        }

        /* renamed from: c */
        public /* synthetic */ void mo916c(Object obj) {
            m2756a((ReliableMessageSentCallback) obj);
        }

        public void gG() {
        }
    }

    private static final class RequestReceivedNotifier implements C0162b<OnRequestReceivedListener> {
        private final GameRequest Zs;

        RequestReceivedNotifier(GameRequest request) {
            this.Zs = request;
        }

        /* renamed from: a */
        public void m2758a(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.Zs);
        }

        /* renamed from: c */
        public /* synthetic */ void mo916c(Object obj) {
            m2758a((OnRequestReceivedListener) obj);
        }

        public void gG() {
        }
    }

    private static final class RequestRemovedNotifier implements C0162b<OnRequestReceivedListener> {
        private final String Zt;

        RequestRemovedNotifier(String requestId) {
            this.Zt = requestId;
        }

        /* renamed from: a */
        public void m2760a(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.Zt);
        }

        /* renamed from: c */
        public /* synthetic */ void mo916c(Object obj) {
            m2760a((OnRequestReceivedListener) obj);
        }

        public void gG() {
        }
    }

    private static abstract class AbstractRoomNotifier extends C0800a<RoomUpdateListener> {
        AbstractRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* renamed from: a */
        protected void m4107a(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            mo3690a(roomUpdateListener, GamesClientImpl.m4113R(dataHolder), dataHolder.getStatusCode());
        }

        /* renamed from: a */
        protected abstract void mo3690a(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private static abstract class AbstractRoomStatusNotifier extends C0800a<RoomStatusUpdateListener> {
        AbstractRoomStatusNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* renamed from: a */
        protected void m4110a(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            mo3689a(roomStatusUpdateListener, GamesClientImpl.m4113R(dataHolder));
        }

        /* renamed from: a */
        protected abstract void mo3689a(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static final class AcceptQuestResultImpl extends C0801b implements AcceptQuestResult {
        private final Quest Yw;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.Yw = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.Yw = null;
                }
                questBuffer.release();
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public Quest getQuest() {
            return this.Yw;
        }
    }

    private static final class CancelMatchResultImpl implements CancelMatchResult {
        private final Status Eb;
        private final String Yy;

        CancelMatchResultImpl(Status status, String externalMatchId) {
            this.Eb = status;
            this.Yy = externalMatchId;
        }

        public String getMatchId() {
            return this.Yy;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class ClaimMilestoneResultImpl extends C0801b implements ClaimMilestoneResult {
        private final Quest Yw;
        private final Milestone Yz;

        ClaimMilestoneResultImpl(DataHolder dataHolder, String milestoneId) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.Yw = new QuestEntity((Quest) questBuffer.get(0));
                    List mQ = this.Yw.mQ();
                    int size = mQ.size();
                    for (int i = 0; i < size; i++) {
                        if (((Milestone) mQ.get(i)).getMilestoneId().equals(milestoneId)) {
                            this.Yz = (Milestone) mQ.get(i);
                            return;
                        }
                    }
                    this.Yz = null;
                } else {
                    this.Yz = null;
                    this.Yw = null;
                }
                questBuffer.release();
            } finally {
                questBuffer.release();
            }
        }

        public Milestone getMilestone() {
            return this.Yz;
        }

        public Quest getQuest() {
            return this.Yw;
        }
    }

    private static final class CommitSnapshotResultImpl extends C0801b implements CommitSnapshotResult {
        private final SnapshotMetadata YA;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.YA = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.YA = null;
                }
                snapshotMetadataBuffer.release();
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.YA;
        }
    }

    private static final class ContactSettingLoadResultImpl extends C0801b implements ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class DeleteSnapshotResultImpl implements DeleteSnapshotResult {
        private final Status Eb;
        private final String YB;

        DeleteSnapshotResultImpl(int statusCode, String snapshotId) {
            this.Eb = new Status(statusCode);
            this.YB = snapshotId;
        }

        public String getSnapshotId() {
            return this.YB;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements GameMuteStatusChangeResult {
        private final Status Eb;
        private final String YC;
        private final boolean YD;

        public GameMuteStatusChangeResultImpl(int statusCode, String externalGameId, boolean isMuted) {
            this.Eb = new Status(statusCode);
            this.YC = externalGameId;
            this.YD = isMuted;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements GameMuteStatusLoadResult {
        private final Status Eb;
        private final String YC;
        private final boolean YD;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.Eb = new Status(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.YC = dataHolder.m2493c("external_game_id", 0, 0);
                    this.YD = dataHolder.m2494d("muted", 0, 0);
                } else {
                    this.YC = null;
                    this.YD = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class InboxCountResultImpl implements InboxCountResult {
        private final Status Eb;
        private final Bundle YE;

        InboxCountResultImpl(Status status, Bundle inboxCounts) {
            this.Eb = status;
            this.YE = inboxCounts;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class LeaderboardMetadataResultImpl extends C0801b implements LeaderboardMetadataResult {
        private final LeaderboardBuffer YH;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YH = new LeaderboardBuffer(dataHolder);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.YH;
        }
    }

    private static final class LoadAchievementsResultImpl extends C0801b implements LoadAchievementsResult {
        private final AchievementBuffer YJ;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YJ = new AchievementBuffer(dataHolder);
        }

        public AchievementBuffer getAchievements() {
            return this.YJ;
        }
    }

    private static final class LoadAclResultImpl extends C0801b implements LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadAppContentsResultImpl extends C0801b implements LoadAppContentResult {
        private final ArrayList<DataHolder> YK;

        LoadAppContentsResultImpl(DataHolder[] appContentData) {
            super(appContentData[0]);
            this.YK = new ArrayList(Arrays.asList(appContentData));
        }
    }

    private static final class LoadEventResultImpl extends C0801b implements LoadEventsResult {
        private final EventBuffer YL;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YL = new EventBuffer(dataHolder);
        }

        public EventBuffer getEvents() {
            return this.YL;
        }
    }

    private static final class LoadExtendedGamesResultImpl extends C0801b implements LoadExtendedGamesResult {
        private final ExtendedGameBuffer YM;

        LoadExtendedGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YM = new ExtendedGameBuffer(dataHolder);
        }
    }

    private static final class LoadGameInstancesResultImpl extends C0801b implements LoadGameInstancesResult {
        private final GameInstanceBuffer YN;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YN = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends C0801b implements LoadGameSearchSuggestionsResult {
        private final GameSearchSuggestionBuffer YO;

        LoadGameSearchSuggestionsResultImpl(DataHolder data) {
            super(data);
            this.YO = new GameSearchSuggestionBuffer(data);
        }
    }

    private static final class LoadGamesResultImpl extends C0801b implements LoadGamesResult {
        private final GameBuffer YP;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YP = new GameBuffer(dataHolder);
        }

        public GameBuffer getGames() {
            return this.YP;
        }
    }

    private static final class LoadInvitationsResultImpl extends C0801b implements LoadInvitationsResult {
        private final InvitationBuffer YQ;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YQ = new InvitationBuffer(dataHolder);
        }

        public InvitationBuffer getInvitations() {
            return this.YQ;
        }
    }

    private static final class LoadMatchesResultImpl implements LoadMatchesResult {
        private final Status Eb;
        private final LoadMatchesResponse YR;

        LoadMatchesResultImpl(Status status, Bundle matchData) {
            this.Eb = status;
            this.YR = new LoadMatchesResponse(matchData);
        }

        public LoadMatchesResponse getMatches() {
            return this.YR;
        }

        public Status getStatus() {
            return this.Eb;
        }

        public void release() {
            this.YR.release();
        }
    }

    private static final class LoadOwnerCoverPhotoUrisResultImpl implements LoadOwnerCoverPhotoUrisResult {
        private final Bundle DJ;
        private final Status Eb;

        LoadOwnerCoverPhotoUrisResultImpl(int statusCode, Bundle bundle) {
            this.Eb = new Status(statusCode);
            this.DJ = bundle;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class LoadPlayerScoreResultImpl extends C0801b implements LoadPlayerScoreResult {
        private final LeaderboardScoreEntity YS;

        LoadPlayerScoreResultImpl(DataHolder scoreHolder) {
            super(scoreHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(scoreHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.YS = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.YS = null;
                }
                leaderboardScoreBuffer.release();
            } catch (Throwable th) {
                leaderboardScoreBuffer.release();
            }
        }

        public LeaderboardScore getScore() {
            return this.YS;
        }
    }

    private static final class LoadPlayersResultImpl extends C0801b implements LoadPlayersResult {
        private final PlayerBuffer YT;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.YT = new PlayerBuffer(dataHolder);
        }

        public PlayerBuffer getPlayers() {
            return this.YT;
        }
    }

    private static final class LoadProfileSettingsResultImpl extends C0801b implements LoadProfileSettingsResult {
        private final boolean YU;
        private final boolean Yh;

        LoadProfileSettingsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                if (dataHolder.getCount() > 0) {
                    int au = dataHolder.au(0);
                    this.Yh = dataHolder.m2494d("profile_visible", 0, au);
                    this.YU = dataHolder.m2494d("profile_visibility_explicitly_set", 0, au);
                } else {
                    this.Yh = true;
                    this.YU = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.Eb;
        }

        public boolean isProfileVisible() {
            return this.Yh;
        }

        public boolean isVisibilityExplicitlySet() {
            return this.YU;
        }
    }

    private static final class LoadQuestsResultImpl extends C0801b implements LoadQuestsResult {
        private final DataHolder JG;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.JG = dataHolder;
        }

        public QuestBuffer getQuests() {
            return new QuestBuffer(this.JG);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends C0801b implements LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadRequestsResultImpl implements LoadRequestsResult {
        private final Status Eb;
        private final Bundle YV;

        LoadRequestsResultImpl(Status status, Bundle requestData) {
            this.Eb = status;
            this.YV = requestData;
        }

        public GameRequestBuffer getRequests(int requestType) {
            String dZ = RequestType.dZ(requestType);
            return !this.YV.containsKey(dZ) ? null : new GameRequestBuffer((DataHolder) this.YV.get(dZ));
        }

        public Status getStatus() {
            return this.Eb;
        }

        public void release() {
            for (String parcelable : this.YV.keySet()) {
                DataHolder dataHolder = (DataHolder) this.YV.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadScoresResultImpl extends C0801b implements LoadScoresResult {
        private final LeaderboardEntity YW;
        private final LeaderboardScoreBuffer YX;

        LoadScoresResultImpl(DataHolder leaderboard, DataHolder scores) {
            super(scores);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(leaderboard);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.YW = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.YW = null;
                }
                leaderboardBuffer.release();
                this.YX = new LeaderboardScoreBuffer(scores);
            } catch (Throwable th) {
                leaderboardBuffer.release();
            }
        }

        public Leaderboard getLeaderboard() {
            return this.YW;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.YX;
        }
    }

    private static final class LoadSnapshotsResultImpl extends C0801b implements LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.JG);
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements LoadXpForGameCategoriesResult {
        private final Status Eb;
        private final List<String> YY;
        private final Bundle YZ;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle xpData) {
            this.Eb = status;
            this.YY = xpData.getStringArrayList("game_category_list");
            this.YZ = xpData;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class LoadXpStreamResultImpl extends C0801b implements LoadXpStreamResult {
        private final ExperienceEventBuffer Za;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.Za = new ExperienceEventBuffer(dataHolder);
        }
    }

    private static final class OpenSnapshotResultImpl extends C0801b implements OpenSnapshotResult {
        private final Snapshot Zf;
        private final String Zg;
        private final Snapshot Zh;
        private final Contents Zi;
        private final SnapshotContents Zj;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents currentContents) {
            this(dataHolder, null, currentContents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder metadataHolder, String conflictId, Contents currentContents, Contents conflictContents, Contents resolutionContents) {
            boolean z = true;
            super(metadataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(metadataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.Zf = null;
                    this.Zh = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    if (metadataHolder.getStatusCode() == 4004) {
                        z = false;
                    }
                    je.m1495K(z);
                    this.Zf = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.Zh = null;
                } else {
                    this.Zf = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.Zh = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(conflictContents));
                }
                snapshotMetadataBuffer.release();
                this.Zg = conflictId;
                this.Zi = resolutionContents;
                this.Zj = new SnapshotContentsEntity(resolutionContents);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public String getConflictId() {
            return this.Zg;
        }

        public Snapshot getConflictingSnapshot() {
            return this.Zh;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.Zj;
        }

        public Snapshot getSnapshot() {
            return this.Zf;
        }
    }

    private static final class SendRequestResultImpl extends C0801b implements SendRequestResult {
        private final GameRequest Zs;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.Zs = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.Zs = null;
                }
                gameRequestBuffer.release();
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class SubmitScoreResultImpl extends C0801b implements SubmitScoreResult {
        private final ScoreSubmissionData ZE;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.ZE = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public ScoreSubmissionData getScoreData() {
            return this.ZE;
        }
    }

    private static abstract class TurnBasedMatchResult extends C0801b {
        final TurnBasedMatch Zc;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.Zc = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.Zc = null;
                }
                turnBasedMatchBuffer.release();
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.Zc;
        }
    }

    private static final class UpdateAchievementResultImpl implements UpdateAchievementResult {
        private final Status Eb;
        private final String Xx;

        UpdateAchievementResultImpl(int statusCode, String achievementId) {
            this.Eb = new Status(statusCode);
            this.Xx = achievementId;
        }

        public String getAchievementId() {
            return this.Xx;
        }

        public Status getStatus() {
            return this.Eb;
        }
    }

    private static final class UpdateRequestsResultImpl extends C0801b implements UpdateRequestsResult {
        private final RequestUpdateOutcomes ZL;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.ZL = RequestUpdateOutcomes.m954W(dataHolder);
        }

        public Set<String> getRequestIds() {
            return this.ZL.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.ZL.getRequestOutcome(requestId);
        }
    }

    private static abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier {
        private final ArrayList<String> Yv = new ArrayList();

        AbstractPeerStatusNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder);
            for (Object add : participantIds) {
                this.Yv.add(add);
            }
        }

        /* renamed from: a */
        protected void mo3689a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            mo3708a(roomStatusUpdateListener, room, this.Yv);
        }

        /* renamed from: a */
        protected abstract void mo3708a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<UpdateAchievementResult> Ea;

        AchievementUpdatedBinderCallback(C0155b<UpdateAchievementResult> resultHolder) {
            this.Ea = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: g */
        public void mo1215g(int i, String str) {
            this.Ea.mo908b(new UpdateAchievementResultImpl(i, str));
        }
    }

    private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LoadAchievementsResult> Ea;

        AchievementsLoadedBinderCallback(C0155b<LoadAchievementsResult> resultHolder) {
            this.Ea = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: c */
        public void mo1199c(DataHolder dataHolder) {
            this.Ea.mo908b(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<LoadAppContentResult> Yx;

        public AppContentLoadedBinderCallbacks(C0155b<LoadAppContentResult> resultHolder) {
            this.Yx = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: a */
        public void mo1194a(DataHolder[] dataHolderArr) {
            this.Yx.mo908b(new LoadAppContentsResultImpl(dataHolderArr));
        }
    }

    private static final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier {
        ConnectedToRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* renamed from: a */
        public void mo3689a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<ContactSettingLoadResult> Ea;

        ContactSettingsLoadedBinderCallback(C0155b<ContactSettingLoadResult> holder) {
            this.Ea = (C0155b) jx.m1578b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: D */
        public void mo1175D(DataHolder dataHolder) {
            this.Ea.mo908b(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<Status> Ea;

        ContactSettingsUpdatedBinderCallback(C0155b<Status> holder) {
            this.Ea = (C0155b) jx.m1578b((Object) holder, (Object) "Holder must not be null");
        }

        public void dP(int i) {
            this.Ea.mo908b(new Status(i));
        }
    }

    private static final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier {
        DisconnectedFromRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* renamed from: a */
        public void mo3689a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LoadEventsResult> Ea;

        EventsLoadedBinderCallback(C0155b<LoadEventsResult> resultHolder) {
            this.Ea = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: d */
        public void mo1202d(DataHolder dataHolder) {
            this.Ea.mo908b(new LoadEventResultImpl(dataHolder));
        }
    }

    private static final class ExtendedGamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LoadExtendedGamesResult> Ea;

        ExtendedGamesLoadedBinderCallback(C0155b<LoadExtendedGamesResult> holder) {
            this.Ea = (C0155b) jx.m1578b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: j */
        public void mo1221j(DataHolder dataHolder) {
            this.Ea.mo908b(new LoadExtendedGamesResultImpl(dataHolder));
        }
    }

    private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LoadGameInstancesResult> Ea;

        GameInstancesLoadedBinderCallback(C0155b<LoadGameInstancesResult> holder) {
            this.Ea = (C0155b) jx.m1578b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: k */
        public void mo1222k(DataHolder dataHolder) {
            this.Ea.mo908b(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<GameMuteStatusChangeResult> Ea;

        GameMuteStatusChangedBinderCallback(C0155b<GameMuteStatusChangeResult> holder) {
            this.Ea = (C0155b) jx.m1578b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: a */
        public void mo1189a(int i, String str, boolean z) {
            this.Ea.mo908b(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<GameMuteStatusLoadResult> Ea;

        GameMuteStatusLoadedBinderCallback(C0155b<GameMuteStatusLoadResult> holder) {
            this.Ea = (C0155b) jx.m1578b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: B */
        public void mo1173B(DataHolder dataHolder) {
            this.Ea.mo908b(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LoadGameSearchSuggestionsResult> Ea;

        GameSearchSuggestionsLoadedBinderCallback(C0155b<LoadGameSearchSuggestionsResult> holder) {
            this.Ea = (C0155b) jx.m1578b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: l */
        public void mo1223l(DataHolder dataHolder) {
            this.Ea.mo908b(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LoadGamesResult> Ea;

        GamesLoadedBinderCallback(C0155b<LoadGamesResult> holder) {
            this.Ea = (C0155b) jx.m1578b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: i */
        public void mo1220i(DataHolder dataHolder) {
            this.Ea.mo908b(new LoadGamesResultImpl(dataHolder));
        }
    }

    private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<InboxCountResult> Ea;

        InboxCountsLoadedBinderCallback(C0155b<InboxCountResult> holder) {
            this.Ea = (C0155b) jx.m1578b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: f */
        public void mo1210f(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Ea.mo908b(new InboxCountResultImpl(new Status(i), bundle));
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        private final C0163d<OnInvitationReceivedListener> Qe;

        InvitationReceivedBinderCallback(C0163d<OnInvitationReceivedListener> listener) {
            this.Qe = listener;
        }

        /* renamed from: n */
        public void mo1225n(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.release();
                if (invitation != null) {
                    this.Qe.m161a(new InvitationReceivedNotifier(invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.release();
            }
        }

        public void onInvitationRemoved(String invitationId) {
            this.Qe.m161a(new InvitationRemovedNotifier(invitationId));
        }
    }

    private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LoadInvitationsResult> Ea;

        InvitationsLoadedBinderCallback(C0155b<LoadInvitationsResult> resultHolder) {
            this.Ea = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: m */
        public void mo1224m(DataHolder dataHolder) {
            this.Ea.mo908b(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private static final class JoinedRoomNotifier extends AbstractRoomNotifier {
        public JoinedRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* renamed from: a */
        public void mo3690a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LoadScoresResult> Ea;

        LeaderboardScoresLoadedBinderCallback(C0155b<LoadScoresResult> resultHolder) {
            this.Ea = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: a */
        public void mo1190a(DataHolder dataHolder, DataHolder dataHolder2) {
            this.Ea.mo908b(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LeaderboardMetadataResult> Ea;

        LeaderboardsLoadedBinderCallback(C0155b<LeaderboardMetadataResult> resultHolder) {
            this.Ea = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: e */
        public void mo1208e(DataHolder dataHolder) {
            this.Ea.mo908b(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        private final C0163d<OnTurnBasedMatchUpdateReceivedListener> Qe;

        MatchUpdateReceivedBinderCallback(C0163d<OnTurnBasedMatchUpdateReceivedListener> listener) {
            this.Qe = listener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            this.Qe.m161a(new MatchRemovedNotifier(matchId));
        }

        /* renamed from: t */
        public void mo1238t(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.release();
                if (turnBasedMatch != null) {
                    this.Qe.m161a(new MatchUpdateReceivedNotifier(turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }
    }

    private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LoadAclResult> Ea;

        NotifyAclLoadedBinderCallback(C0155b<LoadAclResult> resultHolder) {
            this.Ea = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: C */
        public void mo1174C(DataHolder dataHolder) {
            this.Ea.mo908b(new LoadAclResultImpl(dataHolder));
        }
    }

    private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<Status> Ea;

        NotifyAclUpdatedBinderCallback(C0155b<Status> resultHolder) {
            this.Ea = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void dO(int i) {
            this.Ea.mo908b(new Status(i));
        }
    }

    private static final class OwnerCoverPhotoUrisLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LoadOwnerCoverPhotoUrisResult> Ea;

        OwnerCoverPhotoUrisLoadedBinderCallback(C0155b<LoadOwnerCoverPhotoUrisResult> holder) {
            this.Ea = (C0155b) jx.m1578b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: d */
        public void mo1201d(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Ea.mo908b(new LoadOwnerCoverPhotoUrisResultImpl(i, bundle));
        }
    }

    private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LoadPlayerScoreResult> Ea;

        PlayerLeaderboardScoreLoadedBinderCallback(C0155b<LoadPlayerScoreResult> resultHolder) {
            this.Ea = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: E */
        public void mo1176E(DataHolder dataHolder) {
            this.Ea.mo908b(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LoadXpForGameCategoriesResult> Ea;

        PlayerXpForGameCategoriesLoadedBinderCallback(C0155b<LoadXpForGameCategoriesResult> holder) {
            this.Ea = (C0155b) jx.m1578b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: e */
        public void mo1207e(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Ea.mo908b(new LoadXpForGameCategoriesResultImpl(new Status(i), bundle));
        }
    }

    static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LoadXpStreamResult> Ea;

        PlayerXpStreamLoadedBinderCallback(C0155b<LoadXpStreamResult> holder) {
            this.Ea = (C0155b) jx.m1578b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: P */
        public void mo1187P(DataHolder dataHolder) {
            this.Ea.mo908b(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LoadPlayersResult> Ea;

        PlayersLoadedBinderCallback(C0155b<LoadPlayersResult> holder) {
            this.Ea = (C0155b) jx.m1578b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: g */
        public void mo1216g(DataHolder dataHolder) {
            this.Ea.mo908b(new LoadPlayersResultImpl(dataHolder));
        }

        /* renamed from: h */
        public void mo1218h(DataHolder dataHolder) {
            this.Ea.mo908b(new LoadPlayersResultImpl(dataHolder));
        }
    }

    static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<LoadProfileSettingsResult> Ea;

        ProfileSettingsLoadedBinderCallback(C0155b<LoadProfileSettingsResult> holder) {
            this.Ea = (C0155b) jx.m1578b((Object) holder, (Object) "Holder must not be null");
        }

        /* renamed from: Q */
        public void mo1188Q(DataHolder dataHolder) {
            this.Ea.mo908b(new LoadProfileSettingsResultImpl(dataHolder));
        }
    }

    private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final C0155b<Status> Ea;

        ProfileSettingsUpdatedBinderCallback(C0155b<Status> holder) {
            this.Ea = (C0155b) jx.m1578b((Object) holder, (Object) "Holder must not be null");
        }

        public void dQ(int i) {
            this.Ea.mo908b(new Status(i));
        }
    }

    private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<AcceptQuestResult> Zl;

        public QuestAcceptedBinderCallbacks(C0155b<AcceptQuestResult> resultHolder) {
            this.Zl = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: L */
        public void mo1183L(DataHolder dataHolder) {
            this.Zl.mo908b(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<ClaimMilestoneResult> Zm;
        private final String Zn;

        public QuestMilestoneClaimBinderCallbacks(C0155b<ClaimMilestoneResult> resultHolder, String milestoneId) {
            this.Zm = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
            this.Zn = (String) jx.m1578b((Object) milestoneId, (Object) "MilestoneId must not be null");
        }

        /* renamed from: K */
        public void mo1182K(DataHolder dataHolder) {
            this.Zm.mo908b(new ClaimMilestoneResultImpl(dataHolder, this.Zn));
        }
    }

    private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        private final C0163d<QuestUpdateListener> Qe;

        QuestUpdateBinderCallback(C0163d<QuestUpdateListener> listener) {
            this.Qe = listener;
        }

        /* renamed from: T */
        private Quest m4843T(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            Quest quest = null;
            try {
                if (questBuffer.getCount() > 0) {
                    quest = (Quest) ((Quest) questBuffer.get(0)).freeze();
                }
                questBuffer.release();
                return quest;
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        /* renamed from: M */
        public void mo1184M(DataHolder dataHolder) {
            Quest T = m4843T(dataHolder);
            if (T != null) {
                this.Qe.m161a(new QuestCompletedNotifier(T));
            }
        }
    }

    private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<LoadQuestsResult> Zo;

        public QuestsLoadedBinderCallbacks(C0155b<LoadQuestsResult> resultHolder) {
            this.Zo = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: O */
        public void mo1186O(DataHolder dataHolder) {
            this.Zo.mo908b(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final C0163d<ReliableMessageSentCallback> Zr;

        public RealTimeReliableMessageBinderCallbacks(C0163d<ReliableMessageSentCallback> messageSentCallbacks) {
            this.Zr = messageSentCallbacks;
        }

        /* renamed from: b */
        public void mo1195b(int i, int i2, String str) {
            if (this.Zr != null) {
                this.Zr.m161a(new RealTimeMessageSentNotifier(i, i2, str));
            }
        }
    }

    private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        private final C0163d<OnRequestReceivedListener> Qe;

        RequestReceivedBinderCallback(C0163d<OnRequestReceivedListener> listener) {
            this.Qe = listener;
        }

        /* renamed from: o */
        public void mo1226o(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.release();
                if (gameRequest != null) {
                    this.Qe.m161a(new RequestReceivedNotifier(gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }

        public void onRequestRemoved(String requestId) {
            this.Qe.m161a(new RequestRemovedNotifier(requestId));
        }
    }

    private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<SendRequestResult> Zu;

        public RequestSentBinderCallbacks(C0155b<SendRequestResult> resultHolder) {
            this.Zu = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: G */
        public void mo1178G(DataHolder dataHolder) {
            this.Zu.mo908b(new SendRequestResultImpl(dataHolder));
        }
    }

    private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<LoadRequestSummariesResult> Zv;

        public RequestSummariesLoadedBinderCallbacks(C0155b<LoadRequestSummariesResult> resultHolder) {
            this.Zv = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: H */
        public void mo1179H(DataHolder dataHolder) {
            this.Zv.mo908b(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<LoadRequestsResult> Zw;

        public RequestsLoadedBinderCallbacks(C0155b<LoadRequestsResult> resultHolder) {
            this.Zw = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: c */
        public void mo1198c(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Zw.mo908b(new LoadRequestsResultImpl(new Status(i), bundle));
        }
    }

    private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<UpdateRequestsResult> Zx;

        public RequestsUpdatedBinderCallbacks(C0155b<UpdateRequestsResult> resultHolder) {
            this.Zx = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: F */
        public void mo1177F(DataHolder dataHolder) {
            this.Zx.mo908b(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private static final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier {
        RoomAutoMatchingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* renamed from: a */
        public void mo3689a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private static final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        private final C0163d<RealTimeMessageReceivedListener> ZA;
        private final C0163d<? extends RoomUpdateListener> Zy;
        private final C0163d<? extends RoomStatusUpdateListener> Zz;

        public RoomBinderCallbacks(C0163d<RoomUpdateListener> roomCallbacks) {
            this.Zy = (C0163d) jx.m1578b((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.Zz = null;
            this.ZA = null;
        }

        public RoomBinderCallbacks(C0163d<? extends RoomUpdateListener> roomCallbacks, C0163d<? extends RoomStatusUpdateListener> roomStatusCallbacks, C0163d<RealTimeMessageReceivedListener> realTimeMessageReceivedCallbacks) {
            this.Zy = (C0163d) jx.m1578b((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.Zz = roomStatusCallbacks;
            this.ZA = realTimeMessageReceivedCallbacks;
        }

        /* renamed from: A */
        public void mo1172A(DataHolder dataHolder) {
            if (this.Zz != null) {
                this.Zz.m161a(new DisconnectedFromRoomNotifier(dataHolder));
            }
        }

        /* renamed from: a */
        public void mo1193a(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.m161a(new PeerInvitedToRoomNotifier(dataHolder, strArr));
            }
        }

        /* renamed from: b */
        public void mo1197b(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.m161a(new PeerJoinedRoomNotifier(dataHolder, strArr));
            }
        }

        /* renamed from: c */
        public void mo1200c(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.m161a(new PeerLeftRoomNotifier(dataHolder, strArr));
            }
        }

        /* renamed from: d */
        public void mo1203d(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.m161a(new PeerDeclinedNotifier(dataHolder, strArr));
            }
        }

        /* renamed from: e */
        public void mo1209e(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.m161a(new PeerConnectedNotifier(dataHolder, strArr));
            }
        }

        /* renamed from: f */
        public void mo1213f(DataHolder dataHolder, String[] strArr) {
            if (this.Zz != null) {
                this.Zz.m161a(new PeerDisconnectedNotifier(dataHolder, strArr));
            }
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.Zy.m161a(new LeftRoomNotifier(statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            if (this.Zz != null) {
                this.Zz.m161a(new P2PConnectedNotifier(participantId));
            }
        }

        public void onP2PDisconnected(String participantId) {
            if (this.Zz != null) {
                this.Zz.m161a(new P2PDisconnectedNotifier(participantId));
            }
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            if (this.ZA != null) {
                this.ZA.m161a(new MessageReceivedNotifier(message));
            }
        }

        /* renamed from: u */
        public void mo1239u(DataHolder dataHolder) {
            this.Zy.m161a(new RoomCreatedNotifier(dataHolder));
        }

        /* renamed from: v */
        public void mo1240v(DataHolder dataHolder) {
            this.Zy.m161a(new JoinedRoomNotifier(dataHolder));
        }

        /* renamed from: w */
        public void mo1241w(DataHolder dataHolder) {
            if (this.Zz != null) {
                this.Zz.m161a(new RoomConnectingNotifier(dataHolder));
            }
        }

        /* renamed from: x */
        public void mo1242x(DataHolder dataHolder) {
            if (this.Zz != null) {
                this.Zz.m161a(new RoomAutoMatchingNotifier(dataHolder));
            }
        }

        /* renamed from: y */
        public void mo1243y(DataHolder dataHolder) {
            this.Zy.m161a(new RoomConnectedNotifier(dataHolder));
        }

        /* renamed from: z */
        public void mo1244z(DataHolder dataHolder) {
            if (this.Zz != null) {
                this.Zz.m161a(new ConnectedToRoomNotifier(dataHolder));
            }
        }
    }

    private static final class RoomConnectedNotifier extends AbstractRoomNotifier {
        RoomConnectedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* renamed from: a */
        public void mo3690a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private static final class RoomConnectingNotifier extends AbstractRoomStatusNotifier {
        RoomConnectingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* renamed from: a */
        public void mo3689a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private static final class RoomCreatedNotifier extends AbstractRoomNotifier {
        public RoomCreatedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* renamed from: a */
        public void mo3690a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<Status> Ea;

        public SignOutCompleteBinderCallbacks(C0155b<Status> resultHolder) {
            this.Ea = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void fK() {
            this.Ea.mo908b(new Status(0));
        }
    }

    private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<CommitSnapshotResult> ZB;

        public SnapshotCommittedBinderCallbacks(C0155b<CommitSnapshotResult> resultHolder) {
            this.ZB = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: J */
        public void mo1181J(DataHolder dataHolder) {
            this.ZB.mo908b(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<DeleteSnapshotResult> Ea;

        public SnapshotDeletedBinderCallbacks(C0155b<DeleteSnapshotResult> resultHolder) {
            this.Ea = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: i */
        public void mo1219i(int i, String str) {
            this.Ea.mo908b(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<OpenSnapshotResult> ZC;

        public SnapshotOpenedBinderCallbacks(C0155b<OpenSnapshotResult> resultHolder) {
            this.ZC = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: a */
        public void mo1191a(DataHolder dataHolder, Contents contents) {
            this.ZC.mo908b(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        /* renamed from: a */
        public void mo1192a(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.ZC.mo908b(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<LoadSnapshotsResult> ZD;

        public SnapshotsLoadedBinderCallbacks(C0155b<LoadSnapshotsResult> resultHolder) {
            this.ZD = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: I */
        public void mo1180I(DataHolder dataHolder) {
            this.ZD.mo908b(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<SubmitScoreResult> Ea;

        public SubmitScoreBinderCallbacks(C0155b<SubmitScoreResult> resultHolder) {
            this.Ea = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: f */
        public void mo1212f(DataHolder dataHolder) {
            this.Ea.mo908b(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<CancelMatchResult> ZF;

        public TurnBasedMatchCanceledBinderCallbacks(C0155b<CancelMatchResult> resultHolder) {
            this.ZF = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: h */
        public void mo1217h(int i, String str) {
            this.ZF.mo908b(new CancelMatchResultImpl(new Status(i), str));
        }
    }

    private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<InitiateMatchResult> ZG;

        public TurnBasedMatchInitiatedBinderCallbacks(C0155b<InitiateMatchResult> resultHolder) {
            this.ZG = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: q */
        public void mo1235q(DataHolder dataHolder) {
            this.ZG.mo908b(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<LeaveMatchResult> ZH;

        public TurnBasedMatchLeftBinderCallbacks(C0155b<LeaveMatchResult> resultHolder) {
            this.ZH = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: s */
        public void mo1237s(DataHolder dataHolder) {
            this.ZH.mo908b(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<LoadMatchResult> ZI;

        public TurnBasedMatchLoadedBinderCallbacks(C0155b<LoadMatchResult> resultHolder) {
            this.ZI = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: p */
        public void mo1234p(DataHolder dataHolder) {
            this.ZI.mo908b(new LoadMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<UpdateMatchResult> ZJ;

        public TurnBasedMatchUpdatedBinderCallbacks(C0155b<UpdateMatchResult> resultHolder) {
            this.ZJ = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: r */
        public void mo1236r(DataHolder dataHolder) {
            this.ZJ.mo908b(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final C0155b<LoadMatchesResult> ZK;

        public TurnBasedMatchesLoadedBinderCallbacks(C0155b<LoadMatchesResult> resultHolder) {
            this.ZK = (C0155b) jx.m1578b((Object) resultHolder, (Object) "Holder must not be null");
        }

        /* renamed from: b */
        public void mo1196b(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.ZK.mo908b(new LoadMatchesResultImpl(new Status(i), bundle));
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class PeerConnectedNotifier extends AbstractPeerStatusNotifier {
        PeerConnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        /* renamed from: a */
        protected void mo3708a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private static final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier {
        PeerDeclinedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        /* renamed from: a */
        protected void mo3708a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private static final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier {
        PeerDisconnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        /* renamed from: a */
        protected void mo3708a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private static final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier {
        PeerInvitedToRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        /* renamed from: a */
        protected void mo3708a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private static final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier {
        PeerJoinedRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        /* renamed from: a */
        protected void mo3708a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private static final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier {
        PeerLeftRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        /* renamed from: a */
        protected void mo3708a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    public GamesClientImpl(Context context, Looper looper, String gamePackageName, String accountName, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener, String[] scopes, int gravity, View gamesContentView, GamesOptions options) {
        super(context, looper, connectedListener, connectionFailedListener, scopes);
        this.Yl = gamePackageName;
        this.DZ = (String) jx.m1582i(accountName);
        this.Yr = new Binder();
        this.Ym = new HashMap();
        this.Yp = PopupManager.m942a(this, gravity);
        m4220k(gamesContentView);
        this.Ys = (long) hashCode();
        this.Yt = options;
        registerConnectionCallbacks((ConnectionCallbacks) this);
        registerConnectionFailedListener((OnConnectionFailedListener) this);
    }

    /* renamed from: R */
    private static Room m4113R(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            roomBuffer.release();
            return room;
        } catch (Throwable th) {
            roomBuffer.release();
        }
    }

    private RealTimeSocket bB(String str) {
        RealTimeSocket bD = ll.ii() ? bD(str) : bC(str);
        if (bD != null) {
            this.Ym.put(str, bD);
        }
        return bD;
    }

    private RealTimeSocket bC(String str) {
        try {
            String bH = ((IGamesService) hw()).bH(str);
            if (bH == null) {
                return null;
            }
            LocalSocket localSocket = new LocalSocket();
            localSocket.connect(new LocalSocketAddress(bH));
            return new RealTimeSocketImpl(localSocket, str);
        } catch (RemoteException e) {
            GamesLog.m685p("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        } catch (IOException e2) {
            GamesLog.m685p("GamesClientImpl", "connect() call failed on socket: " + e2.getMessage());
            return null;
        }
    }

    private RealTimeSocket bD(String str) {
        try {
            ParcelFileDescriptor bN = ((IGamesService) hw()).bN(str);
            if (bN != null) {
                GamesLog.m683n("GamesClientImpl", "Created native libjingle socket.");
                return new LibjingleNativeSocket(bN);
            }
            GamesLog.m685p("GamesClientImpl", "Unable to create socket for " + str);
            return null;
        } catch (RemoteException e) {
            GamesLog.m685p("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        }
    }

    private void lD() {
        for (RealTimeSocket close : this.Ym.values()) {
            try {
                close.close();
            } catch (Throwable e) {
                GamesLog.m682c("GamesClientImpl", "IOException:", e);
            }
        }
        this.Ym.clear();
    }

    private void lg() {
        this.Yn = null;
    }

    /* renamed from: a */
    public int m4115a(C0163d<ReliableMessageSentCallback> c0163d, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) hw()).mo1248a(new RealTimeReliableMessageBinderCallbacks(c0163d), bArr, str, str2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: a */
    public int m4116a(byte[] bArr, String str, String[] strArr) {
        jx.m1578b((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) hw()).mo1309b(bArr, str, strArr);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: a */
    public Intent m4117a(int i, int i2, boolean z) {
        try {
            return ((IGamesService) hw()).mo1249a(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: a */
    public Intent m4118a(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent a = ((IGamesService) hw()).mo1250a(i, bArr, i2, str);
            jx.m1578b((Object) bitmap, (Object) "Must provide a non null icon");
            a.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return a;
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: a */
    public Intent m4119a(Room room, int i) {
        try {
            return ((IGamesService) hw()).mo1254a((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: a */
    public Intent m4120a(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) hw()).mo1255a(str, z, z2, i);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: a */
    protected void mo2968a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            this.Yq = bundle.getBoolean("show_welcome_popup");
        }
        super.mo2968a(i, iBinder, bundle);
    }

    /* renamed from: a */
    public void m4122a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) hw()).mo1259a(iBinder, bundle);
            } catch (RemoteException e) {
                GamesLog.m684o("GamesClientImpl", "service died");
            }
        }
    }

    /* renamed from: a */
    public void m4123a(C0155b<LoadRequestsResult> c0155b, int i, int i2, int i3) {
        try {
            ((IGamesService) hw()).mo1263a(new RequestsLoadedBinderCallbacks(c0155b), i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4124a(C0155b<LoadExtendedGamesResult> c0155b, int i, int i2, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).mo1264a(new ExtendedGamesLoadedBinderCallback(c0155b), i, i2, z, z2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4125a(C0155b<LoadAppContentResult> c0155b, int i, String str, String[] strArr, boolean z) {
        try {
            ((IGamesService) hw()).mo1266a(new AppContentLoadedBinderCallbacks(c0155b), i, str, strArr, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4126a(C0155b<LoadPlayersResult> c0155b, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).mo1267a(new PlayersLoadedBinderCallback(c0155b), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4127a(C0155b<LoadMatchesResult> c0155b, int i, int[] iArr) {
        try {
            ((IGamesService) hw()).mo1268a(new TurnBasedMatchesLoadedBinderCallbacks(c0155b), i, iArr);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4128a(C0155b<LoadScoresResult> c0155b, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        try {
            ((IGamesService) hw()).mo1271a(new LeaderboardScoresLoadedBinderCallback(c0155b), leaderboardScoreBuffer.mH().mI(), i, i2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4129a(C0155b<InitiateMatchResult> c0155b, TurnBasedMatchConfig turnBasedMatchConfig) {
        try {
            ((IGamesService) hw()).mo1265a(new TurnBasedMatchInitiatedBinderCallbacks(c0155b), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.mO(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4130a(C0155b<CommitSnapshotResult> c0155b, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        jx.m1576a(!snapshotContents.isClosed(), "Snapshot already closed");
        C0810a mT = snapshotMetadataChange.mT();
        if (mT != null) {
            mT.m2501a(getContext().getCacheDir());
        }
        Contents ir = snapshotContents.ir();
        snapshotContents.close();
        try {
            ((IGamesService) hw()).mo1285a(new SnapshotCommittedBinderCallbacks(c0155b), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, ir);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4131a(C0155b<UpdateAchievementResult> c0155b, String str) {
        if (c0155b == null) {
            IGamesCallbacks iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(c0155b);
        }
        try {
            ((IGamesService) hw()).mo1284a(iGamesCallbacks, str, this.Yp.lV(), this.Yp.lU());
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4132a(C0155b<UpdateAchievementResult> c0155b, String str, int i) {
        try {
            ((IGamesService) hw()).mo1277a(c0155b == null ? null : new AchievementUpdatedBinderCallback(c0155b), str, i, this.Yp.lV(), this.Yp.lU());
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4133a(C0155b<LoadScoresResult> c0155b, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) hw()).mo1276a(new LeaderboardScoresLoadedBinderCallback(c0155b), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4134a(C0155b<LoadPlayersResult> c0155b, String str, int i, boolean z, boolean z2) {
        Object obj = -1;
        switch (str.hashCode()) {
            case 156408498:
                if (str.equals("played_with")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                try {
                    ((IGamesService) hw()).mo1361d(new PlayersLoadedBinderCallback(c0155b), str, i, z, z2);
                    return;
                } catch (RemoteException e) {
                    GamesLog.m684o("GamesClientImpl", "service died");
                    return;
                }
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    /* renamed from: a */
    public void m4135a(C0155b<LoadExtendedGamesResult> c0155b, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        try {
            ((IGamesService) hw()).mo1280a(new ExtendedGamesLoadedBinderCallback(c0155b), str, i, z, z2, z3, z4);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4136a(C0155b<LoadMatchesResult> c0155b, String str, int i, int[] iArr) {
        try {
            ((IGamesService) hw()).mo1281a(new TurnBasedMatchesLoadedBinderCallbacks(c0155b), str, i, iArr);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4137a(C0155b<SubmitScoreResult> c0155b, String str, long j, String str2) {
        try {
            ((IGamesService) hw()).mo1283a(c0155b == null ? null : new SubmitScoreBinderCallbacks(c0155b), str, j, str2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4138a(C0155b<LeaveMatchResult> c0155b, String str, String str2) {
        try {
            ((IGamesService) hw()).mo1349c(new TurnBasedMatchLeftBinderCallbacks(c0155b), str, str2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4139a(C0155b<LoadPlayerScoreResult> c0155b, String str, String str2, int i, int i2) {
        try {
            ((IGamesService) hw()).mo1287a(new PlayerLeaderboardScoreLoadedBinderCallback(c0155b), str, str2, i, i2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4140a(C0155b<LoadRequestsResult> c0155b, String str, String str2, int i, int i2, int i3) {
        try {
            ((IGamesService) hw()).mo1288a(new RequestsLoadedBinderCallbacks(c0155b), str, str2, i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4141a(C0155b<LoadScoresResult> c0155b, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) hw()).mo1289a(new LeaderboardScoresLoadedBinderCallback(c0155b), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4142a(C0155b<LoadPlayersResult> c0155b, String str, String str2, int i, boolean z, boolean z2) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1049482625:
                if (str.equals("nearby")) {
                    obj = 2;
                    break;
                }
                break;
            case 156408498:
                if (str.equals("played_with")) {
                    obj = 1;
                    break;
                }
                break;
            case 782949780:
                if (str.equals("circled")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
            case 2:
                try {
                    ((IGamesService) hw()).mo1290a(new PlayersLoadedBinderCallback(c0155b), str, str2, i, z, z2);
                    return;
                } catch (RemoteException e) {
                    GamesLog.m684o("GamesClientImpl", "service died");
                    return;
                }
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    /* renamed from: a */
    public void m4143a(C0155b<OpenSnapshotResult> c0155b, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        jx.m1576a(!snapshotContents.isClosed(), "SnapshotContents already closed");
        C0810a mT = snapshotMetadataChange.mT();
        if (mT != null) {
            mT.m2501a(getContext().getCacheDir());
        }
        Contents ir = snapshotContents.ir();
        snapshotContents.close();
        try {
            ((IGamesService) hw()).mo1291a(new SnapshotOpenedBinderCallbacks(c0155b), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, ir);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4144a(C0155b<LeaderboardMetadataResult> c0155b, String str, String str2, boolean z) {
        try {
            ((IGamesService) hw()).mo1327b(new LeaderboardsLoadedBinderCallback(c0155b), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4145a(C0155b<LoadQuestsResult> c0155b, String str, String str2, boolean z, String[] strArr) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).mo1295a(new QuestsLoadedBinderCallbacks(c0155b), str, str2, strArr, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4146a(C0155b<LoadQuestsResult> c0155b, String str, String str2, int[] iArr, int i, boolean z) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).mo1293a(new QuestsLoadedBinderCallbacks(c0155b), str, str2, iArr, i, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4147a(C0155b<UpdateRequestsResult> c0155b, String str, String str2, String[] strArr) {
        try {
            ((IGamesService) hw()).mo1294a(new RequestsUpdatedBinderCallbacks(c0155b), str, str2, strArr);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4148a(C0155b<LoadPlayersResult> c0155b, String str, boolean z) {
        try {
            ((IGamesService) hw()).mo1377f(new PlayersLoadedBinderCallback(c0155b), str, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4149a(C0155b<UpdateMatchResult> c0155b, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) hw()).mo1297a(new TurnBasedMatchUpdatedBinderCallbacks(c0155b), str, bArr, str2, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4150a(C0155b<UpdateMatchResult> c0155b, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) hw()).mo1298a(new TurnBasedMatchUpdatedBinderCallbacks(c0155b), str, bArr, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4151a(C0155b<SendRequestResult> c0155b, String str, String[] strArr, int i, byte[] bArr, int i2) {
        try {
            ((IGamesService) hw()).mo1300a(new RequestSentBinderCallbacks(c0155b), str, strArr, i, bArr, i2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4152a(C0155b<LoadPlayersResult> c0155b, boolean z) {
        try {
            ((IGamesService) hw()).mo1352c(new PlayersLoadedBinderCallback(c0155b), z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4153a(C0155b<Status> c0155b, boolean z, Bundle bundle) {
        try {
            ((IGamesService) hw()).mo1302a(new ContactSettingsUpdatedBinderCallback(c0155b), z, bundle);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4154a(C0155b<LoadEventsResult> c0155b, boolean z, String... strArr) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).mo1303a(new EventsLoadedBinderCallback(c0155b), z, strArr);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4155a(C0155b<LoadQuestsResult> c0155b, int[] iArr, int i, boolean z) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).mo1305a(new QuestsLoadedBinderCallbacks(c0155b), iArr, i, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4156a(C0155b<LoadPlayersResult> c0155b, String[] strArr) {
        try {
            ((IGamesService) hw()).mo1353c(new PlayersLoadedBinderCallback(c0155b), strArr);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4157a(C0163d<OnInvitationReceivedListener> c0163d) {
        try {
            ((IGamesService) hw()).mo1269a(new InvitationReceivedBinderCallback(c0163d), this.Ys);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4158a(C0163d<RoomUpdateListener> c0163d, C0163d<RoomStatusUpdateListener> c0163d2, C0163d<RealTimeMessageReceivedListener> c0163d3, RoomConfig roomConfig) {
        lD();
        try {
            ((IGamesService) hw()).mo1272a(new RoomBinderCallbacks(c0163d, c0163d2, c0163d3), this.Yr, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), roomConfig.isSocketEnabled(), this.Ys);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4159a(C0163d<RoomUpdateListener> c0163d, String str) {
        try {
            ((IGamesService) hw()).mo1346c(new RoomBinderCallbacks(c0163d), str);
            lD();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void m4160a(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        jx.m1576a(!snapshotContents.isClosed(), "Snapshot already closed");
        Contents ir = snapshotContents.ir();
        snapshotContents.close();
        try {
            ((IGamesService) hw()).mo1260a(ir);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    protected void mo2969a(jt jtVar, C1399e c1399e) throws RemoteException {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.Yt.Xa);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.Yt.Xb);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.Yt.Xc);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.Yt.Xd);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.Yt.Xe);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.Yt.Xf);
        bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.Yt.Xg);
        jtVar.mo1871a(c1399e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.DZ, hv(), this.Yl, this.Yp.lV(), locale, bundle);
    }

    protected IGamesService aC(IBinder iBinder) {
        return Stub.aE(iBinder);
    }

    /* renamed from: b */
    public Intent m4162b(int i, int i2, boolean z) {
        try {
            return ((IGamesService) hw()).mo1310b(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: b */
    public Intent m4163b(int[] iArr) {
        try {
            return ((IGamesService) hw()).mo1311b(iArr);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: b */
    public void m4164b(C0155b<Status> c0155b) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).mo1261a(new SignOutCompleteBinderCallbacks(c0155b));
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m4165b(C0155b<LoadPlayersResult> c0155b, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).mo1314b(new PlayersLoadedBinderCallback(c0155b), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m4166b(C0155b<UpdateAchievementResult> c0155b, String str) {
        if (c0155b == null) {
            IGamesCallbacks iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(c0155b);
        }
        try {
            ((IGamesService) hw()).mo1323b(iGamesCallbacks, str, this.Yp.lV(), this.Yp.lU());
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m4167b(C0155b<UpdateAchievementResult> c0155b, String str, int i) {
        try {
            ((IGamesService) hw()).mo1320b(c0155b == null ? null : new AchievementUpdatedBinderCallback(c0155b), str, i, this.Yp.lV(), this.Yp.lU());
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m4168b(C0155b<LoadScoresResult> c0155b, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) hw()).mo1319b(new LeaderboardScoresLoadedBinderCallback(c0155b), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m4169b(C0155b<LoadExtendedGamesResult> c0155b, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).mo1279a(new ExtendedGamesLoadedBinderCallback(c0155b), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m4170b(C0155b<ClaimMilestoneResult> c0155b, String str, String str2) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).mo1376f(new QuestMilestoneClaimBinderCallbacks(c0155b, str2), str, str2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m4171b(C0155b<LoadScoresResult> c0155b, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) hw()).mo1325b(new LeaderboardScoresLoadedBinderCallback(c0155b), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m4172b(C0155b<LoadPlayersResult> c0155b, String str, String str2, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).mo1326b(new PlayersLoadedBinderCallback(c0155b), str, str2, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m4173b(C0155b<LoadAchievementsResult> c0155b, String str, String str2, boolean z) {
        try {
            ((IGamesService) hw()).mo1292a(new AchievementsLoadedBinderCallback(c0155b), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m4174b(C0155b<LeaderboardMetadataResult> c0155b, String str, boolean z) {
        try {
            ((IGamesService) hw()).mo1351c(new LeaderboardsLoadedBinderCallback(c0155b), str, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m4175b(C0155b<LeaderboardMetadataResult> c0155b, boolean z) {
        try {
            ((IGamesService) hw()).mo1329b(new LeaderboardsLoadedBinderCallback(c0155b), z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m4176b(C0155b<LoadQuestsResult> c0155b, boolean z, String[] strArr) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).mo1307a(new QuestsLoadedBinderCallbacks(c0155b), strArr, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m4177b(C0155b<UpdateRequestsResult> c0155b, String[] strArr) {
        try {
            ((IGamesService) hw()).mo1306a(new RequestsUpdatedBinderCallbacks(c0155b), strArr);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m4178b(C0163d<OnTurnBasedMatchUpdateReceivedListener> c0163d) {
        try {
            ((IGamesService) hw()).mo1315b(new MatchUpdateReceivedBinderCallback(c0163d), this.Ys);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void m4179b(C0163d<RoomUpdateListener> c0163d, C0163d<RoomStatusUpdateListener> c0163d2, C0163d<RealTimeMessageReceivedListener> c0163d3, RoomConfig roomConfig) {
        lD();
        try {
            ((IGamesService) hw()).mo1273a(new RoomBinderCallbacks(c0163d, c0163d2, c0163d3), this.Yr, roomConfig.getInvitationId(), roomConfig.isSocketEnabled(), this.Ys);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    public void bA(String str) {
        try {
            ((IGamesService) hw()).bL(str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    public Intent bE(String str) {
        try {
            return ((IGamesService) hw()).bE(str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    public void bF(String str) {
        try {
            ((IGamesService) hw()).mo1308a(str, this.Yp.lV(), this.Yp.lU());
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    protected String bK() {
        return "com.google.android.gms.games.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    /* renamed from: c */
    public void m4180c(C0155b<LoadInvitationsResult> c0155b, int i) {
        try {
            ((IGamesService) hw()).mo1262a(new InvitationsLoadedBinderCallback(c0155b), i);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m4181c(C0155b<LoadPlayersResult> c0155b, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).mo1343c(new PlayersLoadedBinderCallback(c0155b), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m4182c(C0155b<InitiateMatchResult> c0155b, String str) {
        try {
            ((IGamesService) hw()).mo1392l(new TurnBasedMatchInitiatedBinderCallbacks(c0155b), str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m4183c(C0155b<LoadXpStreamResult> c0155b, String str, int i) {
        try {
            ((IGamesService) hw()).mo1318b(new PlayerXpStreamLoadedBinderCallback(c0155b), str, i);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m4184c(C0155b<LoadExtendedGamesResult> c0155b, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).mo1369e(new ExtendedGamesLoadedBinderCallback(c0155b), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m4185c(C0155b<InitiateMatchResult> c0155b, String str, String str2) {
        try {
            ((IGamesService) hw()).mo1362d(new TurnBasedMatchInitiatedBinderCallbacks(c0155b), str, str2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m4186c(C0155b<LoadSnapshotsResult> c0155b, String str, String str2, boolean z) {
        try {
            ((IGamesService) hw()).mo1350c(new SnapshotsLoadedBinderCallbacks(c0155b), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m4187c(C0155b<OpenSnapshotResult> c0155b, String str, boolean z) {
        try {
            ((IGamesService) hw()).mo1371e(new SnapshotOpenedBinderCallbacks(c0155b), str, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m4188c(C0155b<LoadAchievementsResult> c0155b, boolean z) {
        try {
            ((IGamesService) hw()).mo1301a(new AchievementsLoadedBinderCallback(c0155b), z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m4189c(C0155b<UpdateRequestsResult> c0155b, String[] strArr) {
        try {
            ((IGamesService) hw()).mo1330b(new RequestsUpdatedBinderCallbacks(c0155b), strArr);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void m4190c(C0163d<QuestUpdateListener> c0163d) {
        try {
            ((IGamesService) hw()).mo1358d(new QuestUpdateBinderCallback(c0163d), this.Ys);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    protected void mo3132c(String... strArr) {
        int i = 0;
        boolean z = false;
        for (String str : strArr) {
            if (str.equals(Scopes.GAMES)) {
                z = true;
            } else if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
                i = 1;
            }
        }
        if (i != 0) {
            jx.m1577a(!z, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
            return;
        }
        jx.m1577a(z, "Games APIs requires %s to function.", Scopes.GAMES);
    }

    public void connect() {
        lg();
        super.connect();
    }

    /* renamed from: d */
    public int m4192d(byte[] bArr, String str) {
        try {
            return ((IGamesService) hw()).mo1309b(bArr, str, null);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: d */
    public void m4193d(C0155b<LoadPlayersResult> c0155b, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).mo1367e(new PlayersLoadedBinderCallback(c0155b), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void m4194d(C0155b<InitiateMatchResult> c0155b, String str) {
        try {
            ((IGamesService) hw()).mo1417m(new TurnBasedMatchInitiatedBinderCallbacks(c0155b), str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void m4195d(C0155b<LoadXpStreamResult> c0155b, String str, int i) {
        try {
            ((IGamesService) hw()).mo1347c(new PlayerXpStreamLoadedBinderCallback(c0155b), str, i);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void m4196d(C0155b<LoadExtendedGamesResult> c0155b, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).mo1375f(new ExtendedGamesLoadedBinderCallback(c0155b), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void m4197d(C0155b<InitiateMatchResult> c0155b, String str, String str2) {
        try {
            ((IGamesService) hw()).mo1370e(new TurnBasedMatchInitiatedBinderCallbacks(c0155b), str, str2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void m4198d(C0155b<LeaderboardMetadataResult> c0155b, String str, boolean z) {
        try {
            ((IGamesService) hw()).mo1363d(new LeaderboardsLoadedBinderCallback(c0155b), str, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void m4199d(C0155b<LoadEventsResult> c0155b, boolean z) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).mo1378f(new EventsLoadedBinderCallback(c0155b), z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: d */
    public void m4200d(C0163d<OnRequestReceivedListener> c0163d) {
        try {
            ((IGamesService) hw()).mo1344c(new RequestReceivedBinderCallback(c0163d), this.Ys);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    public void dS(int i) {
        this.Yp.setGravity(i);
    }

    public void dT(int i) {
        try {
            ((IGamesService) hw()).dT(i);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    public void disconnect() {
        this.Yq = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) hw();
                iGamesService.lE();
                this.Yk.flush();
                iGamesService.mo1423q(this.Ys);
            } catch (RemoteException e) {
                GamesLog.m684o("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        lD();
        super.disconnect();
    }

    /* renamed from: e */
    public void m4201e(C0155b<LeaveMatchResult> c0155b, String str) {
        try {
            ((IGamesService) hw()).mo1419o(new TurnBasedMatchLeftBinderCallbacks(c0155b), str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: e */
    public void m4202e(C0155b<LoadInvitationsResult> c0155b, String str, int i) {
        try {
            ((IGamesService) hw()).mo1321b(new InvitationsLoadedBinderCallback(c0155b), str, i, false);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: e */
    public void m4203e(C0155b<LoadExtendedGamesResult> c0155b, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).mo1348c(new ExtendedGamesLoadedBinderCallback(c0155b), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: e */
    public void m4204e(C0155b<GameMuteStatusChangeResult> c0155b, String str, boolean z) {
        try {
            ((IGamesService) hw()).mo1296a(new GameMuteStatusChangedBinderCallback(c0155b), str, z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: e */
    public void m4205e(C0155b<LoadSnapshotsResult> c0155b, boolean z) {
        try {
            ((IGamesService) hw()).mo1364d(new SnapshotsLoadedBinderCallbacks(c0155b), z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: f */
    public void m4206f(C0155b<LoadGamesResult> c0155b) {
        try {
            ((IGamesService) hw()).mo1356d(new GamesLoadedBinderCallback(c0155b));
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: f */
    public void m4207f(C0155b<CancelMatchResult> c0155b, String str) {
        try {
            ((IGamesService) hw()).mo1418n(new TurnBasedMatchCanceledBinderCallbacks(c0155b), str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: f */
    public void m4208f(C0155b<LoadRequestSummariesResult> c0155b, String str, int i) {
        try {
            ((IGamesService) hw()).mo1275a(new RequestSummariesLoadedBinderCallbacks(c0155b), str, i);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: f */
    public void m4209f(C0155b<LoadPlayersResult> c0155b, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) hw()).mo1322b(new PlayersLoadedBinderCallback(c0155b), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: f */
    public void m4210f(C0155b<LoadProfileSettingsResult> c0155b, boolean z) {
        try {
            ((IGamesService) hw()).mo1382g(new ProfileSettingsLoadedBinderCallback(c0155b), z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    public Bundle fX() {
        try {
            Bundle fX = ((IGamesService) hw()).fX();
            if (fX == null) {
                return fX;
            }
            fX.setClassLoader(GamesClientImpl.class.getClassLoader());
            return fX;
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: g */
    public void m4211g(C0155b<LoadOwnerCoverPhotoUrisResult> c0155b) {
        try {
            ((IGamesService) hw()).mo1389j(new OwnerCoverPhotoUrisLoadedBinderCallback(c0155b));
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: g */
    public void m4212g(C0155b<LoadMatchResult> c0155b, String str) {
        try {
            ((IGamesService) hw()).mo1421p(new TurnBasedMatchLoadedBinderCallbacks(c0155b), str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: g */
    public void m4213g(C0155b<Status> c0155b, boolean z) {
        try {
            ((IGamesService) hw()).mo1386h(new ProfileSettingsUpdatedBinderCallback(c0155b), z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: h */
    public void m4214h(C0155b<LoadAclResult> c0155b) {
        try {
            ((IGamesService) hw()).mo1385h(new NotifyAclLoadedBinderCallback(c0155b));
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: h */
    public void m4215h(C0155b<AcceptQuestResult> c0155b, String str) {
        try {
            this.Yk.flush();
            ((IGamesService) hw()).mo1437u(new QuestAcceptedBinderCallbacks(c0155b), str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: h */
    public void m4216h(C0155b<ContactSettingLoadResult> c0155b, boolean z) {
        try {
            ((IGamesService) hw()).mo1372e(new ContactSettingsLoadedBinderCallback(c0155b), z);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: i */
    public void m4217i(C0155b<InboxCountResult> c0155b) {
        try {
            ((IGamesService) hw()).mo1432t(new InboxCountsLoadedBinderCallback(c0155b), null);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: i */
    public void m4218i(C0155b<DeleteSnapshotResult> c0155b, String str) {
        try {
            ((IGamesService) hw()).mo1427r(new SnapshotDeletedBinderCallbacks(c0155b), str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: j */
    public void m4219j(C0155b<LoadExtendedGamesResult> c0155b, String str) {
        try {
            ((IGamesService) hw()).mo1368e(new ExtendedGamesLoadedBinderCallback(c0155b), str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: k */
    public void m4220k(View view) {
        this.Yp.mo1503l(view);
    }

    /* renamed from: k */
    public void m4221k(C0155b<LoadGameInstancesResult> c0155b, String str) {
        try {
            ((IGamesService) hw()).mo1374f(new GameInstancesLoadedBinderCallback(c0155b), str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: l */
    protected /* synthetic */ IInterface mo2972l(IBinder iBinder) {
        return aC(iBinder);
    }

    /* renamed from: l */
    public void m4223l(C0155b<LoadGameSearchSuggestionsResult> c0155b, String str) {
        try {
            ((IGamesService) hw()).mo1424q(new GameSearchSuggestionsLoadedBinderCallback(c0155b), str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    public int lA() {
        try {
            return ((IGamesService) hw()).lA();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int lB() {
        try {
            return ((IGamesService) hw()).lB();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int lC() {
        try {
            return ((IGamesService) hw()).lC();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void lE() {
        if (isConnected()) {
            try {
                ((IGamesService) hw()).lE();
            } catch (RemoteException e) {
                GamesLog.m684o("GamesClientImpl", "service died");
            }
        }
    }

    public String lh() {
        try {
            return ((IGamesService) hw()).lh();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    public String li() {
        try {
            return ((IGamesService) hw()).li();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    public Player lj() {
        dS();
        synchronized (this) {
            if (this.Yn == null) {
                PlayerBuffer playerBuffer;
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) hw()).lG());
                    if (playerBuffer.getCount() > 0) {
                        this.Yn = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.release();
                } catch (RemoteException e) {
                    GamesLog.m684o("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    playerBuffer.release();
                }
            }
        }
        return this.Yn;
    }

    public Game lk() {
        GameBuffer gameBuffer;
        dS();
        synchronized (this) {
            if (this.Yo == null) {
                try {
                    gameBuffer = new GameBuffer(((IGamesService) hw()).lI());
                    if (gameBuffer.getCount() > 0) {
                        this.Yo = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.release();
                } catch (RemoteException e) {
                    GamesLog.m684o("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    gameBuffer.release();
                }
            }
        }
        return this.Yo;
    }

    public Intent ll() {
        try {
            return ((IGamesService) hw()).ll();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent lm() {
        try {
            return ((IGamesService) hw()).lm();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent ln() {
        try {
            return ((IGamesService) hw()).ln();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent lo() {
        try {
            return ((IGamesService) hw()).lo();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    public void lp() {
        try {
            ((IGamesService) hw()).mo1426r(this.Ys);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    public void lq() {
        try {
            ((IGamesService) hw()).mo1428s(this.Ys);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    public void lr() {
        try {
            ((IGamesService) hw()).mo1436u(this.Ys);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    public void ls() {
        try {
            ((IGamesService) hw()).mo1431t(this.Ys);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    public Intent lt() {
        try {
            return ((IGamesService) hw()).lt();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent lu() {
        try {
            return ((IGamesService) hw()).lu();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    public int lv() {
        try {
            return ((IGamesService) hw()).lv();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return 4368;
        }
    }

    public String lw() {
        try {
            return ((IGamesService) hw()).lw();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    public int lx() {
        try {
            return ((IGamesService) hw()).lx();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return -1;
        }
    }

    public Intent ly() {
        try {
            return ((IGamesService) hw()).ly();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    public int lz() {
        try {
            return ((IGamesService) hw()).lz();
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: m */
    public void m4224m(C0155b<LoadXpForGameCategoriesResult> c0155b, String str) {
        try {
            ((IGamesService) hw()).mo1429s(new PlayerXpForGameCategoriesLoadedBinderCallback(c0155b), str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: n */
    public Intent m4225n(String str, int i) {
        try {
            return ((IGamesService) hw()).mo1435u(str, i);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: n */
    public void m4226n(C0155b<LoadInvitationsResult> c0155b, String str) {
        try {
            ((IGamesService) hw()).mo1391k(new InvitationsLoadedBinderCallback(c0155b), str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: o */
    public void m4227o(C0155b<Status> c0155b, String str) {
        try {
            ((IGamesService) hw()).mo1390j(new NotifyAclUpdatedBinderCallback(c0155b), str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: o */
    public void m4228o(String str, int i) {
        this.Yk.m947o(str, i);
    }

    public void onConnected(Bundle connectionHint) {
        if (this.Yq) {
            this.Yp.lT();
            this.Yq = false;
        }
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.Yq = false;
    }

    public void onConnectionSuspended(int cause) {
    }

    /* renamed from: p */
    public void m4229p(C0155b<GameMuteStatusLoadResult> c0155b, String str) {
        try {
            ((IGamesService) hw()).mo1388i(new GameMuteStatusLoadedBinderCallback(c0155b), str);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: p */
    public void m4230p(String str, int i) {
        try {
            ((IGamesService) hw()).mo1422p(str, i);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: q */
    public void m4231q(String str, int i) {
        try {
            ((IGamesService) hw()).mo1425q(str, i);
        } catch (RemoteException e) {
            GamesLog.m684o("GamesClientImpl", "service died");
        }
    }

    /* renamed from: s */
    public RealTimeSocket m4232s(String str, String str2) {
        if (str2 == null || !ParticipantUtils.bY(str2)) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        RealTimeSocket realTimeSocket = (RealTimeSocket) this.Ym.get(str2);
        return (realTimeSocket == null || realTimeSocket.isClosed()) ? bB(str2) : realTimeSocket;
    }
}
