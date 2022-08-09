package jp.villageworks.datautils.core;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UtilsCoreTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	@DisplayName("DataUtils#paddingZeroメソッドのテストクラス")
	class paddingZero {

		@Test
		@DisplayName("【Test-02】数字「3794」を3桁の前ゼロ付き数字列にすると「3794」である")
		void test_02() {
			// setup
			int target = 3794;
			String expected = "3794";
			// execute
			String actual = UtilsCore.zeroPadding(3, target);
			// verify
			assertThat(actual, is(expected));
		}

		@Test
		@DisplayName("【Test-01】数字「2734」を7桁で前ゼロ付きの文字列にすると「0002734」である")
		void test_01() {
			// setup
			int target = 2734;
			String expected = "0002734";
			// execute
			String actual = UtilsCore.zeroPadding(7, target);
			// verify
			assertThat(actual, is(expected));
		}
	}

	@Nested
	@DisplayName("DataUtils#paddingCharメソッドのテストクラス")
	class paddingChar {

		@Test
		@DisplayName("【Test-04】数字「45678」を先頭から文字「?」で埋めて5文字の文字列にすると「45678」である。")
		void test_04() {
			// setup
			int target = 45678;
			String expected = "45678";
			// execute
			String actual = UtilsCore.paddingChar(5, "?", target);
			// verify
			assertThat(actual, is(expected));
		}

		@Test
		@DisplayName("【Test-03】数字「123456789」を先頭から文字「#」で埋めて5文字の文字列にすると「123456789」である。")
		void test_03() {
			// setup
			int target = 123456789;
			String expected = "123456789";
			// execute
			String actual = UtilsCore.paddingChar(5, "#", target);
			// verify
			assertThat(actual, is(expected));
		}

		@Test
		@DisplayName("【Test-02】数字「123」を先頭から空文字「」で埋めると「123」である。")
		void test_02() {
			// setup
			int target = 123;
			String expected = "123";
			// execute
			String actual = UtilsCore.paddingChar(5, "", target);
			// verify
			assertThat(actual, is(expected));
		}

		@Test
		@DisplayName("【Test-01】数字「123」を先頭から文字「@」で埋めて5文字の文字列にすると「@@123」である。")
		void test_01() {
			// setup
			int target = 123;
			String expected = "@@123";
			// execute
			String actual = UtilsCore.paddingChar(5, "@", target);
			// verify
			assertThat(actual, is(expected));
		}

	}

}
