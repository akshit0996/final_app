package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompatBase.Action;
import android.support.v4.app.NotificationCompatBase.Action.Factory;
import android.widget.RemoteViews;
import java.util.ArrayList;

class NotificationCompatApi20 {

    public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {
        /* renamed from: b */
        private android.app.Notification.Builder f88b;

        public Builder(Context context, Notification n, CharSequence contentTitle, CharSequence contentText, CharSequence contentInfo, RemoteViews tickerView, int number, PendingIntent contentIntent, PendingIntent fullScreenIntent, Bitmap largeIcon, int mProgressMax, int mProgress, boolean mProgressIndeterminate, boolean useChronometer, int priority, CharSequence subText, boolean localOnly, Bundle extras, String groupKey, boolean groupSummary, String sortKey) {
            boolean z;
            android.app.Notification.Builder lights = new android.app.Notification.Builder(context).setWhen(n.when).setSmallIcon(n.icon, n.iconLevel).setContent(n.contentView).setTicker(n.tickerText, tickerView).setSound(n.sound, n.audioStreamType).setVibrate(n.vibrate).setLights(n.ledARGB, n.ledOnMS, n.ledOffMS);
            if ((n.flags & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            lights = lights.setOngoing(z);
            if ((n.flags & 8) != 0) {
                z = true;
            } else {
                z = false;
            }
            lights = lights.setOnlyAlertOnce(z);
            if ((n.flags & 16) != 0) {
                z = true;
            } else {
                z = false;
            }
            lights = lights.setAutoCancel(z).setDefaults(n.defaults).setContentTitle(contentTitle).setContentText(contentText).setSubText(subText).setContentInfo(contentInfo).setContentIntent(contentIntent).setDeleteIntent(n.deleteIntent);
            if ((n.flags & 128) != 0) {
                z = true;
            } else {
                z = false;
            }
            this.f88b = lights.setFullScreenIntent(fullScreenIntent, z).setLargeIcon(largeIcon).setNumber(number).setUsesChronometer(useChronometer).setPriority(priority).setProgress(mProgressMax, mProgress, mProgressIndeterminate).setLocalOnly(localOnly).setExtras(extras).setGroup(groupKey).setGroupSummary(groupSummary).setSortKey(sortKey);
        }

        public void addAction(Action action) {
            android.app.Notification.Action.Builder actionBuilder = new android.app.Notification.Action.Builder(action.getIcon(), action.getTitle(), action.getActionIntent());
            if (action.getRemoteInputs() != null) {
                for (RemoteInput remoteInput : RemoteInputCompatApi20.fromCompat(action.getRemoteInputs())) {
                    actionBuilder.addRemoteInput(remoteInput);
                }
            }
            if (action.getExtras() != null) {
                actionBuilder.addExtras(action.getExtras());
            }
            this.f88b.addAction(actionBuilder.build());
        }

        public android.app.Notification.Builder getBuilder() {
            return this.f88b;
        }

        public Notification build() {
            return this.f88b.build();
        }
    }

    NotificationCompatApi20() {
    }

    public static Action getAction(Notification notif, int actionIndex, Factory actionFactory, RemoteInputCompatBase.RemoteInput.Factory remoteInputFactory) {
        return getActionCompatFromAction(notif.actions[actionIndex], actionFactory, remoteInputFactory);
    }

    private static Action getActionCompatFromAction(Notification.Action action, Factory actionFactory, RemoteInputCompatBase.RemoteInput.Factory remoteInputFactory) {
        return actionFactory.build(action.icon, action.title, action.actionIntent, action.getExtras(), RemoteInputCompatApi20.toCompat(action.getRemoteInputs(), remoteInputFactory));
    }

    private static Notification.Action getActionFromActionCompat(Action actionCompat) {
        android.app.Notification.Action.Builder actionBuilder = new android.app.Notification.Action.Builder(actionCompat.getIcon(), actionCompat.getTitle(), actionCompat.getActionIntent()).addExtras(actionCompat.getExtras());
        RemoteInputCompatBase.RemoteInput[] remoteInputCompats = actionCompat.getRemoteInputs();
        if (remoteInputCompats != null) {
            for (RemoteInput remoteInput : RemoteInputCompatApi20.fromCompat(remoteInputCompats)) {
                actionBuilder.addRemoteInput(remoteInput);
            }
        }
        return actionBuilder.build();
    }

    public static Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> parcelables, Factory actionFactory, RemoteInputCompatBase.RemoteInput.Factory remoteInputFactory) {
        if (parcelables == null) {
            return null;
        }
        Action[] actions = actionFactory.newArray(parcelables.size());
        for (int i = 0; i < actions.length; i++) {
            actions[i] = getActionCompatFromAction((Notification.Action) parcelables.get(i), actionFactory, remoteInputFactory);
        }
        return actions;
    }

    public static ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actions) {
        if (actions == null) {
            return null;
        }
        ArrayList<Parcelable> parcelables = new ArrayList(actions.length);
        for (Action action : actions) {
            parcelables.add(getActionFromActionCompat(action));
        }
        return parcelables;
    }

    public static boolean getLocalOnly(Notification notif) {
        return (notif.flags & 256) != 0;
    }

    public static String getGroup(Notification notif) {
        return notif.getGroup();
    }

    public static boolean isGroupSummary(Notification notif) {
        return (notif.flags & 512) != 0;
    }

    public static String getSortKey(Notification notif) {
        return notif.getSortKey();
    }
}