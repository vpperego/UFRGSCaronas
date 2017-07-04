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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
        TextView traveTime = (TextView) customView.findViewById(R.id.travelTime);

         Ride ridePosition = getItem(position);

        Log.d(TAG,"D Name: "+ ridePosition.getDriver().getName());
        Log.d(TAG,"C Name: "+ ridePosition.getDriver().getVehicle().getName());
        Log.d(TAG,"C Color: "+ ridePosition.getDriver().getVehicle().getColor());

        GregorianCalendar gc = new GregorianCalendar();

        gc.setTime(ridePosition.getDate());
        riderName.setText(ridePosition.getDriver().getName());
        carName.setText(ridePosition.getDriver().getVehicle().getName());
        carColor.setText(ridePosition.getDriver().getVehicle().getColor());

        String minutes = null;

        if(gc.get(GregorianCalendar.MINUTE) < 10)
            minutes = "0" + String.valueOf(gc.get(GregorianCalendar.MINUTE) ) ;
        else
            minutes = String.valueOf(gc.get(GregorianCalendar.MINUTE) );

        traveTime.setText(String.valueOf(gc.get(GregorianCalendar.HOUR_OF_DAY)) + ":"
                + minutes);

         return customView;
    }
}
