package intranet.client.network;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import intranet.client.network.model.Announcement;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AnnouncementFetcher {
    private static final String TAG = AnnouncementFetcher.class.getSimpleName();
    private OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    public Announcement fetchAnnouncement(Long announcementId) {
        try {
            String url = Constants.GRAILS_APP_URL + Constants.ANNOUNCEMENTS_PATH + "/" + announcementId;
            String jsonString = fetchAnnouncementJsonString(url);
            return gson.fromJson(jsonString, Announcement.class);

        } catch (IOException e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    private String fetchAnnouncementJsonString(String url) throws IOException {
        Request request = NetworkTask.requestWithUrl(url);
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
