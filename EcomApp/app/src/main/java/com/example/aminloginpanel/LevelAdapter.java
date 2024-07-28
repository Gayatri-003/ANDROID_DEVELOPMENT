package com.example.aminloginpanel;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LevelAdapter extends ArrayAdapter<String> {
	private final Activity context;
	private final String[] name;
	private final String[] address;
	private final String[] contact;
	private final String[] email;
	private final String[] password;
	public LevelAdapter(Activity context, String[] name, String[] address, String[]  contact,String[] email,String[] password) {
		super(context,R.layout.levellist,name);
		
		// TODO Auto-generated constructor stub
		
		this.context=context;
		this.name=name;
		this.address=address;
		this.contact=contact;
		this.email= email;
		this.password=password;
	}
	public View getView(int position,View view,ViewGroup parent) {
		LayoutInflater inflater=context.getLayoutInflater();
		View rowView=inflater.inflate(R.layout.levellist, null,true);
		
		TextView nametxt = (TextView) rowView.findViewById(R.id.person_name);
		TextView addrtxt = (TextView) rowView.findViewById(R.id.address);
		TextView contacttxt=(TextView)rowView.findViewById(R.id.contact);
		TextView emailtxt = (TextView) rowView.findViewById(R.id.email);
		TextView pwtxt = (TextView) rowView.findViewById(R.id.password);
		nametxt.setText(name[position]);
		addrtxt.setText(address[position]);
		contacttxt.setText(contact[position]);
		emailtxt.setText(email[position]);
		pwtxt.setText((password[position]));

		return rowView;
		
	};
}
