package jp.villageworks.datautils.api;

/**
 * データ返還に係る例外クラス
 * @author tutor
 */
public class ConvertException extends Exception {

	/**
	 * コンストラクタ
	 * @param message エラーメッセージ
	 * @param cause 発生した例外クラス
	 */
	public ConvertException(String message, Throwable cause) {
		super(message, cause);
	}

}
