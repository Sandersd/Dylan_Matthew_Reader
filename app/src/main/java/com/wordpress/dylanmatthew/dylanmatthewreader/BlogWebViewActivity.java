package com.wordpress.dylanmatthew.dylanmatthewreader;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class BlogWebViewActivity extends ActionBarActivity {

    //Member variable that will hold Url
    protected String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_web_view);

        //Getting the Data passed from Intent
        Intent intent = getIntent();
        Uri blogUri = intent.getData();

        //Setting up Web View
        WebView webView = (WebView) findViewById(R.id.webView);

        //Loading Url from Intent in Web View
        mUrl = blogUri.toString();
        webView.loadUrl(mUrl);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_blog_web_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //Checks to see if Share button is pressed
        if (id == R.id.action_share) {

            sharePost();

            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    //Method to Share Url with Chooser
    private void sharePost() {

        Intent shareIntent = new Intent(Intent.ACTION_SEND);

        //Set type to plain text
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, mUrl);

        //Creates Chooser
        startActivity(Intent.createChooser(shareIntent, "How do you want to share?"));
    }
}
