package util;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.ufrgscaronas.R;

import java.util.ArrayList;

import model.Ride;

import static android.content.ContentValues.TAG;

/**
 * Created by user on 6/4/2017.
 */

public class RideAdapterItem extends ArrayAdapter<Ride> {
    private Context context;
    private ArrayList<Ride> rideList;
    public RideAdapterItem(Context context, ArrayList<Ride> objects) {
        super(context, R.layout.show_rides_item, objects);
        this.context = context;
        this.rideList = objects;
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

            //this.rideList.get(position);

        LayoutInflater rideInflater = LayoutInflater.from(getContext());
        View customView= rideInflater.inflate(R.layout.show_rides_item,parent,false);

        //      ImageView imageView = (ImageView) convertView.findViewById(R.id.userImage);
 //       imageView.setImageResource(R.mipmap.ic_launcher);

        TextView riderName = (TextView) customView.findViewById(R.id.riderName);
        TextView carName = (TextView) customView.findViewById(R.id.carName);
        TextView carColor = (TextView) customView.findViewById(R.id.carColor);
        ImageView driverImg = (ImageView) customView.findViewById(R.id.driverImg) ;
        Ride ridePosition = getItem(position);

        Log.d(TAG,"D Name: "+ ridePosition.getDriver().getName());
        Log.d(TAG,"C Name: "+ ridePosition.getDriver().getVehicle().getName());
        Log.d(TAG,"C Color: "+ ridePosition.getDriver().getVehicle().getColor());

        riderName.setText(ridePosition.getDriver().getName());
        carName.setText(ridePosition.getDriver().getVehicle().getName());
        carColor.setText(ridePosition.getDriver().getVehicle().getColor());
        driverImg.setImageResource(R.drawable.robot);
        return customView;
    }
}
