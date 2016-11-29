package com.example.simpleadaptertest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.SimpleAdapter;

public class MainActivity extends ListActivity {

	String[] names=new String[]{"明天会更好","浅川","萍水相逢"};
	String[] infos=new String[]{"个性签名：磨剑！","个性签名：拼搏！","个性签名：求其上者得其中，求其中者得其下。"};
	int[] imageids=new int[]{R.drawable.a,R.drawable.b,R.drawable.c};
	List<Map<String,Object>>listItems=new ArrayList<Map<String,Object>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		for(int i = 0;i<names.length;i++){
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("img", imageids[i]);
			map.put("title", names[i]);
			map.put("info",infos[i]);
			listItems.add(map);
		}
		
		SimpleAdapter simpleAdapter=new SimpleAdapter(this, listItems, R.layout.activity_main, 
				new String[]{"img","title","info"}, new int[]{R.id.img,R.id.title,R.id.info});
		setListAdapter(simpleAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
