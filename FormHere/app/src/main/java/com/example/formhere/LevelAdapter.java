package com.example.formhere;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LevelAdapter extends ArrayAdapter<String> {
	private final Activity context;
	private final String[] bloodgroup;
	private final String[] name;
	private final String[] address;
	private final String[] contact;
	public LevelAdapter(Activity context, String[] bloodgroup, String[] pincode, String[]  contactnumber,String[] mobnum) {
		super(context,R.layout.levellist,bloodgroup);
		
		// TODO Auto-generated constructor stub
		
		this.context=context;
		this.bloodgroup=bloodgroup;
		this.name=pincode;
		this.address=contactnumber;
		this.contact= mobnum;
	}
	public View getView(int position,View view,ViewGroup parent) {
		LayoutInflater inflater=context.getLayoutInflater();
		View rowView=inflater.inflate(R.layout.levellist, null,true);
		
		TextView txtTitle = (TextView) rowView.findViewById(R.id.person_name);
		TextView extratxt = (TextView) rowView.findViewById(R.id.person_status);
		TextView extaddress=(TextView)rowView.findViewById(R.id.address);
		TextView contact1 = (TextView) rowView.findViewById(R.id.contact);
		txtTitle.setText(bloodgroup[position]);
		extratxt.setText(name[position]);
		extaddress.setText(address[position]);
		contact1.setText(contact[position]);

		return rowView;
		
	};
}
