package jp.villageworks.datautils.api;

/**
 * 文字列から数値データに変換するユーティリティクラス
 * @author tutor
 */
public class Convertor {

	/**
	 * 文字列から整数型に変換する。
	 * @param target 変換対象文字列
	 * @return 整数
	 * @throws ConvertException NumberFormatExceptionを置き換える
	 */
	public static int toInt(String target) throws ConvertException {
		try {
			return Integer.parseInt(target);
		} catch (NumberFormatException e) {
			throw new ConvertException("整数型に変換できませんでした。", e);
		}
	}

	/**
	 * 文字列から長整数型に変換する。
	 * @param target 変換対象文字列
	 * @return 長整数型の整数
	 * @throws ConvertException NumberFormatExceptionを置き換える
	 */
	public static long toLong(String target) throws ConvertException {
		try {
			return Long.parseLong(target);
		} catch (NumberFormatException e) {
			throw new ConvertException("長整数型に変換できませんでした。", e);
		}
	}

	/**
	 * 文字列から倍精度浮動小数型に変換する。
	 * @param target 変換対象文字列
	 * @return 倍精度浮動小数型の整数
	 * @throws ConvertException NumberFormatExceptionを置き換える
	 */
	public static double toDouble(String target) throws ConvertException {
		try {
			return Double.parseDouble(target);
		} catch (NumberFormatException e) {
			throw new ConvertException("浮動小数に変換できませんでした。", e);
		}
	}

}
