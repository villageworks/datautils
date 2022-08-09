package jp.villageworks.datautils.api;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ValidatorTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	@DisplayName("DataValidator#isAlphaNumericSeqメソッドのテストクラス")
	class isAlphNumericSeq {
		@Test
		@DisplayName("【Test-02】文字列「A0-b33」は英数字の文字列ではない")
		void test_02() {
			// setup
			String target = "A0-b33";
			// execute & verify
			assertThat(Validator.isAlphaNumericSeq(target), is(false));
		}
		@Test
		@DisplayName("【Test-01】文字列「A0b1C2d3e4」は英数字のみの文字列である")
		void test_01() {
			// setup
			String target = "A0b1C2d3e4";
			// execute & verify
			assertThat(Validator.isAlphaNumericSeq(target), is(true));
		}
	}

	@Nested
	@DisplayName("DataValidator#isNumericSeqメソッドのテストクラス")
	class isCharType {
		@Test
		@DisplayName("【Test-06】空文字列「」は数字列ではない")
		void test_06() {
			// setup
			String target = "";
			// execute & verify
			assertThat(Validator.isNumericSeq(target), is(false));
		}
		@Test
		@DisplayName("【Test-05】nullは数字列ではない")
		void test_05() {
			// setup
			String target = null;
			// execute & verify
			assertThat(Validator.isNumericSeq(target), is(false));
		}
		@Test
		@DisplayName("【Test-04】文字列「192.168.0.1」は数字列ではない")
		void test_04() {
			// setup
			String target = "192.168.0.1";
			// execute & verify
			assertThat(Validator.isNumericSeq(target), is(false));
		}
		@Test
		@DisplayName("【Test-03】文字列「123 456 789」は数字列ではない")
		void test_03() {
			// setup
			String target = "123 456 789";
			// execute & verify
			assertThat(Validator.isNumericSeq(target), is(false));
		}
		@Test
		@DisplayName("【Test-02】文字列「-1234」は数字列ではない")
		void test_02() {
			// setup
			String target = "-1234";
			// execute & verify
			assertThat(Validator.isNumericSeq(target), is(false));
		}
		@Test
		@DisplayName("【Test-01】文字列「0123456789」は数字列である")
		void test_01() {
			// setup
			String target = "012345678";
			// execute & verify
			assertThat(Validator.isNumericSeq(target), is(true));
		}

	}

/*
		@Nested
		@DisplayName("DataValidator#isEmailAddressFormatメソッドのテストクラス")
		class isEmailAddressFormat {
			@Test
			@DisplayName("【Test-09】文字列「Abc..123@example.com」は電子メールアドレス形式である")
			void test_09() {
				// setup
				String target = "Abc..123@example.com";
				// execute & verify
				assertThat(DataValidator.isEmailAddressFormat(target), is(false));
			}
			@Test
			@DisplayName("【Test-08】文字列「Abc.@example.com」は電子メールアドレス形式である")
			void test_08() {
				// setup
				String target = "Abc.@example.com";
				// execute & verify
				assertThat(DataValidator.isEmailAddressFormat(target), is(false));
			}
			@Test
			@DisplayName("【Test-07】文字列「\"Joe.\\\\Blow\"@example.com」は電子メールアドレス形式である")
			void test_07() {
				// setup
				String target = "\"Joe.\\\\Blow\"@example.com";
				// execute & verify
				assertThat(DataValidator.isEmailAddressFormat(target), is(false));
			}
			@Test
			@DisplayName("【Test-06】文字列「\"Fred\\ Bloggs\"@example.com」は電子メールアドレス形式である")
			void test_06() {
				// setup
				String target = "\"Fred\\ Bloggs\"@example.com";
				// execute & verify
				assertThat(DataValidator.isEmailAddressFormat(target), is(false));
			}
			@Test
			@DisplayName("【Test-05】文字列「\"Abc@def\"@example.com」は電子メールアドレス形式である")
			void test_05() {
				// setup
				String target = "\"Abc@def\"@example.com";
				// execute & verify
				assertThat(DataValidator.isEmailAddressFormat(target), is(false));
			}
			@Test
			@DisplayName("【Test-04】文字列「!#$%&'*+-/=?^_`.{|}~@example.com」は電子メールアドレス形式である")
			void test_04() {
				// setup
				String target = "!#$%&'*+-/=?^_`.{|}~@example.com";
				// execute & verify
				assertThat(DataValidator.isEmailAddressFormat(target), is(true));
			}
			@Test
			@DisplayName("【Test-03】文字列「user+mailbox/department=shipping@example.com」は電子メールアドレス形式である")
			void test_03() {
				// setup
				String target = "user+mailbox/department=shipping@example.com";
				// execute & verify
				assertThat(DataValidator.isEmailAddressFormat(target), is(true));
			}
			@Test
			@DisplayName("【Test-02】文字列「Abc.123@example.com」は電子メールアドレス形式である")
			void test_02() {
				// setup
				String target = "Abc.123@example.com";
				// execute & verify
				assertThat(DataValidator.isEmailAddressFormat(target), is(true));
			}
			@Test
			@DisplayName("【Test-01】文字列「Abc@example.com」は電子メールアドレス形式である")
			void test_01() {
				// setup
				String target = "Abc@example.com";
				// execute & verify
				assertThat(DataValidator.isEmailAddressFormat(target), is(true));
			}
		}
*/


	@Nested
	@DisplayName("DataValidator#likeEmailAdressメソッドのテストクラス")
	class likeEmailAddress {
		@Test
		@DisplayName("【Test-11・NG】nullは電子メール形式ではない")
		void test_11() {
			// setup
			String target = null;
			// execute
			assertThat(Validator.likeEmailAddress(target), is(false));
		}
		@Test
		@DisplayName("【Test-10・NG】空文字列「」は電子メール形式ではない")
		void test_10() {
			// setup
			String target = "";
			// execute
			assertThat(Validator.likeEmailAddress(target), is(false));
		}
		@Test
		@DisplayName("【Test-09・NG】文字列「Abc..123@example.com」は電子メール形式ではない")
		void test_09() {
			// setup
			String target = "Abc..123@example.com";
			// execute
			assertThat(Validator.likeEmailAddress(target), is(false));
		}
		@Test
		@DisplayName("【Test-08・NG】文字列「Abc.@example.com」は電子メール形式ではない")
		void test_08() {
			// setup
			String target = "Abc.@example.com";
			// execute
			assertThat(Validator.likeEmailAddress(target), is(false));
		}
		@Test
		@DisplayName("【Test-07・quoted-string included quoted-pair】文字列「\"Joe.\\\\Blow\"@example.com」は電子メール形式である")
		void test_07() {
			// setup
			String target = "\"Joe.\\\\Blow\"@example.com";
			// execute
			assertThat(Validator.likeEmailAddress(target), is(true));
		}
		@Test
		@DisplayName("【Test-06・quoted-string included quoted-pair】文字列「\"Fred\\ Bloggs\"@example.com」は電子メール形式である")
		void test_06() {
			// setup
			String target = "\"Fred\\ Bloggs\"@example.com";
			// execute
			assertThat(Validator.likeEmailAddress(target), is(true));
		}
		@Test
		@DisplayName("【Test-05・quoted-string】文字列「\"Abc@def\"@example.com」は電子メール形式である")
		void test_05() {
			// setup
			String target = "\"Abc@def\"@example.com";
			// execute
			assertThat(Validator.likeEmailAddress(target), is(true));
		}
		@Test
		@DisplayName("【Test-04・dot-atom】文字列「!#$%&'*+-/=?^_`.{|}~@example.com」は電子メール形式である")
		void test_04() {
			// setup
			String target = "!#$%&'*+-/=?^_`.{|}~@example.com";
			// execute
			assertThat(Validator.likeEmailAddress(target), is(true));
		}
		@Test
		@DisplayName("【Test-03・dot-atom】文字列「user+mailbox/department=shipping@example.com」は電子メール形式である")
		void test_03() {
			// setup
			String target = "user+mailbox/department=shipping@example.com";
			// execute
			assertThat(Validator.likeEmailAddress(target), is(true));
		}
		@Test
		@DisplayName("【Test-02・dot-atom】文字列「Abc.123@example.com」は電子メール形式である")
		void test_02() {
			// setup
			String target = "Abc.123@example.com";
			// execute
			assertThat(Validator.likeEmailAddress(target), is(true));
		}
		@Test
		@DisplayName("【Test-01・dot-atom】文字列「Abc@example.com」は電子メール形式である")
		void test_01() {
			// setup
			String target = "Abc@example.com";
			// execute
			assertThat(Validator.likeEmailAddress(target), is(true));
		}
	}

	@Nested
	@DisplayName("DataValidator#likeZipcodeメソッドのテストクラス")
	class likeZipcode {
		@Test
		@DisplayName("【Test-04】nullは郵便番号書式ではない")
		void test_04() {
			// setup
			String target = null;
			// execute & verify
			assertThat(Validator.likeZipcode(target), is(false));
		}
		@Test
		@DisplayName("【Test-03】空文字列「」は郵便番号書式ではない")
		void test_03() {
			// setup
			String target = "";
			// execute & verify
			assertThat(Validator.likeZipcode(target), is(false));
		}
		@Test
		@DisplayName("【Test-02】文字列「1234567」は郵便番号書式ではない")
		void test_02() {
			// setup
			String target = "1234567";
			// execute & verify
			assertThat(Validator.likeZipcode(target), is(false));
		}
		@Test
		@DisplayName("【Test-01】文字列「123-4567」は郵便番号書式である")
		void test_01() {
			// setup
			String target = "123-4567";
			// execute & verify
			assertThat(Validator.likeZipcode(target), is(true));
		}
	}

	@Nested
	@DisplayName("DataValidator#likePhoneメソッドのテストクラス")
	class likePhone {
		@Test
		@DisplayName("【Test-11】nullは電話番号書式ではない")
		void test_11() {
			// execute & verify
			assertThat(Validator.likePhone(null), is(false));
		}
		@Test
		@DisplayName("【Test-10】空文字列「」は電話番号書式ではない")
		void test_10() {
			// execute & verify
			assertThat(Validator.likePhone(""), is(false));
		}
		@Test
		@DisplayName("【Test-09：料金着払い通話】文字列「0800-123-4567」は電話番号書式である")
		void test_09() {
			// setup
			String target = "0800-123-4567";
			// execute & verify
			assertThat(Validator.likePhone(target), is(true));
		}
		@Test
		@DisplayName("【Test-08：料金着払い通話】文字列「0120-123-456」は電話番号書式である")
		void test_08() {
			// setup
			String target = "0120-123-456";
			// execute & verify
			assertThat(Validator.likePhone(target), is(true));
		}
		@Test
		@DisplayName("【Test-07：スマートフォン】文字列「090-1234-5678」は電話番号書式である")
		void test_07() {
			// setup
			String target = "090-1234-5678";
			// execute & verify
			assertThat(Validator.likePhone(target), is(true));
		}
		@Test
		@DisplayName("【Test-06：スマートフォン】文字列「080-1234-5678」は電話番号書式である")
		void test_06() {
			// setup
			String target = "080-1234-5678";
			// execute & verify
			assertThat(Validator.likePhone(target), is(true));
		}
		@Test
		@DisplayName("【Test-05：PHS】文字列「070-1234-5678」は電話番号書式である")
		void test_05() {
			// setup
			String target = "070-1234-5678";
			// execute & verify
			assertThat(Validator.likePhone(target), is(true));
		}
		@Test
		@DisplayName("【Test-04：固定電話・市外局番5桁】文字列は「01234-5-6789」は電話番号書式である")
		void test_04() {
			// setup
			String target = "01234-5-6789";
			// execute & verify
			assertThat(Validator.likePhone(target), is(true));
		}
		@Test
		@DisplayName("【Test-03：固定電話・市外局番4桁】文字列は「0123-45-6789」は電話番号書式である")
		void test_03() {
			// setup
			String target = "0123-45-6789";
			// execute & verify
			assertThat(Validator.likePhone(target), is(true));
		}
		@Test
		@DisplayName("【Test-02：固定電話・市外局番3桁】文字列は「012-345-6789」は電話番号書式である")
		void test_02() {
			// setup
			String target = "012-345-6789";
			// execute & verify
			assertThat(Validator.likePhone(target), is(true));
		}
		@Test
		@DisplayName("【Test-01：固定電話・市外局番2桁】文字列は「01-2345-6789」は電話番号書式である")
		void test_01() {
			// setup
			String target = "01-2345-6789";
			// execute & verify
			assertThat(Validator.likePhone(target), is(true));
		}
	}

	@Nested
	@DisplayName("DataValidator#isNumericメソッドのテストクラス")
	class isNumeric {
		@Test
		@DisplayName("【Test-03】数値入力の変数に数字列「178cm」が代入されていた場合は正しくない")
		void test_03() {
			// setup
			String target = "178cm";
			// execute & verify
			assertThat(Validator.isNumeric(target), is(false));
		}
		@Test
		@DisplayName("【Test-02】数値入力の変数に数字列「178.5」が代入されていた場合は正しい")
		void test_02() {
			// setup
			String target = "178.5";
			// execute & verify
			assertThat(Validator.isNumeric(target), is(true));
		}
		@Test
		@DisplayName("【Test-01】数値入力の変数に数字列「178」が代入されていた場合は正しい")
		void test_01() {
			// setup
			String target = "178";
			// execute & verify
			assertThat(Validator.isNumeric(target), is(true));
		}
	}

	@Nested
	@DisplayName("DataValidator#isInRangeメソッドのテストクラス")
	class isInRange {
		@Test
		@DisplayName("【Test-11】nullは判定できない")
		void test_11() {
			// setup
			String target = null;
			// execute & verify
			assertThat(Validator.isInRange(target, 0, 0), is(false));
		}
		@Test
		@DisplayName("【Test-02】文字列「ど根性ガエル」は3文字以上5文字以下ではない")
		void test_02() {
			// setup
			String target = "ど根性ガエル";
			int lower = 3;
			int upper = 5;
			// execute & verify
			assertThat(Validator.isInRange(target, lower, upper), is(false));
		}
		@Test
		@DisplayName("【Test-01】文字列「ど根性ガエル」は5文字以上7文字以下である")
		void test_01() {
			// setup
			String target = "ど根性ガエル";
			int lower = 4;
			int upper = 6;
			// execute & verify
			assertThat(Validator.isInRange(target, lower, upper), is(true));
		}
	}

	@Nested
	@DisplayName("Datavalidator#isOverLimitメソッドのテストクラス")
	class isOverLimit {
		@Test
		@DisplayName("【Test-11】nullは判定できない")
		void test_11() {
			// setup
			String target = null;
			int minLength = 0;
			// execute & verify
			assertThat(Validator.isOverLimit(target, minLength), is(false));
		}
		@Test
		@DisplayName("【Test-02】文字列「変身忍者嵐」は5文字以上である")
		void test_02() {
			// setup
			String target = "変身忍者嵐";
			int minLength = 5;
			// execute & verify
			assertThat(Validator.isOverLimit(target, minLength), is(true));
		}
		@Test
		@DisplayName("【Test-01】文字列「変身忍者嵐」は4文字以上である")
		void test_01() {
			// setup
			String target = "変身忍者嵐";
			int minLength = 4;
			// execute & verify
			assertThat(Validator.isOverLimit(target, minLength), is(true));
		}
	}

	@Nested
	@DisplayName("DataValidator#isUnderLimitメソッドのテストクラス")
	class isUnderLength {
		@Test
		@DisplayName("【Test-11】nullは判定できない")
		void test_11() {
			// setup
			String target = null;
			int limit = 0;
			// execute & verify
			assertThat(Validator.isUnderLimit(target, limit), is(false));
		}
		@Test
		@DisplayName("【Test-05】文字列「アンパンマン」は5文字以下ではない")
		void test_05() {
			// setup
			String target = "アンパンマン";
			int limit = 5;
			// execute & verify
			assertThat(Validator.isUnderLimit(target, limit), is(false));
		}
		@Test
		@DisplayName("【Test-04】空文字列「」は0文字以下である")
		void test_04() {
			// setup
			String target = "";
			int limit = 0;
			// execute & verify
			assertThat(Validator.isUnderLimit(target, limit), is(true));
		}
		@Test
		@DisplayName("【Test-03】空文字列「」は5文字以下である")
		void test_03() {
			// setup
			String target = "";
			int limit = 5;
			// execute & verify
			assertThat(Validator.isUnderLimit(target, limit), is(true));
		}
		@Test
		@DisplayName("【Test-02】文字列「アンパンマン」は6文字以下である")
		void test_02() {
			// setup
			String target = "アンパンマン";
			int maxLength = 6;
			// execute & verify
			assertThat(Validator.isUnderLimit(target, maxLength), is(true));
		}
		@Test
		@DisplayName("【Test-01】文字列「アンパンマン」は10文字以下である")
		void test_01() {
			// setup
			String target = "アンパンマン";
			int limit = 10;
			// execute & verify
			assertThat(Validator.isUnderLimit(target, limit), is(true));
		}
	}

	@Nested
	@DisplayName("DataValidator#isRequiredメソッドのテストクラス")
	class isReuired {
		@Test
		@DisplayName("【Test-12】必須入力の項目にnullが代入されている場合は正しくない")
		void test_12() {
			// setup
			String target = null;
			// execute & verify
			assertThat(Validator.isRequired(target), is(false));
		}
		@Test
		@DisplayName("【Test-11】必須入力の項目に空文字列「」が代入されている場合は正しくない")
		void test_11() {
			// setup
			String target = "";
			// execute & verify
			assertThat(Validator.isRequired(target), is(false));
		}
		@Test
		@DisplayName("【Test-01】必須入力の項目に文字列「必須入力」が代入されている場合は正しい")
		void test_01() {
			// setup
			String target = "必須入力";
			// execute & verify
			assertThat(Validator.isRequired(target), is(true));
		}
	}

}
