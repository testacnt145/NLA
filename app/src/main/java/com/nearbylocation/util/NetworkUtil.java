package com.nearbylocation.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;
import com.nearbylocation.App;
import com.nearbylocation.R;

public class NetworkUtil {

	public static Boolean checkInternet() {
    	ConnectivityManager cm = (ConnectivityManager) App.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
	}

	public static void internetNotAvailableDialog(Context _ctx) {
		new AlertDialog.Builder(_ctx)
				.setTitle(R.string.network_connectivity_error)
			.setMessage(R.string.network_not_available)
			.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
				}
			})
			.show();
	}

	public static void internetNotAvailableToast() {
		Toast.makeText(App.applicationContext, R.string.network_not_available, Toast.LENGTH_SHORT).show();
	}

	public static void noResponseToast() {
		Toast.makeText(App.applicationContext, R.string.no_response_from_server, Toast.LENGTH_SHORT).show();
	}

}
