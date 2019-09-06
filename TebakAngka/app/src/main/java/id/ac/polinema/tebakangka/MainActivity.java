package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private EditText number_input;
	private int n, convert;
	private Random rnd;
	private Button guess_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		number_input = findViewById(R.id.number_input);
		guess_button = findViewById(R.id.guess_button);
//		number_input = findViewById(R.id.number_input);
		rnd = new Random();
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		n = rnd.nextInt(100)+1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka

		if(number_input.getText().toString().isEmpty()){
			Toast.makeText(this, "Wajib Input Angka", Toast.LENGTH_SHORT).show();
		}else {
			String no = number_input.getText().toString();
			convert = Integer.parseInt(no);
			if (convert == n){
				Toast.makeText(this, "Tebakan Anda Benar!", Toast.LENGTH_SHORT).show();
				guess_button.setEnabled(false);
			}else if(convert > n){
				Toast.makeText(this, "Tebakan Anda Telalu Besar!", Toast.LENGTH_SHORT).show();
			}else if(convert < n){
				Toast.makeText(this, "Tebakan Anda Terlalu Kecil", Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		number_input.setText("");
		initRandomNumber();
		guess_button.setEnabled(true);
	}
}
