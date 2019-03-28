public class ShiritoriJp {

	public static void main(String[] args) {

		char last = 'あ';
		char first = 0;

		final int NUM = 100;
		String[] log;
		log = new String[NUM];
		boolean gameover = false;
		String data;
		char now_last;

		System.out.println("しりとりを始めてください");
		for (int i = 0; i < NUM; i++) {
			// 1．入力
			System.out.println("入力してください");
			// 文字列を取得
			data = Utility.getStream();
			// 入力値の先頭文字を切り取り
			String tmp = data.replaceAll("ー", "");
			first = tmp.charAt(0);
			// 現在の入力値の語尾を切り取り
			now_last = tmp.charAt(tmp.length() - 1);
			// System.out.println(now_last);

			// 2．配列にいれる
			log[i] = data;

			// 3.日本語の入力チェック
			if (log.length < 1) {
				System.exit(1);
			}

			// 4.ひらがなだけを入力可能にする
			if (!log[i].matches("^[ぁ-んー]*$")) {
				gameover = true;
				System.out.println("ひらがな以外の文字が含まれます");
				break;
			}
			gameover = false;

			// 5．最後の文字が「ん」で終わると、終了
			if (now_last == 'ん') {
				gameover = true;
				System.out.println("最後の文字が「ん」です");
				break;

			}
			gameover = false;

			// 6．の文字と最後の文字を確認
			if (i > 0) {

				if (last != first) {
					gameover = true;
					System.out.println("文字のつながりがありません");
					break;
				}
			}
			gameover = false;
			last = now_last;

			// 7．小さい文字を大きい文字に変換・時間があればやり直し
			char[] small = { 'ゃ', 'ゅ', 'ょ', 'っ', 'ぁ', 'ぃ', 'ぅ', 'ぇ', 'ぉ' };
			char[] big = { 'や', 'ゆ', 'よ', 'つ', 'あ', 'い', 'う', 'え', 'お' };

			for (int j = 0; j < small.length; j++) {

				if (last == small[j]) {
					last = big[j];

					break;

				}
			}
			// 8.前回に出てきた単語を検索
			// dataをlog[i]に入れる作業を行っているので、equalsメソッドは添え字i-1の時点まで参照する
			for (int j = 0; j < i; j++) {

				if (log[j].equals(data)) {
					gameover = true;
					System.out.println("前回と同じ単語です");
					break;
				}
				gameover = false;

			}
			if (gameover) {
				break;
			}

		}
		System.out.println("ゲーム終了です");
		System.exit(0);
	}

}
