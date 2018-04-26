package com.smartglass.swe.videocapture_test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.hardware.Camera;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.VideoView;

import net.majorkernelpanic.streaming.Session;
import net.majorkernelpanic.streaming.SessionBuilder;
import net.majorkernelpanic.streaming.audio.AudioQuality;
import net.majorkernelpanic.streaming.rtsp.RtspServer;
import net.majorkernelpanic.streaming.video.VideoQuality;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback, RtspServer.CallbackListener, Session.Callback {

//    Camera camera;
//    FrameLayout frameLayout;
//    ShowCamera showCamera;

    SurfaceView mSw;
    Session mSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

//        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        this.mSw = (SurfaceView) findViewById(R.id.surfaceView_main);

        //Preferences
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
        editor.putString(RtspServer.KEY_PORT, String.valueOf(1234));
        editor.commit();

        mSession =  SessionBuilder.getInstance()
                .setCallback(this)
                .setSurfaceView((net.majorkernelpanic.streaming.gl.SurfaceView) mSw)
                .setPreviewOrientation(90)
                .setContext(getApplicationContext())
                .setAudioEncoder(SessionBuilder.AUDIO_AAC)
                .setAudioQuality(new AudioQuality(8000, 16000))
                .setVideoEncoder(SessionBuilder.VIDEO_H264)
                .setVideoQuality(new VideoQuality(320,240,25,500000))
                .build();

        mSw.getHolder().addCallback(this);

        ((net.majorkernelpanic.streaming.gl.SurfaceView) mSw).setAspectRatioMode(net.majorkernelpanic.streaming.gl.SurfaceView.ASPECT_RATIO_PREVIEW);
        String ip, port, path;

        // Starts the RTSP server
        this.startService(new Intent(this,RtspServer.class));

        Log.d("test", "1");



        mSession.startPreview(); //camera preview on phone surface
        mSession.start();

//        // Open the camera on start
//        camera = Camera.open();
//        showCamera = new ShowCamera(this, camera);
//        frameLayout.addView(showCamera);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSession.release();
        mSw.getHolder().removeCallback(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSession.stopPreview();
    }

//    implementations

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void onBitrateUpdate(long bitrate) {

    }

    @Override
    public void onSessionError(int reason, int streamType, Exception e) {

    }

    @Override
    public void onPreviewStarted() {

    }

    @Override
    public void onSessionConfigured() {

    }

    @Override
    public void onSessionStarted() {

    }

    @Override
    public void onSessionStopped() {

    }

    @Override
    public void onError(RtspServer server, Exception e, int error) {
        Log.e("Server", e.toString());
    }

    @Override
    public void onMessage(RtspServer server, int message) {
        Log.e("Server", "unkown message");
    }
}
