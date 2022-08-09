package jp.villageworks.datautils.core;

public class UtilsCore {

	/** クラス定数 */
	public static final String NUMERIC_PATTERN = "^[-+]?([0-9]+(\\.[0-9]*)?)$";
	public static final String INTEGER_PATTERN = "^[-+]?[0-9]{1,10}$";

	/**
	 * 【判定系】文字列が空またはnullであるかどうかを判定する。
	 * @param target 判定対象文字列
	 * @return nullまたは空の場合はtrue、それ以外はfalse
	 */
	public static boolean isEmpty(String target) {
		return (isNull(target) || target.isEmpty());
	}

	/**
	 * 【判定系】文字列がnullであるかどうかを判定する。
	 * @param target 判定対象のObject型のインスタンス
	 * @return nullの場合はtrue、それ以外はfalse
	 */
	public static boolean isNull(Object target) {
		return (target == null);
	}

	/**
	 * 【判定系】文字列が数値に変換できるかどうかを判定する。
	 * @param target 判定対象文字列
	 * @return 数値として変換できる場合はtrue、それ以外はfalse
	 * 				 数値として変換できるとは、整数・浮動小数・正負符号付き数値である場合を指す。
	 * 				 3桁区切りカンマや通貨記号付きは数値とみなさない。
	 */
	public static boolean isNumeric(String target) {
		if (!isEmpty(target)) {
			return target.matches(NUMERIC_PATTERN);
		} else {
			return false;
		}
	}

	/**
	 * 【判定系】文字列が整数に変換できるかどうかを判定する。
	 * @param target 判定対象文字列
	 * @return 整数値として変換できる場合はtrue、それ以外はfalse
	 */
	public static boolean isInt(String target) {
		if (!isEmpty(target)) {
			return target.matches(INTEGER_PATTERN);
		} else {
			return false;
		}
	}

	/**
	 * 【判定系】判定対象の整数が下限値以上であるかどうかを判定する。
	 * @param target	判定対象の整数
	 * @param lower		下限値
	 * @return 判定対象の整数が下限値以上である場合はtrue、それ以外はfalse
	 */
	public static boolean isOver(int target, int lower) {
		return (target >= lower);
	}

	/**
	 * 【判定系】判定対象の整数が上限値以下であるかどうかを判定する。
	 * @param target	判定対象の整数
	 * @param upper		上限値
	 * @return 判定対象の整数が上限値以下である場合はtrue、それ以外はfalse
	 */
	public static boolean isUnder(int target, int upper) {
		return (target <= upper);
	}

	/**
	 * 【判定系】判定対象の整数が下限値以上かつ上限値以下であるかどうかを判定する。
	 * @param target	判定対象の整数
	 * @param lower		下限値
	 * @param upper		上限値
	 * @return 判定対象の整数が下限値以上かつ上限値以下である場合はtrue、それ以外はfalse
	 */
	public static boolean isInRange(int target, int lower, int upper) {
		return (isOver(target, lower) && isUnder(target, upper));
	}

	/**
	 * 【変換系】変換対象の整数の前方に指定した文字を追加して指定の文字列長の文字列に変換する。
	 * @param length 変換後の文字列長
	 * @param padChar 前方に追加する文字
	 * @param core 変換対象の整数
	 * @return 変換対象の整数の前方に指定した文字を追加して指定の文字列長の文字列
	 */
	public static String paddingChar(int length, String padChar, int core) {
		// 対象数字を文字列に変換
		String target = Integer.valueOf(core).toString();
		// 指定された文字列長が対象数字の桁数以下である場合：処理しない
		if (length < target.length()) {
			return target;
		}
		// 戻り値の初期化
		String result = "";
		// 指定された文字列長が対象数字の桁数より大きい場合
		for (int i = 0; i < length - target.length(); i++) {
			result += padChar;
		}
		result += target;
		return result;
	}

	/**
	 * 【変換系】変換対象の整数を指定した文字列長の前ゼロ付き数字列に変換する。
	 * @param length 変換後の文字列長
	 * @param target 変換対象の整数
	 * @return 前ゼロ付き数字列
	 */
	public static String zeroPadding(int length, int target) {
		// paddingCharメソッドを呼び出す
		return paddingChar(length, "0", target);
	}

}
