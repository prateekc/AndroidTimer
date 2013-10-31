package com.example.simplelandscapetimer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
//activity_timer_main
public class TimerMainActivity extends Activity implements OnClickListener {
    final TimerStack timerStack=new TimerStack();
	Button bOne,bTwo,bThree,bFour,bFive,bSix,bSeven,bEight,bNine,bZero,bClear;
	Button start, pause, reset;
	ImageView timeOne, timeTwo, timeThree, timeFour;
	boolean timeEditable;
	private Timer timer;
	TimerTask timTsk;
	OnItemClickListener itmClk;
	int currSel=0;
	ArrayList<TimerData> list;
	ListView liv;
	AdapterForThis stabAr;
	int[] imgAddTab={R.drawable.a0,
    R.drawable.a1,
    R.drawable.a2,
    R.drawable.a3,
    R.drawable.a4,
    R.drawable.a5,
    R.drawable.a6,
    R.drawable.a7,
    R.drawable.a8,
    R.drawable.a9
    
    };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer_main);
		timer = new Timer();
		timeOne=(ImageView) findViewById(R.id.imageView1);
		timeTwo=(ImageView) findViewById(R.id.ImageView01);
		timeThree=(ImageView) findViewById(R.id.ImageView02);
		timeFour=(ImageView) findViewById(R.id.ImageView03);
		bOne=(Button) findViewById(R.id.button1);
		bTwo=(Button) findViewById(R.id.button2);
		bThree=(Button) findViewById(R.id.button3);
		bFour=(Button) findViewById(R.id.button4);
		bFive=(Button) findViewById(R.id.button5);
		bSix=(Button) findViewById(R.id.button6);
		bSeven=(Button) findViewById(R.id.button7);
		bEight=(Button) findViewById(R.id.button8);
		bNine=(Button) findViewById(R.id.button9);
		bZero=(Button) findViewById(R.id.button10);
		bClear=(Button) findViewById(R.id.button11);
		start=(Button) findViewById(R.id.buttonGreen);
		pause=(Button) findViewById(R.id.ButtonYellow);
		reset=(Button) findViewById(R.id.ButtonRed);
		bOne.setOnClickListener( this);
		bTwo.setOnClickListener( this);
		bThree.setOnClickListener(this);
		bFour.setOnClickListener(this);
		bFive.setOnClickListener( this);
		bSix.setOnClickListener(this);
		bSeven.setOnClickListener(this);
		bEight.setOnClickListener(this);
		bNine.setOnClickListener(this);
		bZero.setOnClickListener(this);
		bClear.setOnClickListener(this);
		start.setOnClickListener(this);
		pause.setOnClickListener(this);
		reset.setOnClickListener(this);
		//final Button button1=(Button) findViewById(R.id.buttonGreen);
		//	final ImageView imgv1=(ImageView) findViewById(R.id.imageView1);
		//int i=0;
		//final LinearLayout lin=(LinearLayout) findViewById(R.id.linearLay);
		//lin.a
		liv=(ListView) findViewById(R.id.linearLay);
		//liv.a
		list=new ArrayList<TimerData>();
		int[] tempTime=new int[4];
		list.add(new TimerData("a",tempTime));
		tempTime[3]=6;
		list.add(new TimerData("b",tempTime));
		tempTime[3]=3;
		list.add(new TimerData("c",tempTime));
		tempTime[3]=2;
		list.add(new TimerData("d",tempTime));
		tempTime[3]=8;
		list.add(new TimerData("e",tempTime));
		stabAr=new AdapterForThis(this,R.layout.customlistitem , list);
		//android.R.layout.simple_list_item_1
		liv.setAdapter(stabAr);
		itmClk=new OnItemClickListener() {
            
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
				// TODO Auto-generated method stub
				//Object i=liv.getItemAtPosition(arg2);
				//ListView liv1=(ListView) arg0;
				//i.getClass().getName();
				//Toast.makeText(getApplicationContext(), "Clicked item is"+arg3, Toast.LENGTH_LONG).show();
				try{
                    timTsk.cancel();
				} catch(Exception e){
					
				}
				currSel=(int)arg3;
				
				timerStack.setStack(list.get((int)arg3).value);
				bOne.setEnabled(true);
				bTwo.setEnabled(true);
				bThree.setEnabled(true);
				bFour.setEnabled(true);
				bFive.setEnabled(true);
				bSix.setEnabled(true);
				bSeven.setEnabled(true);
				bEight.setEnabled(true);
				bNine.setEnabled(true);
				bZero.setEnabled(true);
				bClear.setEnabled(true);
				
			}
		};
		liv.setOnItemClickListener(itmClk);
        //		button1.setOnClickListener(new OnClickListener() {
        //
        //			@Override
        //			public void onClick(View v) {
        //				//timeStack[1]=1;
        //				Toast toast = Toast.makeText(getApplicationContext(), "here", Toast.LENGTH_SHORT);
        //				toast.show();
        //
        //
        //				// 	imgv1.setImageResource(R.drawable.a1);
        //				timerMgr();
        //				//imgv1.setBackground(createBmp());
        //			}
        //		});
        
        
        
	}
	
	public void timerMgr(){
		ImageView im=(ImageView) findViewById(R.id.ImageView03);
		int[] time=timerStack.timeStack;
		//imgAddTab
        //		timeOne.setImageResource(timeImgSel(time[0]));
        //		timeTwo.setImageResource(timeImgSel(time[1]));
        //		timeThree.setImageResource(timeImgSel(time[2]));
        //		timeFour.setImageResource(timeImgSel(time[3]));
		timeOne.setImageResource(imgAddTab[time[0]]);
		timeTwo.setImageResource(imgAddTab[time[1]]);
		timeThree.setImageResource(imgAddTab[time[2]]);
		timeFour.setImageResource(imgAddTab[time[3]]);
        
	}
	public int timeImgSel(int timeValue){
		switch(timeValue){
            case 1:
                return R.drawable.a1;
            case 2:
                return R.drawable.a2;
            case 3:
                return R.drawable.a3;
            case 4:
                return R.drawable.a4;
            case 5:
                return R.drawable.a5;
            case 6:
                return R.drawable.a6;
            case 7:
                return R.drawable.a7;
            case 8:
                return R.drawable.a8;
            case 9:
                return R.drawable.a9;
            default:
                return R.drawable.a0;
		}
        
        
        
        
	}
	public class AdapterForThis extends ArrayAdapter<TimerData>{
        
		public AdapterForThis(Context context, int resource,
                              List<TimerData> objects) {
			super(context, resource, objects);
			// TODO Auto-generated constructor stub
		}
		
        
        
	}
	public void onClick(View args0){
		if(args0.getId()==R.id.button1){
			timerStack.setNext(1);
			Toast toast = Toast.makeText(getApplicationContext(), timerStack.toString(), Toast.LENGTH_SHORT);
			toast.show();
			timerMgr();
		}
		if(args0.getId()==R.id.button2){
            
			timerStack.setNext(2);
			Toast toast = Toast.makeText(getApplicationContext(), timerStack.toString(), Toast.LENGTH_SHORT);
			toast.show();
			timerMgr();
		}
		if(args0.getId()==R.id.button3){
			timerStack.setNext(3);
			Toast toast = Toast.makeText(getApplicationContext(), timerStack.toString(), Toast.LENGTH_SHORT);
			toast.show();
			timerMgr();
		}
		if(args0.getId()==R.id.button4){
			timerStack.setNext(4);
			Toast toast = Toast.makeText(getApplicationContext(), timerStack.toString(), Toast.LENGTH_SHORT);
			toast.show();
			timerMgr();
		}
		if(args0.getId()==R.id.button5){
			timerStack.setNext(5);
			Toast toast = Toast.makeText(getApplicationContext(), timerStack.toString(), Toast.LENGTH_SHORT);
			toast.show();
			timerMgr();
		}
		if(args0.getId()==R.id.button6){
			timerStack.setNext(6);
			Toast toast = Toast.makeText(getApplicationContext(), timerStack.toString(), Toast.LENGTH_SHORT);
			toast.show();
			timerMgr();
		}
		if(args0.getId()==R.id.button7){
			timerStack.setNext(7);
			Toast toast = Toast.makeText(getApplicationContext(), timerStack.toString(), Toast.LENGTH_SHORT);
			toast.show();
			timerMgr();
		}
		if(args0.getId()==R.id.button8){
			timerStack.setNext(8);
			Toast toast = Toast.makeText(getApplicationContext(), timerStack.toString(), Toast.LENGTH_SHORT);
			toast.show();
			timerMgr();
		}
		if(args0.getId()==R.id.button9){
			timerStack.setNext(9);
			Toast toast = Toast.makeText(getApplicationContext(), timerStack.toString(), Toast.LENGTH_SHORT);
			toast.show();
			timerMgr();
		}
		if(args0.getId()==R.id.button10){
			timerStack.setNext(0);
			Toast toast = Toast.makeText(getApplicationContext(), timerStack.toString(), Toast.LENGTH_SHORT);
			toast.show();
			timerMgr();
		}
		if(args0.getId()==R.id.button11){
			timerStack.resetToNull();
			Toast toast = Toast.makeText(getApplicationContext(), timerStack.toString(), Toast.LENGTH_SHORT);
			toast.show();
			timerMgr();
		}
		if(args0.getId()==R.id.buttonGreen){
			bOne.setEnabled(false);
			bTwo.setEnabled(false);
			bThree.setEnabled(false);
			bFour.setEnabled(false);
			bFive.setEnabled(false);
			bSix.setEnabled(false);
			bSeven.setEnabled(false);
			bEight.setEnabled(false);
			bNine.setEnabled(false);
			bZero.setEnabled(false);
			bClear.setEnabled(false);
			for(int k=0;k<4;k++)list.get(currSel).value[k]=timerStack.timeStack[k];
			liv.setAdapter(stabAr);
			Toast toast = Toast.makeText(getApplicationContext(), "loud and clear", Toast.LENGTH_SHORT);
			toast.show();
			timerStack.activateResetCac();
			timTsk=new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					TimerMethod();
					
				}
			};
			timer.schedule(timTsk,0,1000);
		}
		if(args0.getId()==R.id.ButtonYellow){
			timTsk.cancel();
		}
		if(args0.getId()==R.id.ButtonRed){
			bOne.setEnabled(true);
			bTwo.setEnabled(true);
			bThree.setEnabled(true);
			bFour.setEnabled(true);
			bFive.setEnabled(true);
			bSix.setEnabled(true);
			bSeven.setEnabled(true);
			bEight.setEnabled(true);
			bNine.setEnabled(true);
			bZero.setEnabled(true);
			bClear.setEnabled(true);
			timTsk.cancel();
			timerStack.useResetCac();
			timerMgr();
			
		}
	}
	private void TimerMethod(){
		this.runOnUiThread(timer_tick);
	}
	private void timeIt(){
		
	}
	private Runnable timer_tick=new Runnable() {
    
    @Override
    public void run() {
    // TODO Auto-generated method stub
    timerStack.reduceSec();
    timerMgr();
    //time.setText(Long.toString((Calendar.getInstance().getTimeInMillis()-l)/1000));
    //time.setText(Long.toString(((Calendar.getInstance().getTimeInMillis()-l)/1000)/60)+":"+(Long.toString(((Calendar.getInstance().getTimeInMillis()-l)/1000)%60)));
    //Long.toString((Calendar.getInstance().getTimeInMillis()-l)/1000);
}
};

public class TimerStack{
    int[] timeStack={0,0,0,0};
    int[] timeStackForReset=new int[4];
    int lev=0;
    public void setStack(int[] inp){
        for(int k=0; k<4;k++) timeStackForReset[k]=timeStack[k]=inp[k];
        timerMgr();
        lev=0;
        
    }
    public void setNext(int i){
        if(lev>3){return;}
        for(int k=0; k<3;k++){
            timeStack[k]=timeStack[k+1];
        }
        timeStack[3]=i;
        lev++;
    }
    public void activateResetCac(){
        if(timeStackForReset[0]==0&&timeStackForReset[1]==0&&timeStackForReset[2]==0&&timeStackForReset[3]==0)
			for(int u=0;u<4;u++) timeStackForReset[u]=timeStack[u];
        int lvs=1000;
        int red=0;
        for(int k:timeStackForReset) {
            red=red+k*lvs;
            lvs/=10;
        }
        Toast toast = Toast.makeText(getApplicationContext(), "csc"+red, Toast.LENGTH_SHORT);
        toast.show();
    }
    public void useResetCac(){
        int lvs=1000;
        int red=0;
        for(int k:timeStackForReset) {
            red=red+k*lvs;
            lvs/=10;
        }
        Toast toast = Toast.makeText(getApplicationContext(), "csc"+red, Toast.LENGTH_SHORT);
        toast.show();
        for(int u=0;u<4;u++) timeStack[u]=timeStackForReset[u];
        
    }
    public void reduceSec(){
        if(timeStack[3]!=0){
            timeStack[3]--;
        }else if(timeStack[2]!=0){
            timeStack[2]--;
            timeStack[3]=9;
        }else if(timeStack[1]!=0){
            timeStack[1]--;
            timeStack[2]=5;
            timeStack[3]=9;
        }else if(timeStack[0]!=0){
            timeStack[0]--;
            timeStack[1]=9;
            timeStack[2]=5;
            timeStack[3]=9;
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT);
            toast.show();
            timTsk.cancel();
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
            r.play();
            for(int u=0;u<4;u++) timeStack[u]=timeStackForReset[u];
            timerMgr();
            //lev=0;
            timeStack=timeStackForReset;
            bOne.setEnabled(true);
            bTwo.setEnabled(true);
            bThree.setEnabled(true);
            bFour.setEnabled(true);
            bFive.setEnabled(true);
            bSix.setEnabled(true);
            bSeven.setEnabled(true);
            bEight.setEnabled(true);
            bNine.setEnabled(true);
            bZero.setEnabled(true);
            bClear.setEnabled(true);
        }
    }
    public void resetToNull(){
        for(int j=0; j<=3;j++){
            timeStack[j]=0;
            timeStackForReset[j]=0;
        }
        lev=0;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String ret="";
        for(int k:timeStack){
            ret=ret+k;
        }
        ret=ret+"and level is"+lev;
        return ret;
    }
}
public class TimerData {
    String name;
    int[] value={0,0,0,0};
    public TimerData(String name,int[] time ){
        this.name=name;
        for(int k=0;k<4;k++) this.value[k]=time[k];
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return name+"\n"+value[0]+value[0]+":"+value[2]+value[3];
    }
    public String getName(){
        return this.name;
        
    }
}
public class currentTimerData{
    long startTime;
    int timerTime;
    int timeRemaining;
    public currentTimerData(int i){
        startTime=Calendar.getInstance().getTimeInMillis();
        
    }
    
}

//	private LayerDrawable createBmp(){  
//	     BitmapDrawable d1 = (BitmapDrawable) getResources().getDrawable(R.drawable.a0);  
//	     //d1.setGravity(Gravity.LEFT);  
//	   //  BitmapDrawable d2 = (BitmapDrawable) getResources().getDrawable(R.drawable.bg);  
//	    // d1.setGravity(Gravity.LEFT);  
//	        
//	     //Drawable drawableArray[]= new Drawable[]{d1};  
//	     //LayerDrawable layerDraw = new LayerDrawable(drawableArray);  
//	     //layerDraw.setLayerInset(1, 15, 15, 0, 0);//set offset of 2 layer  
//	       
//	     return layerDraw;  
//	   } 
@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.timer_main, menu);
return true;
}

}
