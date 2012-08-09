package alecmcgavin.capturecalc;

import java.text.DecimalFormat;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class CaptureCalcActivity extends Activity {
	/** Called when the activity is first created. */
	SeekBar hpBar;
	Spinner mPokeSpinner;
	Spinner mBallSpinner;
	Spinner mStatusSpinner;
	Button mCalculateButton;
	TextView mResult;
	TextView mResultBox;
	AutoCompleteTextView mAutoComplete;
	HorizontalNumberPicker mNumberPicker;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



		setContentView(R.layout.main);
		setupButton();
		setupHpBar();
		setupScrollBoxes();
		setupTextView();
		setupNumberPicker(); //waterbottle


	}

	public void setupNumberPicker()
	{
		mNumberPicker = (HorizontalNumberPicker)findViewById(R.id.numberpicker);
		mNumberPicker.setMaxValue(100);
		mNumberPicker.setMinValue(1);
		mNumberPicker.setValue(30);
	} 
	public void setupTextView()
	{
		mResultBox = (TextView)findViewById(R.id.resultbox);
		mResult = (TextView)findViewById(R.id.results);
		mResult.setTextColor(Color.GREEN);
		mResult.setTextSize(48);
	}
	public void setupButton()
	{
		mCalculateButton = (Button)findViewById(R.id.button);
		mCalculateButton.setText("Calculate");

		mCalculateButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String pokemon, pokeball, status;
				int maxHP, currentHP, catchRate, level;
				float ball, statusval;
				double rate;

				pokemon = (String)mPokeSpinner.getAdapter().getItem(mPokeSpinner.getSelectedItemPosition());
				pokeball = (String)mBallSpinner.getSelectedItem();
				status = (String)mStatusSpinner.getSelectedItem();
				level = mNumberPicker.getValue(); //plays extremely minor role, unless the capture rate is very high (too bad yo)
				if(pokemon.equals("Shedinja"))
					maxHP=1;
				else
					maxHP = (PokemonUtils.GET_BASE_HP(pokemon)*2 + 15) * level/100 + level + 10;
				catchRate = PokemonUtils.GET_CAPTURE_RATE(pokemon);
				if(pokeball.equals("Nest Ball")){
					ball = (40-level)/10;
					if (ball < 1)
						ball = 1;
				}
				else
					ball = PokemonUtils.GET_BALL_VALUE(pokeball);
				statusval = PokemonUtils.GET_STATUS_VALUE(status);

				currentHP = maxHP*hpBar.getProgress()/100;
				Log.d("Pokemon", pokemon);
				Log.d("maxHP", maxHP+"");
				Log.d("CurrentHP", currentHP+"");
				Log.d("catchRate", catchRate+"");
				rate = PokemonUtils.EVALUATE(maxHP, currentHP, catchRate, ball, statusval)*100;

				DecimalFormat df = new DecimalFormat("#.##");
				rate = Double.valueOf(df.format(rate));
				mResult.setText(rate+"%"); 

				int average = (int) Math.ceil(100/rate);
				if(status.equals("None"))
					mResultBox.setText("There is a "+ rate +"% chance to catch a level " + level + " " + pokemon + " with a " + pokeball +". You will require an average of " + average + " balls for capture.");
				else
					mResultBox.setText("There is a "+ rate +"% chance to catch a "+ status.toLowerCase() + ", level " + level + " " + pokemon + " with a " + pokeball +". You will require an average of " + average + " balls for capture.");

				mResultBox.setText(mResultBox.getText()+"\n\nNote that any special ball must meet it's requirements. Ie, a Repeat Ball must be used on a Pokemon you've caught before. Likewise, a Timer Ball must be used after 40 turns, and a Quick Ball only on the first.");
			}
		});


	}
	public void setupScrollBoxes()
	{
		mAutoComplete = (AutoCompleteTextView)findViewById(R.id.autocomplete);
		mAutoComplete.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, PokemonUtils.GET_POKEMON()));
		mAutoComplete.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				//	Log.d("autoClick", parent.getAdapter().getItem(position).toString());
				String pokemon = parent.getAdapter().getItem(position).toString();
				mPokeSpinner.setSelection(PokemonUtils.GET_ID(pokemon));	
				mAutoComplete.setText("");			}
		});

		mAutoComplete.setHint("Search...");

		mPokeSpinner = (Spinner)findViewById(R.id.pokespinner);
		String[] pokemans;
		pokemans = PokemonUtils.GET_POKEMON();


		ArrayAdapter<String> pokeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pokemans);
		pokeAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		mPokeSpinner.setAdapter(pokeAdapter);
		mPokeSpinner.setSelection(0);

		mBallSpinner = (Spinner)findViewById(R.id.ballspinner);
		ArrayAdapter<String> ballAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, PokemonUtils.POKEBALLS);
		ballAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		mBallSpinner.setAdapter(ballAdapter);
		mBallSpinner.setSelection(0);

		mStatusSpinner = (Spinner)findViewById(R.id.statusspinner);
		ArrayAdapter<String> statusAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, PokemonUtils.STATUSES);
		statusAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		mStatusSpinner.setAdapter(statusAdapter);
		mStatusSpinner.setSelection(0);
	}

	public void setupHpBar()
	{
		hpBar = (SeekBar)findViewById(R.id.seekbar);

		hpBar.setProgress(100);
		hpBar.setProgressDrawable(getResources().getDrawable(R.drawable.progress_green));
		hpBar.setThumbOffset(Math.abs(((int)((100*0.32)-16))));
		hpBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				if(progress < 48 && progress > 18) {
					if(!seekBar.getProgressDrawable().equals(getResources().getDrawable(R.drawable.progress_yellow))){
						seekBar.setProgressDrawable(getResources().getDrawable(R.drawable.progress_yellow));
					}
				}
				else if(progress <= 18) {	
					if(!seekBar.getProgressDrawable().equals(getResources().getDrawable(R.drawable.progress_red))){
						seekBar.setProgressDrawable(getResources().getDrawable(R.drawable.progress_red));

					}
				}
				else if(progress >= 48) {	
					if(!seekBar.getProgressDrawable().equals(getResources().getDrawable(R.drawable.progress_green))){
						seekBar.setProgressDrawable(getResources().getDrawable(R.drawable.progress_green));
					}
				}

				seekBar.setThumbOffset(Math.abs(((int)((progress*0.32)-16))));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				seekBar.setThumbOffset(Math.abs(((int)((seekBar.getProgress()*0.32)-16))));
			}

		});
	}
}