package io.trigger.forge.android.modules.contextmenufix;
/*
Copyright 2012 Fetchnotes,Inc.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
  */


import com.google.gson.JsonArray;

import io.trigger.forge.android.core.ForgeApp;
import io.trigger.forge.android.core.ForgeParam;
import io.trigger.forge.android.core.ForgeTask;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;

public class API {
	
	private static String[] toJavaArray(JsonArray array) {
		String[] toRet = new String[array.size()];
		for(int i = 0; i < toRet.length; i++)
			toRet[i] = array.get(i).getAsString();
		return toRet;
	}
			
	private static int getCompatibleTheme(){
		if(android.os.Build.VERSION.SDK_INT >= 11){
			return android.R.style.Theme_Holo_Light;
		}else{
			return ForgeApp.getActivity().getApplicationInfo().theme;
		}
	}
	
	private static AlertDialog.Builder getBuilder() {
		return new AlertDialog.Builder(
				new ContextThemeWrapper(ForgeApp.getActivity(), getCompatibleTheme()));
	}
	public static void show(final ForgeTask task, @ForgeParam("title") final String title,
			@ForgeParam("items") final JsonArray JSONItems) {
		final AlertDialog.Builder builder = getBuilder();
		final String[] items = toJavaArray(JSONItems);
		
		if (title != null) builder.setTitle(title);
		builder.setItems(items, new OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				task.success(items[which]);
			}
		});
		
		ForgeApp.getActivity().runOnUiThread( new Runnable () {
			@Override
			public void run() {
				AlertDialog toShow = builder.create();
				toShow.show();
			}
		}
		);
	}
	
}
