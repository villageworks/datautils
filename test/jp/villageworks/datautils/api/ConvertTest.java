package jp.villageworks.datautils.api;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ConvertTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	@DisplayName("DataConverter#toDoubleメソッドのテストクラス")
	class toDouble {
		@Test
		@DisplayName("【Test01・倍精度浮動小数のテスト】数字列「3.14」を倍精度浮動小数型に変換できる")
		void test_01() throws Exception {
			// setup
			String target = "3.14";
			double expected = 3.14;
			// execute
			double actual = Convertor.toDouble(target);
			// verify
			assertThat(actual, is(expected));
		}
	}

	@Nested
	@DisplayName("DataConverter#toLongメソッドのテストクラス")
	class toLong {
		// DataConverter#toIntメソッドのテストケースとかぶるのでTest13からTest16までは割愛
		@Test
		@DisplayName("【Test12・長整数型の桁数範囲外のテスト】数字列「123456789012」は長整数型の整数に変換できない")
		void test_12() {
			// setup
			String target = "12345678901234567890";
			// execute
			try {
				Convertor.toLong(target);
			} catch (Exception e) {
				// verify
				assertThat(e, is(instanceOf(ConvertException.class)));
				assertThat(e.getMessage(), is("変換できませんでした。"));
			}
		}
		@Test
		@DisplayName("【Test11・長整数型の範囲外のテスト】数字列「9223372036854775808」は長整数型の整数に変換できない")
		void test_11() throws Exception {
			// setup
			String target = "9223372036854775808";
			// execute
			try {
				Convertor.toLong(target);
			} catch (Exception e) {
				// verify
				assertThat(e, is(instanceOf(ConvertException.class)));
				assertThat(e.getMessage(), is("変換できませんでした。"));
			}
		}
		@Test
		@DisplayName("【Test03・長整数型の最小値のテスト】数字列「-9223372036854775808」を長整数型の整数に変換できる")
		void test_03() throws Exception {
			// setup
			String target = "-9223372036854775808";
			long expected = -9223372036854775808l;
			// execute
			long actual = Convertor.toLong(target);
			// verify
			assertThat(actual, is(expected));
		}
		@Test
		@DisplayName("【Test02・長整数型の最大値のテスト】数字列「9223372036854775807」を長整数型の整数に変換できる")
		void test_02() throws Exception {
			// setup
			String target = "9223372036854775807";
			long expected = 9223372036854775807l;
			// execute
			long actual = Convertor.toLong(target);
			// verify
			assertThat(actual, is(expected));
		}
		@Test
		@DisplayName("【Test01・長整数型のテスト】数字列「111」を長整数型の整数に変換できる")
		void test_01() throws Exception {
			// setup
			String target = "111";
			long expected = 111l;
			// execute
			long actual = Convertor.toLong(target);
			// verify
			assertThat(actual, is(expected));
		}
	}

	@Nested
	@DisplayName("DataConverter#toIntメソッドのテストクラス")
	class toInt {
		@Test
		@DisplayName("【Test16・nullの変換テスト】nullは整数に変換できない")
		void test_16() {
			// execute
			try {
				Convertor.toInt(null);
			} catch (Exception e) {
				// verify
				assertThat(e, is(instanceOf(ConvertException.class)));
				assertThat(e.getMessage(), is("変換できませんでした。"));
			}
		}
		@Test
		@DisplayName("【Test15・空文字列の変換テスト】空文字列は整数に変換できない")
		void test_15() {
			// execute
			try {
				Convertor.toInt("");
			} catch (Exception e) {
				// verify
				assertThat(e, is(instanceOf(ConvertException.class)));
				assertThat(e.getMessage(), is("変換できませんでした。"));
			}
		}
		@Test
		@DisplayName("【Test14・数字以外の文字が含まれる文字列の変換テスト】文字列「2000kg」は整数に変換できない")
		void test_14() {
			// setup
			String target = "2000kg";
			// execute
			try {
				Convertor.toInt(target);
			} catch (Exception e) {
				// verify
				assertThat(e, is(instanceOf(ConvertException.class)));
				assertThat(e.getMessage(), is("変換できませんでした。"));
			}
		}
		@Test
		@DisplayName("【Test13・3桁区切りが含まれる文字列の変換テスト】文字列「10,000,000」は整数に変換できない")
		void test_13() {
			// setup
			String target = "10,000,000";
			// execute
			try {
				Convertor.toInt(target);
			} catch (Exception e) {
				// verify
				assertThat(e, is(instanceOf(ConvertException.class)));
				assertThat(e.getMessage(), is("変換できませんでした。"));
			}
		}
		@Test
		@DisplayName("【Test12・整数型のサイズ範囲外のテスト】数字列「12345678901」は整数に変換できない")
		void test_12() {
			// setup
			String target = "12345678901";
			// execute
			try {
				Convertor.toInt(target);
			} catch (Exception e) {
				// verify
				assertThat(e, is(instanceOf(ConvertException.class)));
				assertThat(e.getMessage(), is("変換できませんでした。"));
			}
		}
		@Test
		@DisplayName("【Test11・整数型の範囲外のテスト】数字列「2147483648」は整数に変換できない")
		void test_11() {
			// setup
			String target = "2147483648";
			// execute
			try {
				Convertor.toInt(target);
			} catch (Exception e) {
				// verify
				assertThat(e, is(instanceOf(ConvertException.class)));
				assertThat(e.getMessage(), is("変換できませんでした。"));
			}
		}
		@Test
		@DisplayName("【Test03・整数型最小値のテスト】数字列「-2147483648」を整数に変換できる")
		void test_03() throws Exception {
			// setup
			String target = "-2147483648";
			int expected = -2147483648;
			// execute
			int actual = Convertor.toInt(target);
			// verify
			assertThat(actual, is(expected));
		}
		@Test
		@DisplayName("【Test02・整数型最大値のテスト】数字列「2147483647」を整数に変換できる")
		void test_02() throws Exception {
			// setup
			String target = "2147483647";
			int expected = 2147483647;
			// execute
			int actual = Convertor.toInt(target);
			// verify
			assertThat(actual, is(expected));
		}
		@Test
		@DisplayName("【Test01整数型のテスト】数字列「111」を整数に変換できる")
		void test_01() throws Exception {
			// setup
			String target = "111";
			int expected = 111;
			// execute
			int actual = Convertor.toInt(target);
			// verify
			assertThat(actual, is(expected));
		}
	}


}
