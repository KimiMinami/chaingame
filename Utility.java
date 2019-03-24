package chaingame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utility {
	// static String line;

	static String line;

	// インスタンスがなくても呼べるメソッド
	static String getStream() {
		String line = "";

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {

			line = reader.readLine();

		} catch (IOException e) {
			System.out.println(e);
		}

		return line;
	}

	public void input() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
