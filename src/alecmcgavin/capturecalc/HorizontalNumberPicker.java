package alecmcgavin.capturecalc;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;


public class HorizontalNumberPicker extends LinearLayout {

	private final int REP_DELAY = 25;
	private int min;
	private int max;

	private Button minusButton;
	private Button plusButton;
	private EditText numberBox;

	private Handler repeatUpdateHandler;
	private boolean mAutoIncrement =false;
	private boolean mAutoDecrement=false;


	public HorizontalNumberPicker(Context context, AttributeSet attrs) {
		super(context, attrs);

		repeatUpdateHandler = new Handler();
		setOrientation(LinearLayout.HORIZONTAL);
		setGravity(Gravity.CENTER_HORIZONTAL);
		

		minusButton = new Button(context);
		plusButton = new Button(context);
		numberBox = new EditText(context);
		numberBox.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);

		numberBox.setInputType(InputType.TYPE_CLASS_NUMBER);
		numberBox.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) {
				int value;
				if(s.toString().equals(""))
					value =0;
				else
					value = Integer.parseInt(s.toString());

				if(value > max)
					numberBox.setText(""+max);
				if(value < min)
					numberBox.setText(""+min);
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}});

		minusButton.setText("-");
		minusButton.setPadding(2, 2, 2, 2);
		minusButton.setGravity(Gravity.CENTER);
		minusButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				decrement();
			}});
		minusButton.setLongClickable(true);
		minusButton.setOnLongClickListener(new OnLongClickListener(){
			@Override
			public boolean onLongClick(View v) {
				mAutoDecrement = true;
				repeatUpdateHandler.post( new RptUpdater() );
				return false;
			}});
		minusButton.setOnTouchListener(new OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_UP || event.getAction()==MotionEvent.ACTION_CANCEL)
					mAutoDecrement = false;
				return false;
			}});



		plusButton.setText("+");
		plusButton.setPadding(2, 2, 2, 2);
		plusButton.setGravity(Gravity.CENTER);
		plusButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				increment();
			}});
		plusButton.setLongClickable(true);
		plusButton.setOnLongClickListener( new OnLongClickListener(){
			public boolean onLongClick(View arg0) {
				mAutoIncrement = true;
				repeatUpdateHandler.post( new RptUpdater() );
				return false;
			}});   
		plusButton.setOnTouchListener(new OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_UP || event.getAction()==MotionEvent.ACTION_CANCEL)
					mAutoIncrement = false;
				return false;
			}});





		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, 1.25F);
		LayoutParams params2 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT, 1.0F);

		
		
		minusButton.setLayoutParams(params);
		plusButton.setLayoutParams(params);
		numberBox.setLayoutParams(params2);
		
		
		addView(minusButton);
		addView(numberBox);
		addView(plusButton);


	}

	public void setMaxValue(int max)
	{
		this.max = max;

	}
	public void setMinValue(int min)
	{
		this.min = min;
	}
	public void setValue(int value)
	{
		numberBox.setText(""+value);
	}
	public int getValue()
	{
		return Integer.parseInt(numberBox.getText().toString());
	}

	private void decrement()
	{
		int value = Integer.parseInt(numberBox.getText().toString());

		if(value > min)
			numberBox.setText(""+(value-1));
	}
	private void increment()
	{
		int value = Integer.parseInt(numberBox.getText().toString());

		if(value < max)
			numberBox.setText(""+(value+1));
	}
	class RptUpdater implements Runnable {

		@Override
		public void run() {
			if(mAutoIncrement)
			{
				increment();
				repeatUpdateHandler.postDelayed(new RptUpdater(), REP_DELAY);
			}
			else if(mAutoDecrement)
			{
				decrement();
				repeatUpdateHandler.postDelayed(new RptUpdater(), REP_DELAY);
			}
		}

	}

}
