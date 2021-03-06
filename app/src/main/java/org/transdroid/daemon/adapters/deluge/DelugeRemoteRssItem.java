package org.transdroid.daemon.adapters.deluge;

import android.os.Parcel;
import android.os.Parcelable;

import org.transdroid.core.gui.remoterss.data.RemoteRssItem;

import java.util.Date;

/**
 * Deluge implementation of RemoteRssItem.
 *
 * @author alonalbert
 */
class DelugeRemoteRssItem extends RemoteRssItem {
    public static final Parcelable.Creator<DelugeRemoteRssItem> CREATOR = new Parcelable.Creator<DelugeRemoteRssItem>() {
        public DelugeRemoteRssItem createFromParcel(Parcel in) {
            return new DelugeRemoteRssItem(in);
        }

        public DelugeRemoteRssItem[] newArray(int size) {
            return new DelugeRemoteRssItem[size];
        }
    };

    DelugeRemoteRssItem(String title, String link, String sourceName, Date timestamp) {
        this.title = title;
        this.link = link;
        this.sourceName = sourceName;
        this.timestamp = timestamp;
    }

    private DelugeRemoteRssItem(Parcel in) {
        title = in.readString();
        link = in.readString();
        sourceName = in.readString();
        timestamp = (Date) in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(link);
        dest.writeString(sourceName);
        dest.writeSerializable(timestamp);
    }
}
