package com.example.sailsandroid;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.util.Log;
import android.widget.Toast;

public class JSInterface {
	
	public Context context;
	public GPSTracker gps;
	
	public JSInterface(Context c) {
		this.context=c;
		this.gps=new GPSTracker(c);
	}
	
	public void notification(){
		
		String message= "Notification";
		//Toast.makeText(this.context, message, Toast.LENGTH_LONG).show();
		long when = System.currentTimeMillis();
		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new Notification(R.drawable.ic_launcher,message, when);
		notification.defaults |= Notification.DEFAULT_SOUND;
		notification.defaults |= Notification.DEFAULT_VIBRATE;
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		String title = context.getString(R.string.app_name);
		Intent notificationIntent = new Intent(context,MainActivity.class);
		// set intent so it does not start a new activity
		notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_SINGLE_TOP);
		PendingIntent intent = PendingIntent.getActivity(context, 0,notificationIntent, 0);
		notification.setLatestEventInfo(context, title, message, intent);
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notificationManager.notify(0, notification);
	}
	public void toast(){
		Toast.makeText(this.context, "Toast", Toast.LENGTH_LONG).show();
	}
	public void getGps(){
		double lat,lon;
		lat=gps.getLatitude();
		lon=gps.getLongitude();
		if(gps.canGetLocation()){
			AlertDialog alertDialog = new AlertDialog.Builder(this.context).create();
				alertDialog.setTitle("GPS Coordinates");
				alertDialog.setMessage("Latitute : " + lat + "\n Longitude : "+ lon);
				alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
						}
						});
				alertDialog.setIcon(R.drawable.ic_launcher);
				alertDialog.show();
		}else{
			Toast.makeText(this.context, "You must turn on GPS", Toast.LENGTH_LONG).show();
			gps.showSettingsAlert();
		}
	}
	public void runCamera(){
		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		this.context.startActivity(intent);
	}

}
