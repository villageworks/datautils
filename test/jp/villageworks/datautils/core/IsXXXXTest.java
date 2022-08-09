package jp.villageworks.datautils.core;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * 文字列判定系メソッドのテストクラス
 * @author tutor
 */
class IsXXXXTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	@DisplayName("DataUtils#isInRangeメソッドのテストクラス")
	class isInRange {
		@Test
		@DisplayName("【Test-11】整数3は5以上10以下の範囲外である")
		void test_11() {
			// setup
			int target = 3;
			int lower = 5;
			int upper = 10;
			// execute & verify
			assertThat(UtilsCore.isInRange(target, lower, upper), is(false));
		}
		@Test
		@DisplayName("【Test-03】整数10は5以上10以下である")
		void test_03() {
			// setup
			int target = 10;
			int lower = 5;
			int upper = 10;
			// execute & verify
			assertThat(UtilsCore.isInRange(target, lower, upper), is(true));
		}
		@Test
		@DisplayName("【Test-02】整数5は5以上10以下である")
		void test_02() {
			// setup
			int target = 5;
			int lower = 5;
			int upper = 10;
			// execute & verify
			assertThat(UtilsCore.isInRange(target, lower, upper), is(true));
		}
		@Test
		@DisplayName("【Test-01】整数512は500以上550以下である")
		void test_01() {
			// setup
			int target = 512;
			int lower = 500;
			int upper = 550;
			// execute & verify
			assertThat(UtilsCore.isInRange(target, lower, upper), is(true));
		}
	}
	@Nested
	@DisplayName("DataUtils#isUnderメソッドのテストクラス")
	class isUnder {
		@Test
		@DisplayName("【Test-11】整数1026は1025以下ではない")
		void test_11() {
			// setup
			int target = 1026;
			int upper = 1025;
			// execute & verify
			assertThat(UtilsCore.isUnder(target, upper), is(false));
		}
		@Test
		@DisplayName("【Test-02】整数1025は1025以下である")
		void test_02() {
			// setup
			int target = 1025;
			int upper = 1025;
			// execute & verify
			assertThat(UtilsCore.isUnder(target, upper), is(true));
		}
		@Test
		@DisplayName("【Test-01】整数1024は1025以下である")
		void test_01() {
			// setup
			int target = 1024;
			int upper = 1025;
			// execute & verify
			assertThat(UtilsCore.isUnder(target, upper), is(true));
		}
	}
	@Nested
	@DisplayName("DataUtils#isOverメソッドのテストクラス")
	class isOver {
		@Test
		@DisplayName("【Test-11】整数254は255以上ではない")
		void test11() {
			// setup
			int target = 254;
			int lower = 255;
			// execute & verify
			assertThat(UtilsCore.isOver(target, lower), is(false));
		}
		@Test
		@DisplayName("【Test-02】整数255は255以上である")
		void test02() {
			// setup
			int target = 255;
			int lower = 255;
			// execute & verify
			assertThat(UtilsCore.isOver(target, lower), is(true));
		}
		@Test
		@DisplayName("【Test-01】整数256は255以上である")
		void test01() {
			// setup
			int target = 256;
			int lower = 255;
			// execute & verify
			assertThat(UtilsCore.isOver(target, lower), is(true));
		}
	}
	@Nested
	@DisplayName("DataUtils#isIntメソッドのテストクラス")
	class isInt {
		@Test
		@DisplayName("【Test-13】文字列「256GBit」は整数列ではない")
		void test_13() {
			// setup
			String target = "256GBit";
			// execute
			boolean actual = UtilsCore.isInt(target);
			// verify
			assertThat(actual, is(false));
		}
		@Test
		@DisplayName("【Test-12】文字列「10,000,000」は整数列ではない")
		void test_12() {
			// setup
			String target = "10,000,000";
			// execute
			boolean actual = UtilsCore.isInt(target);
			// verify
			assertThat(actual, is(false));
		}
		@Test
		@DisplayName("【Test-11】数字列「3.14」は整数列ではない")
		void test_11() {
			// setup
			String target = "3.14";
			// execute
			boolean actual = UtilsCore.isInt(target);
			// verify
			assertThat(actual, is(false));
		}
		@Test
		@DisplayName("【Test-02】数字列「-1024」は整数列である")
		void test_02() {
			// setup
			String target = "1024";
			// execute
			boolean actual = UtilsCore.isInt(target);
			// verify
			assertThat(actual, is(true));
		}
		@Test
		@DisplayName("【Test-01】数字列「128」は整数列である")
		void test_01() {
			// setup
			String target = "128";
			// execute
			boolean actual = UtilsCore.isInt(target);
			// verify
			assertThat(actual, is(true));
		}
	}
	@Nested
	@DisplayName("DataUtils#isNumericメソッドのテストクラス")
	class isNumeric {
		@Test
		@DisplayName("【Test-06】文字列「10,000,000」は数値ではない")
		void test_06() {
			// setup
			String target = "10,000,000";
			// execute
			boolean actual = UtilsCore.isNumeric(target);
			// verify
			assertThat(actual, is(false));
		}
		@Test
		@DisplayName("【Test-05】文字列「\200」は数値ではない")
		void test_05() {
			// setup
			String target = "\200";
			// execute
			boolean actual = UtilsCore.isNumeric(target);
			// verify
			assertThat(actual, is(false));
		}
		@Test
		@DisplayName("【Test-04】文字列「+2.71」は数値である")
		void test_04() {
			// setup
			String target = "+2.71";
			// execute
			boolean actual = UtilsCore.isNumeric(target);
			// verify
			assertThat(actual, is(true));
		}
		@Test
		@DisplayName("【Test-03】文字列「3.14」は数値である")
		void test_03() {
			// setup
			String target = "3.14";
			// execute
			boolean actual = UtilsCore.isNumeric(target);
			// verify
			assertThat(actual, is(true));
		}
		@Test
		@DisplayName("【Test-02】文字列「-111」は数値である")
		void test_02() {
			// setup
			String target = "-111";
			// execute
			boolean actual = UtilsCore.isNumeric(target);
			// verify
			assertThat(actual, is(true));
		}
		@Test
		@DisplayName("【Test-01】文字列「111」は数値である")
		void test_01() {
			// setup
			String target = "111";
			// execute
			boolean actual = UtilsCore.isNumeric(target);
			// verify
			assertThat(actual, is(true));
		}
	}
	@Nested
	@DisplayName("DataUtils#isNullメソッドのテストクラス")
	class isNull {
		@Test
		@DisplayName("Listクラスのオブジェクトにnullが代入されている場合はnullである")
		void test_04() {
			// setup
			List<String> target = null;
			// execute
			boolean actual = UtilsCore.isNull(target);
			// verify
			assertThat(actual, is(true));
		}
		@Test
		@DisplayName("【Test-03】nullが代入された変数はnullである")
		void test_03() {
			// setup
			String target = null;
			// execute
			boolean actual = UtilsCore.isNull(target);
			// verify
			assertThat(actual, is(true));
		}
		@Test
		@DisplayName("【Test-02】空文字列が代入された変数はnullではない")
		void test_02() {
			// setup
			String target = "";
			// execute
			boolean actual = UtilsCore.isNull(target);
			// verify
			assertThat(actual, is(false));
		}
		@Test
		@DisplayName("【Test-01】文字列「jQuery」が代入されている変数はnullではない")
		void test_01() {
			// setup
			String target = "jQuery";
			// execute
			boolean actual = UtilsCore.isNull(target);
			// verify
			assertThat(actual, is(false));
		}
	}
	@Nested
	@DisplayName("DataUtils#isEmptyメソッドのテストクラス")
	class isEmpty {
		@Test
		@DisplayName("【Test-03】nullが代入された変数は空である")
		void test_03() {
			// setup
			String target = null;
			// execute
			boolean actual = UtilsCore.isEmpty(target);
			// verify
			assertThat(actual, is(true));
		}
		@Test
		@DisplayName("【Test-02】空文字列が代入された変数は空である")
		void test_02() {
			// setup
			String target = "";
			// execute
			boolean actual = UtilsCore.isEmpty(target);
			// verify
			assertThat(actual, is(true));
		}
		@Test
		@DisplayName("【Test-01】文字列「jQuery」が代入されている変数は空ではない")
		void test_01() {
			// setup
			String target = "jQuery";
			// execute
			boolean actual = UtilsCore.isEmpty(target);
			// verify
			assertThat(actual, is(false));
		}
	}

}
