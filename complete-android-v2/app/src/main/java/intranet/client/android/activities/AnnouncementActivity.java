package intranet.client.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import intranet.client.R;
import intranet.client.android.asynctasks.RetrieveAnnouncementTask;
import intranet.client.android.delegates.RetrieveAnnouncementDelegate;
import intranet.client.network.model.Announcement;

public class AnnouncementActivity extends AppCompatActivity implements RetrieveAnnouncementDelegate {

    private TextView tvTitle;
    private WebView wvBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        wvBody = (WebView) findViewById(R.id.wvBody);

        Intent intent = getIntent();
        final Long announcementId = intent.getLongExtra(MainActivity.EXTRA_ID, 0L);
        new RetrieveAnnouncementTask(this).execute(announcementId);
    }

    private void populateUiWithTitleAndBody(final String title, final String body) {
        tvTitle.setText(title);
        final String mime = "text/html";
        final String encoding = "utf-8";
        wvBody.loadDataWithBaseURL(null, body, mime, encoding, null);
    }

    @Override
    public void onAnnouncementFetched(Announcement announcement) {
        populateUiWithTitleAndBody(announcement.getTitle(), announcement.getBody());
    }
}
