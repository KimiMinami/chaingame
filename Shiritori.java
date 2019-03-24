package chaingame;

public class Shiritori {

	public static void main(String[] args) {
		final int NUM = 100;
		String[] log;
		log = new String[NUM];
		boolean gameover = false;
		String data;

		System.out.println("しりとりを始めてください");
		for (int i = 0; i < NUM; i++) {

			System.out.println("入力してください");
			// 文字列を取得
			data = Utility.getStream();

			log[i] = data.toLowerCase();


			// アルファベットの入力チェック：大文字小文字は問わない
			if (log.length < 1) {
				System.exit(1);
			}

			if (log[i].matches("[a-zA-Z]+")) {

			} else {
				gameover = true;
				System.out.println("英数以外の文字が含まれます");
				break;
			}
			gameover = false;

			if (i > 0) {
				// P1の入力値の語尾を切り取り
				// P2の入力値の先頭文字を切り取り
				log[i - 1].charAt(log[i - 1].length() - 1);
				log[i].charAt(0);

				if (log[i].charAt(0) != log[i - 1].charAt(log[i - 1].length() - 1)) {
					gameover = true;
					System.out.println("最初の文字が一致してません");
					break;
				}
				gameover = false;
				// System.out.println("ゲームが継続可能です");
			}

			// dataをlog[i]に入れる作業を行っているので、equalsメソッドは添え字i-1の時点まで参照する
			for (int j = 0; j < i; j++) {

				if (data.equals(log[j])) {
					// 一致したときはゲーム終了
					gameover = true;
					System.out.println("前と同じ言葉です");
					break;

				}
				gameover = false;
				// System.out.println("ゲームが継続可能です");
			}
			if (gameover) {
				System.out.println("ゲーム終了です");
			} else {
				System.out.println("勝負を継続してください");
			}
		}
	}
}
