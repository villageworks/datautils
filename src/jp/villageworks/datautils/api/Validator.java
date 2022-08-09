package jp.villageworks.datautils.api;

import jp.villageworks.datautils.core.UtilsCore;

public class Validator {

	private static final String PATTERN_NUMERIC_SEQ = "^\\d+$";
	private static final String PATTERN_ALPHA_NUMERIC = "^[\\w]+$";

	/**
	 * 必須入力項目に文字リテラルが入力されているかどうかを判定する。
	 * @param target 判定対象変数
	 * @return 空文字列またはnull以外の文字列が入力されている場合はtrue、それ以外はfalse
	 */
	public static boolean isRequired(String target) {
		return !UtilsCore.isEmpty(target);
	}

	/**
	 * 文字列長が指定されたサイズ以下であるかどうかを判定する。
	 * @param target 	判定対象文字列
	 * @param limit 	判定基準サイズ
	 * @return 判定対象文字列の文字列長が判定基準サイズ以下である場合はtrue、それ以外はfalse
	 */
	public static boolean isUnderLimit(String target, int limit) {
		if (UtilsCore.isNull(target)) return false;
		int length = target.length();
		return UtilsCore.isUnder(length, limit);
	}

	/**
	 * 文字列長が指定されたサイズ以上であるかどうかを判定する。
	 * @param target 	判定対象文字列
	 * @param limit 	判定基準サイズ
	 * @return 判定対象文字列の文字列長が判定基準サイズ以上である場合はtrue、それ以外はfalse
	 */
	public static boolean isOverLimit(String target, int limit) {
		if (UtilsCore.isNull(target)) return false;
		int length = target.length();
		return UtilsCore.isOver(length, limit);
	}

	/**
	 * 文字列長が指定されたサイズ下限値以上かつ上限値以下であるかどうかを判定する。
	 * @param target 	判定対象文字列
	 * @param lower 	判定基準サイズ下限値
	 * @param upper		判定基準サイズ上限値
	 * @return 判定対象文字列の文字列長が判定基準サイズ下限値以上かつ上限値以下である場合はtrue、それ以外はfalse
	 */
	public static boolean isInRange(String target, int lower, int upper) {
		if (UtilsCore.isNull(target)) return false;
		int length = target.length();
		return UtilsCore.isInRange(length, lower, upper);
	}

	/**
	 * 文字列が数値であるかどうかを判定する。
	 * @param target 判定対象文字列
	 * @return 数値に変換できる場合はtrue、それ以外はfalse
	 */
	public static boolean isNumeric(String target) {
		return UtilsCore.isNumeric(target);
	}

	/**
	 * 文字列が電話番号の形式であるかどうかを判定する。
	 * @param target 判定対象文字列
	 * @return 電話番号書式である場合はtrue、それ以外はfalse
	 * @see 『総務省 電話番号に関するQ&A（https://www.soumu.go.jp/main_sosiki/joho_tsusin/top/tel_number/q_and_a.html#q2）』
	 */
	public static boolean likePhone(String target) {
		// 判定対象文字列がnullまたは空文字の場合
		if (UtilsCore.isEmpty(target)) return false;

		String hyphenless = target.replace("-", "");
		if (hyphenless.length() == 10) {
			if (target.matches("^0[0-9]{1}-[0-9]{4}-[0-9]{4}$")) {
				// 固定電話の場合：市外局番2桁
				return true;
			} else if (target.matches("^0[0-9]{2}-[0-9]{3}-[0-9]{4}$")) {
				// 固定電話の場合：市外局番3桁
				return true;
			} else if (target.matches("^0[0-9]{3}-[0-9]{2}-[0-9]{4}$")) {
				// 固定電話の場合：市外局番4桁
				return true;
			} else if (target.matches("^0[0-9]{4}-[0-9]-[0-9]{4}$")) {
				// 固定電話の場合：市外局番5桁
				return true;
			} else if (hyphenless.matches("^(0120)([0-9]{6})$")) {
				// 料金着払い通話番号
				return true;
			}
		} else if (hyphenless.length() == 11) {
			if (target.matches("^(0(7|8|9)0)(-[0-9]{4}){2}$")) {
				// PHS・スマートフォンの場合
				return true;
			} else if (hyphenless.matches("^(0800)([0-9]{7})$")) {
				// 料金着払い通話番号の場合
				return true;
			}
		}
		return false;
	}

	/**
	 * 文字列が郵便番号の形式であるかどうかを判定する。
	 * @param target 判定対象文字列
	 * @return 郵便番号書式である場合はtrue、それ以外はfalse
	 */
	public static boolean likeZipcode(String target) {
		if (UtilsCore.isEmpty(target)) return false;
		return target.matches("^[0-9]{3}-[0-9]{4}$");
	}

	/**
	 * 文字列が電子メールの形式であるかどうかを判定する。
	 * @param target 判定対象文字列
	 * @return RFCで規定された電子メールアドレスの書式に準拠している場合はtrue、それ以外はfalse
	 * TODO: ドメイン部の検査は未実装
	 */
	public static boolean likeEmailAddress(String target) {
		if (UtilsCore.isEmpty(target)) return false;
		if (target.matches("^([\\w]+)(\\.)(\\.[\\w]+)?@[A-z\\.]+$")) return false;
		return target.matches("^([\\w\\+/=!#$%&\\'\\*\\-\\=\\?\\^_`\\.\\{\\|\\}~\"@\\s\\\\]+)((\\.)?([\\w\\+/=!#$%&\\'\\*\\-\\=\\?\\^_`\\{\\|\\}~\"@\\s\\\\]*))(@)([\\w\\.]+)$");
	}

	/**
	 * 文字列が数字列であるかどうかを判定する（DataValidator#isCharTypeメソッドのラッパーメソッド）。
	 * @param target 判定対象文字列
	 * @return 文字列が数字のみで構成されている場合はtrue、それ以外はfalse
	 */
	public static boolean isNumericSeq(String target) {
		return isCharType(target, PATTERN_NUMERIC_SEQ);
	}

	/**
	 * 文字列が英数字列であるかどうかを判定する（DataValidator#isCharTypeメソッドのラッパーメソッド）。
	 * @param target 判定対象文字列
	 * @return 文字列が英数字のみで構成されている場合はtrue、それ以外はfalse
	 */
	public static boolean isAlphaNumericSeq(String target) {
		return isCharType(target, PATTERN_ALPHA_NUMERIC);
	}

	/**
	 * 文字列が指定された文字種パターンであるかを判定する。
	 * @param target 判定対象文字列
	 * @param type 文字種パターン（正規表現パターン）
	 * @return 文字列が指定された文字種パターンに合致する場合はtrue、それ以外はfalse
	 */
	private static boolean isCharType(String target, String type) {
		if (UtilsCore.isEmpty(target)) return false;
		return target.matches(type);
	}

}
